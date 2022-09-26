package com.company.password.validate.adapter;

import com.company.password.domain.domain.port.ValidatePasswordPort;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.company.password.validate.constant.RegexConst.REGEX_PASSWORD;

@Service
public class ValidatePasswordAdapter implements ValidatePasswordPort {

   // private static final Logger LOG = LoggerFactory.getLogger(ValidatePasswordAdapter.class);
    @Override
    public boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(REGEX_PASSWORD);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
