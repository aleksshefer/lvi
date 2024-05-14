package ru.shefer.service.utilServices;

import ru.shefer.entity.User;
import ru.shefer.exception.UserIsNotLoggedException;


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

    public User getLoggedUser(){
        if(user==null){
            throw new UserIsNotLoggedException
        }
    }
}
