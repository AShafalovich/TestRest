package by.ashafalovich.testRest.dto;

import by.ashafalovich.testRest.model.enums.UserStatus;
import lombok.*;

@Data
@Builder
public class UserRequestDto {

    private String name;
    private String email;
    private String imageUrl;
    private UserStatus status;

}
