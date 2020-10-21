package com.example.demo;


import com.example.demo.entities.Dorm;
import com.example.demo.entities.Janitor;
import com.example.demo.entities.Student;
import com.example.demo.entities.Watchman;
import com.example.demo.entities.dto.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
public class MainLab2Application {

    private static final String URL = "http://localhost:8083";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    public static void main(String[] args) {

        headers.setContentType(MediaType.APPLICATION_JSON);

        Dorm dorm1 = new Dorm(1,100,20,700);
        Dorm dorm2 = new Dorm(2,75,30,550);
        Dorm dorm3 = new Dorm(3,60,35,400);

        saveDorm(dorm1);
        saveDorm(dorm2);
        saveDorm(dorm3);

        Watchman watchman = new Watchman( "Galina", "Martynenko", 3000, 100, 1500);
        saveWatchman(watchman);

        Janitor janitor = new Janitor( "Viktor", "Paltsev", 2000, 2000, 30);
        saveJanitor(janitor);

        Student stud1 = new Student("Aleksandr", "Povidzion", 400, 1000, 0);
        Student stud2 = new Student( "Anna", "Sushkina", 1350, 500, 1);
        Student stud3 = new Student( "Oleg", "Popov", 400, 600, 10);
        Student stud4 = new Student( "Oleg", "Panchenko", 400, 100, 5);

        saveStudent(stud1);
        saveStudent(stud2);
        saveStudent(stud3);
        saveStudent(stud4);


        moveIn(dorm1,stud2);
        moveIn(dorm1,stud3);
        moveIn(dorm1,stud4);

        cleanDorm(janitor,dorm1);
        cleanDorm(janitor,dorm3);

        party(dorm2);

        tryToEnter(stud1, watchman);
        tryToEnter(stud2, watchman);
        stud2.leaveDorm();
        tryToEnter(stud2, watchman);

        stud1.monthSalary();
        stud2.monthSalary();
        stud3.monthSalary();
        stud4.monthSalary();

        payingForDorm(dorm1);
        payingForDorm(dorm2);
        payingForDorm(dorm3);
    }

    public static void saveDorm(Dorm dorm){
        DormDto dormDto = new DormDto(dorm.getDormNumber(),
                dorm.getCleanliness(),
                dorm.getNumOfFreeRooms(),
                dorm.getMonthPrice());
        HttpEntity<DormDto> saveDorm = new HttpEntity<>(dormDto);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/dorm/crDorm",
                HttpMethod.POST, saveDorm, Void.class);
    }

    public static void saveStudent(Student student){
        StudentDto studentDto = new StudentDto(student.getName(),
                student.getSurname(),
                student.getCash(),
                student.getSalary(),
                student.getRoomNumber());
        HttpEntity<StudentDto> saveStudent = new HttpEntity<>(studentDto);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/students/crStudent",
                HttpMethod.POST, saveStudent, Void.class);
    }

    public static void saveJanitor(Janitor janitor){
        JanitorDto janitorDto = new JanitorDto(janitor.getName(),
                janitor.getSurname(),
                janitor.getCash(),
                janitor.getSalary(),
                janitor.getCleaningQuality());
        HttpEntity<JanitorDto> saveJanitor = new HttpEntity<>(janitorDto);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/clean/crJanitor",
                HttpMethod.POST, saveJanitor, Void.class);
    }

    public static void saveWatchman(Watchman watchman){
        WatchmanDto watchmanDto = new WatchmanDto(watchman.getName(),
                watchman.getSurname(),
                watchman.getCash(),
                watchman.getSalary(),
                watchman.getBribeNeeded());
        HttpEntity<WatchmanDto> saveWatchman = new HttpEntity<>(watchmanDto);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/entrance/crWatchman",
                HttpMethod.POST, saveWatchman, Void.class);
    }

    public static void moveIn(Dorm dorm, Student student){
        MoveInKickOutDto moveInKickOutDto = new MoveInKickOutDto(student,dorm);
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String deliverJsonStr = gson.toJson(moveInKickOutDto);

        HttpEntity<String> deliverJson = new HttpEntity<>(deliverJsonStr, headers);
        ResponseEntity<Void> response1 = restTemplate.exchange(URL + "/students/moveIn",
                HttpMethod.POST, deliverJson, Void.class);
    }

    public static void cleanDorm(Janitor janitor, Dorm dorm){
        CleanDto cleanDto = new CleanDto(janitor,dorm);
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String deliverJsonStr = gson.toJson(cleanDto);

        HttpEntity<String> deliverJson = new HttpEntity<>(deliverJsonStr, headers);
        ResponseEntity<Void> response1 = restTemplate.exchange(URL + "/clean/cleanDorm",
                HttpMethod.POST, deliverJson, Void.class);
    }

    public static void party(Dorm dorm){
        DormDto dormDto = new DormDto(dorm.getDormNumber(),
                dorm.getCleanliness(),
                dorm.getNumOfFreeRooms(),
                dorm.getMonthPrice());
        HttpEntity<DormDto> giveDorm = new HttpEntity<>(dormDto);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/party",
                HttpMethod.POST, giveDorm, Void.class);
    }

    public static void tryToEnter(Student student,Watchman watchman){
        EntranceDto entranceDto = new EntranceDto(watchman,student);
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String deliverJsonStr = gson.toJson(entranceDto);

        HttpEntity<String> deliverJson = new HttpEntity<>(deliverJsonStr, headers);
        ResponseEntity<Void> response1 = restTemplate.exchange(URL + "/entrance/tryToEnter",
                HttpMethod.POST, deliverJson, Void.class);
    }

    public static void payingForDorm(Dorm dorm){
        DormDto dormDto = new DormDto(dorm.getDormNumber(),
                dorm.getCleanliness(),
                dorm.getNumOfFreeRooms(),
                dorm.getMonthPrice());
        HttpEntity<DormDto> giveDorm = new HttpEntity<>(dormDto);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/dorm/pay",
                HttpMethod.POST, giveDorm, Void.class);
    }
}
