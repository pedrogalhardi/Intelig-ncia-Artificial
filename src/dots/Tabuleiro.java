/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dots;

import java.util.ArrayList;

/**
 *
 * @author 201911020023
 */
public class Tabuleiro {

    private final String[][] tabuleiro;
    private final ArrayList<ArrayList<Integer>> mapa;

    public Tabuleiro() {
        mapa = new ArrayList();
        this.tabuleiro = new String[5][5];

    }

    public void formata() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    tabuleiro[i][j] = "*";
                }
            }
        }
        tabuleiro[1][1] = " ";
        tabuleiro[1][3] = " ";
        tabuleiro[3][1] = " ";
        tabuleiro[3][3] = " ";

        int count = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (tabuleiro[i][j] == null) {
                    tabuleiro[i][j] = Integer.toString(count);
                    count++;
                    ArrayList<Integer> entrada = new ArrayList();
                    entrada.add(i);
                    entrada.add(j);
                    mapa.add(entrada);
                }
            }
        }
    }

    public void imprime() {
        System.out.println("\n");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(tabuleiro[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public boolean jogada(int jogada) {
        int jogadaX;
        int jogadaY;
                
        if (jogada > 12 || jogada < 1) {
            System.out.println("Posicao Invalida! Tente novamente:");
            return false;
        } else {
             jogadaX = mapa.get(jogada - 1).get(0);
             jogadaY = mapa.get(jogada - 1).get(1);
        }

        if (jogadaX >= 5 || jogadaX < 0 || jogadaY >= 5 || jogadaY < 0) {
            System.out.println("Local Invalido, tente novamente:");
            return false;

        } else if (tabuleiro[jogadaX][jogadaY].equals("-") || tabuleiro[jogadaX][jogadaY].equals("|")) {
            System.out.println("Local ja ocupado por um traco! Tente novamente:");
            return false;

        } else if (jogadaX % 2 != 0 && jogadaY % 2 == 0) {
            tabuleiro[jogadaX][jogadaY] = "|";
            return true;

        } else if (jogadaX % 2 == 0 && jogadaY % 2 != 0) {
            tabuleiro[jogadaX][jogadaY] = "-";
            return true;

        }
        System.out.println("Local Inexistente no jogo. Digite outro:");
        return false;
    }

    public int getX(int jogada) {
        return mapa.get(jogada - 1).get(0);
    }

    public int getY(int jogada) {
        return mapa.get(jogada - 1).get(1);
    }

    public boolean condicao(int jogadaX, int jogadaY, boolean erro, int jogador) {
        int novoQuadrado = 0;
        if (erro == true) {
            if (jogadaX >= 1 && jogadaY >= 2) {
                if ((tabuleiro[jogadaX][jogadaY].equals("|")) && (tabuleiro[jogadaX][jogadaY - 2].equals("|")) && (tabuleiro[jogadaX - 1][jogadaY - 1].equals("-") && tabuleiro[jogadaX + 1][jogadaY - 1].equals("-"))) {
                    switch (jogador) {
                        case 1:
                            tabuleiro[jogadaX][jogadaY - 1] = "1";
                            break;
                        case 2:
                            tabuleiro[jogadaX][jogadaY - 1] = "2";
                            break;
                        default:
                            System.out.println("Ocorreu algum erro!");
                            break;
                    }
                    novoQuadrado++;
                }
            }
            if ((jogadaX + 1) < 5 && (jogadaY + 2) < 5 && (jogadaX - 1 >= 0)) {
                if (tabuleiro[jogadaX][jogadaY].equals("|") && (tabuleiro[jogadaX][jogadaY + 2].equals("|")) && (tabuleiro[jogadaX + 1][jogadaY + 1].equals("-") && tabuleiro[jogadaX - 1][jogadaY + 1].equals("-"))) {
                    switch (jogador) {
                        case 1:
                            tabuleiro[jogadaX][jogadaY + 1] = "1";
                            break;
                        case 2:
                            tabuleiro[jogadaX][jogadaY + 1] = "2";
                            break;
                        default:
                            System.out.println("Ocorreu algum erro!");
                            break;
                    }
                    novoQuadrado++;
                }
            }
            if ((jogadaX + 2) < 5 && (jogadaY + 1) < 5 && (jogadaY - 1 >= 0)) {
                if (tabuleiro[jogadaX][jogadaY].equals("-") && (tabuleiro[jogadaX + 2][jogadaY].equals("-")) && (tabuleiro[jogadaX + 1][jogadaY + 1].equals("|")) && (tabuleiro[jogadaX + 1][jogadaY - 1].equals("|"))) {
                    switch (jogador) {
                        case 1:
                            tabuleiro[jogadaX + 1][jogadaY] = "1";
                            break;
                        case 2:
                            tabuleiro[jogadaX + 1][jogadaY] = "2";
                            break;
                        default:
                            System.out.println("Ocorreu algum erro!");
                            break;
                    }
                    novoQuadrado++;
                }
            }
            if ((jogadaX - 2) >= 0 && (jogadaY - 1) >= 0 && (jogadaY + 1) < 5) {
                if ((tabuleiro[jogadaX][jogadaY].equals("-")) && (tabuleiro[jogadaX - 2][jogadaY].equals("-")) && (tabuleiro[jogadaX - 1][jogadaY + 1].equals("|")) && (tabuleiro[jogadaX - 1][jogadaY - 1].equals("|"))) {
                    switch (jogador) {
                        case 1:
                            tabuleiro[jogadaX - 1][jogadaY] = "1";
                            break;
                        case 2:
                            tabuleiro[jogadaX - 1][jogadaY] = "2";
                            break;
                        default:
                            System.out.println("Ocorreu algum erro!");
                            break;
                    }
                    novoQuadrado++;
                }
            }
            if (novoQuadrado > 0) {
                return true;
            }

        }
        return false;
    }

    public int finalizado() {
        int pontuacao1 = 0, pontuacao2 = 0;
        int contador = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (tabuleiro[i][j].equals(" ")) {
                    contador++;
                }
                if (tabuleiro[i][j].equals("1")) {
                    pontuacao1++;
                }
                if (tabuleiro[i][j].equals("2")) {
                    pontuacao2++;
                }
            }
        }
        if (contador == 0) {
            System.out.println("\nPontuacao FINAL:\nJogador 1: " + pontuacao1 + " ponto(s);\nJogador 2: " + pontuacao2 + " ponto(s);\n");
            if (pontuacao1 > pontuacao2) {
                System.out.println("Vencedor:\nJogador 1!");
            }
            if (pontuacao1 < pontuacao2) {
                System.out.println("Vencedor:\nJogador 2!");
            }
            if (pontuacao1 == pontuacao2) {
                System.out.println("Resultado: Empate!");
            }
        } else {
            System.out.println("\nPontuacao atual:\nJogador 1: " + pontuacao1 + " ponto(s);\nJogador 2: " + pontuacao2 + " ponto(s);\n");
        }
        return contador;
    }
}
