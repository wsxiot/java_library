package com;

import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class BorrowQuery implements ActionListener
{ private JFrame frame;
  private JButton btn1,btn2;
  private JTextField jtfd1,jtfd2;
  private JTable tableTest;
  private String[]columnNames={"����֤��","ͼ������","��������","Ӧ������"};
  
  private Object[][] rowData=new Object[4][4];
  private Statement stmt;
  private Connection con;
	public BorrowQuery()
	{    Font s=new Font("����",Font.PLAIN,12);
         UIManager.put("Component.font",s);  
         UIManager.put("Label.font",s);  
         UIManager.put("ComboBox.font",s);  
         UIManager.put("Button.font",s); 
         UIManager.put("Menu.font",s); 	
         UIManager.put("MenuItem.font",s);
		//JFrame.setDefaultLookAndFeelDecorated(true);
		frame=new JFrame("���Ĳ�ѯ");
		Container content=frame.getContentPane();
		content.setLayout(new BorderLayout());
		
		JLabel lb1=new JLabel("����֤��:");
		JLabel lb2=new JLabel("����:");
		btn1=new JButton("��ѯ");
		btn2=new JButton("�˳�");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		jtfd1=new JTextField();
		jtfd2=new JTextField();
		JPanel pl=new JPanel();
		pl.setLayout(new GridLayout(2,3,10,10));
		pl.add(lb1);
		pl.add(jtfd1);
		pl.add(btn1);
		pl.add(lb2);
		pl.add(jtfd2);
		pl.add(btn2);
		
		tableTest=new JTable(rowData,columnNames);
		tableTest.setRowHeight(30);
	 
		tableTest.setPreferredScrollableViewportSize(new Dimension(500,60));
		JScrollPane scrollPane=new JScrollPane(tableTest);
		
		content.add(pl,BorderLayout.NORTH);
		content.add(scrollPane,BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library", "root", "wsx7562482");
			 stmt=con.createStatement();
		}
		catch(ClassNotFoundException e)
		{
		}
		catch(SQLException e)
		{System.err.println(e);
		}
		
		
	}
	public void actionPerformed(ActionEvent e)
	{String sqlStr,cardnumber,user_name,str1,str2,bannercode;
	 ResultSet result;
	 java.util.Date day1,day2;
	 Object obj=(JButton)e.getSource();
	 str1=jtfd1.getText().trim();
	 str2=jtfd2.getText().trim();
	 try
	 {if(obj==btn1)
	  {if(str1.equals("")|str2.equals(""))
	   {JOptionPane.showMessageDialog(frame,"���벻��Ϊ��!");
	    return;
	   }
	   
	   sqlStr="select borrow.user_cardnumber,user_name,bannercode,borrowdate,receivedate"+
	   " from borrow,user where borrow.user_cardnumber=user.user_cardnumber and"+
	   " borrow.user_cardnumber="+"'"+str1+"'";
	   result=stmt.executeQuery(sqlStr);
	   
	   for(int j=0;j<rowData.length;j++)
	   { for(int k=0;k<4;k++)
	   	 rowData[j][k]=null;
	   }
	  tableTest.repaint();
	  int i=0;
	   while(result.next())
	   {
	   
	   	cardnumber=result.getString("user_cardnumber");
	   	user_name=result.getString("user_name");
	   	if(str2.equals(user_name))
	   	{
	   	 	day1=result.getDate("borrowdate");
	   	 	day2=result.getDate("receivedate");
	   	 	bannercode=result.getString("bannercode");
	   	 	
	   	 	rowData[i][0]=cardnumber;
	   	 	rowData[i][1]=bannercode;
	   	 	rowData[i][2]=day1;
	   	 	rowData[i][3]=day2;
	   	 	i++;
	   	}
	   }
	   
	   jtfd1.setText("");
	   jtfd2.setText("");
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
	{new BorrowQuery();
	}
}