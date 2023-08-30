package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	 JButton login, clear, signup;
	 JTextField cardtext;
	 JPasswordField pintext;
	 
	 Login(){
		setTitle("AUTOMATED TELLER MACHINE");
		
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel label=new JLabel(i3);
		label.setBounds(70, 10, 100, 100);
		add(label);
		
		JLabel text=new JLabel("Welcome To ATM");
		text.setFont(new Font("Osward", Font.BOLD, 38));
		text.setBounds(250, 40, 400, 40);
		add(text);
		
		JLabel cardno=new JLabel("Card No.");
		cardno.setFont(new Font("Raleway", Font.BOLD, 28));
		cardno.setBounds(120, 150, 150, 30);
		add(cardno);
		
		cardtext=new JTextField();
		cardtext.setBounds(300, 150, 230, 30);
		cardtext.setFont(new Font("Arial", Font.BOLD, 14));
		add(cardtext); 
		
		JLabel pin=new JLabel("Pin");
		pin.setFont(new Font("Raleway", Font.BOLD, 28));
		pin.setBounds(120, 220, 200, 30);
		add(pin);
		
		pintext=new JPasswordField();
		pintext.setBounds(300, 220, 230, 30);
		cardtext.setFont(new Font("Arial", Font.BOLD, 14));
		add(pintext); 
		
		login=new JButton("SIGN IN");
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		clear=new JButton("CLEAR");
		clear.setBounds(430, 300, 100, 30);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signup=new JButton("SIGNUP");
		signup.setBounds(300, 350, 230, 30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,480);
		setVisible(true);
		setLocation(250,100);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == clear) {
			cardtext.setText("");
			pintext.setText("");
		}
		else if(ae.getSource() == login) {
			Conn c=new Conn();
			String cardnumber=cardtext.getText();
			String pin=pintext.getText();
			try {
						
			String query="select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pin+"'";
			
			
			ResultSet rs=c.s.executeQuery(query);	
			if(rs.next()) {
				setVisible(false);
				new Transaction(pin).setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "Incorrect Card No. or Pin");
			}
					
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}
		else if(ae.getSource() == signup) {
			setVisible(false);
			new Signup1().setVisible(true);
			
		}
		 
	}
	
	public static void main(String[] args) {
		new Login();
		
	}

}
