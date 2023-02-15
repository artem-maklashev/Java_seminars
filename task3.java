import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class task3 {

  public static void main(String[] args) throws IOException {
    StringBuilder sb = jsonParser("task3.json");
    System.out.println(sb.toString());
  }

  static StringBuilder jsonParser(String fileName) throws IOException {
    Map<String, String> json_dic = new HashMap<>();
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    StringBuilder jsonString = new StringBuilder();
    StringBuilder resultStrings = new StringBuilder();
    String str;
    while ((str = br.readLine()) != null) {
      jsonString.append(str.replaceAll("\\s+", "")); //Удаляем табуляцию и лишние пробелы и составляем строку
    }
    //  System.out.println(jsonString.toString());
    String json = jsonString.toString(); //StringBuilder->String
    json = json.substring(1, jsonString.length() - 1); //Удаляем []
    json = json.replace("{", "").replace("},", " ").replace("}", "");

    String[] json_arr = json.split(" ");
    //   System.out.println(json_arr[2].toString());
    for (int i = 0; i < json_arr.length; i++) {
      String[] keyValuePairs = json_arr[i].split(",");
      //   System.out.println(Arrays.toString(keyValuePairs));
      for (String pair : keyValuePairs) {
        String[] entry = pair.split(":");
        json_dic.put(
          entry[0].substring(1, entry[0].length() - 1),
          entry[1].substring(1, entry[1].length() - 1)
        );
      }
      resultStrings
        .append(
          "Студент(ка) " +
          json_dic.get("фамилия") +
          " получил(а) " +
          json_dic.get("оценка") +
          " по предмету " +
          json_dic.get("предмет") +
          "."
        )
        .append("\n");
    }
    br.close();
    return resultStrings;
  }
}
