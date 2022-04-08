package com.noticias.sistemanoticias;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noticias.controller.model.Noticia;

import ch.qos.logback.classic.Logger;

@Controller
public class HomeController {

	private final static Logger logger = (Logger) LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String Main(Model model) {

		String rutaArchivo = "src/main/resources/static/noticias.txt";
		List<Noticia> listaNoticias = new ArrayList<Noticia>();

		try {

			FileReader fr = new FileReader(rutaArchivo);
			BufferedReader br = new BufferedReader(fr);
			String dataNoticias = br.readLine();
			logger.info("	Comienza a leer archivo");
			while (dataNoticias != null) {

				String[] noticiaSplit = dataNoticias.split("@@");
				if(noticiaSplit.length > 1) {
					Noticia noticia = new Noticia(noticiaSplit[0], noticiaSplit[1], noticiaSplit[2]);
					listaNoticias.add(noticia);
					logger.info("Noticia Agregada Correctamente");
				}

				dataNoticias = br.readLine();

			}

			br.close();
			fr.close();

		} catch (Exception e) {
			logger.error("Error al leer el archivo con ruta: " + rutaArchivo + ", " + e);
		}

		model.addAttribute("listaNoticias", listaNoticias);

		logger.info("Archivo listo para ser enviado a la vista");
		return "main";
	}

}
