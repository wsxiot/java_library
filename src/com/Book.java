package com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.*;
import java.math.*;

public class Book implements ActionListener
{private  JButton btn1,btn2,btn3,btn4;
 private JTextField jtfd1,jtfd2,jtfd3,jtfd5,jtfd6,
 jtfd7,jtfd8,jtfd9,jtfd10;
 private JComboBox jcbx;
 private  JTextArea jta;
 private  Connection con;
 private  PreparedStatement pstmt1,pstmt2;
 private  JFrame frame;

public Book()
{   
  Font s=new Font("����",Font.PLAIN,12);
  UIManager.put("Component.font",s);  
  UIManager.put("Label.font",s);  
  UIManager.put("ComboBox.font",s);  
  UIManager.put("Button.font",s); 
  UIManager.put("Menu.font",s); 	
  UIManager.put("MenuItem.font",s);
  //JFrame.setDefaultLookAndFeelDecorated(true);
 frame=new JFrame("ͼ�����");
 Container content=frame.getContentPane();
 Toolkit tool=frame.getToolkit();
 Dimension wndsize=tool.getScreenSize();
  
 JLabel lb1=new JLabel("����:");
 JLabel lb2=new JLabel("������:");
 JLabel lb3=new JLabel("�����:");
 JLabel lb4=new JLabel("������:");
 JLabel lb5=new JLabel("�żܺ�:");
 JLabel lb6=new JLabel("������:");
 JLabel lb7=new JLabel("��������:");
 JLabel lb8=new JLabel("�������:");
 JLabel lb9=new JLabel("�۸�:");
 JLabel lb10=new JLabel("����:");
 JLabel lb11=new JLabel("���:");

  jtfd1=new JTextField();
  jtfd2=new JTextField();
  jtfd3=new JTextField();
  String[] kindname={"���˼�������塢ë��˼��","�ۺ���ͼ��","��ѧ","����ѧ����",
	 "���Ρ�����","����","����","�Ļ�����ѧ������������","��������","��ѧ","����ѧ�������ѧ",
	 "�����ѧ","ҽҩ������","ũҵ��ѧ","��ҵ����","����","��ʷ������","����","��Ȼ��ѧ����",
	 "������ѧ","���պ���","��ͨ"};
	 
 jcbx=new JComboBox(kindname);
 
  jtfd5=new JTextField();
  jtfd6=new JTextField();
  jtfd7=new JTextField();
  jtfd8=new JTextField();
  jtfd9=new JTextField();
  jtfd10=new JTextField();
  jtfd8.addFocusListener(new FocusHandler());
  jta=new JTextArea();
 jta.setLineWrap(true);
 btn1=new JButton("���");
 btn2=new JButton("ɾ��");
 btn3=new JButton("����");
 btn4=new JButton("�˳�");
 btn1.addActionListener(this);
 btn2.addActionListener(this);
 btn3.addActionListener(this);
 btn4.addActionListener(this);
 
 JPanel pl1=new JPanel();
 JPanel pl2=new JPanel();
 JPanel pl3=new JPanel();
 JPanel pl4=new JPanel();
 
 pl1.setLayout(new GridLayout(5,4,6,6));
 pl1.add(lb1);
 pl1.add(jtfd1);
 pl1.add(lb2);
 pl1.add(jtfd2);
 pl1.add(lb10);
 pl1.add(jtfd10);
 pl1.add(lb3);
 pl1.add(jtfd3);
 pl1.add(lb4);
 pl1.add(jcbx);
 pl1.add(lb5);
 pl1.add(jtfd5);
 pl1.add(lb6);
 pl1.add(jtfd6);
 pl1.add(lb7);
 pl1.add(jtfd7);
 pl1.add(lb8);
 pl1.add(jtfd8);
 pl1.add(lb9);
 pl1.add(jtfd9);
 
 
 
 GridBagLayout gridbag=new GridBagLayout();
 GridBagConstraints constraints=new GridBagConstraints();
 pl2.setLayout(gridbag);
 constraints.weightx=constraints.weighty=10.0;
 constraints.fill=constraints.BOTH;
 
 gridbag.setConstraints(lb11,constraints);
 constraints.weightx=1;
 constraints.gridwidth=1;
 pl2.add(lb11,constraints);
 gridbag.setConstraints(jta,constraints);
 constraints.weightx=9;
 constraints.gridheight=3;
 constraints.gridwidth=3;
 constraints.insets=new Insets(10,15,10,20);
 
 pl2.add(jta,constraints);
 
 GridBagLayout gridbag1=new GridBagLayout();
 GridBagConstraints constraints1=new GridBagConstraints();
 constraints1.weightx=1.0;
 constraints1.fill=constraints1.BOTH;
 pl3.setLayout(gridbag1);
 
 //gridbag1.setConstraints(pl1,constraints1);
 constraints1.weighty=0.8;
 constraints1.gridwidth=constraints1.REMAINDER;
 pl3.add(pl1,constraints1);
 
 //gridbag1.setConstraints(pl2,constraints1);
 constraints1.weighty=0.2;
 constraints1.gridheight=constraints.REMAINDER;
 pl3.add(pl2,constraints1);
 
 pl4.setLayout(new GridLayout(1,4,6,0));
 pl4.add(btn1);
 pl4.add(btn2);
 pl4.add(btn3);
 pl4.add(btn4);
 
 content.setLayout(new BorderLayout());
 content.add(pl3,BorderLayout.CENTER);
 content.add(pl4,BorderLayout.SOUTH);
 
 frame.setBounds(100,100,550,400);
 frame.setResizable(false);
 frame.setVisible(true);
 
 try
 {    
 	
 	String sqlStr1,sqlStr2;
 	sqlStr1="insert into book (bookname,bannercode,kindnumber,kindname,"+
 	"positionnumber,publishingcompany,publishtime,putintime,price,"+
 	"state,introduction,author) values(?,?,?,?,?,?,?,?,?,'�ڼ�',?,?)";
 	sqlStr2="delete from book where bannercode=?";
 	Class.forName("com.mysql.jdbc.Driver");
 	con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library", "root", "wsx7562482");
 	pstmt1=con.prepareStatement(sqlStr1);
 	pstmt2=con.prepareStatement(sqlStr2);
 	
 }
 catch(ClassNotFoundException e)
 {
 }
 catch(SQLException sqle)
 {
 }
 
 
}

class FocusHandler implements FocusListener
{ java.util.Date today=new java.util.Date();
  DateFormat format=DateFormat.getDateInstance();
  String formatted=format.format(today);
  
	
	public void focusGained(FocusEvent e)
	{Object obj=(JTextField)e.getSource();
	 if(obj==jtfd8)
	 {jtfd8.setText(formatted);
	 }
	 
	}
	public void focusLost(FocusEvent e)
	{
	}
}

 public void actionPerformed(ActionEvent e)
 {String str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11;
  
  str1=jtfd1.getText().trim();
  str2=jtfd2.getText().trim();
  str3=jtfd3.getText().trim();
  str4=(String)jcbx.getSelectedItem();
  str5=jtfd5.getText().trim();
  str6=jtfd6.getText().trim();
  str7=jtfd7.getText().trim();
  str8=jtfd8.getText().trim();
  str9=jtfd9.getText().trim();
  str10=jtfd10.getText().trim();
  str11=jta.getText().trim();
  
  int result;

 try{	
  Object obj=(JButton)e.getSource();
  if(obj==btn1)
  {
   if(str1.equals("")|str2.equals("")|str3.equals("")|str4.equals("")|str5.equals(""))
   {JOptionPane.showMessageDialog(frame,"����Ϊ��!");
    return;
   }
   if(str6.equals("")|str7.equals("")|str8.equals("")|str9.equals("")|str10.equals(""))
   {JOptionPane.showMessageDialog(frame,"����Ϊ��!");
    return;
   }
   
   java.sql.Date today1,today2;
   BigDecimal money=new BigDecimal(str9);
   today1=java.sql.Date.valueOf(str7);
   today2=java.sql.Date.valueOf(str8);
   pstmt1.setString(1,str1);
   pstmt1.setString(2,str2);
   pstmt1.setString(3,str10);
   pstmt1.setString(4,str4);
   pstmt1.setString(5,str5);
   pstmt1.setString(6,str6);
   pstmt1.setDate(7,today1);
   pstmt1.setDate(8,today2);
   pstmt1.setBigDecimal(9,money);
 
   pstmt1.setString(10,str11);
   pstmt1.setString(11,str10);
   
   result=pstmt1.executeUpdate();
     
    if(result>0)
    {JOptionPane.showMessageDialog(frame,"ͼ����ӳɹ�!");
    }
    else{
    	JOptionPane.showMessageDialog(frame,"ͼ�����ʧ��!");
    }
  jtfd1.setText("");
  jtfd2.setText("");
  jtfd3.setText("");
  
  jtfd5.setText("");
  jtfd6.setText("");
  jtfd7.setText("");
  jtfd8.setText("");
  jtfd9.setText("");
  jtfd10.setText("");
  jta.setText("");
   
   }
  else if(obj==btn2)
  {if(str2.equals(""))
   {JOptionPane.showMessageDialog(frame,"ɾ��ͼ�鲻��Ϊ��!");
    return;
   }
   
    pstmt2.setString(1,str2);
    result=pstmt2.executeUpdate();
    if(result>0)
    {JOptionPane.showMessageDialog(frame,"ͼ��ɾ���ɹ�!");
    }
  
  }
  else if(obj==btn3)
  {jtfd1.setText("");
  jtfd2.setText("");
  jtfd3.setText("");
  
  jtfd5.setText("");
  jtfd6.setText("");
  jtfd7.setText("");
  jtfd8.setText("");
  jtfd9.setText("");
  jtfd10.setText("");
  jta.setText("");
   
  }
  else if(obj==btn4)
  {pstmt1.close();
   pstmt2.close();
   con.close();
   frame.dispose();
  }
  }
  catch(SQLException sqle)
  {System.err.println(sqle);
  }catch(IllegalArgumentException iae){
	  JOptionPane.showMessageDialog(frame,"���ڸ�ʽ����ӦΪ2016-10-16��ʽ�������Ǽ۸������"); 
  }
 }
public static void main(String[]args)
{new Book();
}
	
}
