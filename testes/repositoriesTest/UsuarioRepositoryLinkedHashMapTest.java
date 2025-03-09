package repositoriesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entities.Usuario;
import repositories.UsuarioRepositoryLinkedHashMap;

class UsuarioRepositoryLinkedHashMapTest {

	private UsuarioRepositoryLinkedHashMap rep;
	private Usuario userPadrao;
	
	@BeforeEach
	void setUp() throws Exception {
		rep = new UsuarioRepositoryLinkedHashMap();
		userPadrao = new Usuario("Lukas", "1234567890", "senha123", "matricula321");
	}

	@Test
	void testAdicionaEstudante() {
		//fail("Not yet implemented");
		assertTrue(rep.adicionaEstudante(userPadrao.getCpf(), userPadrao));
	}
	
	@Test
	void testAdicionaEstudanteCpfNulo() {
		try {
			rep.adicionaEstudante(null, userPadrao);
			fail("Não pode adicionar um usuario com chave nula");
		} catch (NullPointerException e) {
			assertEquals(e.getMessage(), "O CPF do estudante não pode ser nulo");
		}
	}
	
	@Test
	void testAdicionaEstudanteJaAdicionado() {
		assertTrue(rep.adicionaEstudante(userPadrao.getCpf(), userPadrao));
		assertFalse(rep.adicionaEstudante(userPadrao.getCpf(), userPadrao));
	}
	
	@Test
	void testBuscaEstudant() {
		assertTrue(rep.adicionaEstudante(userPadrao.getCpf(), userPadrao));
		assertEquals(userPadrao, rep.buscaEstudante(userPadrao.getCpf(), "senha123"));
	}
	
	@Test
	void testBuscaEstudanteCpfInvalido() {
		assertTrue(rep.adicionaEstudante(userPadrao.getCpf(), userPadrao));
		try {
			rep.buscaEstudante(userPadrao.getCpf(), "");
		} catch (IllegalArgumentException e) {
			assertEquals("CPF do estudante inválido", e.getMessage());
		}
	}
	
	@Test
	void testBuscaEstudanteSenhaInvalida() {
		assertTrue(rep.adicionaEstudante(userPadrao.getCpf(), userPadrao));
		try {
			rep.buscaEstudante(userPadrao.getCpf(), "");
		} catch (IllegalArgumentException e) {
			assertEquals("A senha do estudante não pode ser vazia", e.getMessage());
		}
	}
	
	@Test
	void testListaEstudantes() {
		String[] lista = new String[] {userPadrao.toString()};
		assertTrue(rep.adicionaEstudante(userPadrao.getCpf(), userPadrao));
		assertArrayEquals(lista, rep.listaEstudantes());
	}
	
	@Test
	void testListaEstudantesVazio() {
		String[] lista = new String[0];
		//assertTrue(rep.adicionaEstudante(userPadrao.getCpf(), userPadrao));
		assertArrayEquals(rep.listaEstudantes(), lista);
		
	}
}
