package repositories;

import entities.Dica;
import java.util.LinkedHashMap;
import java.util.Map;
import validators.ValidadorDica;

/**
 * Classe responsável por gerenciar e armazenar as dicas em um repositório.
 * Esta classe permite adicionar e listar dicas.
 */
public class DicaRepositoryLinkedHashMap {
   
    private Map<Integer, Dica> dicas;
    private Integer numeroDaDica = 0;


    /**
     * Cria um novo repositório de dicas
     */
    public DicaRepositoryLinkedHashMap(){
        this.dicas = new LinkedHashMap<>();
    }

    /**
     * Adiciona uma dica ao repositório
     * @param dica a dica ser adicionada
     * @return o número total de dicas no repositório após adição ou 0 se a dica não foi adicionada
     * @throws NullPointerException se a dica for nula
     */
    public int adicionaDica(Dica dica){
        ValidadorDica.validaDica(dica);
        dicas.put(++numeroDaDica, dica);
        return numeroDaDica;
    }

    /**
     * Retorna uma lista das dicas como strings.
     *
     * @return um array de strings representando as dicas
     */
    public String[] listaDicas(){
        if (this.dicas.isEmpty())
            return new String[0];
        
        String[] lista = new String[dicas.size()];
        int i = 0;
        while (i < dicas.size())
            lista[i] = dicas.get(i++).toString();
        
        return lista;
    }

    /**
     * Retorna uma lista detalhada das dicas.
     *
     * @return um array de strings representando as dicas
     */
    public String[] listaDicasDetalhes(){
        if (this.dicas.isEmpty())
            return new String[0];
        
        String[] lista = new String[dicas.size()];
        int i = 0;
        while (i < dicas.size())
            lista[i] = dicas.get(i++).exibeDetalhes();
        
        return lista;
    }

    /**
	 * Retorna a representação em string da dica na posição especificada.
	 *
	 * @param posicao a posição da dica a ser retornada (1-based)
	 * @return a representação em string da dica
	 * @throws IllegalArgumentException se posicao for inválida
	 */
    public String listaDica(int posicao){
        return this.dicas.get(posicao).toString();
    }

    /**
     * Retorna os detalhes da dica na posição especificada.
     *
     * @param posicao a posição da dica a ser retornada (1-based)
     * @return os detalhes da dica
     * @throws IllegalArgumentException se posicao for inválida
     */
    public String listaDicaDetalhada(int posicao){
        return dicas.get(posicao).exibeDetalhes();
    }

    /**
     * Busca e retorna a dica na posição especificada.
     *
     * @param posicao a posição da dica a ser buscada (1-based)
     * @return a dica na posição especificada
     * @throws IllegalArgumentException se posicao for inválida
     */
    public Dica buscaDica(int posicao){
        ValidadorDica.validaPosicao(posicao, this.dicas.size());
        return this.dicas.get(posicao);
    }

}
