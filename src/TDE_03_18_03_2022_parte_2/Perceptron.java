package TDE_03_18_03_2022_parte_2;

//Exemplo - Rede Perceptron com apenas 1 neuronio

import java.util.Scanner;

import static java.lang.Math.abs;

public class Perceptron {
    public static void main(String args[]) {
        Neuronio neuronio = new Neuronio();
        int tamanho = 8;
        double x1[] = new double[tamanho]; // 1a entrada
        double x2[] = new double[tamanho]; // 2a entrada
        double d[] = new double[tamanho]; // saida desejada

        // Conjunto de Treino :
        //1
//        x1[0] = 0;
//        x2[0] = 1;
//        d[0] = 1;
//        //2
//        x1[1] = 0;
//        x2[1] = 2;
//        d[1] = 1;
//        //3
//        x1[2] = 1;
//        x2[2] = 1;
//        d[2] = 1;
//        //4
//        x1[3] = 1;
//        x2[3] = 2;
//        d[3] = 1;
//        //5
//        x1[4] = 1;
//        x2[4] = 3;
//        d[4] = 1;
//        //6
//        x1[5] = 2;
//        x2[5] = 2;
//        d[5] = 1;
//        //7
//        x1[6] = 2;
//        x2[6] = 3;
//        d[6] = 1;
//        //8
//        x1[7] = 3;
//        x2[7] = 2;
//        d[7] = 1;
//        //9
//        x1[8] = 4;
//        x2[8] = 1;
//        d[8] = 1;
//        //10
//        x1[9] = 4;
//        x2[9] = 3;
//        d[9] = 1;
//        //11
//        x1[10] = 0;
//        x2[10] = 3;
//        d[10] = 1;
//        //12
//        x1[11] = 2;
//        x2[11] = 0;
//        d[11] = -1;
//        //13
//        x1[12] = 2;
//        x2[12] = 1;
//        d[12] = -1;
//        //14
//        x1[13] = 3;
//        x2[13] = 0;
//        d[13] = -1;
//        //15
//        x1[14] = 3;
//        x2[14] = 1;
//        d[14] = -1;
//        //16
//        x1[15] = 3;
//        x2[15] = 3;
//        d[15] = -1;
//        //17
//        x1[16] = 4;
//        x2[16] = 0;
//        d[16] = -1;
//        //18
//        x1[17] = 4;
//        x2[17] = 2;
//        d[17] = -1;
//        //19
//        x1[18] = 5;
//        x2[18] = 0;
//        d[18] = -1;
//        //20
//        x1[19] = 5;
//        x2[19] = 1;
//        d[19] = -1;
//        //21
//        x1[20] = 5;
//        x2[20] = 2;
//        d[20] = -1;
//        //22
//        x1[21] = 5;
//        x2[21] = 3;
//        d[21] = -1;
        //23
        x1[0] = 0;
        x2[0] = 0;
        d[0] = 1;
        //24
        x1[1] = 1;
        x2[1] = 0;
        d[1] = -1;
        //25
        x1[2] = 4.5;
        x2[2] = 0.5;
        d[2] = -1;
        //26
        x1[3] = 3.5;
        x2[3] = 1.5;
        d[3] = 1;
        //27
        x1[4] = 4;
        x2[4] = 2.5;
        d[4] = 1;
        //28
        x1[5] = 1.5;
        x2[5] = 1.5;
        d[5] = 1;
        //29
        x1[6] = 2;
        x2[6] = 0.5;
        d[6] = -1;
        //30
        x1[7] = 2.5;
        x2[7] = 2.5;
        d[7] =  1;

        // Treinamento
        int epocas = 0, i;
        boolean fim = true;
        double y, erro, erroGeral;
        double eta = 1d;
        double norma1[] = new double[tamanho];
        double norma2[] = new double[tamanho];
        double xmax1 = 0, xmax2 = 0;

        //Valor máximo de x1
        for (i = 0; i < x1.length; i++) {
            if (xmax1 < x1[i]) {
                xmax1 = x1[i];
            }
        }

        //Valor máximo de x2
        for (i = 0; i < x2.length; i++) {
            if (xmax2 < x2[i]) {
                xmax2 = x2[i];
            }
        }

        System.out.println(" \n X1 MAXIMO " + xmax1 + "\n X2 MINIMO: " + xmax2);

        //Normalizacao da x2
        for (i = 0; i < x1.length; i++) {
            norma1[i] = (x1[i] / xmax1);
        }

        //Normalizacao de x1
        for (i = 0; i < x2.length; i++) {
            norma2[i] = (x2[i] / xmax2);
        }

        System.out.println("--- TREINAMENTO");
        while (fim) {
            epocas++;
            erroGeral = 0;
            System.out.println("Epoca: " + epocas);
            for (i = 0; i < tamanho; i++) {
                // propagacao
                System.out.println("N1:" + norma1[i] + "N2:" + norma2[i]);
                y = neuronio.calculaY(norma1[i], norma2[i]);
                System.out.println("y:"+y);
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
            System.out.println("Erros: " + erroGeral);
            Scanner dados = new Scanner(System.in);
            dados.nextInt();
            if (erroGeral == 0){
                fim = false;
            }
        }

        // Generalizacao - Teste da rede
        double entrada1, entrada2;
        Scanner dados = new Scanner(System.in);
        System.out.println("\n--- GENERALIZACAO");

        while (true) {
            double esca1, esca2 = 0;
            int resul;

            // Digita novas entradas
            System.out.println("\n X1: ");
            entrada1 = dados.nextInt();
            if (entrada1 == -100)
                break;

            System.out.print("\n X2: ");
            entrada2 = dados.nextInt();
            if (entrada2 == -100)
                break;

            System.out.print("Digite ' -100 ' para sair: ");

            //Normalizacao
            esca1 = (entrada1 / xmax1);
            esca2 = (entrada2 / xmax2);

            // propagacao
            System.out.println("Saida Gerada pela rede: "
                    + neuronio.calculaY(esca1, esca2));

        }
    }
}
