package ru.javaproject.threatmodel.model;

import java.util.Objects;

public class User {
    private String password;

    public User() {
    }

    public User(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(password);
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                '}';
    }
}
