package com.example.demo.entities.dto;

import com.example.demo.entities.Dorm;
import com.example.demo.entities.Janitor;

public class CleanDto {
    private Janitor janitor;
    private Dorm dorm;

    public CleanDto(Janitor janitor, Dorm dorm){
        this.janitor = janitor;
        this.dorm = dorm;
    }
}
