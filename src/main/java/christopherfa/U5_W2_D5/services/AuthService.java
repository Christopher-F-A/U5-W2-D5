package christopherfa.U5_W2_D5.services;

import christopherfa.U5_W2_D5.entities.User;
import christopherfa.U5_W2_D5.payloads.UserLoginDTO;
import christopherfa.U5_W2_D5.repositories.UserRepository;
import christopherfa.U5_W2_D5.security.TokenTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenTools tokenTools;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticateUser(UserLoginDTO body) {
        // cerca l'utente per email
        User user = userRepository.findByEmail(body.email())
                .orElseThrow(() -> new RuntimeException("Credenziali non valide"));

        // confronta la password
        if (!passwordEncoder.matches(body.password(), user.getPassword())) {
            throw new RuntimeException("Credenziali non valide");
        }

        // genera e ritorna il token
        return tokenTools.createToken(user.getEmail());
    }
}