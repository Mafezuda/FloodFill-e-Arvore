public class Ponto {
    private int x;
    private int y;
    private boolean verificado;

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
        this.verificado = false;
    }

    public int getPosX() {
        return x;
    }

    public int getPosY() {
        return y;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void marcarVerificado() {
        this.verificado = true;
    }
}
