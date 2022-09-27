package com.company.password.domain.domain.port;

import com.company.password.domain.domain.model.PasswordModel;

public interface ValidatePasswordPort {

    boolean validatePassword(PasswordModel password);
}
