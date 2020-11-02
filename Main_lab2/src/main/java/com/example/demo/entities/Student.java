package com.example.demo.entities;


import java.util.UUID;

final public class Student{
    private String name;
    private String surname;
    private int salary;
    private int cash;
    private int roomNumber;
    private boolean isInsideDorm;
    private UUID id;
    private int dormNumber = 0;

    public Student( String name, String surname, int cash, int salary, int roomNumber){
        this.name = name;
        this.surname = surname;
        this.cash = cash;
        this.salary = salary;
        this.roomNumber = roomNumber;
        this.isInsideDorm = false;
    }

    public Student() {

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

    public boolean isInsideDorm() {
        return isInsideDorm;
    }

    public void setInsideDorm(boolean insideDorm) {
        isInsideDorm = insideDorm;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getDormNumber() {
        return dormNumber;
    }

    public void monthSalary(){
        this.cash += this.salary;
    }

    public void enterDorm(){
        this.isInsideDorm = true;
    }

    public void setDormNumber(int value){
        this.dormNumber = value;
    }

    public int getRoomNumber(){return this.roomNumber;}

    public void setRoomNumber(int value){
        this.roomNumber = value;
    }

    public void leaveDorm(){
        this.isInsideDorm = false;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cash=" + cash +
                ", roomNumber=" + roomNumber +
                ", dormNumber=" + dormNumber +
                '}';
    }
}
