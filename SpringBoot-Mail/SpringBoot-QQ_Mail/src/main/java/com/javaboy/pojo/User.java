package com.javaboy.pojo;

/**
 * @author : shmily
 * @GitHub : https://github.com/shmily0021
 * @Gitee : https://gitee.com/shmily0213
 * @createDate: 2023/5/22 11:17
 */
public class User {

    private String username;
    private Double salary;
    private String position;
    private String company;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
