package com.example.demo.entities;


import java.util.UUID;

final public class Janitor{
    private String name;
    private String surname;
    private int salary;
    private int cash;
    private int cleaningQuality;
    private UUID id;

    public Janitor( String name, String surname, int cash, int salary, int cleaningQuality){
        this.name = name;
        this.surname = surname;
        this.cash = cash;
        this.salary = salary;
        this.cleaningQuality = cleaningQuality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void setCleaningQuality(int cleaningQuality) {
        this.cleaningQuality = cleaningQuality;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Janitor() {

    }

    public int getCleaningQuality(){
        return this.cleaningQuality;
    }

    @Override
    public String toString() {
        return "Janitor{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cash=" + cash +
                ", cleaningQuality=" + cleaningQuality +
                '}';
    }
}
