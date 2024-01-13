package com.example.Lattice_Innovation_doctor_patient.Exceptions;

public class DoctorNotFoundOnLocationException extends RuntimeException{
    public DoctorNotFoundOnLocationException(String m){
        super(m);
    }
}
