package com.example.userdata.userdataapi.entity;
import javax.persistence.*;

@Entity
public class User {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
@Column(name="Name",nullable = false)
    private String name;
    @Column(name="eMail",nullable = false)
    private String email;
    @Column(name="Mobile")
    private String mobile;

    public User(){

    }

    public User(Integer id, String name, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
