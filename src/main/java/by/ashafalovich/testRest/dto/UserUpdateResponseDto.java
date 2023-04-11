package by.ashafalovich.testRest.dto;

import by.ashafalovich.testRest.model.enums.UserStatus;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class UserUpdateResponseDto extends Response{

    private Long id;
    private UserStatus prevStatus;
    private UserStatus newStatus;

}
