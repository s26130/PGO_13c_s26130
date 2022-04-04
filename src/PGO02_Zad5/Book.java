package PGO02_Zad5;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Book {
    private static long maxId = 0;

    private static long getNextId() {
        maxId = maxId + 1;
        return maxId;
    }

    Long id;
    String name;
    Genre genre;
    Lang language;
    LocalDate publishDate;
    int borrowCount;
    boolean isAvailable;
    Person borrowing;
    Set<Person> authors;

    public Book(String name, Genre genre, Lang language, LocalDate publishDate) {
        this.id = getNextId();
        this.name = name;
        this.genre = genre;
        this.language = language;
        this.publishDate = publishDate;
        this.borrowCount = 0;
        this.isAvailable = true;
        this.authors = new HashSet<>();

        System.out.println("New book created: " + toString());
    }

    void borrowBook(Person person){
        if(person == null ){
            throw new RuntimeException("Book can not be null");
        }
        if(isAvailable == false){
            System.out.println("Book is not available");
            return;
        }
        if(person.borrowing != null){
            System.out.println("You must return previus book, before you borrow new one: "+person.borrowing.name);
            return;
        }
        System.out.println(person.name + " borrowing book " + this.name);
        this.isAvailable = false;
        this.borrowCount = this.borrowCount + 1;
        this.borrowing = person;
        person.borrowing = this;
    }
    void palceBack(){
        Person personWhoBorrows = this.borrowing;
        if(personWhoBorrows == null){
         System.out.println("This Book isn't ours");
         return;
        }
        System.out.println(personWhoBorrows.name + " Placeing Back "+this.name);
        this.isAvailable = true;
        personWhoBorrows.borrowing = null;
        this.borrowing = null;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", language=" + language +
                ", publishDate=" + publishDate +
                ", borrowCount=" + borrowCount +
                ", isAvailable=" + isAvailable +
                ", authors=" + authors +
                '}';
    }
}
