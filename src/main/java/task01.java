import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class task01 {
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("MSI", "4", "1000", "Windows", "grey");
        Notebook notebook2 = new Notebook("Asus", "4", "1200", "Linex", "white");
        Notebook notebook3 = new Notebook("Acer", "16", "1400", "Windows", "blue");
        Notebook notebook4 = new Notebook("HP", "8", "1000", "Windows", "black");

        Set<Notebook> notebooks = new HashSet<>(List.of(notebook1, notebook2,
                notebook3, notebook4));

        Map<String, String> sel = chooseCriterion();
        sort(sel, notebooks);

    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
    }

    public static Map<String, String> chooseCriterion() {
        Map<String, String> resultCriterion = new HashMap<>();
        while (true) {
            System.out.println("Если хотите выбрать критерий введите 'yes', если нет введите 'no'");
            String question = scanner();
            if (question.equals("no")) {
                break;
            } else {

                System.out.println(
                        "Введите цифру, соответствующую необходимому критерию: \n 1. Название \n 2. ОЗУ \n 3. Объем ЖД \n 4. Операционная система \n 5. Цвет");
                String key = scanner();
                System.out.println("Введите значения для выбранного критерия: ");
                String value = scanner();

                resultCriterion.put(key, value);
            }
        }
        System.out.println(resultCriterion);
        return resultCriterion;

    }

    public static void sort(Map<String, String> criterion, Set<Notebook> notebooks) {

        Set<Notebook> temp = new HashSet<>(notebooks);
        for (Notebook notebook : notebooks) {

            for (Object pair : criterion.keySet()) {

                if (pair.equals("1") && !notebook.getName().equals(criterion.get(pair))) {
                    temp.remove(notebook);
                }
                for (Object pair1 : criterion.keySet()) {

                    if (pair1.equals("2") && !notebook.getRam().equals(criterion.get(pair1))) {
                        temp.remove(notebook);

                    }
                    for (Object pair2 : criterion.keySet()) {

                        if (pair2.equals("3") && !notebook.getHardDisk().equals(criterion.get(pair2))) {
                            temp.remove(notebook);

                        }
                        for (Object pair3 : criterion.keySet()) {

                            if (pair3.equals("4") && !notebook.getOperatingSystem().equals(criterion.get(pair3))) {
                                temp.remove(notebook);

                            }
                            for (Object pair4 : criterion.keySet()) {

                                if (pair4.equals("5") && !notebook.getColour().equals(criterion.get(pair4))) {
                                    temp.remove(notebook);

                                }
                            }
                        }
                    }
                }
            }

        }
        if (temp.isEmpty()) {
            System.out.println("По введенным критериям ничего не найдено!");
        } else {
            System.out.println("Вот что мы нашли по заданному критерию: \n" + temp.toString());
        }

    }

}