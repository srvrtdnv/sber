package ru.sarvartdinov.sber.exception;

public class GroupsValidationException extends RuntimeException {
    private static final String GROUP_VALIDATION_FAILED_ERROR = "В списке групп присутсвуют несуществующие либо неактивные группы.";

    public GroupsValidationException() {
        super(GROUP_VALIDATION_FAILED_ERROR);
    }

}
