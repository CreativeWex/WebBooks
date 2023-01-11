package web.digitallibrary.model;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

public class Author {
    @NonNull
    private int id;

    @Size(min = 2, max = 20, message = "Имя должно быть не меньше 2 и не больше 20 символов!")
    @Pattern(regexp = "([А-Я]\\. [А-Я]\\. [А-я][а-я]+)|([А-Я][а-я]+\\. [А-Я]\\. [А-я][а-я]+)|([А-Я]\\. [А-Я][а-я]+\\. [А-я][а-я]+)|([А-Я][а-я]+ [А-Я][а-я]+ [А-я][а-я]+)|([А-Я][а-я]+ [А-Я][а-я]+)",
            message = "Неверный формат имени! Пример: А. П. Чехов, Антоша Чехонте")
    private String name;

    String dateOfBirth;

    String dateOfDeath;

    private String description;

    public Author() {}

    public Author(int id, String name, String dateOfBirth, String dateOfDeath, String description) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

