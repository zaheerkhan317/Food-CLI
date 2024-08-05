package com.foodiecliapp.model;

import java.util.Objects;

public class Customer {
    private String id;
    private String Name;
    private String email;
    private String password;

    public Customer() {
    }

    public String getCustomerId() {
        return id;
    }

    public Customer setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return Name;
    }

    public Customer setName(String Name) {
        this.Name = Name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Customer setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name, email, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(Name, customer.Name) && Objects.equals(email, customer.email) && Objects.equals(password, customer.password);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + Name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
