package Recall;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        /// задание для контрольной работы

        //добавить иницирование переменных

        int a, b, c;
        a = 10;
        b = 2;
        c = 3;


        System.out.println(a *= c);
        System.out.println(a /= c);
        System.out.println(a += c);
        System.out.println(a -= c);
        System.out.println(a %= c);
        System.out.println();

        int d = ++b;
        System.out.println(d);
        System.out.println(b);
        int e = b++;
        System.out.println(e);
        System.out.println(b);


        //if

        int m = 1;
        if (m > 7) {
            System.out.println("Больше 7");
        }
        if (m > 3) {
            System.out.println("Больше 3");
        }
        if (m > 3 & m < 7) {
            System.out.println("От 3 до 7");
        }
        if (m < 3) {
            System.out.println("Меньше 3");
        }


        //switch - case - default

        String number = "2";
        switch (number) {
            case "Один":
                System.out.println("One");
                break;
            case "Два":
                System.out.println("Two");
                break;
            case "Три":
                System.out.println("Three");
                break;
            case "Четыре":
                System.out.println("Four");
                break;
            case "Пять":
                System.out.println("Five");
                break;
            default:
                System.out.println("Oops, something went wrong!");

        }


        int y = 0;
        int x = 1;
        int fibonacciResult = 0;
        int counter = 0;
        String method = "for";
        switch (method) {

            case "while":
                while (counter <= 20) {
                    System.out.print(fibonacciResult + " ");
                    fibonacciResult = x + y;
                    x = y;
                    y = fibonacciResult;
                    counter++;
                }

            case "do-while":
                do {
                    System.out.print(fibonacciResult + " ");
                    fibonacciResult = x + y;
                    x = y;
                    y = fibonacciResult;
                    counter++;
                } while (counter <= 20);


            case "for":
                for (; counter <= 20; counter++) {
                    System.out.print(fibonacciResult + " ");
                    fibonacciResult = x + y;
                    x = y;
                    y = fibonacciResult;
                }
        }


        //массивы

        int[][][][][] array = new int[2][2][2][2][2];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int u = 0; u < array[i].length; u++) {
                for (int k = 0; k < array[i][u].length; k++) {
                    for (int l = 0; l < array[i][u][k].length; l++) {
                        for (int h = 0; h < array[i][u][k][l].length; h++) {
                            array[i][u][k][l][h] = random.nextInt(5);
                            System.out.println(array[i][u][k][l][h]);
                        }


                    }

                }


            }


        }
    }
}

