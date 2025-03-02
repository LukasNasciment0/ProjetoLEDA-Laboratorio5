#conding: utf-8

import sys
import string
import random

nome = "Alana"
senha = "senha123"
matricula = "202501203"
bonificacao = 0

#Retorna uma lista com strings com cada elemento representando cpf
def listaDeCpfAleatorios(qtdDeCpf):
	lista = []
	
	i = 0
	while (i < qtdDeCpf):
		cpfASerAdicionado = geraCpfAleatorio()
		if (cpfASerAdicionado not in lista):
			lista.append(cpfASerAdicionado)
			i += 1
	return lista


#Gera uma String com numeros aleatorios de tamanho 11 (tam de um cpf brasileiro)
def geraCpfAleatorio():
	return ''.join(random.choices(string.digits, k=11))

def listaUsuarios(tamanhoDaSaida):
	listaUsers = []
	lista = listaDeCpfAleatorios(tamanhoDaSaida)
	for i in lista:
		user = f"{nome} {i} {senha} {matricula}"
		listaUsers.append(user)
	
	return listaUsers


def main():
	tamanhoDaSaida = int(sys.argv[1])
	lista = listaUsuarios(tamanhoDaSaida)

	for i in lista:
		print(i)

if __name__ == "__main__":
    main()

#main()
