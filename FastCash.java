package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton b100, b500, b1000, b2000, b5000, b10000, back;
    String pinnumber;

    FastCash(String pinnumber) {

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Select Amount to Withraw: ");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        b100 = new JButton("Rs. 100");
        b100.setBounds(170, 415, 150, 30);
        b100.addActionListener(this);
        image.add(b100);

        b500 = new JButton("Rs. 500");
        b500.setBounds(355, 415, 150, 30);
        b500.addActionListener(this);
        image.add(b500);

        b1000 = new JButton("Rs. 1000");
        b1000.setBounds(170, 450, 150, 30);
        b1000.addActionListener(this);
        image.add(b1000);

        b2000 = new JButton("Rs. 2000");
        b2000.setBounds(355, 450, 150, 30);
        b2000.addActionListener(this);
        image.add(b2000);

        b5000 = new JButton("Rs. 5000");
        b5000.setBounds(170, 485, 150, 30);
        b5000.addActionListener(this);
        image.add(b5000);

        b10000 = new JButton("Rs. 10000");
        b10000.setBounds(355, 485, 150, 30);
        b10000.addActionListener(this);
        image.add(b10000);

        back = new JButton("Back");
        back.setBounds(262, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setLocation(300, 0);
        setSize(900, 900);

        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amountText = ((JButton) ae.getSource()).getText().substring(4);
            int amount = Integer.parseInt(amountText);

            Conn conn = new Conn();
            try {
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (balance < amount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance !!");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values ('" + pinnumber + "', '" + date + "', 'Withdrawal', '" + amount + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " withdrawn successfully !!");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
