package com.challenger.airuser.services;

import com.challenger.airuser.models.User;
import org.springframework.stereotype.Service;

/**
 * Created By ZNAIDI :)
 */
@Service
public interface UserService {
        User save (User user);
        User findUserByEmail (String email);
        User findUserByID(Long id);
}
