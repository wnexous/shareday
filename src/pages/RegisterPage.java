package pages;

import javax.swing.*;
import auth.Auth;
import java.awt.*;
import java.awt.event.*;
import controllers.HashController;
import data.UsersData;
import types.UserTypes;
import java.util.function.Consumer;

public class RegisterPage extends JFrame implements ActionListener {
    JTextField usernameField;
    JPasswordField passwordField;
    UsersData usersData = new UsersData();
    // private Consumer<UserTypes> onLoginSuccess;

    public RegisterPage() {

        setTitle("Registro de Usuário");
        // setTop
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Usuário:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Senha:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Cadastrar");
        loginButton.addActionListener(this);

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String passwordHash = HashController.encode(password);

        UserTypes user = usersData.getUserByUsername(username);

        if (user != null) {
            JOptionPane.showMessageDialog(null, "Usuário já cadastrado!.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }


        UserTypes newUser = new UserTypes(username, password);

        usersData.createUser(newUser);
        Auth.setUser(user);

        JOptionPane.showMessageDialog(null, "Conta criada com sucesso realizado");

        // Notifica o callback que o login foi bem-sucedido
        // onLoginSuccess.accept(user);

        // Fecha a janela de login
        this.dispose();

        
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> new RegisterPage(user -> new LoginPage(this::)));
    // }
}
