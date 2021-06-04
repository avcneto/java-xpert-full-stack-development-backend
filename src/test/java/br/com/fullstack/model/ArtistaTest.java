package br.com.fullstack.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArtistaTest {

	@Test
	void setAll() {

		Artista artista = new Artista();
		artista.setAll(0, "Anita", "Brasileira", "Feminina");
		artista.toString();

		assertEquals("Anita", artista.getNomeArtistico());
		assertEquals(0, artista.id);
		assertEquals("Feminina", artista.getGenero());
		assertEquals("Brasileira", artista.getNacionalidade());

	}

}
