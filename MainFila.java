import java.awt.Color;

public class MainFila {
    public static void main(String[] args) {
        Imagem imagem = new Imagem("Imagem/imagem.png");
        InterfaceGrafica interfaceGrafica = new InterfaceGrafica(imagem, "Exibindo Imagem");
        interfaceGrafica.mostrarImagem();

        int x = 10;
        int y = 10;
        Coordenada coordenadaInicial = new Coordenada(x, y);
        int corInicial = imagem.getCorPixel(coordenadaInicial);
        int corEscolhida = new Color(0, 255, 0).getRGB(); // Verde

        Fila fila = new Fila(imagem.getAltura() * imagem.getLargura());
        fila.enfileirar(coordenadaInicial);

        while (!fila.estaVazia()) {
            Coordenada coordenadaAtual = fila.desenfileirar();
            int coordX = coordenadaAtual.getX();
            int coordY = coordenadaAtual.getY();

            if (coordX >= 0 && coordX < imagem.getLargura() && coordY >= 0 && coordY < imagem.getAltura()) {
                if (imagem.getCorPixel(coordenadaAtual) == corInicial && !coordenadaAtual.getVerificada()) {
                    imagem.setCorPixel(coordenadaAtual, corEscolhida);
                    coordenadaAtual.setVerificada();

                    fila.enfileirar(new Coordenada(coordX + 1, coordY));
                    fila.enfileirar(new Coordenada(coordX - 1, coordY));
                    fila.enfileirar(new Coordenada(coordX, coordY + 1));
                    fila.enfileirar(new Coordenada(coordX, coordY - 1));
                    interfaceGrafica.atualizarImagem(imagem);
                    imagem.salvarImagem("Imagem/imagem_modificada.png");
                }
            }
        }
    }
}
