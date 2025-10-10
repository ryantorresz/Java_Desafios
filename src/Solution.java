import java.util.*;

abstract class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    abstract void display();
}

class MyBook extends Book {

    int price;



    MyBook(String title, String author, int price) {
        super(title, author);
        this.price = price;
    }

    @Override
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class Solution {
    public static void main(String[] args) {

        System.out.println("--- Digite o Sample Input Abaixo ---");
        System.out.println("The Alchemist (e pressione ENTER)");
        System.out.println("Paulo Coelho (e pressione ENTER)");
        System.out.println("248 (e pressione ENTER)");
        System.out.println("------------------------------------");

        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();

        Book newBook = new MyBook(title, author, price);

        newBook.display();

        scanner.close();
    }
}