package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class AddDetails extends JFrame implements ActionListener {

    JTextField panNumber, adhaarNumber;
    JButton next;
    JRadioButton sYes, sNo, eYes, eNo;

    JComboBox religion, category, income, occupation, education;
    String formno;

    AddDetails(String formno) {
        this.formno = formno;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel additionalDetails = new JLabel("PAGE 2: ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel rel = new JLabel("RELIGION: ");
        rel.setFont(new Font("Raleway", Font.BOLD, 20));
        rel.setBounds(100, 180, 150, 30);
        add(rel);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 180, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel cat = new JLabel("CATEGORY: ");
        cat.setFont(new Font("Raleway", Font.BOLD, 20));
        cat.setBounds(100, 230, 200, 30);
        add(cat);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 230, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel inc = new JLabel("INCOME: ");
        inc.setFont(new Font("Raleway", Font.BOLD, 20));
        inc.setBounds(100, 280, 200, 30);
        add(inc);

        String incCategory[] = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incCategory);
        income.setBounds(300, 280, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel edu = new JLabel("QUALIFICATION: ");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100, 330, 200, 30);
        add(edu);

        String eduCategory[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        education = new JComboBox(eduCategory);
        education.setBounds(300, 330, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel ocu = new JLabel("OCCUPATION: ");
        ocu.setFont(new Font("Raleway", Font.BOLD, 20));
        ocu.setBounds(100, 380, 200, 30);
        add(ocu);

        String ocuCategory[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox(ocuCategory);
        occupation.setBounds(300, 380, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel pan = new JLabel("PAN NUMBER: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 480, 200, 30);
        add(pan);

        panNumber = new JTextField();
        panNumber.setFont(new Font("Raleway", Font.BOLD, 14));
        panNumber.setBounds(300, 480, 400, 30);
        add(panNumber);

        JLabel adhaar = new JLabel("ADHAAR NUMBER: ");
        adhaar.setFont(new Font("Raleway", Font.BOLD, 20));
        adhaar.setBounds(100, 530, 200, 30);
        add(adhaar);

        adhaarNumber = new JTextField();
        adhaarNumber.setFont(new Font("Raleway", Font.BOLD, 14));
        adhaarNumber.setBounds(300, 530, 400, 30);
        add(adhaarNumber);

        JLabel senCit = new JLabel("SENIOR CITIZEN: ");
        senCit.setFont(new Font("Raleway", Font.BOLD, 20));
        senCit.setBounds(100, 580, 200, 30);
        add(senCit);

        sYes = new JRadioButton("Yes");
        sYes.setBounds(300, 580, 100, 30);
        sYes.setBackground(Color.WHITE);
        add(sYes);

        sNo = new JRadioButton("No");
        sNo.setBounds(450, 580, 100, 30);
        sNo.setBackground(Color.WHITE);
        add(sNo);

        ButtonGroup seniorCitizen = new ButtonGroup();
        seniorCitizen.add(sYes);
        seniorCitizen.add(sNo);

        JLabel exist = new JLabel("EXISTING USER: ");
        exist.setFont(new Font("Raleway", Font.BOLD, 20));
        exist.setBounds(100, 630, 200, 30);
        add(exist);

        eYes = new JRadioButton("Yes");
        eYes.setBounds(300, 630, 100, 30);
        eYes.setBackground(Color.WHITE);
        add(eYes);

        eNo = new JRadioButton("No");
        eNo.setBounds(450, 630, 100, 30);
        eNo.setBackground(Color.WHITE);
        add(eNo);

        ButtonGroup existing = new ButtonGroup();
        existing.add(eYes);
        existing.add(eNo);

        next = new JButton("NEXT");
        next.setBounds(620, 680, 80, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.addActionListener(this);
        add(next);

        setSize(850, 800);

        setTitle("NEW ACCOUNT APPLICATION - PAGE 2");

        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String sReligion = (String) religion.getSelectedItem();
        String sCategory = (String) category.getSelectedItem();
        String sIncome = (String) income.getSelectedItem();
        String sEducation = (String) education.getSelectedItem();
        String sOccupation = (String) occupation.getSelectedItem();

        String SenCitizen = null;
        if (sYes.isSelected()) {
            SenCitizen = "Yes";
        } else if (sNo.isSelected()) {
            SenCitizen = "No";
        }

        String ExistingAccount = null;
        if (eYes.isSelected()) {
            ExistingAccount = "yes";
        } else if (eNo.isSelected()) {
            ExistingAccount = "No";
        }

        String sPan = panNumber.getText();
        String sAdhaar = adhaarNumber.getText();

        try {

            Conn c = new Conn();
            String query = "insert into adddetails values ('" + formno + "', '" + sReligion + "', '" + sCategory + "', '" + sIncome + "', '" + sEducation + "', '" + sOccupation + "', '" + sPan + "', '" + sAdhaar + "', '" + SenCitizen + "', '" + ExistingAccount + "')";
            c.s.executeUpdate(query);
            setVisible(false);
            new AccType(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new AddDetails("");
    }
}
