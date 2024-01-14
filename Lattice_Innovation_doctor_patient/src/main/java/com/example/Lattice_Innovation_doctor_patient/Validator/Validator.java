package com.example.Lattice_Innovation_doctor_patient.Validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validator {
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static boolean isValidEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidNameLength(String name){
        if(name.length()<2) return false;
        return true;
    }
    public static boolean isValidPhoneNumber(String number){
        if(number.length()!=10) return false;
        return true;
    }
    public static boolean isValidCityLength(String cityLength){
        if(cityLength.length()>20) return false;
        return true;
    }
}
