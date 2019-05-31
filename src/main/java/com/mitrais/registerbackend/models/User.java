package com.mitrais.registerbackend.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tbl_user")
public class User implements Serializable
{
    private static final long serialVersionUID = 6331819443541044768L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    public long getId()
    {
        return id;
    }

    public User setId(long id)
    {
        this.id = id;
        return this;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public User setFirstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }

    public String getLastName()
    {
        return lastName;
    }

    public User setLastName(String lastName)
    {
        this.lastName = lastName;
        return this;
    }

    public String getEmail()
    {
        return email;
    }

    public User setEmail(String email)
    {
        this.email = email;
        return this;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public User setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Integer getGender()
    {
        return gender;
    }

    public User setGender(Integer gender)
    {
        this.gender = gender;
        return this;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public User setBirthday(Date birthday)
    {
        this.birthday = birthday;
        return this;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                '}';
    }
}
