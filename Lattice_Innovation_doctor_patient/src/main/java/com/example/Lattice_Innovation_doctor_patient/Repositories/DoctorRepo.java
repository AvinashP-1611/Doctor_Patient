package com.example.Lattice_Innovation_doctor_patient.Repositories;

import com.example.Lattice_Innovation_doctor_patient.Enums.City;
import com.example.Lattice_Innovation_doctor_patient.Enums.Speciality;
import com.example.Lattice_Innovation_doctor_patient.Models.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepo extends JpaRepository<Doctors,Integer> {
    List<Doctors> findBySpeciality(Speciality speciality);


    Doctors findById(int id);

    @Override
    void deleteById(Integer integer);
}
