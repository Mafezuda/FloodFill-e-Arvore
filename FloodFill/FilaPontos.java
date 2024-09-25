public class FilaPontos {
    private int inicio;
    private int fim;
    private Ponto[] dados;
    private int tamanho;

    public FilaPontos(int capacidade) {
        this.dados = new Ponto[capacidade];
        this.inicio = 0;
        this.fim = -1;
        this.tamanho = 0;
    }

    public void adicionar(Ponto ponto) {
        if (estaCheia()) {
            throw new IllegalStateException("A fila está cheia!");
        }
        fim = (fim + 1) % dados.length;
        dados[fim] = ponto;
        tamanho++;
    }

    public Ponto remover() {
        if (estaVazia()) {
            throw new IllegalStateException("A fila está vazia!");
        }
        Ponto removido = dados[inicio];
        dados[inicio] = null;
        inicio = (inicio + 1) % dados.length;
        tamanho--;
        return removido;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == dados.length;
    }
}
