#include "calculo.h"
#include <iostream>
#include <cmath>
#include <limits>

using namespace std;

// Função para calcular distância euclidiana entre dois locais
double Calculo::calcularDistanciaEuclidiana(const Local &local1, const Local &local2)
{
    int deltaX = local1.getCoordXLocal() - local2.getCoordXLocal();
    int deltaY = local1.getCoordYLocal() - local2.getCoordYLocal();
    return sqrt(deltaX * deltaX + deltaY * deltaY);
}

// Função para encontrar o veículo disponível mais próximo de um local
Veiculo *Calculo::encontrarVeiculoMaisProximo(const vector<Veiculo> &veiculos, const Local &localOrigem)
{
    Veiculo *veiculoMaisProximo = nullptr;
    double menorDistancia = numeric_limits<double>::max();

    for (auto &veiculo : const_cast<vector<Veiculo> &>(veiculos))
    {
        if (veiculo.getDisponibilidade())
        {
            Local localVeiculo = veiculo.getLocalAtual();
            double distancia = calcularDistanciaEuclidiana(localVeiculo, localOrigem);
            if (distancia < menorDistancia)
            {
                menorDistancia = distancia;
                veiculoMaisProximo = &veiculo;
            }
        }
    }

    return veiculoMaisProximo;
}

// Função principal para calcular e exibir a rota de entrega
void Calculo::calcularRotaEntrega(vector<Pedido> &pedidos, vector<Veiculo> &veiculos)
{
    if (pedidos.empty())
    {
        cout << "\nNenhum pedido foi cadastrado." << endl;
        return;
    }

    cout << "\n===== PEDIDOS PENDENTES =====" << endl;
    int contador = 1;
    for (const auto &pedido : pedidos)
    {
        if (!pedido.getPendente())
            continue;

        cout << "\nPedido " << contador << ":" << endl;
        cout << "ID: " << pedido.getIdentificadorUnico() << endl;
        cout << "Origem: " << pedido.getLocalOrigem()->getNomeLocal() << endl;
        cout << "Destino: " << pedido.getLocalDestino()->getNomeLocal() << endl;
        cout << "Peso: " << pedido.getPesoItem() << " kg" << endl;
        contador++;
    }

    int escolhaPedido;
    cout << "\nEscolha o número do pedido para calcular a rota: ";
    cin >> escolhaPedido;

    if (escolhaPedido < 1 || escolhaPedido > (int)pedidos.size())
    {
        cout << "\nPedido inválido!" << endl;
        return;
    }

    Pedido &pedidoSelecionado = pedidos[escolhaPedido - 1];
    Veiculo *veiculoMaisProximo = encontrarVeiculoMaisProximo(veiculos, *pedidoSelecionado.getLocalOrigem());

    if (veiculoMaisProximo == nullptr)
    {
        cout << "\nNenhum veículo disponível encontrado!" << endl;
        return;
    }

    Local localVeiculo = veiculoMaisProximo->getLocalAtual();
    double distanciaVeiculoOrigem = calcularDistanciaEuclidiana(localVeiculo, *pedidoSelecionado.getLocalOrigem());
    double distanciaOrigemDestino = calcularDistanciaEuclidiana(*pedidoSelecionado.getLocalOrigem(), *pedidoSelecionado.getLocalDestino());
    double distanciaTotal = distanciaVeiculoOrigem + distanciaOrigemDestino;

    cout << "\n===== ROTA DE ENTREGA CALCULADA =====" << endl;
    cout << "Veículo selecionado: " << veiculoMaisProximo->getPlaca() << " (" << veiculoMaisProximo->getModelo() << ")" << endl;
    cout << "Local atual do veículo: " << localVeiculo.getNomeLocal() << endl;
    cout << "Local de origem do pedido: " << pedidoSelecionado.getLocalOrigem()->getNomeLocal() << endl;
    cout << "Local de destino do pedido: " << pedidoSelecionado.getLocalDestino()->getNomeLocal() << endl;
    cout << "Distância até a origem: " << distanciaVeiculoOrigem << " unidades" << endl;
    cout << "Distância origem-destino: " << distanciaOrigemDestino << " unidades" << endl;
    cout << "Distância total percorrida: " << distanciaTotal << " unidades" << endl;

    char confirmar;
    cout << "\nDeseja simular a entrega? (s/n): ";
    cin >> confirmar;

    if (confirmar == 's' || confirmar == 'S')
    {
        veiculoMaisProximo->setDisponibilidade(false);
        cout << "\nSimulando entrega..." << endl;
        cout << "Veículo " << veiculoMaisProximo->getPlaca() << " agora está OCUPADO." << endl;

        pedidoSelecionado.setPendente(false);
        cout << "Entrega concluída com sucesso!" << endl;

        veiculoMaisProximo->setLocalAtual(*pedidoSelecionado.getLocalDestino());
        veiculoMaisProximo->setDisponibilidade(true);

        cout << "Veículo " << veiculoMaisProximo->getPlaca() << " agora está DISPONÍVEL." << endl;
        cout << "Local atual do veículo atualizado para: " << pedidoSelecionado.getLocalDestino()->getNomeLocal() << endl;

        // Remove pedido da lista
        pedidos.erase(pedidos.begin() + (escolhaPedido - 1));
        cout << "Pedido removido da lista de pendentes." << endl;
    }
}
