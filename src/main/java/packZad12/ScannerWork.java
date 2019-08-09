package packZad12;

import java.util.Scanner;

public class ScannerWork {
    Scanner scanner = new Scanner(System.in);

    public String getString() {
        System.out.println();
        System.out.println("Podaj nazwę produktu:");
        return scanner.next();
    }

    public int getInt() {
        System.out.println();
        System.out.println("Podaj nr seryjny produktu z zakresu od 1 do 999:");
        boolean flag = false;
        int number = 0;
        do {
//            System.out.println();
            System.out.println("Wprowadź liczbę od 1 do 999:");
            String numberString = scanner.next();
            try {
                number = Integer.valueOf(numberString);
            } catch (NumberFormatException e) {
                System.err.println("Wprowadź liczbę!");
            }
            if (number > 0 && number < 1000) {
                flag = true;
            }
        } while (!flag);
        return number;
    }

    public char getCharABCW() {
        char znak = 'a';
        boolean flag = false;
        do {
            System.out.println();
            System.out.println("Wybierz a/b/c/w ?");
            znak = scanner.next().charAt(0);
            if (znak == 'a' || znak == 'b' || znak == 'c' || znak == 'w') {
                flag = true;
            }
        } while (!flag);
        return znak;
    }

    public char getCharAB() {
        char znak = 'a';
        boolean flag = false;
        do {
            System.out.println();
            System.out.println("Wybierz a/b ?");
            znak = scanner.next().charAt(0);
            if (znak == 'a' || znak == 'b') {
                flag = true;
            }
        } while (!flag);
        return znak;
    }
}
