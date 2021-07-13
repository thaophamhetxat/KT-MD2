package com.codegym.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateDate {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String Date_REGEX =  "^[0-9]{2,}[/][0-9]{2,}[/][0-9]{4,}$";
    public ValidateDate(){
        pattern =Pattern.compile(Date_REGEX);
    }
    public boolean validateDate(String regex3){
        matcher     =  pattern.matcher(regex3);
        return matcher.matches();
    }
}
