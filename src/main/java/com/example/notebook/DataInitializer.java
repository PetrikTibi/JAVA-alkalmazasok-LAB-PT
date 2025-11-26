package com.example.notebook;

import com.example.notebook.model.User;
import com.example.notebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Ellenőrizzük, létezik-e már az Admin felhasználó
        if (userRepository.findByUsername("Admin") == null) {
            User admin = new User();
            admin.setUsername("Admin");
            // A jelszót titkosítva mentjük el
            admin.setPassword(passwordEncoder.encode("Jelszo12345"));
            admin.setEmail("admin@notebook.hu");
            admin.setRole("ROLE_ADMIN"); // Ő lesz az ADMIN

            userRepository.save(admin);
            System.out.println(">>> Admin felhasználó létrehozva: Admin / Jelszo12345");
        }
    }
}