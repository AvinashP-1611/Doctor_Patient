package com.example.Lattice_Innovation_doctor_patient.Services;

import com.example.Lattice_Innovation_doctor_patient.Models.Doctors;
import com.example.Lattice_Innovation_doctor_patient.Repositories.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    DoctorRepo doctorRepo;

    public String addDoctor(Doctors doctor) {
        doctorRepo.save(doctor);
        return "Doctor save successfully";
    }

    //delete an existing doctor
    public String deleteBYId(int id) {
        Doctors doctors=doctorRepo.findById(id);
        if(doctors==null) return null;
        doctorRepo.deleteById(id);
        return "found";
    }
}
