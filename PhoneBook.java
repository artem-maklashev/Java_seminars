import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> pb = new HashMap<>();

    void add(String name, String phone) {
        List<String> list = new ArrayList<>();
        if (pb.containsKey(name)) {
            if (!pb.get(name).contains(phone)) {
                pb.get(name).add(phone);
            } else {
                System.out.println("Данный телефон уже сожержится в справочнике");
            }
        } else {
            list.add(phone);
            pb.put(name, list);
        }
    }

    void print() {
        for (Map.Entry<String, List<String>> entry : pb.entrySet()) {
            System.out.printf("Имя: %s | Телефон: %s\n", entry.getKey(), entry.getValue());
        }
    }
}
