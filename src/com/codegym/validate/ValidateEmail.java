package com.codegym.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {

    private static Pattern pattern;
    private Matcher matcher;
    private static final String Email_REGEX =  "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public ValidateEmail(){
        pattern =Pattern.compile(Email_REGEX);
    }
    public boolean validateEmail(String regex1){
        matcher     =  pattern.matcher(regex1);
        return matcher.matches();
    }
}
