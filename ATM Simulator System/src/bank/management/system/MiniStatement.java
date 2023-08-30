package bank.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;

public class MiniStatement extends JFrame implements ActionListener{
		
	MiniStatement(String pin){
		
		setTitle("Mini Statement");
		
		setLayout(null);
		
		JLabel mini=new JLabel();
		mini.setBounds(20, 130, 600, 200);
		add(mini);
		
		JLabel bank=new JLabel("Indian Bank");
		bank.setBounds(120, 30, 100, 20);
		add(bank);
		
		JLabel card=new JLabel();
		card.setBounds(20, 80, 300, 20);	
		add(card);
		
		JLabel balance=new JLabel();
		balance.setBounds(20, 350, 300, 20);
		add(balance);
		
		try {
			Conn c=new Conn();
			
			ResultSet rs=c.s.executeQuery("select * from login where pin = '"+pin+"'");
			while(rs.next()) {
				card.setText("Card Number: " +rs.getString("cardnumber").substring(0, 4)+ "XXXXXXXX" +rs.getString("cardnumber").substring(12));
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pin+"'");
			int bal=0;
			while(rs.next()) {
				mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
				if(rs.getString("type").equals("Deposit")) {
					bal+= Integer.parseInt(rs.getString("amount"));
				}
				else {
					bal-=Integer.parseInt(rs.getString("amount"));
				}
			}
			balance.setText("Your Current account balance is Rs " +bal);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		setSize(350,500);
		setLocation(20,20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
	}
	
	public static void main(String[] args) {
		new MiniStatement("");
	}
	
	
	

}
