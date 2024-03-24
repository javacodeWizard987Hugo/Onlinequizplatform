package quizplatform;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.SystemColor; // Add this import statement

public class online_quiz_platform extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField balance;
    private JTextField withdrawField;
    private JTextField transactionField;
    private JTextField depositField;
    private bankaccount account;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    online_quiz_platform frame = new online_quiz_platform();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public class bankaccount {
        private int balance;
        private int previousTransaction;
        private String customerName;
        private String customerId;

        public bankaccount(String customerName, String customerId) {
            this.customerName = customerName;
            this.customerId = customerId;
        }

        public void deposit(int amount) {
            if (amount > 0) {
                balance += amount;
                previousTransaction = amount;
            }
        }

        public void withdraw(int amount) {
            if (amount > 0) {
                balance -= amount;
                previousTransaction = -amount;
            }
        }

        public int getBalance() {
            return balance;
        }

        public int getPreviousTransaction() {
            return previousTransaction;
        }
    }
    public online_quiz_platform() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 720, 490);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.textHighlight);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Online_Quiz_Platform_System");
        lblNewLabel.setForeground(new Color(224, 255, 255));
        lblNewLabel.setBackground(new Color(224, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
        lblNewLabel.setBounds(146, 25, 394, 110);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Balance");
        lblNewLabel_1.setForeground(Color.BLACK);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1.setBounds(3, 149, 106, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Withdraw amount");
        lblNewLabel_2.setForeground(Color.BLACK);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_2.setBounds(3, 219, 122, 14);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Previous Transaction");
        lblNewLabel_3.setForeground(Color.BLACK);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_3.setBounds(263, 151, 153, 14);
        contentPane.add(lblNewLabel_3);

        JLabel depositLabel = new JLabel("Deposit amount");
        depositLabel.setForeground(Color.BLACK);
        depositLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        depositLabel.setBounds(266, 219, 141, 14);
        contentPane.add(depositLabel);

        balance = new JTextField();
        balance.setBackground(new Color(224, 255, 255));
        balance.setBounds(146, 146, 86, 20);
        contentPane.add(balance);
        balance.setColumns(10);

        withdrawField = new JTextField();
        withdrawField.setBackground(new Color(224, 255, 255));
        withdrawField.setBounds(146, 216, 86, 20);
        contentPane.add(withdrawField);
        withdrawField.setColumns(10);

        transactionField = new JTextField();
        transactionField.setBackground(new Color(224, 255, 255));
        transactionField.setBounds(454, 156, 86, 20);
        contentPane.add(transactionField);
        transactionField.setColumns(10);

        depositField = new JTextField();
        depositField.setBackground(new Color(224, 255, 255));
        depositField.setBounds(454, 216, 86, 20);
        contentPane.add(depositField);
        depositField.setColumns(10);

        JButton checkBalanceBtn = new JButton("Check Balance");
        checkBalanceBtn.setBackground(Color.ORANGE);
        checkBalanceBtn.setForeground(new Color(0, 128, 255));
        checkBalanceBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                balance.setText(Integer.toString(account.getBalance()));
            }
        });
        checkBalanceBtn.setBounds(10, 284, 182, 23);
        contentPane.add(checkBalanceBtn);

        JButton withdrawalBtn = new JButton("Withdraw");
        withdrawalBtn.setBackground(Color.ORANGE);
        withdrawalBtn.setForeground(new Color(0, 128, 255));
        withdrawalBtn.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
            	// Check if withdrawField is empty
                if (withdrawField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a withdraw amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method
                }
                
                int withdrawAmount = Integer.parseInt(withdrawField.getText());
                account.withdraw(withdrawAmount);
                balance.setText(Integer.toString(account.getBalance()));
                transactionField.setText(Integer.toString(account.getPreviousTransaction()));
            }
        });
        withdrawalBtn.setBounds(10, 318, 182, 23);
        contentPane.add(withdrawalBtn);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBackground(Color.ORANGE);
        depositBtn.setForeground(new Color(0, 128, 255));
        depositBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 // Check if depositField is empty
                if (depositField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a deposit amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method
            }
                int depositAmount = Integer.parseInt(depositField.getText());
                account.deposit(depositAmount);
                balance.setText(Integer.toString(account.getBalance()));
                transactionField.setText(Integer.toString(account.getPreviousTransaction()));
            }
        });
        depositBtn.setBounds(10, 352, 182, 23);
        contentPane.add(depositBtn);

        JButton transactionsBtn = new JButton("Previous Transaction");
        transactionsBtn.setBackground(Color.ORANGE);
        transactionsBtn.setForeground(new Color(0, 128, 255));
        transactionsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                transactionField.setText(Integer.toString(account.getPreviousTransaction()));
            }
        });
        transactionsBtn.setBounds(10, 386, 182, 23);
        contentPane.add(transactionsBtn);

        JButton exitBtn = new JButton("Exit");
        exitBtn.setBackground(Color.ORANGE);
        exitBtn.setForeground(new Color(0, 128, 255));
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 // Clear text fields
                balance.setText("");
                withdrawField.setText("");
                transactionField.setText("");
                depositField.setText("");
                JOptionPane.showMessageDialog(null, "Thank you for choosing Bank of Ceylon", "Exit Message", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
               
            }
        });
        exitBtn.setBounds(10, 417, 182, 23);
        contentPane.add(exitBtn);

        // Initialize bank account
        account = new bankaccount("Gimhani", "0055");
    }
}

