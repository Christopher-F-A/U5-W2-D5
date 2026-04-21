package christopherfa.U5_W2_D5.controllers;

import christopherfa.U5_W2_D5.entities.User;
import christopherfa.U5_W2_D5.payloads.UserLoginDTO;
import christopherfa.U5_W2_D5.repositories.UserRepository;
import christopherfa.U5_W2_D5.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDTO body) {
        return authService.authenticateUser(body);
    }

    // endpoint temporaneo per creare un utente di test
    @PostMapping("/register")
    public String register(@RequestBody UserLoginDTO body) {
        User user = new User();
        user.setEmail(body.email());
        user.setPassword(passwordEncoder.encode(body.password()));
        user.setName("Test");
        user.setSurname("User");
        userRepository.save(user);
        return "Utente creato";
    }
}