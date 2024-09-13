import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Imagem {
    private BufferedImage imagem;
    private int largura;
    private int altura;
    private String caminho;

    public Imagem(String caminho) {
        try {
            this.imagem = ImageIO.read(new File(caminho));
            this.largura = imagem.getWidth();
            this.altura = imagem.getHeight();
            this.caminho = caminho;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCorPixel(Coordenada coordenada) {
        return imagem.getRGB(coordenada.getX(), coordenada.getY());
    }

    public void setCorPixel(Coordenada coordenada, int cor) {
        imagem.setRGB(coordenada.getX(), coordenada.getY(), cor);
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public String getCaminho() {
        return caminho;
    }

    public BufferedImage getImagem() {
        return imagem;
    }

    public void salvarImagem(String caminho) {
        try {
            File arquivo = new File(caminho);
            ImageIO.write(imagem, "png", arquivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
