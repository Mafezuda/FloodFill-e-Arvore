public class PilhaPontos {
    private int topo;
    private Ponto[] elementos;

    public PilhaPontos(int tamanho) {
        this.topo = -1;
        this.elementos = new Ponto[tamanho];
    }

    public void empilhar(Ponto ponto) {
        if (estaCheia()) {
            throw new IllegalStateException("A pilha está cheia!");
        }
        this.elementos[++topo] = ponto;
    }

    public Ponto desempilhar() {
        if (estaVazia()) {
            throw new IllegalStateException("A pilha está vazia!");
        }
        Ponto removido = this.elementos[topo];
        this.elementos[topo] = null;
        topo--;
        return removido;
    }

    public boolean estaCheia() {
        return topo + 1 == elementos.length;
    }

    public boolean estaVazia() {
        return topo == -1;
    }
}
