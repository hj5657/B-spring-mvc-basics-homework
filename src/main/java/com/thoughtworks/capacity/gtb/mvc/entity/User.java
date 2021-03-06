package com.thoughtworks.capacity.gtb.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    @NotBlank(message = "用户名不能为空")
    @Size(min = 3, max = 10,message = "用户名长度要求为3到10位")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$",message ="用户名只能由字母、数字或下划线组成")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Size(min = 5, max = 12,message = "密码长度要求为5到12位")
    private String password;
    @Email(message = "不符合邮箱命名规范")
    private String email;
}
