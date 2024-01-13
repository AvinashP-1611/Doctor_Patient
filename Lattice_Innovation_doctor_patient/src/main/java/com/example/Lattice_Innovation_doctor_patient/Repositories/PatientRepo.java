package com.example.Lattice_Innovation_doctor_patient.Repositories;


import com.example.Lattice_Innovation_doctor_patient.Models.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patients,Integer> {
   Patients findById(int id);

   @Override
   void deleteById(Integer id);
}
