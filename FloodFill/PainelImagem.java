import javax.swing.*;
import java.awt.*;

public class PainelImagem {
    private JFrame janela;
    private JLabel rotuloImagem;

    public PainelImagem(Foto foto, String tituloJanela) {
        this.janela = new JFrame(tituloJanela);
        this.rotuloImagem = new JLabel(new ImageIcon(foto.getImagem()));
        janela.add(rotuloImagem);
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void exibirImagem() {
        janela.setVisible(true);
    }

    public void atualizarFoto(Foto foto) {
        this.rotuloImagem.setIcon(new ImageIcon(foto.getImagem()));
        janela.repaint();
    }
}
