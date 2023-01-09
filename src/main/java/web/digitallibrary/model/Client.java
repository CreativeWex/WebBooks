package web.digitallibrary.model;

import jakarta.validation.constraints.*;
import org.springframework.lang.NonNull;

public class Client {
    @NonNull
    private int id;

    @Size(min = 2, max = 20, message = "Имя должно быть не меньше 2 и не больше 20 символов!")
    private String name;

    @Min(value = 1, message = "Возраст должен быть больше 0")
    @Max(value = 110, message = "Возраст не должен превышать 110")
    private int age;

    @NotEmpty(message = "Неверный формат!")
    @Email(message = "Неверный формат!")
    private String email;

    private String sex;

    public Client(int id, String name, int age, String email, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.sex = sex;
    }

    public Client() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
