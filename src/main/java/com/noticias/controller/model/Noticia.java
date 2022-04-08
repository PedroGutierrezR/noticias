package com.noticias.controller.model;

public class Noticia {

	private String titulo;
	private String cuerpo;
	private String url;
	
	public Noticia(String titulo, String cuerpo, String url) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.url = url;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Noticia [titulo=" + titulo + ", cuerpo=" + cuerpo + ", url=" + url + "]";
	}
	
}
