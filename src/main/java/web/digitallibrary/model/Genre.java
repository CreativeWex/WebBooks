package web.digitallibrary.model;

/*
    =====================================
    @project DigitalLibrary
    @created 12/01/2023
    @author Bereznev Nikita @CreativeWex
    =====================================
 */

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

public class Genre {
    @NonNull
    private int id;

    @Size(min = 2, max = 100, message = "Имя должно быть не меньше 2 и не больше 100 символов!")
    @Pattern(regexp = "[А-Я][а-я]+", message = "Введите название жанра кириллицей с большой буквы!")
    private String name;

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genre() {}

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
}
