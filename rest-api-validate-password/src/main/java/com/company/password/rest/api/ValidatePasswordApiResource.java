package com.company.password.rest.api;

import com.company.password.domain.domain.port.ValidatePasswordPort;
import com.company.password.rest.dto.PasswordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication(scanBasePackages = "com.company")
@RestController
@RequestMapping("/v1/validate")
public class ValidatePasswordApiResource implements ValidatePasswordApiDoc {

    @Autowired
    private ValidatePasswordPort validatePasswordPort;

    @PostMapping("/validate-password")
    public ResponseEntity<Boolean> validatePassword(@RequestBody String password) {

        PasswordDTO passwordDTO = PasswordDTO.builder().value(password).build();

        if (validatePasswordPort.validatePassword(passwordDTO.toModel())) {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    }

}
