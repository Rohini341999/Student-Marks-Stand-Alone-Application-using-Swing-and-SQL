
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.*;

public class first  extends JFrame{

	JLabel lbl1,lbl2,lbl3,lbl4;
	JTextField txtrno,txtname,txtmarks;
	JButton btnsave,btndelete,btnupdate;
	
	first()
	{
		lbl1=new JLabel("DAtabase Application");
		lbl1.setBounds(300, 50, 200, 50);
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbl1);
		
		lbl2=new JLabel("Roll No: ");
		lbl2.setBounds(50, 150, 100, 50);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbl2);
		
		txtrno=new JTextField();
		txtrno.setBounds(150, 150, 200, 50);
		txtrno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(txtrno);
		
		lbl3=new JLabel("Name: ");
		lbl3.setBounds(50, 250, 100, 50);
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbl3);
		
		txtname=new JTextField();
		txtname.setBounds(150, 250, 200, 50);
		txtname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(txtname);
		
		lbl4=new JLabel("Marks: ");
		lbl4.setBounds(50, 350, 100, 50);
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lbl4);
		
		txtmarks=new JTextField();
		txtmarks.setBounds(150, 350, 200, 50);
		txtmarks.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(txtmarks);
		
		btnsave=new JButton("SAve");
		btnsave.setBounds(100, 450, 100, 50);
		btnsave.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(btnsave);
		
		btndelete=new JButton("Delete");
		btndelete.setBounds(300, 450, 100, 50);
		btndelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(btndelete);
		
		btnupdate=new JButton("Update");
		btnupdate.setBounds(500, 450, 100, 50);
		btnupdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(btnupdate);
		
		setLayout(null);
		setSize(800,800);
		setVisible(true);
		
		btnsave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/registrationcrud", "root", "Rohini@341999");
					Statement st= con.createStatement();
					//String rno=txtrno.getText();
					st.executeUpdate("insert into marks values("+txtrno.getText()+", ' "+txtname.getText()+" ', "+txtmarks.getText()+" )");
					JOptionPane.showMessageDialog(null, "Record Saved");
//					con.close();
//					st.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		
		btnupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					System.out.print("hello");
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/registrationcrud", "root", "Rohini@341999");
					Statement st1= conn.createStatement();
					st1.executeUpdate("update marks set name= ' "+txtname.getText()+" ', marks="+txtmarks.getText()+" where id=" +txtrno.getText()+ "");
					JOptionPane.showMessageDialog(null, "Record Updated");
					conn.close();
					st1.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		
		btndelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connn= DriverManager.getConnection("jdbc:mysql://localhost:3306/registrationcrud", "root", "Rohini@341999");
					Statement st2= connn.createStatement();
					st2.executeUpdate("delete from marks where id=" +txtrno.getText()+ "");
					JOptionPane.showMessageDialog(null, "Record Deleted");
					connn.close();
					st2.close();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new first();
	}

}
