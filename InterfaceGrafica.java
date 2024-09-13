import javax.swing.*;
import java.awt.*;

public class InterfaceGrafica {
    private JFrame frame;
    private JLabel label;

    public InterfaceGrafica(Imagem imagem, String nome) {
        this.frame = new JFrame(nome);
        this.label = new JLabel(new ImageIcon(imagem.getImagem()));
        frame.add(label);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void mostrarImagem() {
        frame.setVisible(true);
    }

    public void atualizarImagem(Imagem imagem) {
        this.label.setIcon(new ImageIcon(imagem.getImagem()));
        frame.repaint();
    }
}
