public class Coordenada {
    private int x;
    private int y;
    private boolean verificada;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
        this.verificada = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getVerificada() {
        return verificada;
    }

    public void setVerificada() {
        this.verificada = true;
    }
}
