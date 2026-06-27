import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalculator extends JFrame {
    
    private JTextField subject1Field, subject2Field, subject3Field, subject4Field, subject5Field;
    private JLabel totalLabel, percentageLabel, gradeLabel, gpaLabel;
    private JButton calculateBtn, clearBtn;
    
    public GradeCalculator() {
        setTitle("Student Grade Calculator - By Mala");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(245, 247, 250));
        
        // Title
        JLabel titleLabel = new JLabel("GRADE CALCULATOR", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(new Color(30, 64, 175));
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        
        // Input Panel - 5 Subjects
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 12));
        inputPanel.setBackground(new Color(245, 247, 250));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Marks Out of 100"));
        
        inputPanel.add(new JLabel("Subject 1:"));
        subject1Field = new JTextField();
        inputPanel.add(subject1Field);
        
        inputPanel.add(new JLabel("Subject 2:"));
        subject2Field = new JTextField();
        inputPanel.add(subject2Field);
        
        inputPanel.add(new JLabel("Subject 3:"));
        subject3Field = new JTextField();
        inputPanel.add(subject3Field);
        
        inputPanel.add(new JLabel("Subject 4:"));
        subject4Field = new JTextField();
        inputPanel.add(subject4Field);
        
        inputPanel.add(new JLabel("Subject 5:"));
        subject5Field = new JTextField();
        inputPanel.add(subject5Field);
        
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        
        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(245, 247, 250));
        
        calculateBtn = new JButton("Calculate Result");
        calculateBtn.setBackground(new Color(34, 197, 94));
        calculateBtn.setForeground(Color.WHITE);
        calculateBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        calculateBtn.setPreferredSize(new Dimension(160, 40));
        buttonPanel.add(calculateBtn);
        
        clearBtn = new JButton("Clear All");
        clearBtn.setBackground(new Color(107, 114, 128));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        clearBtn.setPreferredSize(new Dimension(120, 40));
        buttonPanel.add(clearBtn);
        
        // Result Panel
        JPanel resultPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        resultPanel.setBackground(Color.WHITE);
        resultPanel.setBorder(BorderFactory.createTitledBorder("Result"));
        
        resultPanel.add(new JLabel("Total Marks:"));
        totalLabel = new JLabel("0 / 500");
        totalLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        resultPanel.add(totalLabel);
        
        resultPanel.add(new JLabel("Percentage:"));
        percentageLabel = new JLabel("0.00%");
        percentageLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        resultPanel.add(percentageLabel);
        
        resultPanel.add(new JLabel("Grade:"));
        gradeLabel = new JLabel("-");
        gradeLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        resultPanel.add(gradeLabel);
        
        resultPanel.add(new JLabel("GPA:"));
        gpaLabel = new JLabel("0.00");
        gpaLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        resultPanel.add(gpaLabel);
        
        // South Panel to hold buttons + results
        JPanel southPanel = new JPanel(new BorderLayout(10, 10));
        southPanel.setBackground(new Color(245, 247, 250));
        southPanel.add(buttonPanel, BorderLayout.NORTH);
        southPanel.add(resultPanel, BorderLayout.CENTER);
        
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        
        // Button Actions
        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult();
            }
        });
        
        clearBtn.addActionListener(e -> clearFields());
        
        add(mainPanel);
    }
    
    private void calculateResult() {
        try {
            double s1 = Double.parseDouble(subject1Field.getText());
            double s2 = Double.parseDouble(subject2Field.getText());
            double s3 = Double.parseDouble(subject3Field.getText());
            double s4 = Double.parseDouble(subject4Field.getText());
            double s5 = Double.parseDouble(subject5Field.getText());
            
            // Validation: marks 0-100 ke beech
            if (s1 < 0 || s1 > 100 || s2 < 0 || s2 > 100 || s3 < 0 || s3 > 100 || 
                s4 < 0 || s4 > 100 || s5 < 0 || s5 > 100) {
                JOptionPane.showMessageDialog(this, "Marks should be between 0 and 100 only!");
                return;
            }
            
            double total = s1 + s2 + s3 + s4 + s5;
            double percentage = (total / 500) * 100;
            
            totalLabel.setText(String.format("%.0f / 500", total));
            percentageLabel.setText(String.format("%.2f%%", percentage));
            
            // Grade + GPA Logic
            String grade;
            double gpa;
            Color gradeColor;
            
            if (percentage >= 90) {
                grade = "A+"; gpa = 4.0; gradeColor = new Color(21, 128, 61);
            } else if (percentage >= 80) {
                grade = "A"; gpa = 4.0; gradeColor = new Color(34, 197, 94);
            } else if (percentage >= 70) {
                grade = "B"; gpa = 3.0; gradeColor = new Color(59, 130, 246);
            } else if (percentage >= 60) {
                grade = "C"; gpa = 2.0; gradeColor = new Color(249, 115, 22);
            } else if (percentage >= 50) {
                grade = "D"; gpa = 1.0; gradeColor = new Color(234, 179, 8);
            } else {
                grade = "F - Fail"; gpa = 0.0; gradeColor = new Color(239, 68, 68);
            }
            
            gradeLabel.setText(grade);
            gradeLabel.setForeground(gradeColor);
            gpaLabel.setText(String.format("%.2f", gpa));
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers in all fields!");
        }
    }
    
    private void clearFields() {
        subject1Field.setText("");
        subject2Field.setText("");
        subject3Field.setText("");
        subject4Field.setText("");
        subject5Field.setText("");
        totalLabel.setText("0 / 500");
        percentageLabel.setText("0.00%");
        gradeLabel.setText("-");
        gradeLabel.setForeground(Color.BLACK);
        gpaLabel.setText("0.00");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GradeCalculator().setVisible(true);
        });
    }
}