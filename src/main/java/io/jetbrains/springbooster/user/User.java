package io.jetbrains.springbooster.user;

import io.jetbrains.springbooster.department.Department;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "age")
    private int age;

    @Column(name = "date_of_birth")
    private String date_of_birth ;

    @Column(name = "gender")
    private String gender ;

    @Column(name = "registered_date")
    private String registered_date;

    @ManyToOne(cascade= CascadeType.ALL )
    @JoinColumn (name = "dept_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;

    User(){

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegistered_date() {
        return registered_date;
    }

    public void setRegistered_date(String registered_date) {
        this.registered_date = registered_date;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User(String first_name, String last_name, int age, String date_of_birth, String gender, String registered_date, Department department) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.registered_date = registered_date;
        this.department = department;
    }
}