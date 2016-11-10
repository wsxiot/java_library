package com;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.math.*;



public class Borrow extends JFrame implements ActionListener
{private  JTextField jtfd1,jtfd2,jtfd3,jtfd4;
 private  JButton btn1,btn2,btn3;
 private  Connection con;
 private Statement stmt;
 private PreparedStatement pstmt;
 private  JFrame frame;
 private JLabel lb5;
	public Borrow()
	{    Font s=new Font("����",Font.PLAIN,12);
         UIManager.put("Component.font",s);  
         UIManager.put("Label.font",s);  
         UIManager.put("ComboBox.font",s);  
         UIManager.put("Button.font",s); 
         UIManager.put("Menu.font",s); 	
         UIManager.put("MenuItem.font",s);
		frame=new JFrame("����");
	 Container content=frame.getContentPane();
	 
	 content.setLayout(new GridLayout(6,2,10,10));

	 JLabel lb1=new JLabel("����֤��:");
	 JLabel lb2=new JLabel("������:");
	 JLabel lb3=new JLabel("��������:");
	 JLabel lb4=new JLabel("Ӧ������:");
	 lb5=new JLabel("����:");
	
	 jtfd1=new JTextField();
	 jtfd2=new JTextField();
	 jtfd3=new JTextField();
	 jtfd4=new JTextField();
	 jtfd1.addFocusListener(new FocusHandler());
	 jtfd2.addFocusListener(new FocusHandler());
	 jtfd3.addFocusListener(new FocusHandler());
	 jtfd4.addFocusListener(new FocusHandler());
	 btn1=new JButton("ȷ��");
	 btn2=new JButton("�˳�");
	 btn3=new JButton("����");
	 btn1.addActionListener(this);
	 btn2.addActionListener(this);
	 btn3.addActionListener(this);
	 content.add(lb1);
	 content.add(jtfd1);
	 content.add(lb2);
	 content.add(jtfd2);
	 content.add(lb3);
	 content.add(jtfd3);
	 content.add(lb4);
	 content.add(jtfd4);
	 content.add(lb5);
	 content.add(btn3);
	 content.add(btn1);
	 content.add(btn2);
	 
	 
	 frame.setBounds(100,100,420,320);
	
	 try{
		 Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library", "root", "wsx7562482");
	 	stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	 	ResultSet.CONCUR_READ_ONLY);
	 	pstmt=con.prepareStatement("insert into borrow(user_cardnumber,bannercode,borrowdate,"+
	 "receivedate,renew) values(?,?,?,?,'��')");
	 	
	    }
	    catch(ClassNotFoundException e)
	    {System.err.println(e);
	    }
	    catch(SQLException e)
	    {System.err.println(e);
	    }
	  frame.setVisible(true);
	 
	}
	class FocusHandler implements FocusListener
	{ String str1,sqlStr1,state;
	   ResultSet result;
	  
      java.util.Date today1=new java.util.Date();
      java.util.Date today2=new java.util.Date();
      
      DateFormat format=DateFormat.getDateInstance();
      String formatted1=format.format(today1);
	 
	 public void focusGained(FocusEvent e)
	 {
	 
	  Object obj=(JTextField)e.getSource();
	  
	  if(obj==jtfd4)
	  {today2.setMonth(today1.getMonth()+1);
	   String formatted2=format.format(today2);
	   jtfd4.setText(formatted2);
	  }
	  try{
	  if(obj==jtfd2)
	  { str1=jtfd1.getText().trim();
	    if(str1.equals(""))
	    {
	    	jtfd1.requestFocus();
	    	JOptionPane.showMessageDialog(frame,"���벻��Ϊ��!");
	     	return;
	    }
	  
	   sqlStr1="select * from user where user_cardnumber="+"'"+str1+"'";
	    
	  result=stmt.executeQuery(sqlStr1);
	   if(!result.next())
	   {
	   	jtfd1.requestFocusInWindow();
	    JOptionPane.showMessageDialog(frame,"��ע��!");
	    
	    jtfd1.setText("");
	    return;
	   }
	   else
	   {
	   	if(result.getString("user_state").equals("��ʧ"))
	   	{jtfd1.requestFocus();
	   	 JOptionPane.showMessageDialog(frame,"�˿��ѹ�ʧ!");
	   	 jtfd1.setText("");
	   	 return;
	   	}
	   	sqlStr1="select * from borrow where user_cardnumber="+
	   "'"+str1+"'";
	    result=stmt.executeQuery(sqlStr1);
	    int i=0;
	    while(result.next())
	    {i=i+1;
	    }
	    if(i==4)
	    {   jtfd1.requestFocus();
	    	JOptionPane.showMessageDialog(frame,"�㲻�ܽ��ĳ���˼����!");
	         jtfd1.setText("");
	    
	     return;
	    }
	   }
	  }
	  
	   if(obj==jtfd3)
	  { 
	  jtfd3.setText(formatted1);
	  str1=jtfd2.getText().trim();
	  if(str1.equals(""))
	  { jtfd2.requestFocus();
	  	JOptionPane.showMessageDialog(frame,"���벻��Ϊ��!");
	   return;
	  }
	  sqlStr1="select state from book where bannercode="+"'"+str1+"'";
	  result=stmt.executeQuery(sqlStr1);
	   if(!result.next())
	   {jtfd2.requestFocus(true);
	    JOptionPane.showMessageDialog(frame,"�������벻�ڼ�¼��!");
	    
	    jtfd2.setText("");
	    return;
	   }
	   else
	   {state=result.getString("state");
	   
	    if(state.equals("���"))
	     {jtfd2.requestFocus(true);
	      JOptionPane.showMessageDialog(frame,"�����ѽ��!");
	       
	       jtfd2.setText("");
	      return;
	     }
	   }
	  }
	  }
	  catch(SQLException sqle)
	  {System.err.println(sqle);
	  }
	
	 }
	 public void focusLost(FocusEvent e)
	 { try{
	 
	  str1=jtfd1.getText().trim();
	 	sqlStr1="select sum_account from punishment where user_cardnumber="+
	 	"'"+str1+"'";
	 	result=stmt.executeQuery(sqlStr1);
	 	if(result.next())
	 	{
	 	
	 	BigDecimal money=result.getBigDecimal("sum_account",2);
	 	lb5.setText("����:"+money);
	 	}
	 	else
	 	{lb5.setText("����:0.00");
	 	}
	 	
	 	}
	 	catch(SQLException sqle)
	 	{System.err.println(sqle);
	 	}
	 
	}
	}
	public void actionPerformed(ActionEvent e)
	{String sqlStr1,sqlStr2,str1,str2,str3,str4;
	 int result;
	 str1=jtfd1.getText().trim();
	 str2=jtfd2.getText().trim();
	 str3=jtfd3.getText().trim();
	 str4=jtfd4.getText().trim();
	 java.sql.Date today1,today2;
	 
	
	 Object obj=(JButton)e.getSource();
	 try{
	 
	 if(obj==btn1)
	 {
	  if(str1.equals("")|str2.equals("")|str3.equals("")|str4.equals(""))
	 {JOptionPane.showMessageDialog(frame,"���벻��Ϊ��!");
	  return;
	 }
	 sqlStr1="update book set state='���' where bannercode="+"'"+str2+"'";
	 today1=java.sql.Date.valueOf(str3);
	 today2=java.sql.Date.valueOf(str4);	
	  pstmt.setString(1,str1);
	  pstmt.setString(2,str2);
	  pstmt.setDate(3,today1);
	  pstmt.setDate(4,today2);
	  result=pstmt.executeUpdate();
	  if(result>0)
	  {JOptionPane.showMessageDialog(frame,"���ĳɹ�!");
	   
	  }
	  result=stmt.executeUpdate(sqlStr1);
	  if(result>0)
	  {JOptionPane.showMessageDialog(frame,"���³ɹ�!");
	  }
	  jtfd1.setText("");
	  jtfd2.setText("");
	  jtfd3.setText("");
	  jtfd4.setText("");
	 }
	 if(obj==btn3)
	 {sqlStr1="delete from punishment where user_cardnumber="+
	  "'"+str1+"'";
	  result=stmt.executeUpdate(sqlStr1);
	  if(result>0)
	  {JOptionPane.showMessageDialog(frame,"����֧���ɹ�!");
	   lb5.setText("����:0.00");
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
	{new Borrow();
	}
}