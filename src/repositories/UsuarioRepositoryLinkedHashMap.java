package repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import entities.Usuario;
import validators.ValidadorUsuario;

public class UsuarioRepositoryLinkedHashMap {

	private Map<String, Usuario> estudantes;
	
	
	/**
     * Cria um novo repositório de usuários.
     */
	public UsuarioRepositoryLinkedHashMap() {
		this.estudantes = new LinkedHashMap<>();
	}
	
	/**
     * Adiciona um estudante ao repositório.
     *
     * @param cpf o cpf do estudante
     * @param estudante o objeto a ser adicionado
     * @return true se o estudante foi adicionado com sucesso, false se já existe um estudante com o mesmo CPF
     * @throws NullPointerException se o estudante for nulo
     */
	public boolean adicionaEstudante(String cpf, Usuario estudante) {
		if (cpf == null) throw new NullPointerException("O CPF do estudante não pode ser nulo");
		ValidadorUsuario.validaUsuario(estudante);
		
		if (this.estudantes.containsKey(cpf))
			return false;
		
			this.estudantes.put(cpf, estudante);
		
		
		return true;
	}
	
	/**
     * Lista todos os estudantes no repositório como um array de strings.
     *
     * @return um array de String contendo a representação de todos os estudantes, se existir
     */
	public String[] listaEstudantes() {
		if (this.estudantes.size() == 0)
			return new String[0];
		
		List<Usuario> listaOrdenadaAlfabeticamente = new ArrayList<>(this.estudantes.values());
		listaOrdenadaAlfabeticamente.sort(null);
		return converteParaArrayDeString(listaOrdenadaAlfabeticamente);
		
	}
	
	/**
     * Busca um estudante no repositório com base no CPF e senha fornecidos.
     *
     * @param cpf o cpf do estudante a ser buscado
     * @param senha a senha do estudante
     * @return o estudante correspondente se encontrado e a senha for válida, null caso contrário
     * @throws NullPointerException se o estudante não for encontrado
     * @throws IllegalArgumentException se as credenciais forem inválidas
     */
	public Usuario buscaEstudante(String cpf, String senha) {
		ValidadorUsuario.validaCpf(cpf);
		ValidadorUsuario.validaSenha(senha);
		Usuario estudanteProcurado = this.estudantes.get(cpf);
		ValidadorUsuario.validaUsuario(estudanteProcurado);
		if (validaSenha(estudanteProcurado, senha)) {
			return estudanteProcurado;
		}
		
		throw new IllegalArgumentException("Usuário ou senha inválidos");
	}
	
	private boolean validaSenha(Usuario estudante, String senha) {
		return estudante.validaSenha(senha);
	}
	
	private <T> String[] converteParaArrayDeString(Collection<T> colecao) {
		String[] lista = new String[colecao.size()];
		int i = 0;
		for (T elemento : colecao) {
			lista[i++] = elemento.toString();
		}
		return lista;
	}
}
