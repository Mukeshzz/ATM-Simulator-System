package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Transaction extends JFrame implements ActionListener {
	
	JButton deposit, cashwith, fastcash, ministat, pinchange, balance, exit;
	String pin;
	
	Transaction(String pin){
		this.pin=pin;
		
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(800, 670, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 800, 670);
		add(image);
		
		JLabel text=new JLabel("Please select your Transaction type");
		text.setBounds(190, 220, 300, 20);
		text.setFont(new Font("System", Font.BOLD,13));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(145, 310, 130, 23);
		deposit.addActionListener(this);
		image.add(deposit);
		
		cashwith = new JButton("Cash Withdraw");
		cashwith.setBounds(320, 310, 130, 23);
		cashwith.addActionListener(this);
		image.add(cashwith);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(145, 336, 130, 23);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministat = new JButton("Mini Statement");
		ministat.setBounds(320, 336, 130, 23);
		ministat.addActionListener(this);
		image.add(ministat);
		
		pinchange = new JButton("Pin Change");
		pinchange.setBounds(145, 362, 130, 23);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balance = new JButton("Balance Enquiry");
		balance.setBounds(320, 362, 130, 23);
		balance.addActionListener(this);
		image.add(balance);
		
		exit = new JButton("Exit");
		exit.setBounds(320, 388, 130, 23);
		exit.addActionListener(this);
		image.add(exit);
					
		setSize(800,670);
		setLocation(240,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == exit ) {
			System.exit(0);
		}
		
		else if(ae.getSource() == deposit) {
			setVisible(false);
			new Deposit(pin).setVisible(true);
		}
		
		else if(ae.getSource() == cashwith) {
			setVisible(false);
			new Withdraw(pin).setVisible(true);
		}
		
		else if(ae.getSource() == fastcash) {
			setVisible(false);
			new Fastcash(pin).setVisible(true);
		}
		
		else if(ae.getSource() == pinchange) {
			setVisible(false);
			new PinChange(pin).setVisible(true);
		}
		
		else if(ae.getSource() == balance) {
			setVisible(false);
			new BalanceEnquiry(pin).setVisible(true);
		}
		
		else if(ae.getSource() == ministat) {
			new MiniStatement(pin).setVisible(true);
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		new Transaction("");
	}

}
