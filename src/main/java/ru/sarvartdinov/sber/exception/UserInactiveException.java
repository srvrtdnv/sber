package ru.sarvartdinov.sber.exception;

public class UserInactiveException extends RuntimeException {
    private static final String USER_INACTIVE_ERROR = "Пользователь в статусе неактивен.";

    public UserInactiveException() {
        super(USER_INACTIVE_ERROR);
    }

}
