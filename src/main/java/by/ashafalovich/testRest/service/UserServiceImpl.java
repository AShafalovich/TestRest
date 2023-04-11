package by.ashafalovich.testRest.service;

import by.ashafalovich.testRest.dto.Response;
import by.ashafalovich.testRest.dto.UserRequestDto;
import by.ashafalovich.testRest.dto.UserResponseDto;
import by.ashafalovich.testRest.dto.UserUpdateResponseDto;
import by.ashafalovich.testRest.model.User;
import by.ashafalovich.testRest.model.enums.UserStatus;
import by.ashafalovich.testRest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Response getUser(Long id) {
        Response result;
        if (id != null) {
            Optional<User> userOpt = userRepository.findById(id);
            if (userOpt.isPresent()) {
                User user = userOpt.get();
                result = UserResponseDto.builder()
                        .name(user.getName())
                        .imageUrl(user.getImageUrl())
                        .email(user.getEmail())
                        .status(user.getStatus())
                        //.code(CREATED.value())
                        //.message(CREATED.getReasonPhrase())
                        .build();
            } else {
                result = getUserResponseDtoWithError(NOT_FOUND);
            }
        } else {
            result = getUserResponseDtoWithError(BAD_REQUEST);
        }
        return result;
    }

    @Override
    public Response addUser(UserRequestDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .status(userDto.getStatus())
                .imageUrl(userDto.getImageUrl())
                .build();
        User savedUser = userRepository.save(user);
        return UserResponseDto.builder()
                .id(savedUser.getId())
                .build();
    }

    @Override
    public Response update(Long id, UserStatus status) {
        Response result;
        if (null != id && null != status) {
            Optional<User> userOpt = userRepository.findById(id);
            if (userOpt.isPresent()) {
                User user = userOpt.get();
                UserStatus prevStatus = user.getStatus();
                user.setStatus(status);
                User savedUser = userRepository.save(user);
                result = UserUpdateResponseDto.builder()
                        .id(savedUser.getId())
                        .newStatus(savedUser.getStatus())
                        .prevStatus(prevStatus)
                        .build();
            } else {
                result = getUserResponseDtoWithError(NOT_FOUND);
            }
        } else {
            result = getUserResponseDtoWithError(BAD_REQUEST);
        }
        return result;
    }

    private Response getUserResponseDtoWithError(HttpStatus status) {
        return UserResponseDto.builder()
                .code(status.value())
                .message(status.getReasonPhrase())
                .build();
    }
}
