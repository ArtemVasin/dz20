package com.artemvasin.spring.boot;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Game {

    public  void newGame() {
        Scanner gm = new Scanner(System.in);
        int random_number = (int) (Math.random() * 1000);
        System.out.println("hello");
        System.out.println("guess the number: ");
        int count = gm.nextInt();
        //  System.out.println(random_number);  // проверка загаданного числа
        while (true){
            if (random_number > count) {
                System.out.println("more");
            } else if (random_number < count) {
                System.out.println("less");

            } else {
                System.out.println("this is it " + random_number);
                break;
            }
            count = gm.nextInt();
        }
    }
}
