public class Fila {
    private int frente;
    private int traseira;
    private Coordenada[] dados;
    private int tamanho;

    public Fila(int tamanho) {
        this.dados = new Coordenada[tamanho];
        this.frente = 0;
        this.traseira = -1;
        this.tamanho = 0;
    }

    public void enfileirar(Coordenada coordenada) {
        if (estaCheia()) {
            throw new IllegalStateException("A fila está cheia!");
        }
        traseira = (traseira + 1) % dados.length;
        dados[traseira] = coordenada;
        tamanho++;
    }

    public Coordenada desenfileirar() {
        if (estaVazia()) {
            throw new IllegalStateException("A fila está vazia!");
        }
        Coordenada itemRemovido = dados[frente];
        dados[frente] = null;
        frente = (frente + 1) % dados.length;
        tamanho--;
        return itemRemovido;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == dados.length;
    }
}
