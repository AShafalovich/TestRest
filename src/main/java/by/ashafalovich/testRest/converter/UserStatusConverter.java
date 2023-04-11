package by.ashafalovich.testRest.converter;

import by.ashafalovich.testRest.model.enums.UserStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserStatusConverter implements AttributeConverter<UserStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(UserStatus attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getNumber();
    }

    @Override
    public UserStatus convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return UserStatus.valueOfNumber(dbData);
    }
}
