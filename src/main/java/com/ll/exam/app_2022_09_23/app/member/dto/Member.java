package com.ll.exam.app_2022_09_23.app.member.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Arrays;

@Data
@Builder
public class Member {
    private long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String roles;

    // 비밀번호 올바른지 검사
    public boolean matchPassword(String password) {
        return this.password.substring("{noop}".length()).equals(password);
    }

    // 해당 role 이 부여되었는지 검사
    public boolean hasRole(String role) {
        return Arrays
                .stream(roles.split(","))
                .anyMatch(role_ -> role_.equals(role));
    }
}
