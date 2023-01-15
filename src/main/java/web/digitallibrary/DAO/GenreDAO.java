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
import web.digitallibrary.model.Genre;
import web.digitallibrary.mapper.GenreCountMapper;

import java.util.List;
import java.util.Optional;

@Component
public class GenreDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GenreDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Genre> getAll() {
        return jdbcTemplate.query("SELECT * FROM genres", new BeanPropertyRowMapper<>(Genre.class));
    }

    public Genre getById(int id) {
        return jdbcTemplate.query("SELECT * FROM genres WHERE id = ?", new Object[]{id},
            new BeanPropertyRowMapper<>(Genre.class)).stream().findAny().orElse(null);
    }

    public void update(int id, Genre newGenre) {
        jdbcTemplate.update("UPDATE genres SET name=? WHERE id = ?",
                newGenre.getName(), id);
    }

    public void save(Genre genre) {
        jdbcTemplate.update("INSERT INTO genres (name) VALUES(?)", genre.getName());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM genres WHERE id=?", id);
    }

    public int countPeopleForGenre(int id) {
        return jdbcTemplate.query("SELECT COUNT(*) FROM clients INNER JOIN genres on " +
                "clients.favoritegenre = genres.name GROUP BY genres.id HAVING genres.id = ?",
                new Object[]{id}, new GenreCountMapper()).stream().findAny().orElse(0);
    }

    //    =========== Validator ===========

    public Optional<Genre> getSimilarGenre(String name, int id) {
        return jdbcTemplate.query("SELECT * FROM genres WHERE name = ? AND id <> ?", new Object[]{name, id},
                new BeanPropertyRowMapper<>(Genre.class)).stream().findAny();
    }
}
