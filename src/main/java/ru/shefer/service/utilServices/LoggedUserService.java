package ru.shefer.service.utilServices;

import org.springframework.stereotype.Service;
import ru.shefer.entity.User;
import ru.shefer.exception.UserIsNotLoggedException;

@Service
public class LoggedUserService {
    private User user;

    public void userLogIn(User user) {
        this.user = user;
    }

    public void userLogOut() {
        this.user = null;
    }

    public boolean isUserLoggedIn() {
        return user != null;
    }

    public User getLoggedUser() {
        if (user == null) {
            throw new UserIsNotLoggedException("User is not logged in");
        }
        return user;
    }
}
