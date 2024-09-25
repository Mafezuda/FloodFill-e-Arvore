import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Foto {
    private BufferedImage imagem;
    private int largura;
    private int altura;

    public Foto(String caminho) {
        try {
            this.imagem = ImageIO.read(new File(caminho));
            this.largura = imagem.getWidth();
            this.altura = imagem.getHeight();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar a imagem: " + caminho, e);
        }
    }

    public int obterCorPonto(Ponto ponto) {
        return imagem.getRGB(ponto.getPosX(), ponto.getPosY());
    }

    public void alterarCorPonto(Ponto ponto, int cor) {
        imagem.setRGB(ponto.getPosX(), ponto.getPosY(), cor);
    }

    public int obterLargura() {
        return largura;
    }

    public int obterAltura() {
        return altura;
    }

    public BufferedImage getImagem() {
        return imagem;
    }

    public void salvarFoto(String caminho) {
        try {
            File arquivo = new File(caminho);
            ImageIO.write(imagem, "png", arquivo);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar a imagem: " + caminho, e);
        }
    }
}
