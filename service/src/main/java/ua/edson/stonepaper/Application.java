package ua.edson.stonepaper;

// Игра Камень-Ножницы-Бумага

import java.util.Random;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) {

        System.out.println("Введите file если нужно сохранить результат игры: ");

        Saver memorySaver;

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.equals("file")) {
            memorySaver = new FileSaver();
        } else {
            memorySaver = new MemorySaver();
        }

        int myScore = 0;
        int botScore = 0;

        for (; ; ) {
            System.out.println("Счёт матча: я " + myScore + ":" + botScore + " бот");
            System.out.print("\n Введите: 0-если камень, 1-если бумага, 2-если ножницы: ");
            int choose = scanner.nextInt();
            if (choose == 0 || choose == 1 || choose == 2) {
                Random rnd = new Random();
                int chooseBot = rnd.nextInt(3);
                if (chooseBot == 0) {
                    System.out.println("Кожаный мешок, я выбрал камень - " + choose);
                } else if (chooseBot == 1) {
                    System.out.println("Кожаный мешок, я выбрал бумагу - " + choose);
                } else if (chooseBot == 2) {
                    System.out.println("Кожаный мешок, я выбрал ножницы - " + choose);
                } else {
                    System.out.println("Кожаный мешок, я выбрал хуйню - " + choose);
                }

                if (choose == 0) {
                    if (chooseBot == 0) {
                        System.out.println("Ничья");
                    } else if (chooseBot == 1) {
                        System.out.println("Побеждает бот");
                        botScore++;
                    } else if (chooseBot == 2) {
                        System.out.println("Побеждаю я");
                        myScore++;
                    }
                }
                if (choose == 1) {
                    if (chooseBot == 0) {
                        System.out.println("Побеждаю я");
                        myScore++;
                    } else if (chooseBot == 1) {
                        System.out.println("Ничья");
                    } else if (chooseBot == 2) {
                        System.out.println("Побеждает бот");
                        botScore++;
                    }
                }

                if (choose == 2) {
                    if (chooseBot == 0) {
                        System.out.println("Побеждает бот");
                        botScore++;
                    } else if (chooseBot == 1) {
                        System.out.println("Побеждаю я");
                        myScore++;
                    } else if (chooseBot == 2) {
                        System.out.println("Ничья");
                    }
                }
            } else {
                System.out.println("Хули ты вводишь,а ну ка повтори");
            }

            if (myScore == 5 || botScore == 5) {
                System.out.println("\n <<Финальный счёт>>: я " + myScore + ":" + botScore + " бот");
                System.out.println("Игра окончена");
                break;
            }
        }
        System.out.println(memorySaver.getScore(myScore, botScore));

        memorySaver.saveScore(myScore, botScore);
        System.out.println(memorySaver.getScore(myScore, botScore));
    }
}
