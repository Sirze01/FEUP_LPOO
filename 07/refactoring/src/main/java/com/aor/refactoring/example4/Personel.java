package com.aor.refactoring.example4;

import java.util.Objects;

public abstract class Personel extends Person{
    private final String username;
    private final String password;

    protected Personel(String name, String phone, String username, String password) {
        super(name, phone);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean login(String username, String password) {
        return this.getUsername().equals(username) && this.getPassword().equals(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personel worker = (Personel) o;
        return Objects.equals(getName(), worker.getName()) &&
                Objects.equals(getPhone(), worker.getPhone()) &&
                Objects.equals(getUsername(), worker.getUsername()) &&
                Objects.equals(getPassword(), worker.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhone(), getUsername(), getPassword());

    }
}
