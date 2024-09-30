package Arvore;

import java.util.Scanner;

public class Main {

    public static void inserirElementos(Arvore a) {
        a.inserir(new Letra(' '));

        char[] e = { '.' };
        a.inserir(new Letra('E', e));

        char[] i = { '.', '.' };
        a.inserir(new Letra('I', i));

        char[] s = { '.', '.', '.' };
        a.inserir(new Letra('S', s));

        char[] h = { '.', '.', '.', '.' };
        a.inserir(new Letra('H', h));

        char[] v = { '.', '.', '.', '-' };
        a.inserir(new Letra('V', v));

        char[] u = { '.', '.', '-' };
        a.inserir(new Letra('U', u));

        char[] f = { '.', '.', '-', '.' };
        a.inserir(new Letra('F', f));

        char[] a = { '.', '-' };
        a.inserir(new Letra('A', a));

        char[] r = { '.', '-', '.' };
        a.inserir(new Letra('R', r));

        char[] l = { '.', '-', '.', '.' };
        a.inserir(new Letra('L', l));

        char[] w = { '.', '-', '-' };
        a.inserir(new Letra('W', w));

        char[] p = { '.', '-', '-', '.' };
        a.inserir(new Letra('P', p));

        char[] j = { '.', '-', '-', '-' };
        a.inserir(new Letra('J', j));

        char[] t = { '-' };
        a.inserir(new Letra('T', t));

        char[] m = { '-', '-' };
        a.inserir(new Letra('M', m));

        char[] o = { '-', '-', '-' };
        a.inserir(new Letra('O', o));

        char[] g = { '-', '-', '.' };
        a.inserir(new Letra('G', g));

        char[] q = { '-', '-', '.', '-' };
        a.inserir(new Letra('Q', q));

        char[] z = { '-', '-', '.', '.' };
        a.inserir(new Letra('Z', z));

        char[] n = { '-', '.' };
        a.inserir(new Letra('N', n));

        char[] k = { '-', '.', '-' };
        a.inserir(new Letra('K', k));

        char[] y = { '-', '.', '-', '-' };
        a.inserir(new Letra('Y', y));

        char[] c = { '-', '.', '-', '.' };
        a.inserir(new Letra('C', c));

        char[] d = { '-', '.', '.' };
        a.inserir(new Letra('D', d));

        char[] b = { '-', '.', '.', '.' };
        a.inserir(new Letra('B', b));

        char[] x = { '-', '.', '.', '-' };
        a.inserir(new Letra('X', x));
    }

    public static String imprimir(char[] decifrado) {
        String palavra = "";
        for (char d : decifrado) {
            if (d != ' ') {
                palavra += d;
            }
        }
        return palavra;
    }

    public static void main(String[] args) {
        Arvore a = new Arvore();
        inserirElementos(a);

        Scanner scan = new Scanner(System.in);

        System.out.println("Escolha uma opção: ");
        System.out.println("1- Digitar um código");
        System.out.println("2- Imprimir árvore");

        int opcao = scan.nextInt();
        scan.nextLine(); // Consumir nova linha

        switch (opcao) {
            case 1:
                System.out.println("Digite o código (utilize espaço para separar as letras):");
                String codigo = scan.nextLine();
                String[] simbolos = codigo.split(" ");
                char[] decifrado = new char[simbolos.length];
                int posicao = 0;
                for (String simbolo : simbolos) {
                    No no = a.pesquisar(simbolo.toCharArray());
                    if (no != null) {
                        decifrado[posicao] = no.getLetra().getValor();
                        posicao++;
                    } else {
                        System.out.println("Entrada inválida!");
                    }
                }

                System.out.println("Decifrado: " + imprimir(decifrado));
                break;
            case 2:
                a.imprimirArvore();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }

        scan.close(); // Fechar o scanner
    }
}