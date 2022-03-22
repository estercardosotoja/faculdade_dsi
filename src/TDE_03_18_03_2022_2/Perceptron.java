package TDE_03_18_03_2022_2;

//Exemplo - Rede Perceptron com apenas 1 neuronio

import java.util.Scanner;
import static java.lang.Math.abs;

public class Perceptron {
    public static void main(String args[]) {
        Neuronio neuronio = new Neuronio();

        int x1[] = new int[14]; // 1a entrada
        int x2[] = new int[14]; // 2a entrada
        int d[] = new int[14]; // saida desejada

        // Conjunto de Treino : Renda, Dividas Classe
        //101
        x1[0] = 2800;
        x2[0] = 550;
        d[0] = 1;
        //102
        x1[1] = 1300;
        x2[1] = 500;
        d[1] = 0;
        //103
        x1[2] = 1400;
        x2[2] = 80;
        d[2] = 1;
        //104
        x1[3] = 500;
        x2[3] = 200;
        d[3] = 0;
        //105
        x1[4] = 1100;
        x2[4] = 270;
        d[4] = 0;
        //106
        x1[5] = 1800;
        x2[5] = 450;
        d[5] = 1;
        //107
        x1[6] = 2400;
        x2[6] = 650;
        d[6] = 1;
        //108
        x1[7] = 1950;
        x2[7] = 600;
        d[7] = 1;
        //109
        x1[8] = 450;
        x2[8] = 70;
        d[8] = 0;
        //110
        x1[9] = 2750;
        x2[9] = 730;
        d[9] = 1;
        //111
        x1[10] = 850;
        x2[10] = 90;
        d[10] = 0;
        //112
        x1[11] = 1300;
        x2[11] = 200;
        d[11] = 0;
        //113
        x1[12] = 2100;
        x2[12] = 750;
        d[12] = 1;
        //114
        x1[13] = 900;
        x2[13] = 300;
        d[13] = 0;

        // Treinamento
        int epocas = 0, i;
        boolean fim = true;
        double y, erro, erroGeral;
        double eta = 1;
        double norma1[] = new double[14];
        double norma2[] = new double[14];
        double xmaxren = 0, xmaxdiv = 0;

        //Valor máximo e minimo da renda
        for (i = 0; i < x1.length; i++) {
            if (xmaxren < x1[i]) {
                xmaxren = x1[i];
            }
        }

        //Valor máximo e minimo da divida
        for (i = 0; i < x2.length; i++) {
            if (xmaxdiv < x2[i]) {
                xmaxdiv = x2[i];
            }
        }

        /*
         * Para realizar a normalização usarei a regra:
         * C' = (valor_entrada / valor_maximo_renda)
         * Para utilizar a formula acima, determino quais são os valores máximo e minimos:
         *  */

        //Normalizacao da renda
        for (i = 0; i < x1.length; i++) {
            norma1[i] = (x1[i]  / xmaxren);
        }

        //Normalizacao da divida
        for (i = 0; i < x2.length; i++) {
            norma2[i] = (x2[i] / xmaxdiv);
        }

        System.out.println("--- TREINAMENTO");
        while (fim) {
            epocas++;
            int tam = x1.length;
            erroGeral = 0;
            System.out.println("Epoca: " + epocas);
            for (i = 0; i < tam; i++) {

                // propagacao
                y = neuronio.calculaY(norma1[i], norma2[i]);

                // calcula do erro
                erro = d[i] - y;

                // ajuste dos pesos
                if (erro != 0) {
                    neuronio.setW0(neuronio.getW0() + eta * erro);
                    neuronio.setW1(neuronio.getW1() + eta * erro * norma1[i]);
                    neuronio.setW2(neuronio.getW2() + eta * erro * norma2[i]);
                }
                System.out.println("Neuronio - pesos: " + neuronio);
                erroGeral = erroGeral + abs(erro);
            }
            // para quando para todas as entradas o erro for zero
            System.out.println("Erros: " + erroGeral);
            if (erroGeral == 0){
                fim = false;
            }
        }

        // Generalizacao - Teste da rede
        double entrada1, entrada2;
        Scanner dados = new Scanner(System.in);
        System.out.println("\n--- GENERALIZACAO");
        System.out.println("\n Utilizado calculo  C' = (valor_entrada  / valor_maximo)");

        while (true) {
            double esca1, esca2 = 0;
            int resul;

            // Digita novas entradas
            System.out.println("\n Renda: ");
            entrada1 = dados.nextInt();
            if (entrada1 == -1)
                break;

            System.out.print("\n Dívida: ");
            entrada2 = dados.nextInt();
            if (entrada2 == -1)
                break;

            System.out.print("Digite ' -1 ' para sair: ");

            //Normalizacao
            esca1 = (entrada1 / xmaxren);
            esca2 = (entrada2 / xmaxdiv);

            //Propagação
            resul = neuronio.calculaY(esca1, esca2);
            if (resul == 1){
                System.out.println("\n Cliente: Bom" );
            }else {
                System.out.println("\n Cliente: Mal" );
            }

        }
    }
}
