package packZad12;

import java.util.Map;
import java.util.Set;

public class Utilities {

    public void addElement(Integer nrSeryjny, String name, Map<Integer, String> map) {
        map.put(nrSeryjny, name);
    }

    public void prinMap(Map<Integer, String> map) {
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }

    public void removeElementByNrSeryjny(Integer nrSeryjny, Map<Integer, String> map) {
        if (map.containsKey(nrSeryjny)) {
            map.remove(nrSeryjny);
            System.out.println();
            System.out.println("Produkt usunięty.");
        } else {
            System.out.println("Nie ma takiego produktu w bazie.");
        }
    }

    public void removeElementByName(String name, Map<Integer, String> map) {
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        int counter = 0;
        int nrSeryjny = 0;
        for (Map.Entry<Integer, String> integerStringEntry : entrySet) {
            if (integerStringEntry.getValue().equalsIgnoreCase(name)) {
                nrSeryjny = integerStringEntry.getKey();
                counter++;
            }
        }
        if (counter > 0) {
            System.out.println();
            System.out.println("Produkt usunięty.");
            map.remove(nrSeryjny);
        } else {
            System.out.println("Nie ma takiego produktu w bazie.");
        }
    }
}
