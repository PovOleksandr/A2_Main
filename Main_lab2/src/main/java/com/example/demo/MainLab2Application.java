package com.example.demo;


import com.example.demo.entities.Dorm;
import com.example.demo.entities.Janitor;
import com.example.demo.entities.Student;
import com.example.demo.entities.Watchman;
import com.example.demo.entities.dto.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@SpringBootApplication
public class MainLab2Application {

    private static final String URL = "http://localhost:8080";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    public static void main(String[] args) {

        headers.setContentType(MediaType.APPLICATION_JSON);


        Dorm dorm1 = new Dorm(1,100,20,700);
        Dorm dorm2 = new Dorm(2,75,40,550);
        Dorm dorm3 = new Dorm(3,60,35,400);

        saveDorm(dorm1);
        saveDorm(dorm2);
        saveDorm(dorm3);


        ResponseEntity<Dorm[]> response0 =  restTemplate.exchange( URL + "/dorm",
                HttpMethod.GET, headersEntity,  Dorm[].class);
        List<Dorm> dorms = Arrays.asList(Objects.requireNonNull(response0.getBody()));
        System.out.println("OUR DORMS.");
        System.out.println(dorms);

        Watchman watchman = new Watchman( "Galina", "Martynenko", 3000, 100, 1500);
        saveWatchman(watchman);

        ResponseEntity<Watchman[]> response1 =  restTemplate.exchange( URL + "/entrance",
                HttpMethod.GET, headersEntity,  Watchman[].class);
        List<Watchman> watchmans = Arrays.asList(Objects.requireNonNull(response1.getBody()));
        System.out.println("OUR WATCHMANS.");
        System.out.println(watchmans);

        Janitor janitor = new Janitor( "Viktor", "Paltsev", 2000, 2000, 30);
        saveJanitor(janitor);

        ResponseEntity<Janitor[]> response2 =  restTemplate.exchange( URL + "/clean",
                HttpMethod.GET, headersEntity, Janitor[].class);
        List<Janitor> janitors = Arrays.asList(Objects.requireNonNull(response2.getBody()));
        System.out.println("OUR JANITORS:");
        System.out.println(janitors);

        Student stud1 = new Student("Aleksandr", "Povidzion", 400, 1000, 0);
        Student stud2 = new Student( "Anna", "Sushkina", 1350, 500, 1);
        Student stud3 = new Student( "Oleg", "Popov", 400, 600, 10);
        Student stud4 = new Student( "Oleg", "Panchenko", 400, 100, 5);

        saveStudent(stud1);
        saveStudent(stud2);
        saveStudent(stud3);
        saveStudent(stud4);

        ResponseEntity<Student[]> response3 =  restTemplate.exchange( URL + "/students",
                HttpMethod.GET, headersEntity, Student[].class);
        List<Student> students = Arrays.asList(Objects.requireNonNull(response3.getBody()));
        System.out.println("OUR STUDENTS:");
        System.out.println(students);


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
        System.out.println("Dorm with number "+dorm.getDormNumber()+" saved.");
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
        System.out.println("Student "+student.getSurname()+" saved.");
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
        System.out.println("Janitor "+janitor.getSurname()+" saved.");
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
        System.out.println("Watchman "+watchman.getSurname()+" saved.");
    }

    public static void moveIn(Dorm dorm, Student student){
        MoveInKickOutDto moveInKickOutDto = new MoveInKickOutDto(student,dorm);

        HttpEntity<MoveInKickOutDto> moveInKickOutDtoHttpEntity = new HttpEntity<>(moveInKickOutDto, headers);
        ResponseEntity<Void> response1 = restTemplate.exchange(URL + "/students/moveIn",
                HttpMethod.POST, moveInKickOutDtoHttpEntity, Void.class);
        System.out.println(student.getSurname()+" moved into dorm number "+dorm.getDormNumber());
    }

    public static void cleanDorm(Janitor janitor, Dorm dorm){
        CleanDto cleanDto = new CleanDto(janitor,dorm);

        HttpEntity<CleanDto> cleanDtoHttpEntity = new HttpEntity<>(cleanDto, headers);
        ResponseEntity<Void> response1 = restTemplate.exchange(URL + "/clean/cleanDorm",
                HttpMethod.POST, cleanDtoHttpEntity, Void.class);
        System.out.println(janitor.getSurname()+"cleared dorm number"+dorm.getDormNumber());

    }

    public static void party(Dorm dorm){
        DormDto dormDto = new DormDto(dorm.getDormNumber(),
                dorm.getCleanliness(),
                dorm.getNumOfFreeRooms(),
                dorm.getMonthPrice());
        dormDto.setId(dorm.getId());
        HttpEntity<DormDto> giveDorm = new HttpEntity<>(dormDto,headers);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/party",
                HttpMethod.POST, giveDorm, Void.class);
        System.out.println("There was a party in the dorm number "+dorm.getDormNumber());
    }

    public static void tryToEnter(Student student,Watchman watchman){
        EntranceDto entranceDto = new EntranceDto(watchman,student);

        HttpEntity<EntranceDto> entranceDtoHttpEntity = new HttpEntity<>(entranceDto, headers);
        ResponseEntity<Void> response1 = restTemplate.exchange(URL + "/entrance/tryToEnter",
                HttpMethod.POST, entranceDtoHttpEntity, Void.class);
        System.out.println(student.getSurname()+" tried to enter the dorm.");
    }

    public static void payingForDorm(Dorm dorm){
        DormDto dormDto = new DormDto(dorm.getDormNumber(),
                dorm.getCleanliness(),
                dorm.getNumOfFreeRooms(),
                dorm.getMonthPrice());
        HttpEntity<DormDto> giveDorm = new HttpEntity<>(dormDto,headers);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/dorm/pay",
                HttpMethod.POST, giveDorm, Void.class);
        System.out.println("Dorm number "+dorm.getDormNumber()+" has collected month fee.");
    }

    public static void deleteDormById(UUID id){
        HttpEntity<UUID> giveId = new HttpEntity<>(id,headers);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/dorm",
                HttpMethod.DELETE, giveId, Void.class);
        System.out.println("Dorm deleted.");
    }

    public static void deleteStudentById(UUID id){
        HttpEntity<UUID> giveId = new HttpEntity<>(id,headers);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/students",
                HttpMethod.DELETE, giveId, Void.class);
        System.out.println("Student deleted.");
    }

    public static void deleteJanitorById(UUID id){
        HttpEntity<UUID> giveId = new HttpEntity<>(id,headers);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/clean",
                HttpMethod.DELETE, giveId, Void.class);
        System.out.println("Janitor deleted.");
    }

    public static void deleteWatchmanById(UUID id){
        HttpEntity<UUID> giveId = new HttpEntity<>(id,headers);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/entrance",
                HttpMethod.DELETE, giveId, Void.class);
        System.out.println("Watchman deleted.");
    }
}
