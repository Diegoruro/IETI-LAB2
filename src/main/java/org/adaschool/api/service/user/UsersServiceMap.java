package org.adaschool.api.service.user;

import org.adaschool.api.exception.UserNotFoundException;
import org.adaschool.api.repository.user.User;
import org.adaschool.api.repository.user.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceMap implements UsersService {

    private HashMap<String, User> db = new HashMap<>();

    @Override
    public User save(User user) {
        return db.put(user.getId(),user);
    }

    @Override
    public Optional<User> findById(String id) {
        User user = db.get(id);
        if (user == null){
            return Optional.empty();
        }else {
            return Optional.of(user);
        }
    }

    @Override
    public List<User> all() {
        return new ArrayList<User>(db.values());
    }

    @Override
    public void deleteById(String id) {
        try {
            db.remove(id);
        }catch (Exception e){
            throw new UserNotFoundException(e.getMessage());
        }
    }

    @Override
    public User update(UserDto user, String userId) {
        try {
            User actualUser =db.get(userId);
            actualUser.update(user);
            return actualUser;
        }catch (Exception e){
            throw new UserNotFoundException(e.getMessage());
        }
    }
}
