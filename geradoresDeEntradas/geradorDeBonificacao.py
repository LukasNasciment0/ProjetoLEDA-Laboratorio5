#conding: utf-8

import sys
import string
import random

#Retorna uma lista com strings com cada elemento representando cpf
def listaDeBonificacoesAleatorias(qtdDeBonificacoes):
	lista = []
	i = 0
	while (i < qtdDeBonificacoes):
		cpfASerAdicionado = geraBonificacaoAleatoria()
		lista.append(cpfASerAdicionado)
		i += 1
	
	return lista


#Gera uma String com numeros aleatorios de tamanho 3 
def geraBonificacaoAleatoria():
	return ''.join(random.choices(string.digits, k=3))

def main():
	tamanhoDaSaida = int(sys.argv[1])
	lista = listaDeBonificacoesAleatorias(tamanhoDaSaida)

	for i in lista:
		print(i)

if __name__ == "__main__":
    main()

#main()
