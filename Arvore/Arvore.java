package Arvore;

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

    public void imprimirArvore() {
        int h = altura(raiz);
        for (int i = 0; i < h; i++) {
            imprimirNivel(raiz, i, h);
            System.out.println();
        }
    }

    private void imprimirNivel(No no, int nivel, int altura) {
        if (no == null) {
            for (int j = 0; j < Math.pow(2, altura - nivel) - 1; j++) {
                System.out.print("   "); // Espaço para manter o alinhamento
            }
            return;
        }

        if (nivel == 0) {
            System.out.print(no.getLetra().getValor() + " ");
        } else {
            imprimirNivel(no.getEsquerda(), nivel - 1, altura);  // Imprime a subárvore esquerda primeiro
            for (int j = 0; j < Math.pow(2, altura - nivel) - 1; j++) {
                System.out.print("   "); // Espaço para manter o alinhamento
            }
            imprimirNivel(no.getDireita(), nivel - 1, altura);  // Imprime a subárvore direita
        }
    }

    private int altura(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + Math.max(altura(no.getEsquerda()), altura(no.getDireita()));
    }
}
