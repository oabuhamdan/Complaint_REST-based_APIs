package com.pwc.assignment.data.dto;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class UserDto {
    private String name;
    @NonNull
    private String username;
    @NonNull
    private String password;
}
