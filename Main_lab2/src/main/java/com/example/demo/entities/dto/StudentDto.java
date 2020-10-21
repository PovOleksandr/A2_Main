package com.example.demo.entities.dto;


import java.util.UUID;

final public class StudentDto extends PersonDto{

    private int roomNumber;
    private boolean isInsideDorm;
    private UUID id;
    private int dormNumber = 0;

    public StudentDto( String name, String surname, int cash, int salary, int roomNumber){
        super( name, surname, cash, salary);
        this.roomNumber = roomNumber;
        this.isInsideDorm = false;
    }

    public StudentDto() {
        super("Ivan","Ivanov",0,0);
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
}