
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    
    JTextField aadharTextField, panTextField;
    JButton next;
    JRadioButton eyes, eno, syes, sno;
    JComboBox categories, religions, incomes, education, occupation;
    String formno;
        
    SignupTwo(String formno)
    {
       this.formno = formno;
       setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
      
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religions = new JComboBox(valReligion);
        religions.setBounds(300,140,400,30);
        religions.setBackground(Color.WHITE);
        add(religions);
        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);
        
        String valCategory[] = {"General","SC","ST","OBC","Other"};
        categories = new JComboBox(valCategory);
        categories.setBounds(300,190,400,30);
        categories.setBackground(Color.WHITE);
        add(categories);
        
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);
        
        String valIncome[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        incomes = new JComboBox(valIncome);
        incomes.setBounds(300,240,400,30);
        incomes.setBackground(Color.WHITE);
        add(incomes);
        
        
        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100,290,200,30);
        add(edu);
        
        JLabel qual = new JLabel("Qualification:");
        qual.setFont(new Font("Raleway",Font.BOLD,20));
        qual.setBounds(100,315,200,30);
        add(qual);
        
        
        String educationValues[] = {"Non-Graduation","Graduation","Post-Graduation","Doctrate","Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        JLabel occ = new JLabel("Occupation:");
        occ.setFont(new Font("Raleway",Font.BOLD,20));
        occ.setBounds(100,390,200,30);
        add(occ);
        
        
        String occupationValues[] = {"Salaried","Self-Employed","Business","Student","Retired","Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);    
        
        
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);
        
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
               
        JLabel adh = new JLabel("Aadhar Number:");
        adh.setFont(new Font("Raleway",Font.BOLD,20));
        adh.setBounds(100,490,200,30);
        add(adh);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);
        
        JLabel sen = new JLabel("Senior Citizen:");
        sen.setFont(new Font("Raleway",Font.BOLD,20));
        sen.setBounds(100,540,200,30);
        add(sen);
        
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        
        ButtonGroup grp = new ButtonGroup();
        grp.add(syes);
        grp.add(sno);
        
        
        JLabel ex = new JLabel("Existing Account:");
        ex .setFont(new Font("Raleway",Font.BOLD,20));
        ex.setBounds(100,590,200,30);
        add(ex);
        
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        
        ButtonGroup egrp = new ButtonGroup();
        egrp.add(eyes);
        egrp.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620, 660, 80, 30);
        add(next);
        next.addActionListener(this);
        
        setLayout(null);
        getContentPane().setBackground(new Color(252,208,76));
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String religion = (String)religions.getSelectedItem();
        String category = (String)categories.getSelectedItem();
        String income = (String)incomes.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()) seniorcitizen = "Yes";
        else if(sno.isSelected()) seniorcitizen = "No";
       
        
        String existingaccount = null;
        if(eyes.isSelected()) existingaccount = "Yes";
        else if(eno.isSelected()) existingaccount = "no";
        
        
        String span = panTextField.getText();
        String sadhar = aadharTextField.getText();
       
        
        try{
            //validation
            if(sadhar.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Aadhar no. is required!");
            }
            //you can add more validations
            else{
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+sadhar+"', '"+seniorcitizen+"', '"+existingaccount+"');";
                c.s.executeUpdate(query);
                
                //signupThree
                setVisible(false);
                new SignupThree(formno);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
