package io.jetbrains.springbooster.subdepartment;

import io.jetbrains.springbooster.department.Department;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;

@RestController
@Entity
@Table(name = "sub_department")
public class SubDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "sub_dept_id" , insertable = false , updatable = false)
    private int sub_dept_id;

    @ManyToOne(cascade= CascadeType.ALL ,targetEntity = Department.class)
    @JoinColumn(name = "dept_id")
    private Department department;

    @Column(name = "sub_department_name")
    private String sub_department_name;

    SubDepartment(){

    }

    public SubDepartment(Department department, String sub_department_name) {
        this.department = department;
        this.sub_department_name = sub_department_name;
    }

    public int getSub_dept_id() {
        return sub_dept_id;
    }

    public void setSub_dept_id(int sub_dept_id) {
        this.sub_dept_id = sub_dept_id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getSub_department_name() {
        return sub_department_name;
    }

    public void setSub_department_name(String sub_department_name) {
        this.sub_department_name = sub_department_name;
    }
}
