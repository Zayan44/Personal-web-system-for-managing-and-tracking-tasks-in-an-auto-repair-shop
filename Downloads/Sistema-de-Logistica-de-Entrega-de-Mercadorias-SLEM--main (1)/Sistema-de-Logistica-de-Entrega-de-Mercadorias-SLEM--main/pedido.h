#ifndef PEDIDO_H
#define PEDIDO_H

#include <vector>

using namespace std;

/*
 * Classe Pedido
 *
 * Representa um pedido de entrega contendo informações de origem, destino, peso e status (pendente ou entregue).
 * Permite o cadastro, listagem, atualização e exclusão dos pedidos no sistema.
 *
 * Como funciona:
 * - Os pedidos são armazenados em um vetor estático da própria classe.
 * - Possui métodos para manipular o status do pedido e acessar seus dados.
 * - O backup e restauração são feitos por gravação/leitura direta do vetor em arquivo binário.
 */

class Local; // Declaração antecipada para evitar dependência circular

class Pedido
{
private:
    int identificadorUnico;
    Local *localOrigem;
    Local *localDestino;
    double pesoItem;
    bool pendente = true;

    static vector<Pedido> pedidos; // Vetor estático de pedidos
    static int proximoId;          // Contador para gerar IDs únicos

public:
    // Construtores
    Pedido();
    Pedido(Local *origem, Local *destino, double peso);

    // Getters
    int getIdentificadorUnico() const;
    Local *getLocalOrigem() const;
    Local *getLocalDestino() const;
    double getPesoItem() const;
    bool getPendente() const;

    static vector<Pedido> &getPedidos();

    // Setters
    void setLocalOrigem(Local *origem);
    void setLocalDestino(Local *destino);
    void setPesoItem(double peso);
    void setPendente(bool status); // Define se o pedido está pendente ou não

    // Operações do sistema de pedidos

    void marcarComoEntregue(); // Marca o pedido como entregue
    static void cadastroPedido();
    static void listarPedidos();
    static void atualizacaoPedido();
    static void deletarPedido();

    // Função auxiliar para encontrar local por nome
    static Local *encontrarLocalPorNome(const char *nomeLocal);

    // Sistema de arquivos binários
    static void salvarPedidosEmArquivoBinario();
    static void carregarPedidosDeArquivoBinario();
};

#endif