package christopherfa.U5_W2_D5.controllers;

import christopherfa.U5_W2_D5.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDTO body) {
        return authService.authenticateUser(body);
    }
}