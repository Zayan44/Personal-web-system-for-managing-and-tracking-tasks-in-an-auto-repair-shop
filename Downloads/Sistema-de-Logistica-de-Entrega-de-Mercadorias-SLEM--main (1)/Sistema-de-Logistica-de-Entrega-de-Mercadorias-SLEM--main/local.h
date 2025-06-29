#ifndef LOCAL_H
#define LOCAL_H

#include "veiculo.h"
#include <cstring>
#include <vector>

using namespace std;

/*
 * Classe Local
 *
 * Representa um local físico no sistema, contendo informações como nome e coordenadas (X, Y).
 * Essa classe permite cadastro, listagem, atualização e remoção de locais.
 * Também possui funcionalidades para salvar e carregar os locais de um arquivo binário,
 * garantindo persistência dos dados entre execuções do programa.
 *
 * Como funciona:
 * - Os locais são armazenados em um vetor estático da própria classe.
 * - Métodos estáticos manipulam esse vetor para realizar operações CRUD.
 * - A persistência é feita através da gravação/leitura direta do vetor em arquivo binário.
 */

class Local
{

private:
    // Atributos
    char nomeLocal[200];
    int coordXLocal;
    int coordYLocal;

    static vector<Local> locais;

public:
    // Construtor
    Local(const char *PnomeLocal, int PcoordXLocal, int PcoordYLocal);
    Local();

    // Getters
    const char *getNomeLocal() const;
    int getCoordXLocal() const;
    int getCoordYLocal() const;
    static vector<Local> &getLocais();

    // Setters
    void setNomeLocal(const char *nomeLocal);
    void setCoordXLocal(int coordXLocal);
    void setCoordYLocal(int coordYLocal);

    // sistema de locais
    static void cadastroLocal();
    static void listarLocal();
    static void atualizacaoLocal();
    static void deletarLocal();

    // sistema de arquivos binarios
    static void salvarLocaisEmArquivoBinario();
    static void carregarLocaisDeArquivoBinario();
};

#endif