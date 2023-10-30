package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class AccType extends JFrame implements ActionListener {

    JRadioButton t1, t2, t3, t4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    AccType(String formo) {
        this.formno = formno;

        setLayout(null);

        JLabel l1 = new JLabel("PAGE 3: ACCOUNT TYPE");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(240, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("ACCOUNT TYPE");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        t1 = new JRadioButton("Saving Account");
        t1.setFont(new Font("Raleway", Font.BOLD, 16));
        t1.setBounds(100, 180, 250, 40);
        t1.setBackground(Color.WHITE);
        add(t1);

        t2 = new JRadioButton("Fixed Deposit Account");
        t2.setFont(new Font("Raleway", Font.BOLD, 16));
        t2.setBounds(350, 220, 250, 40);
        t2.setBackground(Color.WHITE);
        add(t2);

        t3 = new JRadioButton("Current Account");
        t3.setFont(new Font("Raleway", Font.BOLD, 16));
        t3.setBounds(100, 220, 250, 40);
        t3.setBackground(Color.WHITE);
        add(t3);

        t4 = new JRadioButton("Recurring Deposit Account");
        t4.setFont(new Font("Raleway", Font.BOLD, 16));
        t4.setBounds(350, 180, 250, 40);
        t4.setBackground(Color.WHITE);
        add(t4);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(t1);
        groupAccount.add(t2);
        groupAccount.add(t3);
        groupAccount.add(t4);

        JLabel card = new JLabel("CARD NUMBER:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel cardDetail = new JLabel("Your 16-Digit Card Number");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetail.setBounds(100, 330, 300, 20);
        add(cardDetail);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4148");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel cardPin = new JLabel("PIN:");
        cardPin.setFont(new Font("Raleway", Font.BOLD, 22));
        cardPin.setBounds(100, 370, 200, 30);
        add(cardPin);

        JLabel cardPinNumber = new JLabel("XXXX");
        cardPinNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        cardPinNumber.setBounds(330, 370, 300, 30);
        add(cardPinNumber);

        JLabel pinDetail = new JLabel("Your 4-Digit Pin Number");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetail.setBounds(100, 400, 300, 20);
        add(pinDetail);

        JLabel services = new JLabel("SERVICES REQUIRED:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 400, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        c1.setBackground(Color.WHITE);
        add(c1);

        c2 = new JCheckBox("INTERNET BANKING");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        c2.setBackground(Color.WHITE);
        add(c2);

        c3 = new JCheckBox("MOBILE BANKING");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        c3.setBackground(Color.WHITE);
        add(c3);

        c4 = new JCheckBox("EMAIL & SMS ALERTS");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        c4.setBackground(Color.WHITE);
        add(c4);

        c5 = new JCheckBox("CHEQUE BOOK");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        c5.setBackground(Color.WHITE);
        add(c5);

        c6 = new JCheckBox("E-STATEMENT");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        c6.setBackground(Color.WHITE);
        add(c6);

        c7 = new JCheckBox("I hereby declare the the above enetred details are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 680, 600, 30);
        c7.setBackground(Color.WHITE);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        setSize(850, 800);

        setTitle("ACCOUNT TYPE - PAGE 3");
        getContentPane().setBackground(Color.WHITE);
        setLocation(350, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {

            String sAccountType = null;
            if (t1.isSelected()) {
                sAccountType = "Saving Account";
            } else if (t2.isSelected()) {
                sAccountType = "Fixed Deposit Account";
            } else if (t3.isSelected()) {
                sAccountType = "Current Account";
            } else if (t4.isSelected()) {
                sAccountType = "Reccuring Deposit Account";
            }
            Random random = new Random();

            String cardno = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pinno = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (c1.isSelected()) {
                facility = facility + " ATM CARD";
            } else if (c2.isSelected()) {
                facility = facility + " INTERNET BANKING";
            } else if (c3.isSelected()) {
                facility = facility = " MOBILE BANKING";
            } else if (c4.isSelected()) {
                facility = facility + " SMS & EMAIL ALERTS";
            } else if (c5.isSelected()) {
                facility = facility + " CHEQUE BOOK";
            } else if (c6.isSelected()) {
                facility = facility + " E-STATEMENT";
            }

            try {
                if (sAccountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into acctype values ('" + formno + "', '" + sAccountType + "', '" + cardno + "', '" + pinno + "', '" + facility + "')";
                    String query2 = "insert into login values ('" + formno + "', '" + cardno + "', '" + pinno + "')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin: " + pinno);
                    setVisible(false);
                    new Deposit(pinno).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AccType("");
    }
}
