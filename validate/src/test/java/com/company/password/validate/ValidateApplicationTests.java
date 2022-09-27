package com.company.password.validate;

import com.company.password.domain.domain.model.PasswordModel;
import com.company.password.domain.domain.port.ValidatePasswordPort;
import com.company.password.validate.adapter.ValidatePasswordAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;


class ValidateApplicationTests {

    @Autowired
    private final ValidatePasswordPort validatePasswordPort = new ValidatePasswordAdapter();

    @DisplayName("Should validate password as false")
    @ParameterizedTest
    @MethodSource("invalidPasswordProvider")
    void TestInvalidPasswordFail(String password) {
      Assertions.assertFalse(validatePasswordPort.validatePassword(PasswordModel.builder().value(password).build()));
    }

    private static Stream<Arguments> invalidPasswordProvider() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("aa"),
                Arguments.of("AA"),
                Arguments.of("ab"),
                Arguments.of("AAAbbbCc"),
                Arguments.of("AbTp9!foo"),
                Arguments.of("AbTp9!foA"),
                Arguments.of("AbTp9!foA"),
                Arguments.of("AbTp9 fok")
        );
    }

    @DisplayName("Should validate password as true")
    @ParameterizedTest
    @MethodSource("validPasswordProvider")
    void TestInvalidPasswordSuccessful(String password) {
        Assertions.assertTrue(validatePasswordPort.validatePassword(PasswordModel.builder().value(password).build()));
    }

    private static Stream<Arguments> validPasswordProvider() {
        return Stream.of(
                Arguments.of("AbTp9!fo*"),
                Arguments.of("AbTp9!fo$%)"),
                Arguments.of("AbTp9!fo7"),
                Arguments.of("+A-bTp9!fo7"),
                Arguments.of("AbT^p9(fok")
        );
    }

}
