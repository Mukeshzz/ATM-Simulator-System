package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Signup3 extends JFrame implements ActionListener {
	
	JRadioButton  r1,r2,r3,r4;
	JCheckBox j1,j2,j3,j4,j5,j6,declaration;
	JButton submit,cancel;
	String formno;
	
	
	Signup3(String formno){
		this.formno=formno;
		
		setLayout(null);
		
		JLabel l1=new JLabel("Page 3:Account Details");
		l1.setFont(new Font("Raleway", Font.BOLD,18));
		l1.setBounds(290, 80, 300, 30);
		add(l1);
		
		JLabel type=new JLabel("Account Type");
		type.setFont(new Font("Raleway", Font.BOLD,20));
		type.setBounds(100, 120, 140, 30);
		add(type);
		
		r1=new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway", Font.BOLD,14));
		r1.setBounds(100, 160, 140, 20);
		r1.setBackground(Color.WHITE);
		add(r1);
		
		r2=new JRadioButton("Current Account");
		r2.setFont(new Font("Raleway", Font.BOLD,14));
		r2.setBounds(400, 160, 140, 20);
		r2.setBackground(Color.WHITE);
		add(r2);
		
		r3=new JRadioButton("Recurring Deposit Account");
		r3.setFont(new Font("Raleway", Font.BOLD,14));
		r3.setBounds(100, 190, 220, 20);
		r3.setBackground(Color.WHITE);
		add(r3);
		
		r4=new JRadioButton("Fixed Deposit Account");
		r4.setFont(new Font("Raleway", Font.BOLD,14));
		r4.setBounds(400, 190, 190, 20);
		r4.setBackground(Color.WHITE);
		add(r4);
		
		ButtonGroup groupaccount=new ButtonGroup();
		groupaccount.add(r1);
		groupaccount.add(r2);
		groupaccount.add(r3);
		groupaccount.add(r4);
		
		JLabel card=new JLabel("Card Number");
		card.setFont(new Font("Raleway", Font.BOLD,20));
		card.setBounds(100, 230, 150, 30);
		add(card);
		JLabel l2=new JLabel("Your 16 digit card number");
		l2.setFont(new Font("Raleway", Font.BOLD,12));
		l2.setBounds(100, 250, 160, 30);
		add(l2);		
		
		JLabel num=new JLabel("XXXX-XXXX-XXXX-2963");
		num.setFont(new Font("Raleway", Font.BOLD,20));
		num.setBounds(400, 230, 230, 30);
		add(num);
		
		JLabel pin=new JLabel("PIN");
		pin.setFont(new Font("Raleway", Font.BOLD,20));
		pin.setBounds(100, 290, 150, 30);
		add(pin);
		JLabel l3=new JLabel("Your 4 digit password");
		l3.setFont(new Font("Raleway", Font.BOLD,12));
		l3.setBounds(100, 310, 160, 30);
		add(l3);
		
		JLabel cardpin=new JLabel("XXXX");
		cardpin.setFont(new Font("Raleway", Font.BOLD,20));
		cardpin.setBounds(400, 290, 100, 30);
		add(cardpin);
		
		JLabel service=new JLabel("Services Required");
		service.setFont(new Font("Raleway", Font.BOLD,20));
		service.setBounds(100, 350, 180, 30);
		add(service);
		
		j1=new JCheckBox("ATM CARD");
		j1.setFont(new Font("Raleway", Font.BOLD, 14));
		j1.setBounds(100, 390, 100, 30);
		j1.setBackground(Color.WHITE);
		add(j1);
		
		j2=new JCheckBox("Internet Banking");
		j2.setFont(new Font("Raleway", Font.BOLD, 14));
		j2.setBounds(400, 390, 150, 30);
		j2.setBackground(Color.WHITE);
		add(j2);
		
		j3=new JCheckBox("Mobile Banking");
		j3.setFont(new Font("Raleway", Font.BOLD, 14));
		j3.setBounds(100, 420, 150, 30);
		j3.setBackground(Color.WHITE);
		add(j3);
		
		j4=new JCheckBox("Email & SMS alerts");
		j4.setFont(new Font("Raleway", Font.BOLD, 14));
		j4.setBounds(400, 420, 200, 30);
		j4.setBackground(Color.WHITE);
		add(j4);
		
		j5=new JCheckBox("Cheque Book");
		j5.setFont(new Font("Raleway", Font.BOLD, 14));
		j5.setBounds(100, 450, 150, 30);
		j5.setBackground(Color.WHITE);
		add(j5);
		
		j6=new JCheckBox("E-Statement");
		j6.setFont(new Font("Raleway", Font.BOLD, 14));
		j6.setBounds(400, 450, 150, 30);
		j6.setBackground(Color.WHITE);
		add(j6);
		
		declaration=new JCheckBox("I hearby declares that the above entered details are correct to the best of my knowledge");
		declaration.setFont(new Font("Raleway", Font.BOLD, 11));
		declaration.setBounds(100, 520, 500, 30);
		declaration.setBackground(Color.WHITE);
		add(declaration);
		
		submit=new JButton("Submit");
		submit.setBounds(280, 580, 100, 30);
		submit.setForeground(Color.WHITE);
		submit.setBackground(Color.BLACK);
		submit.setFont(new Font("Raleway", Font.BOLD, 14));
		submit.addActionListener(this);
		add(submit);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(450, 580, 100, 30);
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		cancel.setFont(new Font("Raleway", Font.BOLD, 14));
		cancel.addActionListener(this);
		add(cancel);
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setLocation(250,10);
		setVisible(true);
					
	}
	
	public void actionPerformed(ActionEvent ae) {
		String accountype=null;
		String service=null;
		if(ae.getSource() == submit) {
			if(r1.isSelected()) {
				accountype=r1.getText();
				System.out.println(r1.getText());
			}
			else if(r2.isSelected()) {
				accountype=r2.getText();
			}
			else if(r3.isSelected()) {
				accountype=r3.getText();
			}
			else if(r4.isSelected()) {
				accountype=r4.getText();
			}
			
			
			
			if(j1.isSelected()) {
				service=j1.getText();
				
			}
			else if(j2.isSelected()) {
				service=" "+j2.getText();
			}
			else if(j3.isSelected()) {
				service=" "+j3.getText();
			}
			else if(j4.isSelected()) {
				service=" "+j4.getText();
			}
			else if(j5.isSelected()) {
				service=" "+j5.getText();
			}
			else if(j6.isSelected()) {
				service=" "+j6.getText();
			}
			
			Random num=new Random();
			String cardnumber="" +Math.abs(num.nextLong() % 90000000l + 5726299400000000l); 
			String pin="" +Math.abs(num.nextLong() % 9000l + 1000l);
			
//			if(!(declaration.isSelected())){
//				JOptionPane.showMessageDialog(null, "Click on declaration");
//				
//			}
			
			if(accountype.equals("")) {
				JOptionPane.showMessageDialog(null, "Account Type is required");
			}
			else {
				try {
				Conn c=new Conn();
				String query1="insert into signup3 values('"+formno+"','"+accountype+"','"+cardnumber+"','"+pin+"','"+service+"')";
				c.s.executeUpdate(query1);
				String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pin+"')";
				c.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber+"\nPin: "+pin);
				
				setVisible(false);
				new Deposit(pin).setVisible(true);
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			
						
		}
		else if(ae.getSource() == cancel) {
			
			setVisible(false);
			new Login().setVisible(true);
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new Signup3("");
			
		}
	}


