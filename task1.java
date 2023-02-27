/**
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
 * человек может иметь несколько телефонов.
 */
public class task1 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Артем Маклашев", "+79995558443");
        phoneBook.add("Артем Маклашев", "+79995558443");
        phoneBook.add("Артем Маклашев", "+79995558433");
        phoneBook.add("Иван Иванов", "+79996665554");
        phoneBook.add("Сергей Сергеев", "+788855554433");
        phoneBook.add("Сергей Сергеев", "+777766665544");

        phoneBook.print();
    }    
}