package by.ashafalovich.testRest.dto;

import by.ashafalovich.testRest.model.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDto extends Response {

    private Long id;
    private String name;
    private String email;
    private String imageUrl;
    private UserStatus status;

}
