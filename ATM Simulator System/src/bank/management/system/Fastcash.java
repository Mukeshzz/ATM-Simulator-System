package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Fastcash extends JFrame implements ActionListener {
	
	JButton hundred, five, one, two , fthousand, ten, back;
	String pin;
	
	Fastcash(String pin){
		this.pin=pin;
		
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(800, 670, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 800, 670);
		add(image);
		
		JLabel text=new JLabel("Select withdrawl amount");
		text.setBounds(190, 220, 300, 20);
		text.setFont(new Font("System", Font.BOLD,13));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		hundred = new JButton("Rs 100");
		hundred.setBounds(145, 310, 130, 23);
		hundred.addActionListener(this);
		image.add(hundred);
		
		five = new JButton("Rs 500");
		five.setBounds(320, 310, 130, 23);
		five.addActionListener(this);
		image.add(five);
		
		one = new JButton("Rs 1000");
		one.setBounds(145, 336, 130, 23);
		one.addActionListener(this);
		image.add(one);
		
		two = new JButton("Rs 2000");
		two.setBounds(320, 336, 130, 23);
		two.addActionListener(this);
		image.add(two);
		
		fthousand = new JButton("Rs 5000");
		fthousand.setBounds(145, 362, 130, 23);
		fthousand.addActionListener(this);
		image.add(fthousand);
		
		ten = new JButton("Rs 10000");
		ten.setBounds(320, 362, 130, 23);
		ten.addActionListener(this);
		image.add(ten);
		
		back = new JButton("Back");
		back.setBounds(320, 388, 130, 23);
		back.addActionListener(this);
		image.add(back);
				
		
		setSize(800,670);
		setLocation(240,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back ) {
			setVisible(false);
			new Transaction(pin);
		}
		else {
			String amount= ((JButton)ae.getSource()).getText().substring(3);
			Conn c=new Conn();
			try {
				ResultSet rs=  c.s.executeQuery("select * from bank where pin ='"+pin+"'");
				int balance=0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance+= Integer.parseInt(rs.getString("amount"));
					}
					else {
						balance-=Integer.parseInt(rs.getString("amount"));
					}
					
				}
				if(ae.getSource() != back && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient balance");
					return;
					
				}
				Date date=new Date();
				String query="insert into bank values('"+pin+"','"+date+"','Withdrawl','"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
				setVisible(false);
				new Transaction(pin).setVisible(true);
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		new Fastcash("");
	}
	
	

}
