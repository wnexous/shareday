package auth;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import types.UserTypes;

/**
 * Auth: saves the current user session
 */
public class Auth {

    static private UserTypes user = getState().getUser();

    static public void setUser(UserTypes u) {

        user = u;
        try {
            saveState();
        } catch (Exception e) {
            System.out.println("erro ao salvar estado de login");
        }
    }

    static public boolean isAuthed() {
        return user != null;
    }

    static public UserTypes getUser() {
        return user;
    }

    static private void saveState() throws IOException {
        try (FileOutputStream fos = new FileOutputStream("login.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(Auth.class);
        }
    }

    static private Auth getState() {

        try {
            try (FileInputStream fis = new FileInputStream("login.dat");
                    ObjectInputStream ois = new ObjectInputStream(fis)) {

                Auth auth = (Auth) ois.readObject();
                System.out.println("LAST STATE");
                System.out.println(auth);
                return auth;
            }
        } catch (Exception e) {

            System.out.println("err"+ e.getMessage());
            return null;
        }
    }
}