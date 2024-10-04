package Arvore;

public class No {
    private Letra valor;
    private No direita;
    private No esquerda;

    public No(Letra valor){
        this.valor = valor;
        this.direita = null;
        this.esquerda = null;
    }

    public Letra getLetra(){ return valor;}

    public No getDireita(){ return direita;}

    public No getEsquerda(){ return esquerda;}

    public void setLetra(Letra a){ this.valor = a;}
    
    public void setDireita(No trocar){ this.direita = trocar;}

    public void setEsquerda(No trocar){ this.esquerda = trocar;}
}
