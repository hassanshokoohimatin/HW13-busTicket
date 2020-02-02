package ir.sunsor.repositories;

import ir.sunsor.config.CrudRepository;
import ir.sunsor.entities.User;

import java.util.stream.Collectors;

public class UserRepository extends CrudRepository<User , Long> {

    private static UserRepository userRepository;

    private UserRepository(){}

    public static UserRepository getInstance(){
        if (userRepository == null)
            userRepository = new UserRepository();
        return userRepository;
    }

    public User findByUsername(String username){
        User user = userRepository.findAll().stream().filter(u->u.getUsername().equals(username))
                .collect(Collectors.toList()).get(0);
        return user;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
