package cloudSecureStorage;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.List;

public class CloudStorageGUI extends JFrame {
 
	private static final long serialVersionUID = 1L;
	private JTextField fileField;
    private JButton uploadBtn, downloadBtn;

    public CloudStorageGUI() {
        setTitle("☁ Cloud Secure Storage System ☁");
        setSize(500, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JLabel title = new JLabel("Cloud Secure Storage System", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title);

        fileField = new JTextField();
        add(fileField);

        uploadBtn = new JButton("Upload File to Cloud");
        downloadBtn = new JButton("Retrieve File from Cloud");

        add(uploadBtn);
        add(downloadBtn);

        uploadBtn.addActionListener(e -> uploadFile());
        downloadBtn.addActionListener(e -> retrieveFile());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void uploadFile() {
        try {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                fileField.setText(file.getName());

                // Read file content
                String content = new String(java.nio.file.Files.readAllBytes(file.toPath()));

                // Encrypt
                String encrypted = DataEncryptor.encrypt(content);

                // Disperse
                List<String> parts = DataDisperser.splitData(encrypted, 3);

                // Store
                DatabaseManager.saveData(file.getName(), parts);

                JOptionPane.showMessageDialog(this, "✅ File uploaded securely to cloud!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void retrieveFile() {
        try {
            String filename = JOptionPane.showInputDialog(this, "Enter filename to retrieve:");
            if (filename == null || filename.isEmpty()) return;

            List<String> parts = DatabaseManager.retrieveData(filename);
            if (parts.isEmpty()) {
                JOptionPane.showMessageDialog(this, "❌ File not found in cloud!");
                return;
            }

            String joined = DataDisperser.joinData(parts);
            String decrypted = DataEncryptor.decrypt(joined);

            File outFile = new File("retrieved_" + filename);
            FileWriter writer = new FileWriter(outFile);
            writer.write(decrypted);
            writer.close();

            JOptionPane.showMessageDialog(this, "✅ File retrieved and saved as " + outFile.getName());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new CloudStorageGUI();
    }
}