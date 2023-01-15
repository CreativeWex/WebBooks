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
import web.digitallibrary.model.Client;
import java.util.List;
import java.util.Optional;

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
        jdbcTemplate.update("UPDATE clients SET name=?, age=?, email=?, sex=?, phoneNumber=?, deliveryaddress=?, " +
            "description=?, favoriteGenre=? WHERE id = ?", newClient.getName(), newClient.getAge(),
            newClient.getEmail(), newClient.getSex(), newClient.getPhoneNumber(), newClient.getDeliveryAddress(),
            newClient.getDescription(), newClient.getFavoriteGenre(), id);
    }

    public void save(Client client) {
        jdbcTemplate.update("INSERT INTO clients (name, age, email, sex, phonenumber, deliveryaddress, description," +
            " favoritegenre) VALUES(?, ?, ?, ?, ?, ?, ?, ?)", client.getName(), client.getAge(), client.getEmail(),
            client.getSex(), client.getPhoneNumber(), client.getDeliveryAddress(), client.getDescription(), client.getFavoriteGenre());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM clients WHERE id=?", id);
    }

//    =========== Validator ===========

    public Optional<Client> findSimilarName(String name, int id) {
        return jdbcTemplate.query("SELECT * FROM clients WHERE name = ? AND id <> ?", new Object[]{name, id},
                new BeanPropertyRowMapper<>(Client.class)).stream().findAny();
    }

    public Optional<Client> findSimilarEmail(String email, int id) {
        return jdbcTemplate.query("SELECT * FROM clients WHERE email = ? AND id <> ?", new Object[]{email, id},
                new BeanPropertyRowMapper<>(Client.class)).stream().findAny();
    }

    public Optional<Client> findSimilarPhoneNumber(String phoneNumber, int id) {
        return jdbcTemplate.query("SELECT * FROM clients WHERE phoneNumber = ? AND id <> ?", new Object[]{phoneNumber, id},
                new BeanPropertyRowMapper<>(Client.class)).stream().findAny();
    }
}
