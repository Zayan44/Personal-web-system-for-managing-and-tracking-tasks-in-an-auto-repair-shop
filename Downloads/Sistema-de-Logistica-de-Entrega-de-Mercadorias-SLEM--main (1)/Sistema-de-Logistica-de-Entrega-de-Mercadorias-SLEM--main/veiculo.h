#ifndef VEICULO_H
#define VEICULO_H

class Local;

#include <iostream>
#include <cstring>
#include <vector>

#define INPUTMAXPLACA 8

using namespace std;

/*
 * Classe Veiculo
 *
 * Representa um veículo disponível para realizar entregas, contendo atributos como placa,
 * modelo, disponibilidade e o local onde está atualmente.
 * A classe oferece métodos para gerenciar o cadastro, listagem, atualização e remoção dos veículos.
 *
 * Como funciona:
 * - Os veículos são armazenados em um vetor estático da própria classe.
 * - Possui métodos para buscar veículos disponíveis, atualizar localizações e disponibilidade.
 * - O backup e restauração são feitos por gravação/leitura direta do vetor em arquivo binário.
 */

class Veiculo
{
private:
    char placa[INPUTMAXPLACA];
    char modelo[50];
    bool disponivel;
    Local *localAtual;

    static vector<Veiculo> veiculos;

public:
    // Construtores
    Veiculo();
    Veiculo(const char *placa, const char *modelo, bool disponivel, const Local &local);

    // Getters
    const char *getPlaca() const;
    const char *getModelo() const;
    bool getDisponibilidade() const;
    static vector<Veiculo> &getVeiculos();

    Local getLocalAtual() const;

    // Setters
    void setPlaca(const char *p);
    void setModelo(const char *modelo);
    void setDisponibilidade(bool d);
    void setLocalAtual(const Local &l);

    // Funções do sistema
    static void cadastrarVeiculo();
    static void listarVeiculo();
    static void atualizarVeiculo();
    static void deletarVeiculo();

    // Sistema de arquivos binários
    static void salvarVeiculosEmArquivoBinario();
    static void carregarVeiculosDeArquivoBinario();
};

#endif
