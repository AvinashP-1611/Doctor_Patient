package com.example.Lattice_Innovation_doctor_patient.Controllers;

import com.example.Lattice_Innovation_doctor_patient.Models.Doctors;
import com.example.Lattice_Innovation_doctor_patient.Models.Patients;
import com.example.Lattice_Innovation_doctor_patient.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/addPatient")
    public ResponseEntity addPatient(@RequestBody Patients patient){
        String savePatient=patientService.addPatient(patient);
        return new ResponseEntity(savePatient, HttpStatus.CREATED);
    }
    //getting a suggested doctor
    @GetMapping("/suggestDoctor")
    public ResponseEntity getAssignDoctor(@RequestParam int id){

        try{
            List<Doctors> doctors=patientService.getAssignDoctor(id);
            if (doctors.isEmpty()) return new ResponseEntity("There isn’t any doctor present at your location for your symptom",HttpStatus.NOT_FOUND);
            else return new ResponseEntity(doctors,HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    //delete a patient by id
    @DeleteMapping("/deleteById/")
    public ResponseEntity deleteById(@RequestParam int id){
        String patient=patientService.deleteBYId(id);
        if(patient==null) return new ResponseEntity("Patient id is not found",HttpStatus.NOT_FOUND);
        return new ResponseEntity("Patient with id "+id+" deleted successfully",HttpStatus.FOUND);
    }

}
