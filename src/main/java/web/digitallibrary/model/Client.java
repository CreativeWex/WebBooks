package web.digitallibrary.model;

/*
    =====================================
    @project DigitalLibrary
    @created 12/01/2023
    @author Bereznev Nikita @CreativeWex
    =====================================
 */

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

    @Pattern(regexp = "\\d{11}", message = "Неверный формат ввода, пример: 89862514882")
    private String phoneNumber;

    // Страна, Город, Дом 7, 24, индекс
    @Pattern(regexp = "([А-Я][а-я]+, [А-Я][а-я]+, Дом \\d+, \\d+, \\d{6})|()",
            message = "Формат адреса: Страна, Город, Дом №_дома, №_квартиры, индекс(6 цифр). " +
                    "Пример: Россия, Москва, Дом 14, 24, 123456")
    private String deliveryAddress;

    private String description;

    private String favoriteGenre;

    public Client(int id, String name, int age, String email, String sex, String phoneNumber, String deliveryAddress,
                  String description, String favoriteGenre) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.deliveryAddress = deliveryAddress;
        this.description = description;
        this.favoriteGenre = favoriteGenre;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFavoriteGenre() {
        return favoriteGenre;
    }

    public void setFavoriteGenre(String favoriteGenre) {
        this.favoriteGenre = favoriteGenre;
    }
}
