package br.com.vinicius.todolist.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {

        // VALIDATOR
        var user = this.userRepository.findByUsername(userModel.getUsername());

        // SE USUARIO FOR DIFERENTE DE NULO ELE JÁ EXISTE; RETORNAR ERROR
        if(user != null) {
            // Error message
            // Status code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario já existe.");
        }

        // PASSWORD ENCRYPT
        var passwordHashred = BCrypt.withDefaults()
                .hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashred);

        // SE USUARIO NÃO EXISTIR ELE CRIA E SALVA
        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.OK).body(userCreated);
    }
}
