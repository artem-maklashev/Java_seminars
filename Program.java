import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static Notebook userNb = new Notebook();
    public static Scanner iScanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Notebook> nbList = new ArrayList<Notebook>();
        ArrayList<String> mmList = new ArrayList<>(Arrays.asList(
                "Производитель", "Модель", "Диагональ", "ОЗУ", "Процессор", "Объем диска", "Цвет",
                "Операционная система",
                "Отфильтровать"));
        initNotebooks(nbList);
        Menu mm = new Menu(mmList);
        int selection = 1;
        while (selection != 9) {
            mm.printMenu("Основное меню");
            selection = iScanner.nextInt();
            if (selection < 1 && selection > 9) {
                System.out.println("Введено неверное значение");
            } else {                
                getVariants(selection, nbList);
            }
        }
        filterNb(nbList);
        iScanner.close();
    }

    private static void filterNb(ArrayList<Notebook> nbList) {
        for (Notebook notebook : nbList) {
            if ((notebook.manufacturer.equals(userNb.manufacturer) || userNb.manufacturer.isEmpty())
                    && (notebook.model.equals(userNb.model) || userNb.model.isEmpty())
                    && (notebook.diagonal <= userNb.diagonal || userNb.diagonal == 0)
                    && (notebook.ram == userNb.ram || userNb.ram == 0)
                    && (notebook.processor.equals(userNb.processor) || userNb.processor.isEmpty())
                    && (notebook.hardDiskVloume == userNb.hardDiskVloume || userNb.hardDiskVloume == 0)
                    && (notebook.color.equals(userNb.color) || userNb.color.isEmpty())
                    && (notebook.os.equals(userNb.os) || userNb.os.isEmpty())) {
                System.out.println(notebook);
            }
        }
    }

    private static void getVariants(int selection, ArrayList<Notebook> nbList) {
        Set<String> tempSet = new HashSet<>();
        switch (selection) {
            case 1:
                for (Notebook nb : nbList) {
                    tempSet.add(nb.manufacturer);
                }
                String input = input(tempSet);
                userNb.manufacturer = input;
                break;
            case 2:
                for (Notebook nb : nbList) {
                    tempSet.add(nb.model);
                }
                input = input(tempSet);
                userNb.model = input;
                break;
            case 3:
                for (Notebook nb : nbList) {
                    tempSet.add(String.valueOf(nb.diagonal));
                }
                input = input(tempSet);
                userNb.diagonal = Double.parseDouble(input);
                break;
            case 4:
                for (Notebook nb : nbList) {
                    tempSet.add(String.valueOf(nb.ram));
                }
                input = input(tempSet);
                userNb.ram = Integer.parseInt(input);
                break;
            case 5:
                for (Notebook nb : nbList) {
                    tempSet.add(nb.processor);
                }
                input = input(tempSet);
                userNb.processor = input;
                break;
            case 6:
                for (Notebook nb : nbList) {
                    tempSet.add(String.valueOf(nb.hardDiskVloume));
                }
                input = input(tempSet);
                userNb.hardDiskVloume = Integer.parseInt(input);
                break;
            case 7:
                for (Notebook nb : nbList) {
                    tempSet.add(nb.color);
                }
                input = input(tempSet);
                userNb.color = input;
                break;
            case 8:
                for (Notebook nb : nbList) {
                    tempSet.add(nb.os);
                }
                input = input(tempSet);
                userNb.os = input;
                break;

            default:
                break;
        }
    }

    private static String input(Set<String> tempSet) {
        System.out.println("Введите один из следующих вариантов");
        System.out.println(tempSet.toString());
        String imp = iScanner.next();
        return imp;
    }

    static void initNotebooks(ArrayList<Notebook> nbList) {
        Notebook nb1 = new Notebook();

        nb1.manufacturer = "Asus";
        nb1.model = "ROG Zephyrus M16 GU603ZM-K8057";
        nb1.diagonal = 16;
        nb1.ram = 16;
        nb1.processor = "i7";
        nb1.hardDiskVloume = 1000;
        nb1.color = "Black";
        nb1.os = "Windows 11";

        Notebook nb2 = new Notebook();

        nb2.manufacturer = "HUAWEI";
        nb2.model = "MateBook X Pro MRGF-X ";
        nb2.diagonal = 14.2;
        nb2.ram = 16;
        nb2.processor = "i7";
        nb2.hardDiskVloume = 1000;
        nb2.color = "White";
        nb2.os = "Windows 11";

        Notebook nb3 = new Notebook();

        nb3.manufacturer = "MSI";
        nb3.model = "Titan GT77 HX 13VI-096RU";
        nb3.diagonal = 17.3;
        nb3.ram = 32;
        nb3.processor = "i9";
        nb3.hardDiskVloume = 2000;
        nb3.color = "Black";
        nb3.os = "Windows 11";

        Notebook nb4 = new Notebook();

        nb4.manufacturer = "Apple";
        nb4.model = "MacBook Pro";
        nb4.diagonal = 16.2;
        nb4.ram = 16;
        nb4.processor = "M1 Pro";
        nb4.hardDiskVloume = 1024;
        nb4.color = "Silver";
        nb4.os = "macOS";

        Notebook nb5 = new Notebook();

        nb5.manufacturer = "AORUS";
        nb5.model = "5 SE4";
        nb5.diagonal = 15.6;
        nb5.ram = 16;
        nb5.processor = "i7";
        nb5.hardDiskVloume = 512;
        nb5.color = "Black";
        nb5.os = "Windows 11";

        nbList.add(nb1);
        nbList.add(nb2);
        nbList.add(nb3);
        nbList.add(nb4);
        nbList.add(nb5);
    }
}
