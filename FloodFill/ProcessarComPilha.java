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

        while (!pilha.estaVazia()) {
            Ponto atual = pilha.desempilhar(); 
            int x = atual.getPosX();
            int y = atual.getPosY();

            if (x >= 0 && x < foto.obterLargura() && y >= 0 && y < foto.obterAltura()) {
                if (foto.obterCorPonto(atual) == corOriginal && !atual.isVerificado()) {
                    foto.alterarCorPonto(atual, novaCor);
                    atual.marcarVerificado();

                    pilha.empilhar(new Ponto(x + 1, y));
                    pilha.empilhar(new Ponto(x - 1, y));
                    pilha.empilhar(new Ponto(x, y + 1));
                    pilha.empilhar(new Ponto(x, y - 1));

                    painel.atualizarFoto(foto);
                    foto.salvarFoto("Fotos/foto_alterada_pilha.png");
                }
            }
        }
    }
}
