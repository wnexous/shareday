import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JTextField usernameField;
    JPasswordField passwordField;

    public Login() {
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

        // Colocar o código para autenticação

        
        if (username.equals("usuario") && password.equals("senha")) {
            JOptionPane.showMessageDialog(this, "Login realizado");
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorreta.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login());
    }
}
