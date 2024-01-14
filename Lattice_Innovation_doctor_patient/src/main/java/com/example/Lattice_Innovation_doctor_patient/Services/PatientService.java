package com.example.Lattice_Innovation_doctor_patient.Services;


import com.example.Lattice_Innovation_doctor_patient.Enums.City;
import com.example.Lattice_Innovation_doctor_patient.Enums.Speciality;
import com.example.Lattice_Innovation_doctor_patient.Exceptions.*;
import com.example.Lattice_Innovation_doctor_patient.Models.Doctors;
import com.example.Lattice_Innovation_doctor_patient.Models.Patients;
import com.example.Lattice_Innovation_doctor_patient.Repositories.DoctorRepo;
import com.example.Lattice_Innovation_doctor_patient.Repositories.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.Lattice_Innovation_doctor_patient.Enums.Speciality.*;
import static com.example.Lattice_Innovation_doctor_patient.Validator.Validator.*;

@Service
public class PatientService {
    @Autowired
    PatientRepo patientRepo;

    @Autowired
    DoctorRepo doctorRepo;

    //adding a new patient
    public String addPatient(Patients patient) {
        if(!isValidNameLength(patient.getPatientName())) throw new NameSizeIsTooShortException("Doctor Name Size Is Too Short");
        else if(!isValidPhoneNumber(patient.getPhoneNumber())) throw new PhoneNumberException("Phone Number Is Not Valid");
        else if(!isValidEmail(patient.getEmail())) throw new EmailException("Email Is Not Valid");
        else if(!isValidCityLength(patient.getCityName())) throw new CityNameLengthException("City Name Is Too LOng");
        else patientRepo.save(patient);
        return "Patient save successfully";
    }

    //assigning doctors on patient symptom
    public List<Doctors> getAssignDoctor(int id) {
        List<Doctors> suggestedDocs=new ArrayList<>();
        Patients patient=patientRepo.findById(id);

        List<Doctors> docList=new ArrayList<>();
        if(patient==null) throw new PatientNotFoundException("Patient does not exits");
        else{

           String symptom= patient.getSymptom().toString();

           String city=patient.getCityName();
           boolean cityPresent=false;
           for(Enum c:City.values()){
               if(c.toString().equals(city)) {
                   cityPresent=true;
                   break;
               }
           }
           if(!cityPresent) {
               throw new DoctorNotFoundOnLocationException("We are still waiting to expand to your location");
           }

            if(symptom.equals("Arthritis") || symptom.equals("Back_Pain") || symptom.equals("Tissue_Injuries")) {

                  docList = doctorRepo.findBySpeciality(Orthopedic);
           }

           else if(symptom.equals("Dysmenorrhea")){
               docList = doctorRepo.findBySpeciality(Gynecology);
           }
           else if(symptom.equals("Skin_Infection") || symptom.equals("Skin_Burn")){
               docList = doctorRepo.findBySpeciality(Dermatology);
           }
           else if(symptom.equals("Ear_Pain")){
                docList = doctorRepo.findBySpeciality(ENT);
           }
        }

        for(Doctors doctors:docList){
            if(patient.getCityName().equals(doctors.getCity().toString())) suggestedDocs.add(doctors);
        }
        return suggestedDocs;
    }

    //delete a patient
    public String deleteBYId(int id) {
        Patients patients=patientRepo.findById(id);
        if(patients==null) return null;
        else patientRepo.deleteById(id);
        return "found";
    }
}
