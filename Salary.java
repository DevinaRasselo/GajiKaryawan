import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Salary {

    public static void main(String[] args) {
        // Membuat frame baru
        JFrame frame = new JFrame("Employee Salary Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Membuat panel baru
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Menampilkan jendela
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        // Membuat label dan field gaji pokok
        JLabel userLabel = new JLabel("Basic Salary:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Membuat tombol hitung
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(10, 80, 80, 25);
        panel.add(calculateButton);

        // Membuat label untuk menampilkan hasil
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(10, 120, 300, 100);
        panel.add(resultLabel);

        // Menambahkan action listener ke tombol
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double basic = Double.parseDouble(userText.getText());
                double hra = 0.10 * basic;  // 10% of basic
                double da = 0.08 * basic;   // 8% of basic
                double grossSalary = basic + hra + da;

                double tax = 0.05 * grossSalary; // 5% tax on gross salary
                double netSalary = grossSalary - tax;

                String result = "<html>Employee Salary Breakdown:<br>" +
                        "Basic: " + basic + "<br>" +
                        "HRA: " + hra + "<br>" +
                        "DA: " + da + "<br>" +
                        "Gross Salary: " + grossSalary + "<br>" +
                        "Tax Deduction: " + tax + "<br>" +
                        "Net Salary: " + netSalary + "</html>";
                resultLabel.setText(result);
            }
        });
    }
}
