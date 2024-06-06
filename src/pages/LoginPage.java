package pages;

import javax.swing.*;

import auth.Auth;

import java.awt.*;
import java.awt.event.*;
import controllers.HashController;
import data.UsersData;
import types.UserTypes;

public class LoginPage extends JFrame implements ActionListener {
    JTextField usernameField;
    JPasswordField passwordField;

    UsersData usersData = new UsersData();

    public LoginPage() {
        setTitle("Login de Usuário");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Usuário:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Senha:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
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

        if (user == null) {
            JOptionPane.showMessageDialog(null, "Usuário incorreto.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println(passwordHash);
        System.out.println(user.getPassword());

        if (!(passwordHash.equals(user.getPassword()))) {
            JOptionPane.showMessageDialog(null, "Senha incorreta.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Auth.setUser(user);
        JOptionPane.showMessageDialog(null, "Login realizado");

        // Colocar o código para autenticação

        // String usersData =
        // "C:\\Users\\nicol\\Documents\\Projetos\\Java\\RA2\\projfinal_update\\shareday\\src\\data\\UsersData.txt";
        // String linha = "";
        // String separador = ";";

        // try (BufferedReader br = new BufferedReader(new FileReader(usersData))) {
        // boolean encontrou = false;
        // while((linha = br.readLine()) != null) {
        // String[] campos = linha.split(separador);

        // String usuario = campos[0];
        // String senha = campos[1];

        // if (username.equals(usuario) && HashController.verify(senha, password)) {
        // JOptionPane.showMessageDialog(null, "Login realizado");
        // encontrou = true;
        // break;
        // }
        // }
        // if (!encontrou) {
        // JOptionPane.showMessageDialog(null, "Usuário ou senha incorreta.", "Erro",
        // JOptionPane.ERROR_MESSAGE);
        // }
        // } catch (IOException ioe){
        // System.out.println(ioe.getMessage());
        // }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage());
    }
}