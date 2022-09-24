package com.company.password.validate.constant;

public final class RegexConst {

    RegexConst(){}
    public static final String REGEX_PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+])(?!.*(.)\\1).\\S*{9,}$" ;
}
