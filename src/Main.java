import pages.*;
import types.UserTypes;

public class Main {

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        navigateToLoginPage();
    }

    private void navigateToLoginPage() {
        new LoginPage(this::onLoginSuccess);
    }

    private void onLoginSuccess(UserTypes user) {
        navigateToTextEditorPage(user);
    }

    private void navigateToTextEditorPage(UserTypes user) {
        new TextEditorPage();
    }
}
