package com.atguigu.mybatis.entities;

import java.io.Serializable;

public class Employee implements Serializable {
    private Integer id;
    private String lastName;
    private String email;
    private Double salary;
    private Integer deptId;


    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Double salary, Integer deptId) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.deptId = deptId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", deptId=" + deptId +
                '}';
    }
}
