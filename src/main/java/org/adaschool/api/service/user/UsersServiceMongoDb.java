package org.adaschool.api.service.user;

import org.adaschool.api.repository.user.User;
import org.adaschool.api.repository.user.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceMongoDb implements UsersService {

    private final UserMongoRepository userMongoRepository;

    @Autowired
    public UsersServiceMongoDb(UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    @Override
    public User save(User user) {
        userMongoRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> findById(String id) {
        Optional<User> user =userMongoRepository.findById(id);
        if (user.isPresent()){

            return user;
        }else {
            return Optional.empty();
        }
    }

    @Override
    public List<User> all() {
        return userMongoRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        userMongoRepository.deleteById(id);
    }

    @Override
    public User update(User user, String userId) {
        //TODO implement this method
        return null;
    }
}
