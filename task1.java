import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
 *  Данные для фильтрации приведены ниже в виде json строки.
 * Если значение null, то параметр не должен попадать в запрос.
 * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */

 public class task1 {

     public static void main(String[] args) throws IOException {
         StringBuilder req = new StringBuilder();
         String standartText = "select * from students where ";
         req.append(standartText);         
         Map<String, String> json_dic = jsonParser("task1.json");
         requestBuilder(json_dic, req);    
     }

     static Map<String, String> jsonParser(String fileName) throws IOException {
         Map<String, String> req_dic = new HashMap<>();
         BufferedReader br = new BufferedReader(new FileReader(fileName));
         StringBuilder jsonString = new StringBuilder();
         String str;
         while ((str = br.readLine()) != null) {
             jsonString.append(str.replaceAll("\\s+", ""));//Удаляем табуляцию и лишние пробелы и составляем строку
         }
         System.out.println(jsonString.toString());
         String json = jsonString.toString(); //StringBuilder->String
         json = json.substring(1, jsonString.length() - 1);//Удаляем {}
         String[] keyValuePairs = json.split(",");//разбиваем пары значений 
         for (String pair : keyValuePairs) {//Заносим элементы в словарь
             String[] entry = pair.split(":");
             req_dic.put(entry[0], entry[1]);
         }
         br.close();
         return req_dic;
     }

     static void requestBuilder(Map<String, String> json, StringBuilder req) {
         for (Map.Entry<String, String> entry : json.entrySet()) {
             String value = entry.getValue()
                     .substring(1, entry.getValue().length() - 1);//Удаляем лишние кавычки                          

             if (!value.equalsIgnoreCase("null")) {
                 StringBuilder req_new = new StringBuilder();
                 req_new.append(req)
                         .append(entry.getKey() + "=" + entry.getValue());
                 System.out.println(req_new.toString());//Выводим получившийся запрос                
             }
         }
     }
}