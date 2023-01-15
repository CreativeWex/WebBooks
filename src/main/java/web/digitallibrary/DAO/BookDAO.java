package web.digitallibrary.DAO;

/*
    =====================================
    @project DigitalLibrary
    @created 12/01/2023
    @author Bereznev Nikita @CreativeWex
    =====================================
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import web.digitallibrary.mapper.BookMapper;
import web.digitallibrary.model.Book;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getAll() {
        return jdbcTemplate.query("SELECT books.id AS bid, books.name AS bname, genres.name AS gname, authors.name" +
                        " AS aname, year, books.description AS bdesc, genres.id AS gid, authors.id AS aid FROM books" +
                        " INNER JOIN genres on books.genre_id = genres.id INNER JOIN authors on authors.id = books.author_id;" ,
                new BookMapper());
    }

    public Book getById(int id) {
        return jdbcTemplate.query("SELECT books.id AS bid, books.name AS bname, genres.name AS gname, authors.name" +
                        " AS aname, year, books.description AS bdesc, genres.id AS gid, authors.id AS aid FROM books" +
                        " INNER JOIN genres on books.genre_id = genres.id INNER JOIN authors on authors.id =" +
                        " books.author_id WHERE books.id = ?", new Object[]{id},
                new BookMapper()).stream().findAny().orElse(null);
    }

    public void update(int id, Book newBook) {
        jdbcTemplate.update("UPDATE books SET name=?, genre_id=?, author_id=?, year=?, description=? WHERE id = ?",
                newBook.getName(), newBook.getGenreId(), newBook.getAuthorId(), newBook.getYear(),
                newBook.getDescription(), id);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO books (name, genre_id, author_id, year, description) VALUES(?, ?, ?, ?, ?)",
                book.getName(), book.getGenreId(), book.getAuthorId(), book.getYear(), book.getDescription());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM books WHERE id=?", id);
    }

    //    =========== Validator ===========

    public Optional<Book> findSimilarName(String name, int id) {
        return jdbcTemplate.query("SELECT books.id AS bid, books.name AS bname, genres.name AS gname, authors.name" +
                        " AS aname, year, books.description AS bdesc, genres.id AS gid, authors.id AS aid FROM books" +
                        " INNER JOIN genres on books.genre_id = genres.id INNER JOIN authors on authors.id =" +
                        " books.author_id WHERE books.name = ? AND id <> ?", new Object[]{name, id},
                new BookMapper()).stream().findAny();
    }
}