package com.api.taskman;

public enum StatusCodes {
    CREATED(201), OK(200), REDIRECT(301), BAD_REQUEST(400), UNAUTHORIZED(401),
    FORBIDDEN(403), REQUEST_TIMEOUT(408),
    SERVER_ERR(500), BAD_GATEWAY(502);

    private int code;

    StatusCodes(int code) {
        this.code = code;
    }
}
