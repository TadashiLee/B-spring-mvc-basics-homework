package com.thoughtworks.capacity.gtb.mvc.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    Integer id;

    @NotEmpty
    @Pattern(regexp = "[0-9A-Za-z_]{3,10}", message = "用户名不合法")
    @Size(min=3, max = 10)
    private String username;

    @NotEmpty
    @Size(min=5, max = 12)
    private String password;

    @NotEmpty
    @Email
    private String email;

}
