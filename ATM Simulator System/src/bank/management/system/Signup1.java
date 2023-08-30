package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

public class Signup1 extends JFrame implements ActionListener {
	int ran;
	JTextField nametext, ftext, addresstext, phonetext, emailtext, citytext, statetext, pincodetext;
	JDateChooser date;
	JRadioButton male, female;
	JButton next;
	String formno;
	
	
	Signup1(){
		
		setLayout(null);
		
		Random ran=new Random();
		formno=""+Math.abs((ran.nextLong() % 9000 + 1000)); 
		
		
		JLabel title=new JLabel("APPLICATION FORM NO "+formno);
		title.setFont(new Font("Raleway", Font.BOLD,38));
		title.setBounds(150,20,600,40);
		add(title);
		
		JLabel personaldetails=new JLabel("Page 1:Personal Details");
		personaldetails.setFont(new Font("Raleway", Font.BOLD,18));
		personaldetails.setBounds(290,80,600,30);
		add(personaldetails);
		
		JLabel name=new JLabel("Name");
		name.setFont(new Font("Raleway", Font.BOLD,16));
		name.setBounds(100,150,50,30);
		add(name);
		
		nametext=new JTextField();
		nametext.setFont(new Font("Raleway", Font.BOLD, 14));
		nametext.setBounds(300, 150, 300, 30);
		add(nametext);
		
		JLabel father=new JLabel("Father Name");
		father.setFont(new Font("Raleway", Font.BOLD,16));
		father.setBounds(100,190,100,30);
		add(father);
		
		ftext=new JTextField();
		ftext.setFont(new Font("Raleway", Font.BOLD, 14));
		ftext.setBounds(300, 190, 300, 30);
		add(ftext);
		
		JLabel dob=new JLabel("DOB");
		dob.setFont(new Font("Raleway", Font.BOLD,16));
		dob.setBounds(100,230,50,30);
		add(dob);
		
		date=new JDateChooser();
		date.setBounds(300, 230, 300, 30);
		date.setForeground(Color.RED);
		add(date);
		
		JLabel gender=new JLabel("Gender");
		gender.setFont(new Font("Raleway", Font.BOLD,16));
		gender.setBounds(100,270,100,30);
		add(gender);
		
		male=new JRadioButton("Male");
		male.setBounds(300, 270, 60, 30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(500, 270, 80, 30);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup gendergroup=new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		
		
		JLabel address=new JLabel("Address");
		address.setFont(new Font("Raleway", Font.BOLD,16));
		address.setBounds(100,310,100,30);
		add(address);
		
		addresstext=new JTextField();
		addresstext.setFont(new Font("Raleway", Font.BOLD, 14));
		addresstext.setBounds(300, 310, 300, 30);
		add(addresstext);
		
		JLabel phone=new JLabel("Phone No.");
		phone.setFont(new Font("Raleway", Font.BOLD,16));
		phone.setBounds(100,350,100,30);
		add(phone);
		
		phonetext=new JTextField();
		phonetext.setFont(new Font("Raleway", Font.BOLD, 14));
		phonetext.setBounds(300, 350, 300, 30);
		add(phonetext);
		
		JLabel email=new JLabel("Email Id");
		email.setFont(new Font("Raleway", Font.BOLD,16));
		email.setBounds(100,390,100,30);
		add(email);
		
		emailtext=new JTextField();
		emailtext.setFont(new Font("Raleway", Font.BOLD, 14));
		emailtext.setBounds(300, 390, 300, 30);
		add(emailtext);
		
		JLabel city=new JLabel("City");
		city.setFont(new Font("Raleway", Font.BOLD,16));
		city.setBounds(100,430,100,30);
		add(city);
		
		citytext=new JTextField();
		citytext.setFont(new Font("Raleway", Font.BOLD, 14));
		citytext.setBounds(300, 430, 300, 30);
		add(citytext);
		
		JLabel state=new JLabel("State");
		state.setFont(new Font("Raleway", Font.BOLD,16));
		state.setBounds(100,470,100,30);
		add(state);
		
		statetext=new JTextField();
		statetext.setFont(new Font("Raleway", Font.BOLD, 14));
		statetext.setBounds(300, 470, 300, 30);
		add(statetext);
		
		JLabel pincode=new JLabel("pincode");
		pincode.setFont(new Font("Raleway", Font.BOLD,16));
		pincode.setBounds(100,510,100,30);
		add(pincode);
		
		pincodetext=new JTextField();
		pincodetext.setFont(new Font("Raleway", Font.BOLD, 14));
		pincodetext.setBounds(300, 510, 300, 30);
		add(pincodetext);
		
		next=new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD,10));
		next.setBounds(500, 580, 100, 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(850, 800);
		setLocation(250, 10);
		setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent ae) {
		String formno=this.formno;
		String name=nametext.getText(); 
		String fname=ftext.getText();
		
		String dob= ((JTextField) date.getDateEditor().getUiComponent()).getText();
		 
		
		String gender=null;
		if(male.isSelected()) {
			gender="Male";
		}
		else if(female.isSelected()) {
			gender="Female";
		}
		String email=emailtext.getText();
		String phone=phonetext.getText();
		String address=addresstext.getText();
		String city=citytext.getText();
		String state=statetext.getText();
		String pincode=pincodetext.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null,"Name is required");
			}
			else {
				Conn c=new  Conn();
				String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+email+"','"+gender+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
				c.s.executeUpdate(query);  
				
				setVisible(false);
				new Signup2(formno).setVisible(true);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public static void main(String[] args) {
		new Signup1();
	}

	
}
