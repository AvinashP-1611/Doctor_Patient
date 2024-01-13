package com.example.Lattice_Innovation_doctor_patient.Models;

import com.example.Lattice_Innovation_doctor_patient.Enums.City;
import com.example.Lattice_Innovation_doctor_patient.Enums.Speciality;
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
@Table(name = "doctors")
public class Doctors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int doctorId;

    @Size(min = 3, message = "Doctor name should be at least 3 characters")
    String doctorName;

    @Enumerated(EnumType.STRING)
    @Size(max=20, message = "City Name should be at most 20 characters")
    City city;

    @Email(message = "Please Enter valid email address")
    @Column(unique = true, nullable = false)
    String email;

    @Size(min=10, max=10, message = "Please Enter valid Phone Number")
    String phoneNumber;

    @Enumerated(EnumType.STRING)
    Speciality speciality;

}
