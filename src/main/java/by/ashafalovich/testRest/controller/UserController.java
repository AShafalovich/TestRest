package by.ashafalovich.testRest.controller;

import by.ashafalovich.testRest.dto.Response;
import by.ashafalovich.testRest.dto.UserRequestDto;
import by.ashafalovich.testRest.dto.UserResponseDto;
import by.ashafalovich.testRest.dto.UserUpdateResponseDto;
import by.ashafalovich.testRest.model.enums.UserStatus;
import by.ashafalovich.testRest.service.UserService;
import by.ashafalovich.testRest.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Object> addUser(@RequestBody UserRequestDto user) {
        return CommonUtils.answer(userService.addUser(user));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Long id) {
        return CommonUtils.answer(userService.getUser(id));
    }

    @PatchMapping("/{id}/{status}")
    public ResponseEntity<Object> updateUserStatus(@PathVariable Long id,
                                                   @PathVariable UserStatus status) {
        return ResponseEntity.ok(userService.update(id, status));
    }

}
