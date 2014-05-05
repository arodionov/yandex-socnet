package ua.yandex.shad.socnet.web.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;
import ua.yandex.shad.socnet.domain.student.Student;
import ua.yandex.shad.socnet.service.student.StudentService;

@Controller
@RequestMapping("/rest")
public class StudentRestConroller {

    private final StudentService studentService;

    @Autowired
    public StudentRestConroller(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String defaultHellofromRest() {
        return "Hello from REST " + "\n";
    }

    //curl -H Accept:application/json http://localhost:8084/SocNet/service/rest/students
    @RequestMapping(method = RequestMethod.GET, value = "/students",
            headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Student> getAllStudents() {
        return studentService.findAll();
    }

    //curl -H Accept:application/json http://localhost:8084/SocNet/service/rest/students/1
    @RequestMapping(method = RequestMethod.GET, value = "/students/{id}",
            headers = "Accept=application/json")
    public @ResponseBody
    ResponseEntity<Student> getStudentByID(@PathVariable Integer id) {

        Student student = studentService.findByID(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //curl -v -X PUT -H content-type:application/json --data '{"studentID":null,"studentName":"Andy","studentYear":5}' http://localhost:8084/SocNet/service/rest/students
    @RequestMapping(method = RequestMethod.PUT, value = "/students",
            headers = "content-type=application/json" )
    public @ResponseBody
    ResponseEntity<Student> addStudent(@RequestBody Student student, UriComponentsBuilder builder) {
        System.out.println(student);

        HttpStatus status;
        if (studentService.checkIfExists(student)) {
            status = HttpStatus.CONFLICT;
        } else {
            studentService.create(student);
            status = HttpStatus.CREATED;
        }

        Student newStudent = studentService.findByName(student.getStudentName());

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(
                builder.path("/rest/students/{id}")
                .buildAndExpand(newStudent.getStudentID().toString()).toUri());

        return new ResponseEntity<>(newStudent, headers, status);
    }
}
