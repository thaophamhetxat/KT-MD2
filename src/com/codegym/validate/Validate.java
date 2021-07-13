package com.codegym.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    private static Pattern pattern;
    private Matcher matcher;
    private static final String SDT_REGEX =  "^(09|03|07|08|05)+([0-9]{8})$";


    public Validate(){
        pattern =Pattern.compile(SDT_REGEX);

    }
    public boolean validateSDT(String regex2){
        matcher     =  pattern.matcher(regex2);
        return matcher.matches();
    }

}
