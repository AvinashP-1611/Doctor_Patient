package com.example.Lattice_Innovation_doctor_patient.Controllers;

import com.example.Lattice_Innovation_doctor_patient.Models.Doctors;
import com.example.Lattice_Innovation_doctor_patient.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/addDoctor")
    public ResponseEntity addDoctor(@RequestBody Doctors doctor){
        try{
            String saveDoctor=doctorService.addDoctor(doctor);
            return new ResponseEntity(saveDoctor, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
    //delete an existing doctor
    @DeleteMapping("/deleteById/")
    public ResponseEntity deleteById(@RequestParam int id){
        String doctor=doctorService.deleteBYId(id);
        if(doctor==null) return new ResponseEntity("Doctor id is not found",HttpStatus.NOT_FOUND);
        return new ResponseEntity("Doctor with id "+id+" deleted successfully",HttpStatus.FOUND);
    }

}
