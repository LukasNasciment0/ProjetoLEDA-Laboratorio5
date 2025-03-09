package repositoriesTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import entities.Dica;
import entities.Usuario;
import repositories.DicaRepositoryLinkedHashMap;

import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;


class DicaRepositoryLinkedHashMapTest {

	private DicaRepositoryLinkedHashMap repDicas;
	private Dica dicaPadrao;
	private Usuario userPadrao;

	@BeforeEach
	void setup(){
		repDicas = new DicaRepositoryLinkedHashMap();
		userPadrao = new Usuario("Lukas", "1234567890", "senha123", "matricula321");
		dicaPadrao = new Dica(userPadrao,"Monitoria");
		
	}

	@Test
	void testAdicionaDicaNula() {
		try {
			repDicas.adicionaDica(null);
			fail("Essa linha não pode ser executada");
		} catch (NullPointerException e) {
			assertEquals(e.getMessage(), "A dica não pode ser nula");
		}
	}
	
	@Test
	void testAdicionaDicaComUsuarioNulo() {
		try {
			//Usuario userNulo = new Usuario(null, null, null, null);
			Usuario userNulo = null;
			repDicas.adicionaDica(new Dica(userNulo, "Tema2"));
			fail("Essa linha não pode ser executada");
		} catch (NullPointerException e) {
			assertEquals(e.getMessage(), "O usuário não pode ser nulo");
		}
	}
	
	@Test
	void testAdicionaDica() {
		repDicas.adicionaDica(dicaPadrao);
		assertEquals(repDicas.buscaDica(1), dicaPadrao);
	}
	
	@Test
	void testGetFirst() {
		Dica dica2 = new Dica(userPadrao, "Monitoria");
		repDicas.adicionaDica(dicaPadrao);
		repDicas.adicionaDica(dica2);
		assertEquals(repDicas.buscaDica(1), dicaPadrao);
	}
	
	@Test
	void testGet() {
		Dica dica2 = new Dica(userPadrao, "Monitoria");
		repDicas.adicionaDica(dicaPadrao);
		repDicas.adicionaDica(dica2);
		assertEquals(repDicas.buscaDica(2), dica2);
	}
	
	@Test
	void testToStringRepVazio() {
		assertTrue(repDicas.isEmpty());
		String[] vazia = new String[0];
		assertArrayEquals(vazia, repDicas.listaDicas());
	}
	
	@Test
	void testListaDicas() {
		Dica dica2 = new Dica(userPadrao, "Estagio");
		repDicas.adicionaDica(dicaPadrao);
		repDicas.adicionaDica(dica2);
		String[] listaDicas = {dicaPadrao.toString(), dica2.toString()};
		assertArrayEquals(listaDicas, repDicas.listaDicas());
		//String saida = "Autor: " + userPadrao.getNome() + ", tema: " + dicaPadrao.;
	}
	
	@Test
	void testListaDica() {
		Dica dica2 = new Dica(userPadrao, "Monitoria");
		repDicas.adicionaDica(dica2);
		assertEquals(repDicas.listaDica(1), dica2.toString());
		
	}
	
	@Test
	void testListaDicaDetalhes() {
		Dica dica2 = new Dica(userPadrao, "Monitoria");
		repDicas.adicionaDica(dica2);
		assertEquals(repDicas.listaDicaDetalhada(1), dica2.exibeDetalhes());
	}
	
	
	
	
	
	
	
	
	
	

}
