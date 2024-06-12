import auth.Auth;
import pages.*;
import types.UserTypes;

/**
 * LOGIN DE TESTE
 * usuario: teste
 * senha: teste
 */

public class Main {

        public static void main(String[] args) {
                new Main().start();

                // System.out.println(Auth.getUser().getUsername());
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
