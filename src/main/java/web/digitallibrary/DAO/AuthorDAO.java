package web.digitallibrary.DAO;

/*
    =====================================
    @project DigitalLibrary
    @created 12/01/2023
    @author Bereznev Nikita @CreativeWex
    =====================================
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import web.digitallibrary.model.Author;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Author> getAll() {
        return jdbcTemplate.query("SELECT * FROM authors", new BeanPropertyRowMapper<>(Author.class));
    }

    public Author getById(int id) {
        return jdbcTemplate.query("SELECT * FROM authors WHERE id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Author.class)).stream().findAny().orElse(null);
    }

    public void update(int id, Author newAuthor) {
        jdbcTemplate.update("UPDATE authors SET name=?, dateofbirth=?, dateofdeath=?, description=? WHERE id = ?",
                newAuthor.getName(), newAuthor.getDateOfBirth(), newAuthor.getDateOfDeath(), newAuthor.getDescription(), id);
    }

    public void save(Author author) {
        jdbcTemplate.update("INSERT INTO authors (name, dateofbirth, dateofdeath, description) VALUES(?, ?, ?, ?)",
                author.getName(), author.getDateOfBirth(), author.getDateOfDeath(), author.getDescription());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM authors WHERE id=?", id);
    }

    public Optional<Author> findName(String name) {
        return jdbcTemplate.query("SELECT * FROM authors WHERE name=?", new Object[]{name},
                new BeanPropertyRowMapper<>(Author.class)).stream().findAny();
    }
}
