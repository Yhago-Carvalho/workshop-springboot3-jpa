package com.course.course.config;

import com.course.course.entities.User;
import com.course.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration // Faz ser uma classe de configuração
@Profile("test") // argumento com nome igual ao definido no application.properties, ele vai entender que só deve rodr a aplicação quando estiver nos testes
public class TestConfig implements CommandLineRunner {

    @Autowired // Associa uma instância de userRepository à classe TestConfig, resolve a dependência de baixa acoplação
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
