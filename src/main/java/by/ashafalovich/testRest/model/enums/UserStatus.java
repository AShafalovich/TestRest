package by.ashafalovich.testRest.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserStatus {
    OFFLINE(0),
    ONLINE(1);

    private static final Map<Integer, UserStatus> BY_NUMBER = new HashMap<>();

    static {
        for (UserStatus status : values()) {
            BY_NUMBER.put(status.number, status);
        }
    }

    private final int number;

    UserStatus(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static UserStatus valueOfNumber(int number) {
        return BY_NUMBER.get(number);
    }
}
