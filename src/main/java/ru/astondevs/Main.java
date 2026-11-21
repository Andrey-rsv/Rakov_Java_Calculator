package ru.astondevs;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        double a = 10;
        double b = 4;

        System.out.println("Число A: " + a);
        System.out.println("Число B: " + b);
        System.out.println("-----------------------");
        System.out.println("Сложение:   " + calculator.add(a, b));
        System.out.println("Вычитание:  " + calculator.subtract(a, b));
        System.out.println("Умножение:  " + calculator.multiply(a, b));
        System.out.println("Деление:    " + calculator.divide(a, b));
    }
}