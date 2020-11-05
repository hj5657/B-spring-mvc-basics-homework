package com.thoughtworks.capacity.gtb.mvc.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull
    @Size(min = 3, max = 10)
    @Pattern(regexp = "^[a-z0-9_]+$")
    private String username;
    @NotNull
    @Size(min = 5, max = 12)
    private String password;
    @Email
    private String email;
}
