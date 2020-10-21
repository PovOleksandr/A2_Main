package com.example.demo.entities.dto;

import com.example.demo.entities.Student;
import com.example.demo.entities.Watchman;

public class EntranceDto {
    private Watchman watchman;
    private Student student;

    public EntranceDto(Watchman watchman,Student student){
        this.watchman = watchman;
        this.student = student;
    }
}
