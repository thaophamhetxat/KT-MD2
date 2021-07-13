package com.codegym.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {

    private static Pattern pattern;
    private Matcher matcher;
    private static final String Email_REGEX =  "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
    public ValidateEmail(){
        pattern =Pattern.compile(Email_REGEX);
    }
    public boolean validateEmail(String regex1){
        matcher     =  pattern.matcher(regex1);
        return matcher.matches();
    }
}
