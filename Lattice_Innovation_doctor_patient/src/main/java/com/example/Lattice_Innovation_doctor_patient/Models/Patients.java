package com.example.Lattice_Innovation_doctor_patient.Models;
import com.example.Lattice_Innovation_doctor_patient.Enums.City;
import com.example.Lattice_Innovation_doctor_patient.Enums.Speciality;
import com.example.Lattice_Innovation_doctor_patient.Enums.Symptom;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "patients")
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Size(min = 3,message = "Patient name should be at least 3 characters")
    String patientName;

    @Size(min=3,max = 20,message = "City name should be atmost 20 characters")
    String cityName;

    @Email
    @Column(unique=true, nullable = false)
    String email;

    @Size(min=10, max=10, message = "Please Enter valid Phone Number")
    String phoneNumber;

    @Enumerated(EnumType.STRING)
    Symptom symptom;

//    @ManyToOne
//    @JoinColumn(name = "doctor_id")
//    Doctors doctor;

}
