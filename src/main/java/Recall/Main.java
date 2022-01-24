package Recall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException {

//Задание №1

        System.out.println("Задание №1");
        int a = 10;
        byte i1 = 127;
        short shorts = 452;
        long longs = 454986475412345L;
        float floats = 4512.456475456F;
        double doubles = 1545421.4587242545285784;
        boolean booleans = true;
        char chars = 15;

        System.out.println(a);
        System.out.println(i1);
        System.out.println(shorts);
        System.out.println(longs);
        System.out.println(floats);
        System.out.println(doubles);
        System.out.println(booleans);
        System.out.println(chars);

        System.out.println();

        //Задание №2

        //продемонстрировать работу конструкции IF-ELSE
        System.out.println("Задание №2");
        int age = 1;
        if (age > 55) {
            System.out.println("На работу не принимать");
        }
        if (age > 16) {
            System.out.println("Кандидата можно рассматривать. Нужны дополнительные данные");
        }
        if (age > 16 & age < 55) {
            System.out.println("Принимать на работу");
        }
        if (age < 16) {
            System.out.println("Кандидата не рассматривать");
        } else {
            System.out.println("Упс! Что-то пошло не так. Попробуй другое значение");
        }
        System.out.println();

        //продемонстрировать работу конструкции switch - case - default

        String familyMember = "Сестра";
        switch (familyMember) {
            case "Папа":
                System.out.println("Папа может починить кран, но не хочет");
                break;
            case "Мама":
                System.out.println("Мама хочет норковую шубу и iPhone 13");
                break;
            case "Сестра":
                System.out.println("Сестра поссорилась с парнем и тоже хочет iPhone 13");
                break;
            case "Брат":
                System.out.println("Брату всё не важно - он хочет PlayStation 5");
                break;
            default:
                System.out.println("Такого члена семьи нет. Попробуй ещё раз");
        }
        System.out.println();


        //Задание №3
        System.out.println("Задание №3");

        double[][] array = new double[18][11];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextDouble();
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        //Задание №4
        System.out.println("Задание №4");
        String str = null;
        try {
            System.out.println();
            if (str == null) {
                throw new MyException("String can not be empty!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Your string: " + str);
        }
        System.out.println();


        //Задание №5
        System.out.println("Задание №5");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число x ");
        double x = scanner.nextDouble();

        System.out.println("Введите число y");
        double y = scanner.nextDouble();
        if (y == 0) {
            try {
                throw new MyException("Нельзя делить на ноль!");
            } catch (MyException exception) {
                System.out.println(exception.getMessage());
            }
        }


        Calculator calculator = new Calculator();
        System.out.println("Результаты");
        System.out.println("Произведение: " + calculator.multi(x, y));
        System.out.println("Частное: " + calculator.div(x, y));
        System.out.println("Сумма: " + calculator.sum(x, y));
        System.out.println("Разность: " + calculator.sub(x, y));


        //Задание №6
        System.out.println("Задание №6");

        ArrayList<Float> list = new ArrayList<>();
        Random random2 = new Random();
        for (int i = 0; i < 10; i++) {
            float abc = random2.nextFloat();
            list.add(abc);
        }
        System.out.println("Список чисел:");
        System.out.println("Размер списка - " + list.size());
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i,list.get(i) / 3);
            System.out.println(list.get(i));
        }

        System.out.println();


        //Задание №7
        System.out.println("Задание №6");

        HashMap<String, Double> hashMap = new HashMap<>();
        hashMap.put("Vasya O.", 36.666);
        hashMap.put("Ivan H.", 36.689);
        hashMap.put("Sveta K.", 39.258);
        hashMap.remove("Sveta K.");
        hashMap.put("Sveta K.", 36.56);
        System.out.println(hashMap);
        System.out.println("Включает только уникальные значения");
        System.out.println("Размер списка - " + hashMap.size());
    }


}