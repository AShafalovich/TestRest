package by.ashafalovich.testRest.model;

import by.ashafalovich.testRest.converter.UserStatusConverter;
import by.ashafalovich.testRest.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

    @NotBlank
    @Column(name = "name")
    private String name;

    @Email
    @Column(name = "email")
    private String email;

    @URL
    @Column(name = "image_url")
    private String imageUrl;

    @Convert(converter = UserStatusConverter.class)
    @Column(name = "status")
    private UserStatus status;
}
