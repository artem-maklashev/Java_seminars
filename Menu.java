import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Menu {
    private Map<Integer, String> menu = new TreeMap<>();    

    Menu() {        
    }
    
    Menu(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            menu.put(i + 1, list.get(i));
        }
    }

    void printMenu(String menuName) {
        System.out.println("*************");
        System.out.println(menuName);
        System.out.println("*************");
        System.out.println("Выберите пункт:");
        for (Map.Entry<Integer, String> item : menu.entrySet()) {
            System.out.printf("%d - %s\n", item.getKey(), item.getValue());
        }
    }




    


}
