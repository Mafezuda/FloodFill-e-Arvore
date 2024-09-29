package Arvore;

import java.util.Scanner;

public class Main {

    public static void inserirElementos(Arvore a){
        Letra[] letras = new Letra[26];
        a.inserir(new Letra(' '));

        char[] e = {'.'};
        a.inserir(new Letra('E', e));

        char[] i = {'.', '.'};
        a.inserir(new Letra('I', i));

        char[] s = {'.', '.', '.'};
        a.inserir(new Letra('S', s));

        char[] h = {'.', '.', '.', '.'};
        a.inserir(new Letra('H', h));

        char[] v = {'.', '.', '.', '-'};
        a.inserir(new Letra('V', v));

        char[] u = {'.', '.', '-'};
        a.inserir(new Letra('U', u));

        char[] f = {'.', '.', '-', '.'};
        a.inserir(new Letra('F', f));

        char[] A = {'.', '-'};
        a.inserir(new Letra('A', A));

        char[] r = {'.', '-', '.'};
        a.inserir(new Letra('R', r));

        char[] l = {'.', '-', '.', '.'};
        a.inserir(new Letra('L', l));

        char[] w = {'.', '-', '-'};
        a.inserir(new Letra('W', w));

        char[] p = {'.', '-', '-', '.'};
        a.inserir(new Letra('P', p));

        char[] j = {'.', '-', '-', '-'};
        a.inserir(new Letra('J', j));

        char[] t = {'-'};
        a.inserir(new Letra('T', t));

        char[] m = {'-', '-'};
        a.inserir(new Letra('M', m));

        char[] o = {'-', '-', '-'};
        a.inserir(new Letra('o', o));

        char[] g = {'-', '-', '.'};
        a.inserir(new Letra('G', g));

        char[] q = {'-', '-', '.', '-'};
        a.inserir(new Letra('Q', q));

        char[] z = {'-', '-', '.', '.'};
        a.inserir(new Letra('Z', z));

        char[] n = {'-', '.'};
        a.inserir(new Letra('N', n));

        char[] k = {'-', '.', '-'};
        a.inserir(new Letra('K', k));

        char[] y = {'-', '.', '-', '-'};
        a.inserir(new Letra('Y', y));

        char[] c = {'-', '.', '-', '.'};
        a.inserir(new Letra('C', c));

        char[] d = {'-', '.', '.'};
        a.inserir(new Letra('D', d));

        char[] b = {'-', '.', '.', '.'};
        a.inserir(new Letra('B', b));

        char[] x = {'-', '.', '.', '-'};
        a.inserir(new Letra('X', x));
    }
    
        
    public static void main(String[] args) {
        Arvore a = new Arvore();
        inserirElementos(a);
      
        Scanner scan = new Scanner(System.in);

        System.out.println("Escolha uma opção: ");
        System.out.println("1- Digitar uma código");
        System.out.println("2- Imprimir árvore");

        int opcao = scan.nextInt();

        switch (opcao) {
            case 1:
                Scanner s = new Scanner(System.in);
                System.out.println("Digite o código(utilize espaço para separar as letras):");     
                String codigo = s.nextLine();
                char[] simbolos = new char[4];
                char[] decifrado = new char[codigo.length()];
                int posicao = 0;
                for (int i = 0; i < codigo.length(); i++) {
                    if(codigo.charAt(i) == ' '){
                       No no = a.pesquisar(simbolos);
                       decifrado[posicao] = no.getLetra().getValor();
                       posicao++;
                       simbolos = new char[4];
                       i = -1;
                    }
                    else{
                        char letra = codigo.charAt(i); 
                        simbolos[i] = letra;
                    }
                }
                break;
            case 2:
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");;
        }



    }
    
}
