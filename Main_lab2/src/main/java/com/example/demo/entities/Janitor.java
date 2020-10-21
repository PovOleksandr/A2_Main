package com.example.demo.entities;


import java.util.UUID;

final public class Janitor extends Person{

    private int cleaningQuality;
    private UUID id;

    public Janitor( String name, String surname, int cash, int salary, int cleaningQuality){
        super( name, surname, cash, salary);
        this.cleaningQuality = cleaningQuality;
    }

    public Janitor() {
        super("Ivan","Ivanov",0,0);
    }

    public int getCleaningQuality(){
        return this.cleaningQuality;
    }

}
