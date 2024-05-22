import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Index extends JFrame implements ActionListener {
    JTextArea textArea;
    JFileChooser fileChooser;

    public Index() {
        setTitle("Editor de Texto");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        createMenuBar();

        fileChooser = new JFileChooser();

        setVisible(true);
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("Arquivo");
        JMenuItem newMenuItem = new JMenuItem("Novo");
        JMenuItem openMenuItem = new JMenuItem("Abrir");
        JMenuItem saveMenuItem = new JMenuItem("Salvar");
        JMenuItem exitMenuItem = new JMenuItem("Sair");

        newMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Novo":
                newFile();
                break;
            case "Abrir":
                openFile();
                break;
            case "Salvar":
                saveFile();
                break;
            case "Sair":
                System.exit(0);
                break;
        }
    }

    private void newFile() {
        textArea.setText("");
    }

    private void openFile() {
        int returnValue = fileChooser.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.read(reader, null);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao abrir arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveFile() {
        int returnValue = fileChooser.showSaveDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                textArea.write(writer);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {    
        SwingUtilities.invokeLater(() -> new Index());
    }
}
