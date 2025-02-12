
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    String pinnumber;
    
    MiniStatement(String pinnumber)
    {
        this.pinnumber = pinnumber;
        
        JLabel mini = new JLabel();
        add(mini);
        mini.setBounds(20,140,400,200);
        
        JLabel bank = new JLabel("BANK OF BHARAT");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login  where pin = '"+pinnumber+"'");
            while(rs.next())
            {
                card.setText("Card Number: "+ rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+ rs.getString("cardnumber").substring(12));
            }           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank  where pin = '"+pinnumber+"'");
            while(rs.next())
            {
                mini.setText(mini.getText()+ "<html>"+ rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        int bal = 0;
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");          
            while(rs.next())
            {
                if(rs.getString("type").equals("deposit"))
                {
                    bal += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs "+bal);
        }catch(Exception e)
        {
                System.out.println(e);
        }
                
        setLayout(null);
        setTitle("MINI STATEMENT");
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(new Color(222,255,228));
        setVisible(true);
        
        
    }

}
