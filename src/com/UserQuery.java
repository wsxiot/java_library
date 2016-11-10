package com;

import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class UserQuery implements ActionListener
{private JFrame frame;
 private JButton btn1,btn2;
 private Statement stmt;
 private Connection con;
 private JTextField jtfd1,jtfd2,jtfd3,jtfd4,jtfd5,jtfd6,jtfd7,jtfd8;
 
	public UserQuery()
	{  	Font s=new Font("����",Font.PLAIN,12);
    UIManager.put("Component.font",s);  
    UIManager.put("Label.font",s);  
    UIManager.put("ComboBox.font",s);  
    UIManager.put("Button.font",s); 
    UIManager.put("Menu.font",s); 	
     UIManager.put("MenuItem.font",s);
	   //JFrame.setDefaultLookAndFeelDecorated(true);
		frame=new JFrame("�û���ѯ");
		Container content=frame.getContentPane();
		JLabel lb=new JLabel("���������֤���������в�ѯ");
		lb.setFont(new Font("����",Font.PLAIN,16));
		lb.setForeground(Color.blue);
		JLabel lb1=new JLabel("����֤��:*");
		JLabel lb2=new JLabel("����:*");
		JLabel lb3=new JLabel("�Ա�:");
		JLabel lb4=new JLabel("���:");
		JLabel lb5=new JLabel("��λ:");
		JLabel lb6=new JLabel("ע������:");
		JLabel lb7=new JLabel("��Ч��:");
		JLabel lb8=new JLabel("֤��״̬:");
		jtfd1=new JTextField();
		jtfd2=new JTextField();
		jtfd3=new JTextField();
		jtfd4=new JTextField();
		jtfd5=new JTextField();
		jtfd6=new JTextField();
		jtfd7=new JTextField();
		jtfd8=new JTextField();
		btn1=new JButton("��ѯ");
		btn2=new JButton("�˳�");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		JPanel pl=new JPanel();
		JPanel pl2=new JPanel();
		JPanel pl3=new JPanel();
		pl.setLayout(new BorderLayout());
		pl.add(lb,BorderLayout.CENTER);
		pl2.setLayout(new GridLayout(8,8,5,5));
		pl2.add(lb1);
		pl2.add(jtfd1);
		pl2.add(lb2);
		pl2.add(jtfd2);
		pl2.add(lb3);
		pl2.add(jtfd3);
		pl2.add(lb4);
		pl2.add(jtfd4);
		pl2.add(lb5);
		pl2.add(jtfd5);
		pl2.add(lb6);
		pl2.add(jtfd6);
		pl2.add(lb7);
		pl2.add(jtfd7);
		pl2.add(lb8);
		pl2.add(jtfd8);
		pl3.setLayout(new FlowLayout());
		pl3.add(btn1);
		pl3.add(btn2);
		content.add(pl,BorderLayout.NORTH);
		content.add(pl2,BorderLayout.CENTER);
		content.add(pl3,BorderLayout.SOUTH);
		frame.setBounds(100,100,450,400);
		frame.setVisible(true);
		try
		{Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library", "root", "wsx7562482");
		 stmt=con.createStatement();
		}
		catch(ClassNotFoundException e)
		{System.err.println(e);
		}
		catch(SQLException e)
		{System.err.println(e.getMessage());
		}
	
		
	 	
	}
	
	public void actionPerformed(ActionEvent e)
	{  String str1,str2,str3,str4,str5,str6,str7,str8,sqlStr,str;
	   ResultSet result;
	   str1=jtfd1.getText().trim();
	   str2=jtfd2.getText().trim();
		Object obj=(JButton)e.getSource();
		try
		{
			if(obj==btn1)
			{
				if(str1.equals("")|str2.equals(""))
				{JOptionPane.showMessageDialog(frame,"�����ͽ���֤�Ų���Ϊ��!");
				 return;
				}
				sqlStr="select * from user where user_cardnumber="+
				"'"+str1+"'";
				result=stmt.executeQuery(sqlStr);
				if(result.next())
				{str=result.getString("user_name");
				 if(str.equals(str2))
				 {str3=result.getString("user_sex");
				  str4=result.getString("user_status");
				  str5=result.getString("user_office");
				  str6=result.getDate("user_registerdate").toString();
				  str7=result.getDate("user_canceldate").toString();
				  str8=result.getString("user_state");
				  jtfd3.setText(str3);
				  jtfd4.setText(str4);
				  jtfd5.setText(str5);
				  jtfd6.setText(str6);
				  jtfd7.setText(str7);
				  jtfd8.setText(str8);
				 }
				 else
				 {JOptionPane.showMessageDialog(frame,"����֤����������!");
				  jtfd1.setText("");
				  jtfd2.setText("");
				 }
				}
				else
				{JOptionPane.showMessageDialog(frame,"��Ч�Ľ���֤��!");
				 jtfd1.setText("");
				}
				
			}
			if(obj==btn2)
			{stmt.close();
			 con.close();
			 frame.dispose();
			}
		}
		catch(SQLException sqle)
		{System.err.println(sqle);
		
		}
	}
	public static void main(String[]args)
	{new UserQuery();
	}
	}
