package packZad12;

import java.util.HashMap;
import java.util.Map;

/*
12 Zadanie:
Stwórz aplikację która pozwala dodawać i usuwać produkty po numerach seryjnych. Po uruchomieniu użytkownik może wprowadzić kod/numer seryjny i nazwę produktu. Jeśli numer się powtarza zapytaj czy użytkownik chce nadpisać produkt.

 */
public class Main {
    public static void main(String[] args) {
        System.out.println();
        Map<Integer, String> storeMap = new HashMap<Integer, String>();
        Utilities utilities = new Utilities();
        ScannerWork scannerWork = new ScannerWork();

        System.out.println("Aplikacja pozwala dodawać i usuwać produkty po numerach seryjnych.");
        boolean flag = false;
        do {
            System.out.println();
            System.out.println("Wybierz działanie:" +
                    "\n a) dodaj produkt" +
                    "\n b) usuń produkt" +
                    "\n c) wydruk bazy danych" +
                    "\n w) wyjście");
            char znak = scannerWork.getCharABCW();
            switch (znak) {
                case 'a':
                    System.out.println();
                    System.out.println("DODAWANIE PRODUKTU DO BAZY DANYCH.");
//                    System.out.println();
//                    System.out.println("Podaj numer seryjny produktu:");
                    int nrSeryjny = scannerWork.getInt();
                    if (!storeMap.containsKey(nrSeryjny)) {
                        String name = scannerWork.getString();
                        utilities.addElement(nrSeryjny, name, storeMap);
                    } else {
                        System.out.println("Uwaga: w bazie danych jest produkt o nr seryjnym: " + nrSeryjny + " i nazwie: " + storeMap.get(nrSeryjny));
                        System.out.println("Wybierz działanie:" +
                                "\n a) nadpisujemy produkt (zastępujemy nowym)" +
                                "\n b) rezygnacja z działania");
                        char znakA = scannerWork.getCharAB();
                        if (znakA == 'a') {
                            String name = scannerWork.getString();
                            utilities.addElement(nrSeryjny, name, storeMap);
                        } else {
                            break;
                        }
                    }
                    break;
                case 'b':
                    System.out.println();
                    System.out.println("USUWANIE PRODUKTU Z BAZY DANYCH");
                    System.out.println();
                    System.out.println("Wybierz działanie:" +
                            "\n a) usuwanie po numerze seryjnym" +
                            "\n b) usuwanie po nazwie");
                    char znakB = scannerWork.getCharAB();
                    if (znakB == 'a') {
                        int nrSeryjnyB = scannerWork.getInt();
                        utilities.removeElementByNrSeryjny(nrSeryjnyB, storeMap);
                    } else {
                        String nameB = scannerWork.getString();
                        utilities.removeElementByName(nameB, storeMap);
                    }
                    break;
                case 'c':
                    System.out.println();
                    System.out.println("ZAWARTOŚĆ BAZY DANYCH:");
                    utilities.prinMap(storeMap);
                    break;
                case 'w':
                    flag = true;
                    break;
            }
        }while (!flag);
    }
}
