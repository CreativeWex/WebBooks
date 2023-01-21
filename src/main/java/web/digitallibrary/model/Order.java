package web.digitallibrary.model;
/*
    =====================================
    @project DigitalLibrary
    @created 21/01/2023    
    @author Bereznev Nikita @CreativeWex
    =====================================
 */

import org.springframework.lang.NonNull;

public class Order {
    @NonNull
    private int id;

    @NonNull
    private int clientId;

    @NonNull
    private int bookId;

    String clientName;
    String bookName;

    public Order() {}

    public Order(int id, int clientId, int bookId, String clientName, String bookName) {
        this.id = id;
        this.clientId = clientId;
        this.bookId = bookId;
        this.clientName = clientName;
        this.bookName = bookName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
