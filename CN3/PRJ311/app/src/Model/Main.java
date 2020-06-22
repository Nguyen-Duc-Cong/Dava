package Model;

public class Main {
    public static void main(String[] args) {
        Book b = new Book("B0111","Machine Learning","Nguyen Duc Cong","PR","c++");
        BookDB.addNewBook(b);
        Book b1 = new Book("B1111", "Lap trinh PHP", "Hoang Anh", "LT", "PHP");
        BookDB.addNewBook(b1);
        System.out.println(BookDB.getBook("B0001"));
        System.out.println(BookDB.getBook("B000"));

        //BookDB.searchByCategory("LT");
        //BookDB.searchByTitle("Lập trình Java");

    }
}
