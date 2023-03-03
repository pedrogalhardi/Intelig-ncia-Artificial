/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dots;

import java.util.Scanner;

public class Dots {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.formata();

        System.out.println("Qual jogador iniciara?");
        int jogador = sc.nextInt();
        boolean erro, novoPonto;
        tabuleiro.imprime();
        while (tabuleiro.finalizado() != 0) {
            System.out.println("Digite a posicao da jogada (Jogador " + jogador + "):");
            int jogada = sc.nextInt();
            int jogadaX = 0;
            int jogadaY = 0;

            if (jogada > 12 || jogada < 1) {
                System.out.println("Posicao Invalida! Tente novamente:");
            } else {
                jogadaX = tabuleiro.getX(jogada);
                jogadaY = tabuleiro.getY(jogada);
            }

            erro = tabuleiro.jogada(jogada);
            if (erro == false) {
                while (erro == false) {
                    jogada = sc.nextInt();
                    if (jogada > 12 || jogada < 1) {
                        System.out.println("Posicao Invalida! Tente novamente:");
                    } else {
                        jogadaX = tabuleiro.getX(jogada);
                        jogadaY = tabuleiro.getY(jogada);
                    }
                    erro = tabuleiro.jogada(jogada);
                }
            }
            novoPonto = tabuleiro.condicao(jogadaX, jogadaY, erro, jogador);
            tabuleiro.imprime();
            if (novoPonto == true) {
                System.out.println("Ponto! Jogador " + jogador + " joga novamente!");
                tabuleiro.imprime();
            } else {
                switch (jogador) {
                    case 1:
                        jogador = 2;
                        break;
                    case 2:
                        jogador = 1;
                        break;
                    default:
                        jogador = 0;
                        break;
                }
            }
        }
        System.out.println("Fim de Jogo!");
    }

}
