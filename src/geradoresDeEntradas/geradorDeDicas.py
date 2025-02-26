#conding: utf-8
from geradorDeUsuarios import listaUsuarios

import random
import string
import sys

#Gera uma String aleatório de tamanho 10
def geradorDeTemaAleatorio():
    return ''.join(random.choices(string.ascii_letters, k=10))

#Retorna uma lista de strings com cada elemento representando uma Dica
def listaDeDicasAleatorias(qtdDeDicas):
    lista = []

    i = 0
    while(i <= qtdDeDicas):
        dicaASerAdicionada = geradorDeTemaAleatorio()
        if (dicaASerAdicionada not in lista):
            lista.append(dicaASerAdicionada)
            i += 1
    return lista

def main():
    tamanhoDaSaida = int(sys.argv[1])

    listaDeUsu = listaUsuarios(tamanhoDaSaida)
    listaDicas = listaDeDicasAleatorias(tamanhoDaSaida)

    for i in range(tamanhoDaSaida):
        #lista.append((listaDeUsu[i], listaDicas[i]))
        print("Usuário: " + listaDeUsu[i] + ", Tema: " + listaDicas[i])

if __name__ == "__main__":
    main()


#os 2 scripts aqui
#o script de Dicas chama o script de Usuarios pelo import 
#tá vendo?
#nice entao