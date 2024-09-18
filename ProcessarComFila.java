import java.awt.Color;

public class ProcessarComFila {
    public static void main(String[] args) {
        Foto foto = new Foto("Fotos/foto.png");
        PainelImagem painel = new PainelImagem(foto, "Visualizando Foto");
        painel.exibirImagem();

        Ponto pontoInicial = new Ponto(10, 10);
        int corOriginal = foto.obterCorPonto(pontoInicial);
        int novaCor = new Color(0, 128, 0).getRGB(); // Verde

        FilaPontos fila = new FilaPontos(foto.obterAltura() * foto.obterLargura());
        fila.adicionar(pontoInicial);

        int contador = 0;
        int intervaloAtualizacao = 10;
        while (!fila.estaVazia()) {
            Ponto atual = fila.remover();
            int x = atual.getPosX();
            int y = atual.getPosY();

            if (x >= 0 && x < foto.obterLargura() && y >= 0 && y < foto.obterAltura()) {
                if (foto.obterCorPonto(atual) == corOriginal && !atual.isVerificado()) {
                    foto.alterarCorPonto(atual, novaCor);
                    atual.marcarVerificado();

                    fila.adicionar(new Ponto(x + 1, y));
                    fila.adicionar(new Ponto(x - 1, y));
                    fila.adicionar(new Ponto(x, y + 1));
                    fila.adicionar(new Ponto(x, y - 1));
                    contador++;
                    if (contador % intervaloAtualizacao == 0) {
                        painel.atualizarFoto(foto);
                    }
                }
            }
        }

        painel.atualizarFoto(foto);
        foto.salvarFoto("Fotos/foto_alterada_fila.png");
    }
}
