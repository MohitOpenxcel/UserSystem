package io.jetbrains.springbooster.department;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @Column(name = "dept_id")
    private int dept_id;

    @Column(name = "lang_id")
    private int lang_id;

    @Column(name = "department_name")
    private String department_name;

    public Department(){}

    public Department(int dept_id,int lang_id, String department_name) {
        this.dept_id=dept_id;
        this.lang_id = lang_id;
        this.department_name = department_name;
    }

    public int getLang_id() {
        return lang_id;
    }

    public void setLang_id(int lang_id) {
        this.lang_id = lang_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public Department(int lang_id, String department_name) {
        this.lang_id = lang_id;
        this.department_name = department_name;
    }
}
