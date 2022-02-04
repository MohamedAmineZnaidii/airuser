package com.challenger.airuser.repositories;

import com.challenger.airuser.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created By ZNAIDI :)
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    /**
     * Search for User in database by his email address
     * @param email email adress
     * @return user
     */
    User findByEmail(String email);

    /**
     * Search for User in database by his id
     * @param id user's id
     * @return Optional of user
     */
    Optional<User> findById(Long id);
}
