package Arvore;

public class Arvore {
    private No raiz;
    private int altura;
    private int profundidade;

    public Arvore(){ this.raiz = null;}

    public No getRaiz(){ return raiz;}

    public void setRaiz(No trocar){ this.raiz = trocar;}

    public void inserir(Letra letra){
        if( raiz == null){
            No r = new No(letra);
            setRaiz(r);
            return;
        }
        char[] simbolos = letra.getSimbolos();

        No atual = raiz;

        for( int i = 0; i < simbolos.length; i++){
            char simbolo = letra.verifica(i);
            
            if( simbolo == '.' ){
                if( atual.getEsquerda() == null){
                    atual.setEsquerda(new No(letra));
                    break;
                }
                else{
                    atual = atual.getEsquerda();
                } 
            }
            else{
                if( atual.getDireita() == null){
                    atual.setDireita(new No(letra));
                    break;
                }
                else{
                    atual =  atual.getDireita();
                }
            }
        }
    }

    public No pesquisar(char[] simbolos){
        No atual = raiz;

        for (int i = 0; i < simbolos.length; i++) {
            char simbolo = simbolos[i];

            if( simbolo != ' '){
                if( simbolo == '.' ){
                    atual.getEsquerda();
                
                }
                else{
                    atual.getDireita();
                }

            }
        }
        return atual;
    }

}