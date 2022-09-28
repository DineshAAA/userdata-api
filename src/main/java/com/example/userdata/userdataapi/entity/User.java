package com.example.userdata.userdataapi.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {

@Id
@Column(name="ID")
@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="Name")
    @NotEmpty(message = "This Field cannot be empty...")
    @Size(min=2, max=30)
    private String name;

    @Column(name="eMail")
    @NotEmpty(message = "This Field cannot be empty...")
    @Email(regexp = "^(.+)@(.+)$", message = "Invalid email pattern")
    private String email;
    @Column(name="Mobile")
    @NotEmpty(message = "This Field cannot be empty...")
    @Pattern(regexp = "[7-9][0-9]{9}", message = "invalid mobile number.")
    @Size(max = 10, message = "digits should be 10")
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
