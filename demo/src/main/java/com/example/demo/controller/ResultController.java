package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.ResultServices;
import com.example.demo.model.ESE;
import com.example.demo.model.MSE;
import com.example.demo.model.Student;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ResultController {

    @Autowired
    ResultServices resultServices;

    // get all students
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return resultServices.getAllStudents();
    }

    // add mse marks
    @PostMapping("/addMse")
    public MSE addMse(@RequestBody MSE mse) {
        return resultServices.addMseMarks(mse);
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        return resultServices.AddStudent(student);
    }
    // add ese
    @PostMapping("/addEse")
    public ESE addEse(@RequestBody ESE ese) {
        return resultServices.addEseMarks(ese);
    }

    //
    @PostMapping("/calculate/{id}")
    public String finalCalculate(@PathVariable int id) {
        MSE mse = resultServices.getMseById(id);
        if (mse == null) {
            return "MSE is not found";
        }
        ESE ese = resultServices.getEseById(id);
        if (ese == null) {
            return "ESE is not found";
        }
        double finalResult = resultServices.calculateResult(mse, ese);
        Student student = resultServices.getStudentById(id);
        if (student == null) {
            return "Student not found";
        }
        student.setResult(finalResult);
        resultServices.AddStudent(student);
        return "FINAL RESULT UPDATED SUCCESSFULLY !" + finalResult;

    }

}
