package ua.kvelinskiy.entities;

import java.util.Date;

/**
 * This class is an entity of database table "catalogue".
 * @author I.K.
 */

public class Catalogue {

    private int id;
    private int idBook;
    private int idUser;
    private String status;
    private String orderStatus;
    private Date dateIssue;
    private Date dateReturn;
    private Book book;
    private User user;

    public Catalogue() {
    }
//public List<Catalogue> getListBooksGenre
    public Catalogue(Book book, Date dateIssue, Date dateReturn, String status, String orderStatus) {
        this.book = book;
        this.dateIssue = dateIssue;
        this.dateReturn = dateReturn;
        this.status = status;
        this.orderStatus = orderStatus;
    }
//public List<Catalogue> showUserBooksList
    public Catalogue(int id, String status, String orderStatus, Date dateIssue, Date dateReturn, Book book) {
        this.id = id;
        this.status = status;
        this.orderStatus = orderStatus;
        this.dateIssue = dateIssue;
        this.dateReturn = dateReturn;
        this.book = book;
    }
//public List<Catalogue> getCatalogueListBooks()
    public Catalogue(int idUser, String status, String orderStatus, Date dateIssue, Date dateReturn, Book book,User user) {
        this.idUser = idUser;
        this.status = status;
        this.orderStatus = orderStatus;
        this.dateIssue = dateIssue;
        this.dateReturn = dateReturn;
        this.book = book;
        this.user = user;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
