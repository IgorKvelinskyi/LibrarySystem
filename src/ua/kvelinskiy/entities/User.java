package ua.kvelinskiy.entities;

/**
 * This class is an entity of database table "users".
 * @author I.K.
 */

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String abonnement;
    private String contactInformation;
    private String login;
    private String password;
    private boolean librarian;

    public User() {
    }

    public User(int id, String firstName, String lastName,
                String abonnement, String contactInformation, String login, String password, boolean librarian) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.abonnement = abonnement;
        this.contactInformation = contactInformation;
        this.login = login;
        this.password = password;
        this.librarian = librarian;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(String abonnement) {
        this.abonnement = abonnement;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLibrarian() {
        return librarian;
    }

    public void setLibrarian(boolean librarian) {
        this.librarian = librarian;
    }
}

