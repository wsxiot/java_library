package com;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame 
{  private  JLabel JLb1;
   private  JLabel JLb2;
   private  JButton Ok_btn;
   private  JButton Cancel_btn;
   private  JTextField Jtfld1;
   private  JPasswordField Jtfld2;
	private JFrame frame;
	private Connection con;
	private Statement stmt;
	public Login()
	{  Font s=new Font("楷体",Font.PLAIN,12);
       UIManager.put("Component.font",s);  
       UIManager.put("Label.font",s);  
       UIManager.put("ComboBox.font",s);  
       UIManager.put("Button.font",s); 
       UIManager.put("Menu.font",s); 	
       UIManager.put("MenuItem.font",s);
	   //JFrame.setDefaultLookAndFeelDecorated(true);
	    frame=new JFrame("登陆");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	
		Container content=frame.getContentPane();
		content.setLayout(new GridLayout(3,2,20,20));
	   JLb1=new JLabel("   用户名:");
	   
		JLb2=new JLabel("   密 码:");
		Jtfld1=new JTextField();
		Jtfld2=new JPasswordField();
	    Ok_btn=new JButton("确定");
		Cancel_btn=new JButton("取消");
		
		Ok_btn.addActionListener(new ActionHandler());
		Cancel_btn.addActionListener(new ActionHandler());
		content.add(JLb1);
		content.add(Jtfld1);
	
		content.add(JLb2);
		content.add(Jtfld2);
		content.add(Ok_btn);
		content.add(Cancel_btn);
	
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(300,200);
		frame.setVisible(true);
		
	try{ Class.forName("com.mysql.jdbc.Driver");
	 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library", "root", "wsx7562482");
	 stmt=con.createStatement();

	}
	catch(ClassNotFoundException e)
	{
	}
	catch(SQLException ex)
	{
	}
	}
	class ActionHandler implements ActionListener
	{
	public void actionPerformed(ActionEvent e)
	{String str1,str2,username,sqlStr;
		Object obj=e.getSource();
	 str1=Jtfld1.getText().trim();
     str2=Jtfld2.getText().trim();
	 try{
	 	
	 if(obj.equals(Ok_btn))
	 
	  {if(str1.equals(""))
	   {JOptionPane.showMessageDialog(frame,"用户名不能为空!");
	    return;
	   } 
	   if(str2.equals(""))
	   {JOptionPane.showMessageDialog(frame,"密码不能为空!");
	    return;
	   }
	   
	  	sqlStr="select * from login where user_name="+"'"+str1+"'"+
	  	" and psw="+"'"+str2+"'";
	  	
	  ResultSet result=stmt.executeQuery(sqlStr);
	  if(result.next())
	  {
	  	username=result.getString("user_name");
	
	  	if(username.equals("guest"))
	  	{
	  		MainFrame mainFrame=new MainFrame();
	  		mainFrame.menuItem1.setEnabled(false);
	  		mainFrame.menuItem14.setEnabled(false);
	  		mainFrame.menuItem3.setEnabled(false);
	  		mainFrame.menuItem4.setEnabled(false);
	  		mainFrame.menuItem5.setEnabled(false);
	  		mainFrame.menuItem6.setEnabled(false);
	  		mainFrame.menuItem7.setEnabled(false);
	  		mainFrame.menuItem15.setEnabled(false);
	  	}
	  	else
	  	{ new MainFrame();
	  	}
	  
	   frame.dispose();
	   stmt.close();
	   con.close();
	  }
	  else
	  {JOptionPane.showMessageDialog(frame,"用户名或密码错误,请重新输入!");
	   
	  }
	}else if(obj.equals(Cancel_btn)){
		System.exit(0);
	}
	}
	catch(SQLException ex)
	{
		System.err.println(ex);
	}
	}
	
	}
	
	public static void main(String[]args)
	{
		
		
		javax.swing.SwingUtilities.invokeLater(new Runnable()
	{
		public void run()
		{new Login();
		}
	});
	}
	}