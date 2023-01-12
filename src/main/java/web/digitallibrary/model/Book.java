package web.digitallibrary.model;

/*
    =====================================
    @project DigitalLibrary
    @created 12/01/2023
    @author Bereznev Nikita @CreativeWex
    =====================================
 */

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

public class Book {
    @NonNull
    private int id;

    @NonNull
    private int genreId;

    @NonNull
    private int authorId;

    @Size(min = 2, max = 100, message = "Имя должно быть не меньше 2 и не больше 100 символов!")
    private String name;

    @NonNull
    private String genre;

    @NonNull
    private String author;

    @Min(value = 1, message = "Год должен быть больше 0")
    @Max(value = 2049, message = "Год не должен превышать 2049")
    private int year;

    private String description;

    public Book() {}

    public Book(int id, int genreId, int authorId, String name, @NonNull String genre, @NonNull String author, int year, String description) {
        this.id = id;
        this.genreId = genreId;
        this.authorId = authorId;
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.year = year;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @NonNull
    public String getAuthor() {
        return author;
    }

    public void setAuthor(@NonNull String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
