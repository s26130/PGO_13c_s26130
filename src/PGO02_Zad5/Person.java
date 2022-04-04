package PGO02_Zad5;

import java.time.LocalDate;

public class Person {
    String name;
    String surname;
    LocalDate dateOfBirth;
    Address homeAddress;
    Book borrowing;

    public Person(String name, String surname, LocalDate dateOfBirth, Address homeAddress) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.homeAddress = homeAddress;

        System.out.println("New person created: " + toString());
    }

    void publishBook(Book book) {
        if (book == null) {
            throw new RuntimeException("Book can not be null");
        }

        System.out.println(this.name + "Publishing book" + book.name);
        book.authors.add(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", homeAddress=" + homeAddress +
                '}';
    }

}

