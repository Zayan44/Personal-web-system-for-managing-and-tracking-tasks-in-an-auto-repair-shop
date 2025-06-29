#ifndef CALCULO_H
#define CALCULO_H

#include "pedido.h"
#include "local.h"
#include "veiculo.h"
#include <vector>

/*
 * Classe Calculo
 *
 * Responsável por operações matemáticas e lógicas relacionadas à logística, como cálculo de distâncias
 * entre locais e seleção do veículo disponível mais próximo para atender um pedido.
 * Também executa o fluxo completo de cálculo e simulação da rota de entrega.
 *
 * Como funciona:
 * - Calcula distância euclidiana entre dois locais.
 * - Calcula distâncias totais e permite simular a entrega atualizando status dos veículos e pedidos.
 */

class Calculo
{
public:
    // Função para calcular distância euclidiana entre dois locais
    static double calcularDistanciaEuclidiana(const Local &local1, const Local &local2);

    // Função para encontrar o veículo disponível mais próximo de um local
    static Veiculo *encontrarVeiculoMaisProximo(const std::vector<Veiculo> &veiculos, const Local &localOrigem);

    // Função principal para calcular e exibir a rota de entrega
    static void calcularRotaEntrega(std::vector<Pedido> &pedidos, std::vector<Veiculo> &veiculos);
};

// Função global para ser chamada do menu principal
void calcularRota(std::vector<Veiculo> &veiculos);

#endif
