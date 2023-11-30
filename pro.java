import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class pro {
    private Map<String, String> urlMap = new HashMap<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new pro().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("URL Shortener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel originalUrlLabel = new JLabel("Original URL:");
        originalUrlLabel.setBounds(10, 20, 80, 25);
        panel.add(originalUrlLabel);

        JTextField originalUrlText = new JTextField(20);
        originalUrlText.setBounds(100, 20, 250, 25);
        panel.add(originalUrlText);

        JButton shortenButton = new JButton("Shorten");
        shortenButton.setBounds(100, 50, 80, 25);
        panel.add(shortenButton);

        JLabel shortUrlLabel = new JLabel("Short URL:");
        shortUrlLabel.setBounds(10, 80, 80, 25);
        panel.add(shortUrlLabel);

        JTextField shortUrlText = new JTextField(20);
        shortUrlText.setBounds(100, 80, 250, 25);
        shortUrlText.setEditable(false);
        panel.add(shortUrlText);

        shortenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String originalUrl = originalUrlText.getText();
                if (!originalUrl.isEmpty()) {
                    String shortUrl = shortenURL(originalUrl);
                    shortUrlText.setText(shortUrl);
                }
            }
        });
    }

    private String shortenURL(String originalUrl) {
        String shortUrl = "http://short.url/" + originalUrl.hashCode();
        urlMap.put(shortUrl, originalUrl);
        return shortUrl;
    }
}
