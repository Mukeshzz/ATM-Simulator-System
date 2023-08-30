package bank.management.system;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

	JButton back;
	String pin;
	
	BalanceEnquiry(String pin){
		
		this.pin=pin;
		
		setLayout(null);
		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(800, 670, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 800, 670);
		add(image);
		
		back=new JButton("BACK");
		back.setBounds(320, 388, 130, 23);
		back.addActionListener(this);
		image.add(back);
		
		Conn c=new Conn();
		int balance=0;
		try {
			ResultSet rs=  c.s.executeQuery("select * from bank where pin ='"+pin+"'");
			
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance+= Integer.parseInt(rs.getString("amount"));
				}
				else {
					balance-=Integer.parseInt(rs.getString("amount"));
				}
				
			}
		}catch(Exception e) {
				System.out.println(e);
			}
		
		JLabel text=new JLabel("Your Current Amount balance is Rs "+balance);
		text.setForeground(Color.WHITE);
		text.setBounds(150, 220, 400, 30);
		image.add(text);
		
		
		
		
		setSize(800,670);
		setLocation(240,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transaction(pin).setVisible(true);
		
	}
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}
	
}
