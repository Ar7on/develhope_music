package it.develhope.develhopeMusic.entities.user;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private TypeOfUser typeOfUser;

    public User() {
    }

    public User(Integer id, String username, String password, String email, TypeOfUser typeOfUser) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.typeOfUser = typeOfUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TypeOfUser getTypeOfUser() {return typeOfUser;}

    public void setTypeOfUser(TypeOfUser typeOfUser) {this.typeOfUser = typeOfUser;}
}