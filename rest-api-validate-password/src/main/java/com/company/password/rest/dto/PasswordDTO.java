package com.company.password.rest.dto;

import com.company.password.domain.domain.model.PasswordModel;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PasswordDTO {
    @NotNull(message = "PasswordModel cannot be null")
    private String value;

    public PasswordModel toModel() {
        return PasswordModel
                .builder()
                .value(this.value)
                .build();
    }

}
