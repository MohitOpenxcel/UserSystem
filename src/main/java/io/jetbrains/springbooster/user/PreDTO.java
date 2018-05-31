package io.jetbrains.springbooster.user;

public class PreDTO {

    private String first_name;
    private String last_name;
    private int age;
    private String gender;
    private String department_name;
    private String sub_department_name;

    public PreDTO() {
    }

    public PreDTO(String first_name, String last_name, int age, String gender, String department_name, String sub_department_name) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.gender = gender;
        this.department_name = department_name;
        this.sub_department_name = sub_department_name;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getSub_department_name() {
        return sub_department_name;
    }

    public void setSub_department_name(String sub_department_name) {
        this.sub_department_name = sub_department_name;
    }
}
