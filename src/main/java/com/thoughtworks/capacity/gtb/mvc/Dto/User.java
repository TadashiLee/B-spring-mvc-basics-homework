package com.thoughtworks.capacity.gtb.mvc.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    Integer id;

    @NotBlank
    @Pattern(regexp = "[0-9A-Za-z_]{3,10}", message = "用户名不合法")
    @Size(min=3, max = 10)
    private String username;

    @NotBlank
    @Size(min=5, max = 12)
    private String password;

    @NotBlank
    @Email
    private String email;

}
