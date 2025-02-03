package br.com.tasklist.tasklist.service;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tasklist.tasklist.controller.request.LoginUser;
import br.com.tasklist.tasklist.entity.User;
import br.com.tasklist.tasklist.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User create(User user){
        try {
            userRepository.save(user);
            return user;    
        } catch (Exception e) {
            throw new Error("Erro ao criar usuário: " + e);
        }
    }

    public List<User> list(){
        return userRepository.findAll();
    }
    
    public User findByEmail(String email) {
        return userRepository
                .findByEmail(email)
                .orElseThrow(RuntimeException::new);
    }

    public Boolean login(final LoginUser user){
        try {
            User userAuth = findByEmail(user.email());
            if(!(user.senha() == userAuth.getSenha())){
                throw new RuntimeException();
            }

            return true;
        } catch (Exception e) {
            throw new Error("Erro ao realizar login: " + e);
        }

    }

}
