package com.example.demo.entities;

import java.util.UUID;

final public class Watchman extends Person{
    private int bribeNeeded;
    private UUID id;

    public Watchman(String name, String surname, int cash, int bribeNeeded, int salary){
        super(name, surname, cash, salary);
        this.bribeNeeded = bribeNeeded;
    }

    public Watchman() {
        super("Ivan","Ivanov",0,0);
    }

    public int getBribeNeeded(){
        return this.bribeNeeded;
    }
}
