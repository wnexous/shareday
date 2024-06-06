package auth;

import types.UserTypes;

/**
 * Auth: saves the current user session
 */
public abstract class Auth {

    static private UserTypes user;

    static public void setUser(UserTypes u) {
        user = u;
    }

    static public boolean isAuthed() {
        return user != null;
    }

    static public UserTypes getUser() {
        return user;
    }

}