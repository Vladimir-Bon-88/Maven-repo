package service;

import exceptions.UserAlreadyExistException;
import exceptions.UserNotExistException;
import model.User;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addToFile(User user) {
        Optional<User> userOptional = userRepository.getById(user.getId());
        if(userOptional.isPresent()){
            throw new UserAlreadyExistException("User already exist");
        }
        userRepository.addToFile(user);
    }

    @Override
    public void remove(User user) {
        Optional<User> userOptional = userRepository.getById(user.getId());
        if(userOptional.isEmpty()){
            throw new UserNotExistException("User not exist");
        }
        userRepository.remove(user);
    }

    @Override
    // TODO: Add Id information
    public User getById(int id) {
        //Optional<User> userOptional = userRepository.getById(id);
        /*if(userOptional.isEmpty()){
            throw new UserNotExistException("User not exist");
        }
        return userOptional.get();*/
        return userRepository.getById(id)
                .orElseThrow(() -> new UserNotExistException("User not exist"));
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }
}

