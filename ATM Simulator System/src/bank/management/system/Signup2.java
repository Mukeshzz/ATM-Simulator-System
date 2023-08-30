package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


	public class Signup2 extends JFrame implements ActionListener {
		int ran;
		JTextField pantext, adhrtext;
		JRadioButton syes, sno, eyes, eno; 
		JButton next;
		JComboBox religionbox, categorybox, incombox, edbox, occupbox;
		
		String formno;
		
		
		
		Signup2(String formno){
			this.formno=formno;
			
			setLayout(null);
			
			Random ran=new Random();
			
			setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
			
			
			JLabel adddetails=new JLabel("Page 2: Additional Details");
			adddetails.setFont(new Font("Raleway", Font.BOLD,18));
			adddetails.setBounds(290,80,600,30);
			add(adddetails);
			
			JLabel religion=new JLabel("Religion");
			religion.setFont(new Font("Raleway", Font.BOLD,16));
			religion.setBounds(100,150,100,30);
			add(religion);
			
			String valReligion[] = {"Hindu","Muslim","Christian"};
			religionbox=new JComboBox(valReligion);
			religionbox.setBounds(300, 150, 300, 30);
			religionbox.setBackground(Color.WHITE);
			add(religionbox);
			
			JLabel category = new JLabel("Category");
			category.setFont(new Font("Raleway", Font.BOLD,16));
			category.setBounds(100,190,100,30);
			add(category);
			
			String valcategory[] = {"General","OBC","SC","ST"};
			categorybox=new JComboBox(valcategory);
			categorybox.setBounds(300, 190, 300, 30);
			categorybox.setBackground(Color.WHITE);
			add(categorybox);
			
			JLabel income=new JLabel("Income");
			income.setFont(new Font("Raleway", Font.BOLD,16));
			income.setBounds(100,230,100,30);
			add(income);
			
			String valincome[] = {"Null","<1,50,000","<2,50,5000","<5,00,000","Upto 10,00,000"};
			incombox=new JComboBox(valincome);
			incombox.setBounds(300, 230, 300, 30);
			incombox.setBackground(Color.WHITE);
			add(incombox);
			
			JLabel education=new JLabel("Educational");
			education.setFont(new Font("Raleway", Font.BOLD,16));
			education.setBounds(100,270,100,30);
			add(education);
			JLabel quali=new JLabel("qualifation");
			quali.setFont(new Font("Raleway", Font.BOLD,16));
			quali.setBounds(100,290,100,30);
			add(quali);
			
			String edval[] = {"Non-Graduation","Graduate","Post-Graduation","Doctrate","Others"};
			edbox=new JComboBox(edval);
			edbox.setBounds(300, 290, 300, 30);
			edbox.setBackground(Color.WHITE);
			add(edbox);
			
			JLabel occupation=new JLabel("Occupation");
			occupation.setFont(new Font("Raleway", Font.BOLD,16));
			occupation.setBounds(100,350,100,30);
			add(occupation);
			
			String occupval[] = {"Salaried","Self-Employee","Bussiness","Student","Retired","Others"};
			occupbox=new JComboBox(occupval);
			occupbox.setBounds(300, 350, 300, 30);
			occupbox.setBackground(Color.WHITE);
			add(occupbox);
			
			
			
			JLabel pan=new JLabel("PAN No.");
			pan.setFont(new Font("Raleway", Font.BOLD,16));
			pan.setBounds(100,390,100,30);
			add(pan);
			
			pantext=new JTextField();
			pantext.setFont(new Font("Raleway", Font.BOLD, 14));
			pantext.setBounds(300, 390, 300, 30);
			add(pantext);
			
			JLabel adhrno=new JLabel("Adhaar No.");
			adhrno.setFont(new Font("Raleway", Font.BOLD,16));
			adhrno.setBounds(100,430,100,30);
			add(adhrno);
			
			adhrtext=new JTextField();
			adhrtext.setFont(new Font("Raleway", Font.BOLD, 14));
			adhrtext.setBounds(300, 430, 300, 30);
			add(adhrtext);
			
			JLabel scitizen=new JLabel("Senior Citizen");
			scitizen.setFont(new Font("Raleway", Font.BOLD,16));
			scitizen.setBounds(100,470,150,30);
			add(scitizen);
			
			syes=new JRadioButton("Yes");
			syes.setBounds(300, 470, 60, 30);
			syes.setBackground(Color.WHITE);
			add(syes);
			
			sno=new JRadioButton("No");
			sno.setBounds(425, 470, 80, 30);
			sno.setBackground(Color.WHITE);
			add(sno);
			
			ButtonGroup seniorgroup=new ButtonGroup();
			seniorgroup.add(syes);
			seniorgroup.add(sno);
			
			JLabel Existing=new JLabel("Existing Account");
			Existing.setFont(new Font("Raleway", Font.BOLD,16));
			Existing.setBounds(100,510,150,30);
			add(Existing);
			
			eyes=new JRadioButton("Yes");
			eyes.setBounds(300, 510, 60, 30);
			eyes.setBackground(Color.WHITE);
			add(eyes);
			
			eno=new JRadioButton("No");
			eno.setBounds(425, 510, 80, 30);
			eno.setBackground(Color.WHITE);
			add(eno);
			
			ButtonGroup existingroup=new ButtonGroup();
			existingroup.add(syes);
			existingroup.add(sno);
						
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
			String religion=(String)religionbox.getSelectedItem();
			String category=(String)categorybox.getSelectedItem();
			String income=(String)incombox.getSelectedItem();
			String education=(String)edbox.getSelectedItem();
			String occupation=(String)occupbox.getSelectedItem();
			
			String pan=pantext.getText();
			String adhaar=adhrtext.getText();
			
			String seniorcitizen=null;
			if(syes.isSelected()) {
				seniorcitizen="Yes";
			}
			else if(sno.isSelected()) {
				seniorcitizen="No";
			}
			
			String existingroup=null;
			if(eyes.isSelected()) {
				existingroup="Yes";
			}
			else if(eno.isSelected()) {
				existingroup="No";
			}
			
			
			
			try {
					Conn c=new  Conn();
					String query="insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+adhaar+"','"+seniorcitizen+"','"+existingroup+"')";
					c.s.executeUpdate(query);  
					
					setVisible(false);
					new Signup3(formno).setVisible(true);
				
			}
			catch(Exception e) {
				System.out.println(e);
			} 
			
		}
		
		
		public static void main(String[] args) {
			new Signup2("");
		}


}
