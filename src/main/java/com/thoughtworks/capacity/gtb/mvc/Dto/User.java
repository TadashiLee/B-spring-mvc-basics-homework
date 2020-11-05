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

    @NotBlank(message = "用户名不符合要求")
    @Pattern(regexp = "[0-9A-Za-z_]{3,10}", message = "用户名不合法")
    @Size(min=3, max = 10, message = "用户名必须在3—10位之间")
    private String username;

    @NotBlank(message = "密码不符合要求")
    @Size(min=5, max = 12, message = "密码必须在5-12位之间")
    private String password;

    @NotBlank(message = "邮箱不符合要求")
    @Email
    private String email;

}
