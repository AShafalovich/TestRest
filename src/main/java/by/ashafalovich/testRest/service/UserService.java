package by.ashafalovich.testRest.service;

import by.ashafalovich.testRest.dto.Response;
import by.ashafalovich.testRest.dto.UserRequestDto;
import by.ashafalovich.testRest.model.enums.UserStatus;

public interface UserService {

    Response getUser(Long id);

    Response addUser(UserRequestDto user);

    Response update(Long id, UserStatus status);
}
