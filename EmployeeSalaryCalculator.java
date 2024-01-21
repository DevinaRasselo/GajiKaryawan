import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Employee {
    private Double netSalary;

    public Employee(Double salary){
        this.netSalary = null;
    }

    public void setSalary(Double salary){
        this.netSalary = salary;
    }

    public double getSalary(){
        return netSalary;
    }
}



public class EmployeeSalaryCalculator extends JFrame {
    List<Employee> employeeList = new ArrayList<>();
    private JTextField userText;
    private JLabel resultLabel;

    public EmployeeSalaryCalculator() {
        setTitle("Employee Salary Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel userLabel = new JLabel("Basic Salary:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(10, 80, 100, 25);
        panel.add(calculateButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(10, 120, 300, 120);
        panel.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                try {
                    calculateSalary();
                } catch (Exception er) {
                    resultLabel.setText("Wrong input");
                }
            }
        });
    }

    private void calculateSalary() {
       

        Employee employee = new Employee(null);
        double basic = Double.parseDouble(userText.getText());
        double hra = 0.10 * basic;  // 10% of basic
        double da = 0.08 * basic;   // 8% of basic
        double grossSalary = basic + hra + da;

        double tax = 0.05 * grossSalary; // 5% tax on gross salary
        double netSalary = grossSalary - tax;

        employee.setSalary(netSalary);
        employeeList.add(employee);

        String result = "<html>Employee Salary Breakdown:<br>" +
                "Basic: " + basic + "<br>" +
                "HRA: " + hra + "<br>" +
                "DA: " + da + "<br>" +
                "Gross Salary: " + grossSalary + "<br>" +
                "Tax Deduction: " + tax + "<br>" +
                "Net Salary: " + netSalary + "</html>";

        System.out.println(employeeList);
        resultLabel.setText(result);
    }

    public static void main(String[] args) {
        new EmployeeSalaryCalculator();
    }
}
