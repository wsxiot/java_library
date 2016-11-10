package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.text.*;
import java.math.*;

public class Renew implements ActionListener
{ private JTextField jtfd1,jtfd2,jtfd3;
  private JLabel lb4;
  private JButton btn1,btn2,btn3;
  private Connection con;
  private Statement stmt;
  private PreparedStatement pstmt; 
  private JFrame frame;
	public Renew()
	{
	  	Font s=new Font("����",Font.PLAIN,12);
         UIManager.put("Component.font",s);  
         UIManager.put("Label.font",s);  
         UIManager.put("ComboBox.font",s);  
         UIManager.put("Button.font",s); 
         UIManager.put("Menu.font",s); 	
         UIManager.put("MenuItem.font",s);
	 //JFrame.setDefaultLookAndFeelDecorated(true);
	 frame=new JFrame("����");
	 Container content=frame.getContentPane();
	 
	 content.setLayout(new GridLayout(5,2,10,10));
	 JLabel lb1=new JLabel("������:");
	 JLabel lb2=new JLabel("��������:");
	 JLabel lb3=new JLabel("Ӧ������:");
	 lb4=new JLabel("����:");
	 jtfd1=new JTextField();
	 jtfd2=new JTextField();
	 jtfd3=new JTextField();
	 jtfd2.addFocusListener(new FocusHandler());
	 jtfd3.addFocusListener(new FocusHandler());
	 btn1=new JButton("����");
	 btn2=new JButton("����");
	 btn3=new JButton("�˳�");
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
	 content.add(btn1);
	 content.add(btn2);
	 content.add(btn3);
	 frame.setBounds(100,100,400,300);
	 frame.setVisible(true);
	 
	 try{
		 Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library", "root", "wsx7562482");
	 	stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
	 	ResultSet.CONCUR_READ_ONLY);
	 	pstmt=con.prepareStatement("update borrow set receivedate=?,renew='��'"+
	 	" where bannercode=? ");
	 }	
	 catch(ClassNotFoundException e)
	 {
	 }
	 catch(SQLException e)
	 {
	 }
	}
	
	class FocusHandler implements FocusListener
	{   java.util.Date today1=new java.util.Date();
	    DateFormat format=DateFormat.getDateInstance();
	    String formatted=format.format(today1);
	    
		public void focusGained(FocusEvent e)
		{Object obj=(JTextField)e.getSource();
		 if(obj==jtfd2)
		 {jtfd2.setText(formatted);
		 }
		 if(obj==jtfd3)
		 {java.util.Date today2=new java.util.Date();
		  today2.setMonth(today2.getMonth()+1);
		  formatted=format.format(today2);
		  
		  jtfd3.setText(formatted);
		 }
			
		}
	
		public void focusLost(FocusEvent e)
		{
			
		}
	 
	}
	public void actionPerformed(ActionEvent e)
	{  String sqlStr,str,str2,str3,cardnumber;
	   ResultSet result,result2;
	   java.util.Date today=new java.util.Date();
	   int day1,day2,res;
	   float money=0;
	    str=jtfd1.getText().trim();
	    
	    str3=jtfd3.getText().trim();
	    sqlStr="select receivedate,user_cardnumber,renew from borrow where bannercode="+
	    "'"+str+"'";
		Object obj=(JButton)e.getSource();
		try{
		
		if(obj==btn2)
		{if(str.equals("")|str3.equals(""))
		  {JOptionPane.showMessageDialog(frame,"Text can't be null!");
		   jtfd1.setText("");
		   return;
		  }
		  result=stmt.executeQuery(sqlStr);
		if(result.next())
		{java.util.Date recdate=result.getDate("receivedate");
	       cardnumber=result.getString("user_cardnumber");
	       str2=result.getString("renew");
	      if(str2.equals("��"))
	      {JOptionPane.showMessageDialog(frame,"you can renew only once!");
	        jtfd1.setText("");
	       return;
	      }
	    if(recdate.before(today))
	    {day1=today.getYear()*365+today.getMonth()*30+today.getDay();
	     day2=recdate.getYear()*365+recdate.getMonth()*30+recdate.getDate();
	     money=(float)((day1-day2)*0.1);
	     sqlStr="select * from punishment where user_cardnumber="+
	     "'"+cardnumber+"'";
	     result2=stmt.executeQuery(sqlStr);
	     if(!result2.next())
	     {
	      sqlStr="insert into punishment(user_cardnumber,sum_account)"+
	     "values("+"'"+cardnumber+"'"+","+money+")";
	      stmt.executeUpdate(sqlStr);
	      JOptionPane.showMessageDialog(frame,"insert a record!");
	     }
	     else
	     {sqlStr="update punishment set sum_account=sum_account+"+money+
	     " where user_cardnumber="+"'"+cardnumber+"'";
	      stmt.executeUpdate(sqlStr);
	      JOptionPane.showMessageDialog(frame,"update a record!");
	     }
	 
	    }
	   java.sql.Date renewDate=java.sql.Date.valueOf(str3);
	   pstmt.setDate(1,renewDate);
	   pstmt.setString(2,str);
	   res=pstmt.executeUpdate();
	   if(res>0)
	   {JOptionPane.showMessageDialog(frame,"renew successfully!");
	   }
	   
	   sqlStr="select sum_account from punishment where user_cardnumber="+
	 	"'"+cardnumber+"'";
	 	result2=stmt.executeQuery(sqlStr);
	 	
	 	if(result2.next())
	 	{
	   
	 	BigDecimal mon=result2.getBigDecimal("sum_account",2);
	 	lb4.setText("����:"+mon);	
	 	
	 	}
	 	else
	 	{lb4.setText("����:0.00");
	 	}
		  
		  }
		jtfd1.setText(""); 	
		}
		if(obj==btn1)
		{
		 if(str.equals(""))
		  {JOptionPane.showMessageDialog(frame,"Text can't be null!");
		   
		   return;
		  }
		  result=stmt.executeQuery(sqlStr);
		  if(result.next())
		  {cardnumber=result.getString("user_cardnumber");
		   sqlStr="delete from punishment where user_cardnumber="+
		   "'"+cardnumber+"'";
		   res=stmt.executeUpdate(sqlStr);
		   if(res>0)
		   {JOptionPane.showMessageDialog(frame,"pay successfully!");
		    lb4.setText("����:0.00");
		   }
		  }
		}
		if(obj==btn3)
		{stmt.close();
		 con.close();
		 frame.dispose();
		}
		
		}
		catch(SQLException sqle)
		{
		}
	}
	public static void main(String[]args)
	{
	 new Renew();
	}
}