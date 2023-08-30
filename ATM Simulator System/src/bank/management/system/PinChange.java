package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;


import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {
	
	JButton change,back;
	JPasswordField newpin, repin;
	String pin;
	
	PinChange(String pin){
		
		this.pin=pin;
		
		setLayout(null);
		
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(800, 670, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 800, 670);
		add(image);
		
		JLabel text=new JLabel("Change Your PIN");
		text.setBounds(240, 220, 300, 20);
		text.setFont(new Font("System", Font.BOLD,13));
		text.setForeground(Color.WHITE);
		image.add(text);

		
		JLabel pintext=new JLabel("New PIN");
		pintext.setBounds(150, 250, 300, 20);
		pintext.setFont(new Font("System", Font.BOLD,13));
		pintext.setForeground(Color.WHITE);
		image.add(pintext);
		
		newpin=new JPasswordField();
		newpin.setBounds(300, 250, 150, 20);
		newpin.setFont(new Font("Raleway", Font.BOLD, 12));
		image.add(newpin);
		
		JLabel repintext=new JLabel("Re-Enter New PIN");
		repintext.setBounds(150, 280, 300, 20);
		repintext.setFont(new Font("System", Font.BOLD,13));
		repintext.setForeground(Color.WHITE);
		image.add(repintext);
		
		repin=new JPasswordField();
		repin.setBounds(300, 280, 150, 20);
		repin.setFont(new Font("Raleway", Font.BOLD, 12));
		image.add(repin);
		
		change=new JButton("CHANGE");
		change.setBounds(320, 362, 130, 23);
		change.addActionListener(this);
		image.add(change);
		
		back=new JButton("BACK");
		back.setBounds(320, 388, 130, 23);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(800,670);
		setLocation(240,0);
		setUndecorated(true);
		setVisible(true);
		
		}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == change) {
		try {
			String npin=newpin.getText();
			String rpin=repin.getText();
			
			if(!(npin.equals(rpin))) {
				JOptionPane.showMessageDialog(null, "Entered PIN does not match");
				return;
			}
			
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter new PIN");
				return;
			}
			
			if(rpin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
				return;
			} 
			
			Conn c=new Conn();
			String query1="update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
			String query2="update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
			String query3="update signup3 set pin = '"+rpin+"' where pin = '"+pin+"' ";
			
			c.s.executeUpdate(query1);
			c.s.executeUpdate(query2);
			c.s.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null, "PIN changed successfully");
			
			setVisible(false);
			new Transaction(rpin).setVisible(true);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		}else {
			setVisible(false);
			new Transaction(pin).setVisible(true);
			
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}

}
