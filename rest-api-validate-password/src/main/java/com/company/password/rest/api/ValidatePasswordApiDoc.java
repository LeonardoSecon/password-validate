package com.company.password.rest.api;

import com.company.password.rest.dto.PasswordDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Api(value = "Validate", tags = {"Validate"})
public interface ValidatePasswordApiDoc {
    @ApiOperation(value = "Validate password")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Valid password"),
            @ApiResponse(code = 400, message = "InValid password")
    })
    ResponseEntity<Boolean> validatePassword(@RequestBody String password);
}
