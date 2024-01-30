package com.example.hospital.error;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Error {
    AUTH_HEADER_MISSING(AppException.builder().message("auth header missing").header("auth header missing").statusCode(400)),
    INVALID_TOKEN(AppException.builder().message("invalid token").header("invalid token").statusCode(403)),
    INVALID_PASSWORD(AppException.builder().message("invalid password").header("invalid password").statusCode(403)),
    USER_NOT_FOUND(AppException.builder().message("user not found").header("user not found").statusCode(400)),
    PATIENT_ALREADY_ADMITTED(
            AppException.builder().message("patient is already admitted").header("need to discharge the patient first").statusCode(400)),
    PATIENT_NOT_ADMITTED(
            AppException.builder().message("patient is not admitted").header("patient is not admitted").statusCode(400)),
    HOSPITAL_NOT_FOUND(AppException.builder().message("hospital not found").header("hospital not found").statusCode(404)),
    ROOM_NOT_FOUND(AppException.builder().message("room not found").header("room not found").statusCode(404)),
    DOCTOR_NOT_FOUND(AppException.builder().message("doctor not found").header("doctor not found").statusCode(404)),
    PATIENT_NOT_FOUND(AppException.builder().message("hospital not found").header("hospital not found").statusCode(404));

    private final AppException.AppExceptionBuilder appExceptionBuilder;

    public AppException.AppExceptionBuilder getBuilder() {
        return AppException.newBuilder(appExceptionBuilder).errorCode(name());
    }
}
