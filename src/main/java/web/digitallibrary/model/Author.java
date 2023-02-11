package web.digitallibrary.model;

/*
    =====================================
    @project DigitalLibrary
    @created 12/01/2023
    @author Bereznev Nikita @CreativeWex
    =====================================
 */

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 100, message = "Имя должно быть не меньше 2 и не больше 100 символов!")
    @Pattern(regexp = "([А-Я]\\. [А-Я]\\. [А-я][а-я]+)|([А-Я][а-я]+\\. [А-Я]\\. [А-я][а-я]+)|([А-Я]\\. [А-Я][а-я]+\\. " +
            "[А-я][а-я]+)|([А-Я][а-я]+ [А-Я][а-я]+ [А-я][а-я]+)|([А-Я][а-я]+ [А-Я][а-я]+)",
            message = "Неверный формат имени! Пример: А. П. Чехов, Джордж Оруэлл, Луиза Мэй Олкотт")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Pattern(regexp = "(1\\d\\d\\d)|([1-9]\\d)|([1-9]\\d\\d)|(\\d+ до н.э.)", message = "Введите год корректно! Пример: " +
            "1945, 234, 12 до н.э.")
    @Column(name = "dateOfBirth", nullable = false)
    String dateOfBirth;

    @Pattern(regexp = "(1\\d\\d\\d)|([1-9]\\d)|([1-9]\\d\\d)|(\\d+ до н.э.)|()", message = "Введите год корректно или " +
            "Пример: 1945, 234, 12 до н.э.")
    @Column(name = "dateOfDeath")
    String dateOfDeath;

    @Column(name = "description")
    private String description;
}

