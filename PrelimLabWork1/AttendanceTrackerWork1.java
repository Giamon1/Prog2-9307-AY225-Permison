// Import Swing components
import javax.swing.*;
import java.awt.*;

// Import for date and time
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Import for UUID (E-Signature)
import java.util.UUID;

// Import for file writing
import java.io.FileWriter;
import java.io.IOException;


public class AttendanceTrackerWork1 {

    public static void main(String[] args) {

        // Create JFrame
        JFrame frame = new JFrame("Attendance Tracker");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JPanel with layout
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Labels
        JLabel nameLabel = new JLabel("Attendance Name:");
        JLabel courseLabel = new JLabel("Course / Year:");
        JLabel timeLabel = new JLabel("Time In:");
        JLabel signatureLabel = new JLabel("E-Signature:");

        // Text fields
        JTextField nameField = new JTextField();
        JTextField courseField = new JTextField();
        JTextField timeField = new JTextField();
        JTextField signatureField = new JTextField();

        // Disable editing for auto fields (Time and Signature)
        timeField.setEditable(false);
        signatureField.setEditable(false);

        // Date & time formatter
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Get current time and date
        // Swing Timer - updates time every second
        Timer timer = new Timer(1000, e -> {
            String currentTime = LocalDateTime.now().format(formatter);
            timeField.setText(currentTime);
        });
        timer.start(); // start moving time

        // Generate E-Signature
        signatureField.setText(UUID.randomUUID().toString());

        // Submit button
        JButton submitButton = new JButton("Submit");

        // Submit action
        submitButton.addActionListener(e -> {

            // Get field values
            String name = nameField.getText();
            String course = courseField.getText();
            String timeIn = timeField.getText();
            String signature = signatureField.getText();

            // Confirmation with Save option
            int choice = JOptionPane.showConfirmDialog(
                frame,
                "Attendance Submitted!\n\n"
                + "Name: " + name + "\n"
                + "Course/Year: " + course + "\n"
                + "Time In: " + timeIn + "\n"
                + "E-Signature: " + signature + "\n\n"
                + "Do you want to save this record?",
                "Submission Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE
            );

            // If user chooses YES, save to file
            if (choice == JOptionPane.YES_OPTION) {
                try {
                    FileWriter writer = new FileWriter("attendance.txt", true);
                    writer.write("Name: " + name + "\n");
                    writer.write("Course/Year: " + course + "\n");
                    writer.write("Time In: " + timeIn + "\n");
                    writer.write("E-Signature: " + signature + "\n");
                    writer.write("----------------------------------\n");
                    writer.close();

                    JOptionPane.showMessageDialog(
                        frame,
                        "Attendance saved successfully!",
                        "Saved",
                        JOptionPane.INFORMATION_MESSAGE
                    );

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(
                        frame,
                        "Error saving attendance!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        // Add components
        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(courseLabel);
        panel.add(courseField);

        panel.add(timeLabel);
        panel.add(timeField);

        panel.add(signatureLabel);
        panel.add(signatureField);

        panel.add(new JLabel()); // Empty cell
        panel.add(submitButton);

        // Add panel to frame
        frame.add(panel);

        // Center window
        frame.setLocationRelativeTo(null);

        // Show window
        frame.setVisible(true);
    }
}
