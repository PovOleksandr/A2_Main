package com.example.demo.entities.dto;

import java.util.UUID;

final public class DormDto {
    private int dormNumber;
    private int cleanliness;
    private int numOfFreeRooms;
    private int monthPrice;
    private int income = 0;
    private UUID id;


    public DormDto(int dormNumber, int cleanliness, int numOfRooms, int monthPrice ){
        this.dormNumber = dormNumber;
        this.cleanliness = cleanliness;
        this.numOfFreeRooms = numOfRooms;
        this.monthPrice = monthPrice;
    }

    public DormDto() { }


    public int getDormNumber() {
        return dormNumber;
    }

    public void setDormNumber(int dormNumber) {
        this.dormNumber = dormNumber;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }

    public int getNumOfFreeRooms() {
        return numOfFreeRooms;
    }

    public void setNumOfFreeRooms(int numOfFreeRooms) {
        this.numOfFreeRooms = numOfFreeRooms;
    }

    public int getMonthPrice() {
        return monthPrice;
    }

    public void setMonthPrice(int monthPrice) {
        this.monthPrice = monthPrice;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}