package com.example.hospital.error;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AppException extends RuntimeException {
    private String errorCode;

    private Integer statusCode;

    private String message;

    private String header;

    private Map<String, Object> information = new HashMap<>();

    @Builder
    public AppException(final String errorCode, final Integer statusCode, final String message, final String header,
                        final Map<String, Object> information) {
        super(message);
        this.errorCode = errorCode;
        this.statusCode = statusCode;
        this.message = message;
        this.header = header;
        this.information = information;
    }

    public static AppExceptionBuilder newBuilder(AppExceptionBuilder builder) {
        return AppException.builder().statusCode(builder.statusCode).errorCode(builder.errorCode).header(builder.header)
                .information(builder.information).message(builder.message);
    }

    public Map<String, Object> getParamsMap() {
        final Map<String, Object> params = new HashMap<>();
        params.put("error_code", this.errorCode);
        params.put("message", this.message);
        params.put("header", this.header);
        params.put("information", this.information);
        return params;
    }

    public static class AppExceptionBuilder {
        public AppExceptionBuilder information(Map<String, Object> info) {
            this.information = info;
            return this;
        }

        public AppExceptionBuilder information(String key, Object value) {
            if (this.information == null || this.information.isEmpty()) {
                this.information = new HashMap<>();
            }
            this.information.put(key, value);
            return this;
        }

    }
}
