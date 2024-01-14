package com.example.Lattice_Innovation_doctor_patient.Services;

import com.example.Lattice_Innovation_doctor_patient.Exceptions.NameSizeIsTooShortException;
import com.example.Lattice_Innovation_doctor_patient.Exceptions.EmailException;
import com.example.Lattice_Innovation_doctor_patient.Exceptions.PhoneNumberException;
import com.example.Lattice_Innovation_doctor_patient.Models.Doctors;
import com.example.Lattice_Innovation_doctor_patient.Repositories.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.Lattice_Innovation_doctor_patient.Validator.Validator.*;

@Service
public class DoctorService {
    @Autowired
    DoctorRepo doctorRepo;

    public String addDoctor(Doctors doctor) {
        if(!isValidNameLength(doctor.getDoctorName())) throw new NameSizeIsTooShortException("Doctor Name Size Is Too Short");
        else if(!isValidPhoneNumber(doctor.getPhoneNumber())) throw new PhoneNumberException("Phone Number Is Not Valid");
        else if(!isValidEmail(doctor.getEmail())) throw new EmailException("Email Is Not Valid");
       else{
           doctorRepo.save(doctor);
        }
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
