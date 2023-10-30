package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignUp extends JFrame implements ActionListener {
    
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser datechooser;
    
    SignUp() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 40));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personalDetails = new JLabel("PAGE 1: PERSONAL DETAILS");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);
        
        JLabel name = new JLabel("NAME: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 180, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 180, 400, 30);
        add(nameTextField);
        
        JLabel fname = new JLabel("FATHER'S NAME: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 230, 200, 30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 230, 400, 30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("DATE OF BIRTH: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 280, 200, 30);
        add(dob);
        
        datechooser = new JDateChooser();
        datechooser.setBounds(300, 280, 400, 30);
        datechooser.setFont(new Font("Raleway", Font.BOLD, 14));
        datechooser.setForeground(Color.BLACK);
        add(datechooser);
        
        JLabel gender = new JLabel("GENDER: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 330, 200, 30);
        add(gender);
        
        male = new JRadioButton("MALE");
        male.setBounds(300, 330, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("FEMALE");
        female.setBounds(450, 330, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("EMAIL: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 380, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 380, 400, 30);
        add(emailTextField);
        
        JLabel marital = new JLabel("MARITAL STATUS: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 430, 200, 30);
        add(marital);
        
        married = new JRadioButton("MARRIED");
        married.setBounds(300, 430, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBounds(450, 430, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("OTHER");
        other.setBounds(600, 430, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalstatus = new ButtonGroup();
        maritalstatus.add(married);
        maritalstatus.add(unmarried);
        maritalstatus.add(other);
        
        JLabel address = new JLabel("ADDRESS: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 480, 200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 480, 400, 30);
        add(addressTextField);
        
        JLabel city = new JLabel("CITY: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 530, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 530, 400, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("STATE: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 580, 200, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 580, 400, 30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("PINCODE: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 630, 200, 30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 630, 400, 30);
        add(pincodeTextField);
        
        next = new JButton("NEXT");
        next.setBounds(620, 680, 80, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.addActionListener(this);
        add(next);
        
        setSize(850, 800);
        
        setTitle("REGISTER");
        
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        
        String email = emailTextField.getText();
        
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();
        
        try {
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values ('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pin + "')";
                c.s.executeUpdate(query);
                                setVisible(false);
                new AddDetails(formno).setVisible(true);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args) {
        new SignUp();
    }
}
