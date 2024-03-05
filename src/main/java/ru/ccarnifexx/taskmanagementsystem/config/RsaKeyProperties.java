package ru.ccarnifexx.taskmanagementsystem.config;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import static lombok.AccessLevel.PRIVATE;

@Setter
@Getter
@Configuration
@FieldDefaults(level = PRIVATE)
@ConfigurationProperties(prefix = "rsa")
public class RsaKeyProperties {

    @Value("${rsa.public-key}")
    RSAPublicKey rsaPublicKey;

    @Value("${rsa.private-key}")
    RSAPrivateKey rsaPrivateKey;

}
