//Records - Gian Carlo J. Permison 23-0322-603

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class StudentRecordSystem extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    private JTextField txtId, txtFirst, txtLast;
    private JTextField txtLab1, txtLab2, txtLab3;
    private JTextField txtPrelim, txtAttendance;

    public StudentRecordSystem() {
        setTitle("Records - Gian Carlo J. Permison - 23-0322-603");
        setSize(1100, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // ===== TABLE =====
        model = new DefaultTableModel(new String[]{
                "Student ID", "First Name", "Last Name",
                "Lab Work 1", "Lab Work 2", "Lab Work 3",
                "Prelim Exam", "Attendance Grade"
        }, 0);

        table = new JTable(model);
        table.setRowHeight(24);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // ===== FORM PANEL =====
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setPreferredSize(new Dimension(850, 200)); // 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 6, 3, 6); // 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        txtId = new JTextField();
        txtFirst = new JTextField();
        txtLast = new JTextField();
        txtLab1 = new JTextField();
        txtLab2 = new JTextField();
        txtLab3 = new JTextField();
        txtPrelim = new JTextField();
        txtAttendance = new JTextField();

        // ===== ROW 0 =====
        addField(formPanel, gbc, 0, 0, "Student ID", txtId);
        addField(formPanel, gbc, 0, 1, "First Name", txtFirst);
        addField(formPanel, gbc, 0, 2, "Last Name", txtLast);

        // ===== ROW 1 =====
        addField(formPanel, gbc, 1, 0, "Lab Work 1", txtLab1);
        addField(formPanel, gbc, 1, 1, "Lab Work 2", txtLab2);
        addField(formPanel, gbc, 1, 2, "Lab Work 3", txtLab3);

        // ===== ROW 2 =====
        addField(formPanel, gbc, 2, 0, "Prelim Exam", txtPrelim);
        addField(formPanel, gbc, 2, 1, "Attendance Grade", txtAttendance);

        // ===== BUTTONS =====
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(formPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        // 👇 CENTER the whole container
        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        wrapper.add(topPanel);
        add(wrapper, BorderLayout.NORTH);

        // ===== LOAD CSV =====
        loadCSV();

        // ===== ACTIONS =====
        btnAdd.addActionListener(e -> {
            model.addRow(new Object[]{
                    txtId.getText(),
                    txtFirst.getText(),
                    txtLast.getText(),
                    txtLab1.getText(),
                    txtLab2.getText(),
                    txtLab3.getText(),
                    txtPrelim.getText(),
                    txtAttendance.getText()
            });
            clearFields();
        });

        btnDelete.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
            }
        });
    }

    // ===== FIELD ALIGNMENT =====
    private void addField(JPanel panel, GridBagConstraints gbc,
                          int row, int col, String label, JTextField field) {

        gbc.gridx = col;
        gbc.gridy = row * 2;
        panel.add(new JLabel(label), gbc);

        gbc.gridy = row * 2 + 1;
        panel.add(field, gbc);
    }

    private void clearFields() {
        txtId.setText("");
        txtFirst.setText("");
        txtLast.setText("");
        txtLab1.setText("");
        txtLab2.setText("");
        txtLab3.setText("");
        txtPrelim.setText("");
        txtAttendance.setText("");
    }

    private void loadCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader("MOCK_DATA.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                model.addRow(line.split(","));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Could not load MOCK_DATA.csv",
                    "File Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRecordSystem().setVisible(true));
    }
}
