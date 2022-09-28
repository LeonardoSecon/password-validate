package com.company.password.rest.api;

import com.company.password.domain.domain.port.ValidatePasswordPort;
import com.company.password.rest.dto.PasswordDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication(scanBasePackages = "com.company")
@RestController
@RequestMapping("/v1/password")
public class ValidatePasswordApiResource implements ValidatePasswordApiDoc {

    private static final Logger LOG = LoggerFactory.getLogger(ValidatePasswordApiResource.class);
    @Autowired
    private ValidatePasswordPort validatePasswordPort;

    @PostMapping("/validation")
    public ResponseEntity<Boolean> validatePassword(@RequestBody String password) {


        LOG.info("Request validatePassword start");
        PasswordDTO passwordDTO = PasswordDTO.builder().value(password).build();

        if (validatePasswordPort.validatePassword(passwordDTO.toModel())) {
            LOG.trace("Request validatePassword validate as true end ");
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }

        LOG.trace("Request validatePasswordvalidate as false end ");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    }

}
