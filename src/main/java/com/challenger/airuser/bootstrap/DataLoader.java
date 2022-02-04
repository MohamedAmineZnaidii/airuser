package com.challenger.airuser.bootstrap;

import com.challenger.airuser.models.User;
import com.challenger.airuser.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;


/**
 * Created By ZNAIDI :)
 */


@Component
public class DataLoader implements CommandLineRunner {

    private final UserService userService;

    public DataLoader(UserService userService) {
        this.userService = userService;
    }

    /**
     * Load created Random user in database when application runs
     * @param args args
     */
    @Override
    public void run(String... args) {
        User user = createRandomUser();
        userService.save(user);
    }

    /**
     * Create a random user
     * @return user
     */
    private User createRandomUser()  {
        final String birthDateString="2000-01-01";
        LocalDate birthdate = LocalDate.parse(birthDateString);
        User user=new User();
        user.setEmail("test@test.com");
        user.setFirstName("firstNameTest");
        user.setLastName("lastNameTest");
        user.setPassword("HelloPass");
        user.setBirthDate(birthdate);
        user.setCity("Antibes");
        user.setStreet("The Wonderful street");
        user.setCountry("France");
        return user;
    }
}
