package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.ESERepo;
import com.example.demo.Repositories.MSERepo;
import com.example.demo.Repositories.StudentRepo;
import com.example.demo.model.ESE;
import com.example.demo.model.MSE;
import com.example.demo.model.Student;

@Service
public class ResultServices {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    MSERepo mseRepo;

    @Autowired
    ESERepo eseRepo;

    public double calculateResult(MSE mse, ESE ese) {
        double wt_result = (mse.getWt() * 0.3) + (ese.getWt() * 0.7);
        double daa_result = (mse.getDaa() * 0.3) + (ese.getDaa() * 0.7);
        double sdam_result = (mse.getSdam() * 0.3) + (ese.getSdam() * 0.7);
        double toc_result = (mse.getToc() * 0.3) + (ese.getToc() * 0.7);

        double finalResult = (wt_result + daa_result + sdam_result + toc_result) / 4;
        return finalResult;
    }

    // adding a student
    public Student AddStudent(Student student) {
        return studentRepo.save(student);
    }
    // getting all students

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
    // get a student by id

    public Student getStudentById(int id) {
        return studentRepo.findById(id).orElse(null);
    }

    // add MSE marks
    public MSE addMseMarks(MSE mse) {
        return mseRepo.save(mse);
    }

    // get all mse
    public List<MSE> getAllMSE() {
        return mseRepo.findAll();
    }

    // get mse by id

    public MSE getMseById(int id) {
        return mseRepo.findById(id).orElse(null);
    }

    // add ese marks

    public ESE addEseMarks(ESE ese) {
        return eseRepo.save(ese);
    }

    // get all ese marks

    public List<ESE> getAllESE() {
        return eseRepo.findAll();
    }

    // get ese by id
    public ESE getEseById(int id) {
        return eseRepo.findById(id).orElse(null);
    }

}
