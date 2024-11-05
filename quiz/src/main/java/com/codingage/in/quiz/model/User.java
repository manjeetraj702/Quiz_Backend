package com.codingage.in.quiz.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User {
    @Id
    private String id;

    @NotNull
    @NotBlank
    private String userName;

    @NotNull
    @NotBlank
    @Size(min = 6,message = "password size at least 6 character")
    private String password;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phoneNumber;  // Optional field, no @NotNull annotation


    @Pattern(regexp = "^(student|admin)$", message = "Role must be either 'student' or 'admin'")
    private String role;
}
