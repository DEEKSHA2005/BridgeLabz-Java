package javacollectionsstream.java8features.java8feature;

import java.util.*;
import java.util.stream.Collectors;

public class BookRecommendationExample {

    public static void main(String[] args) {

        List<Book> books = List.of(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.6),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.4),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.1),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.5),
                new Book("The Martian", "Andy Weir", "Science Fiction", 4.8),
                new Book("Clean Code", "Robert Martin", "Programming", 4.7),
                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.0),
                new Book("1984", "George Orwell", "Dystopian", 4.9)
        );

        int pageNumber = 1;   // page starts from 1
        int pageSize = 5;

        List<BookRecommendation> result =
                books.stream()

                        // 1️⃣ Filter
                        .filter(b -> b.getGenre().equals("Science Fiction"))
                        .filter(b -> b.getRating() > 4.0)

                        // 2️⃣ Transform
                        .map(b -> new BookRecommendation(b.getTitle(), b.getRating()))

                        // 3️⃣ Sort
                        .sorted(Comparator.comparingDouble(
                                BookRecommendation::getRating).reversed())

                        // 4️⃣ Pagination
                        .skip((pageNumber - 1L) * pageSize)
                        .limit(pageSize)

                        .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}
class Book {
    private String title;
    private String author;
    private String genre;
    private double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }
}
class BookRecommendation {
    private String title;
    private double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return title + " ⭐ " + rating;
    }
}