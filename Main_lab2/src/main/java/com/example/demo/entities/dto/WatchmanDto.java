package com.example.demo.entities.dto;

import java.util.UUID;


final public class WatchmanDto extends PersonDto{
    private int bribeNeeded;
    private UUID id;
    public WatchmanDto(String name, String surname, int cash, int bribeNeeded, int salary){
        super(name, surname, cash, salary);
        this.bribeNeeded = bribeNeeded;
    }

    public WatchmanDto() {
        super("Ivan","Ivanov",0,0);
    }

    public int getBribeNeeded(){
        return this.bribeNeeded;
    }
}
