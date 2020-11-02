package com.example.demo.entities.dto;

import java.util.UUID;


final public class JanitorDto {
    private String name;
    private String surname;
    private int salary;
    private int cash;
    private int cleaningQuality;
    private UUID id;

    public JanitorDto( String name, String surname, int cash, int salary, int cleaningQuality){
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

    public JanitorDto() {

    }

    public int getCleaningQuality(){
        return this.cleaningQuality;
    }

}