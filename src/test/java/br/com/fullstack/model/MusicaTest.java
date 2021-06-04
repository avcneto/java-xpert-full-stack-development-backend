package br.com.fullstack.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MusicaTest {

	@Test
	void shouldCreateAMusica() {

		Musica musica = new Musica();
		musica.setAll(
				0,
				"Caneta Azul",
				null,
				1,
				new Artista() {{
					setAll(1, "manuel bandeira", "Brasileiro", "masculino");
				}});
		assertEquals("manuel bandeira", musica.getArtista().getNomeArtistico());
		assertEquals("Caneta Azul", musica.getTitulo());
	}


}