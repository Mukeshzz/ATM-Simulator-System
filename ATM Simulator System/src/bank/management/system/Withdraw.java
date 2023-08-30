package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdraw extends JFrame implements ActionListener {
		
		JTextField amount;
		JButton withdraw, back;
		String pinnumber;
		
		Withdraw(String pinnumber){
			this.pinnumber=pinnumber;
			
			setLayout(null);
			
			ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
			Image i2=i1.getImage().getScaledInstance(800, 670, Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			JLabel image=new JLabel(i3);
			image.setBounds(0, 0, 800, 670);
			add(image);
			
			JLabel text=new JLabel("Enter the amount you want to withdraw");
			text.setForeground(Color.WHITE);
			text.setBounds(180, 220, 300, 20);
			text.setFont(new Font("System", Font.BOLD, 13));
			image.add(text);
			
			amount=new JTextField();
			amount.setFont(new Font("Raleway", Font.BOLD, 14));
			amount.setBounds(180, 260, 250, 25);
			image.add(amount);
			
			withdraw=new JButton("Withdraw");
			withdraw.setBounds(320, 362, 130, 23);
			withdraw.addActionListener(this);
			image.add(withdraw);
			
			back=new JButton("Back");
			back.setBounds(320, 388, 130, 23);
			back.addActionListener(this);
			image.add(back);
			
			
			setSize(800,670);
			setLocation(240,0);
			setVisible(true);
			
			
		}
		
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource() == withdraw) {
				String rupees=amount.getText();
				Date date=new Date();
				if(rupees.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
				}else {
					try {
					Conn c=new Conn();
					String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+rupees+"')";
					c.s.executeUpdate(query);
					
					JOptionPane.showMessageDialog(null, "Rs "+rupees+" Withdraw Successfully");
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
					
					
					
					}
					catch(Exception e) {
						System.out.println(e);
					}
				}
				
			}
			else if(ae.getSource() == back) {
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
				
			}
		}
		
		
		
		
		public static void main(String[] args) {
			new Withdraw("");
			
		}
	}
