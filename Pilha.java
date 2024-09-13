public class Pilha {
    private int topo;
    private Coordenada[] dados;

    public Pilha(int tamanho) {
        this.topo = -1;
        this.dados = new Coordenada[tamanho];
    }

    public void empilhar(Coordenada coordenada) {
        if (estaCheia()) {
            throw new IllegalStateException("A pilha está cheia!");
        }
        this.dados[++topo] = coordenada;
    }

    public boolean estaCheia() {
        return topo + 1 == dados.length;
    }

    public Coordenada desempilhar() {
        if (estaVazia()) {
            throw new IllegalStateException("A pilha já está vazia!");
        }
        Coordenada itemRemovido = this.dados[topo];
        this.dados[topo] = null;
        topo--;
        return itemRemovido;
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public void limpar() {
        dados = new Coordenada[dados.length];
        topo = -1;
    }
}
