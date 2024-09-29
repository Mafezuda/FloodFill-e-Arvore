package Arvore;

public class Letra {
    private char valor;
    private char[] simbolos;

    public Letra(char valor){
        this.valor = valor;
    }

    public Letra(char valor, char[] simbolos){
        this.valor = valor;
        this.simbolos = simbolos;
    }

    public char verifica(int posicao){
        return simbolos[posicao];
    }

    public char getValor(){ return valor;}

    public char[] getSimbolos(){ return simbolos;}

    public void setValor(char trocar){ this.valor = trocar;}

}
