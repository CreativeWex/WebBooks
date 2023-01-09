package web.digitallibrary.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import web.digitallibrary.model.Client;

import java.util.List;

@Component
public class ClientDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Client> getAll() {
        return jdbcTemplate.query("SELECT * FROM clients", new BeanPropertyRowMapper<>(Client.class));
    }

    public Client getById(int id) {
        return jdbcTemplate.query("SELECT * FROM clients WHERE id = ?", new Object[]{id},
            new BeanPropertyRowMapper<>(Client.class)).stream().findAny().orElse(null);
    }

    public void update(int id, Client newClient) {
        jdbcTemplate.update("UPDATE clients SET name=?, age=?, email=?, sex=? WHERE id = ?",
            newClient.getName(), newClient.getAge(), newClient.getEmail(), newClient.getSex(), id);
    }

    public void save(Client client) {
        jdbcTemplate.update("INSERT INTO clients (name, age, email, sex) VALUES(?, ?, ?, ?)", client.getName(),
            client.getAge(), client.getEmail(), client.getSex());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM clients WHERE id=?", id);
    }
}
