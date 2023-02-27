import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, 
Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, 
Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. Написать программу, которая найдет и выведет повторяющиеся имена 
с количеством повторений. Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
 */

public class task2 {
    public static void main(String[] args) {
        String names = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, " +
                "Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, "
                +
                "Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";

        String[] namesList = names.split(",");
        Map<String, Integer> namesMap = stringToMap(namesList);        
        doSortMap(namesMap);        
    }
    
    static Map<String, Integer> stringToMap(String[] namesList) {
        Map<String, Integer> namesMap = new HashMap<String, Integer>();
        int count;
        for (int i = 0; i < namesList.length; i++) {
            String name = namesList[i].trim().split(" ")[0];
            if (namesMap.containsKey(name)) {
                count = namesMap.get(name) + 1;
                namesMap.put(name, count);
            } else {
                namesMap.put(name, 1);
            }
        }
        return namesMap;
    }
    
    static void doSortMap(Map<String, Integer> namesMap) {
        Map<Integer, List<String>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> entry : namesMap.entrySet()) {
            if (sortedMap.containsKey(entry.getValue())) {
                List<String> list = sortedMap.get(entry.getValue());
                list.add(entry.getKey());
            } else {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                sortedMap.put(entry.getValue(), list);
            }
        }
        for (Map.Entry<Integer, List<String>> entry : sortedMap.entrySet()) {
            System.out.printf("Повторений %d : %s\n", entry.getKey(), entry.getValue());
        }
    }
}

