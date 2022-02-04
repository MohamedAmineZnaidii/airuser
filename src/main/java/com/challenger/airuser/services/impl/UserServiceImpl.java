package com.challenger.airuser.services.impl;

import com.challenger.airuser.exceptions.UserAlreadyExistException;
import com.challenger.airuser.exceptions.UserNotFoundException;
import com.challenger.airuser.models.User;
import com.challenger.airuser.repositories.UserRepository;
import com.challenger.airuser.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created By ZNAIDI :)
 */
@Service

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Save Users to database
     * @param user: user object to save on database
     * @return saved User
     * @throws UserAlreadyExistException if email address is already taken by another account
     */
    @Override
    public User save(User user) {
        if (emailExists(user.getEmail())){
            throw new UserAlreadyExistException("There is an" +
                    " account with that email address: " + user.getEmail());
        }
        return userRepository.save(user);
    }

    /**
     * find a user by his registration email address
     * @param email a String contains email address
     * @return user
     * @throws UserNotFoundException if address email dont exist in the database
     */
    @Override
    public User findUserByEmail(String email) {
        //Verify email existence
        Optional<User> user= Optional.ofNullable(userRepository.findByEmail(email));
        if (user.isEmpty()){
            //if email not found an exception is thrown
           throw new UserNotFoundException("No user found with that email address "+email);
        }
        else return userRepository.findByEmail(email);
    }

    /**
     * find a user by his id
     * @param id user id
     * @return user
     * @throws UserNotFoundException if no user is found with entered id
     */
    @Override
    public User findUserByID(Long id) {
        User user=userRepository.findById(id).orElse(null);
        if (user == null)
            throw new UserNotFoundException("No user found with that email address ");
        else return user;
    }

    /**
     * Verify if email address is already taken by another user
     * @param email a String contains email address
     * @return true if email already exists
     */
    private boolean emailExists(final String email) {
        return userRepository.findByEmail(email) != null;
    }
}
