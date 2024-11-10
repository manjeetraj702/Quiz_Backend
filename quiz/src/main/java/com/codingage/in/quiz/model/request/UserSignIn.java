package com.codingage.in.quiz.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignIn {
    @NotNull
    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    @Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits")
    private String phoneNumber;

    @NotNull
    @NotBlank
    private String password;
}
