package Arvore;

import java.util.ArrayList;
import java.util.List;

public class Arvore {
    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public void inserir(Letra letra) {
        if (raiz == null) {
            No r = new No(letra);
            setRaiz(r);
            return;
        }
        char[] simbolos = letra.getSimbolos();
        No atual = raiz;

        for (int i = 0; i < simbolos.length; i++) {
            char simbolo = letra.verifica(i);
            if (simbolo == '.') {
                if (atual.getEsquerda() == null) {
                    atual.setEsquerda(new No(letra));
                    break;
                } else {
                    atual = atual.getEsquerda();
                }
            } else {
                if (atual.getDireita() == null) {
                    atual.setDireita(new No(letra));
                    break;
                } else {
                    atual = atual.getDireita();
                }
            }
        }
    }

    public No pesquisar(char[] simbolos) {
        No atual = raiz;

        for (char simbolo : simbolos) {
            if (simbolo == '.') {
                atual = atual.getEsquerda();
            } else if (simbolo == '-') {
                atual = atual.getDireita();
            }
        }
        return atual;
    }

    // Função para imprimir a árvore em formato hierárquico com os "trapinhos"
    public static void imprimirArvore(No raiz) {
        List<List<String>> linhas = new ArrayList<>();
        construirLinhas(raiz, 0, linhas);
        for (String linha : formatarLinhas(linhas)) {
            System.out.println(linha);
        }
    }

    // Função recursiva para construir as linhas da árvore
    private static void construirLinhas(No no, int nivel, List<List<String>> linhas) {
        if (nivel == linhas.size()) {
            linhas.add(new ArrayList<>());
        }
        if (no == null) {
            linhas.get(nivel).add(null); // Nó vazio
            if (nivel + 1 < linhas.size()) {
                construirLinhas(null, nivel + 1, linhas); // Garante que nós vazios sejam preenchidos nos próximos níveis
                construirLinhas(null, nivel + 1, linhas);
            }
            return;
        }
        linhas.get(nivel).add(String.valueOf(no.getLetra().getValor()));
        construirLinhas(no.getEsquerda(), nivel + 1, linhas);
        construirLinhas(no.getDireita(), nivel + 1, linhas);
    }

    // Função para formatar as linhas com os "trapinhos" conectando os nós
    private static List<String> formatarLinhas(List<List<String>> linhas) {
        List<String> resultado = new ArrayList<>();
        int espacoEntreNos = (int) Math.pow(2, linhas.size()); // Espaçamento inicial

        for (int i = 0; i < linhas.size(); i++) {
            List<String> nivel = linhas.get(i);
            StringBuilder linhaNos = new StringBuilder();
            StringBuilder linhaConexoes = new StringBuilder();

            // Ajuste para centralizar o primeiro nó
            if (i == 0) {
                linhaNos.append(" ".repeat(espacoEntreNos / 2));
            }

            for (int j = 0; j < nivel.size(); j++) {
                String valorNo = nivel.get(j);
                if (valorNo == null) {
                    linhaNos.append(" ".repeat(espacoEntreNos));
                    if (i < linhas.size() - 1) {
                        linhaConexoes.append(" ".repeat(espacoEntreNos));
                    }
                } else {
                    linhaNos.append(" ".repeat(espacoEntreNos / 2 - 1)).append(valorNo)
                            .append(" ".repeat(espacoEntreNos / 2));
                    if (i < linhas.size() - 1) {
                        if (j % 2 == 0) {
                            linhaConexoes.append(" ".repeat(espacoEntreNos / 2 - 1)).append("/")
                                    .append(" ".repeat(espacoEntreNos / 2));
                        } else {
                            linhaConexoes.append(" ".repeat(espacoEntreNos / 2)).append("\\")
                                    .append(" ".repeat(espacoEntreNos / 2 - 1));
                        }
                    }
                }
            }
            resultado.add(linhaNos.toString());
            if (i < linhas.size() - 1) {
                resultado.add(linhaConexoes.toString());
            }
            espacoEntreNos /= 2; // Reduz o espaçamento a cada nível
        }

        return resultado;
    }

   

    
}
