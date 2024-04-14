package ru.shefer.service;

import org.springframework.stereotype.Component;

@Component
public class JwtService {
    static final long EXPIRATIONTIME = 86400000;
    static final String PREFIX = "Bearer";
}
