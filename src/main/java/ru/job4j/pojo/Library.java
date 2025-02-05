package ru.job4j.pojo;

public class Library {
    public static void showBookList(Book[] books) {
        System.out.println("\nShow book list:");
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getNumberOfPages());
        }
    }

    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 402);
        Book mathematicalAnalysis = new Book("Mathematical analysis", 705);
        Book technicalEnglish = new Book("Technical English", 250);
        Book relationalDataModels = new Book("Relational data models", 604);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = mathematicalAnalysis;
        books[2] = technicalEnglish;
        books[3] = relationalDataModels;
        showBookList(books);
        books[3] = cleanCode;
        books[0] = relationalDataModels;
        showBookList(books);
        System.out.println("\nOutput of books named \"Clean code\":");
        for (Book book : books) {
            if (book.equals(cleanCode)) {
                System.out.println(book.getName() + " - " + book.getNumberOfPages());
            }
        }
    }
}
