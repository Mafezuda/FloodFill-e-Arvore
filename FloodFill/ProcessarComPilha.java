import java.awt.Color;

public class ProcessarComPilha {
    public static void main(String[] args) {
        Foto foto = new Foto("Fotos/foto.png");
        PainelImagem painel = new PainelImagem(foto, "Visualizando Foto");
        painel.exibirImagem();
        Ponto pontoInicial = new Ponto(10, 10);
        int corOriginal = foto.obterCorPonto(pontoInicial);
        int novaCor = new Color(0, 128, 0).getRGB(); // Verde
        PilhaPontos pilha = new PilhaPontos(foto.obterAltura() * foto.obterLargura());
        pilha.empilhar(pontoInicial);

        // Contador para controlar a atualização da imagem durante o processamento
        int contador = 0;
        int intervaloAtualizacao = 1000;

        while (!pilha.estaVazia()) {
            Ponto atual = pilha.desempilhar();
            int x = atual.getPosX();
            int y = atual.getPosY();

            if (x >= 0 && x < foto.obterLargura() && y >= 0 && y < foto.obterAltura()) {
                if (foto.obterCorPonto(atual) == corOriginal && !atual.isVerificado()) {
                    foto.alterarCorPonto(atual, novaCor);

                    atual.marcarVerificado();

                    if (x + 1 < foto.obterLargura()) pilha.empilhar(new Ponto(x + 1, y));
                    if (x - 1 >= 0) pilha.empilhar(new Ponto(x - 1, y));
                    if (y + 1 < foto.obterAltura()) pilha.empilhar(new Ponto(x, y + 1));
                    if (y - 1 >= 0) pilha.empilhar(new Ponto(x, y - 1));
                    contador++;
                    if (contador % intervaloAtualizacao == 0) {
                        painel.atualizarFoto(foto);
                    }
                }
            }
        }

        // Atualiza a imagem uma última vez após o processo
        painel.atualizarFoto(foto);

        // Salva a imagem alterada no final
        foto.salvarFoto("Fotos/foto_alterada_pilha.png");
    }
}
