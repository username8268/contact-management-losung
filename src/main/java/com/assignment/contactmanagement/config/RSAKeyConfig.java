package com.assignment.contactmanagement.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPublicKey;
import java.security.interfaces.RSAPrivateKey;

@ConfigurationProperties(prefix = "rsa")
public record RSAKeyConfig(RSAPublicKey publickey, RSAPrivateKey privateKey) {

} 
