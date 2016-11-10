package com;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class NewBookReport implements ActionListener
{   
 	
	
 private JRadioButton rbtn1,rbtn2,rbtn3;
 private JComboBox jcbx;
 private JFrame frame;
 
 private String[]columnNames={"����","����","������","��������","�۸�"};
 private Object[][]rowData=new Object[1000][5];
 private JTable tableTest;
 private JButton btn;
 private Statement stmt;
 private Connection con;


	public NewBookReport()
	{ 
	 Font s=new Font("����",Font.PLAIN,12);
     UIManager.put("Component.font",s);  
    UIManager.put("Label.font",s);  
    UIManager.put("ComboBox.font",s);  
    UIManager.put("Button.font",s); 
    UIManager.put("Menu.font",s); 	
    UIManager.put("MenuItem.font",s);
		
	 //JFrame.setDefaultLookAndFeelDecorated(true);
	 frame=new JFrame("����ͨ��");
	 Container content=frame.getContentPane();
	 rbtn1=new JRadioButton("��һ��");
	 rbtn2=new JRadioButton("��һ��");
	 rbtn3=new JRadioButton("��������");
	 rbtn1.setSelected(true);
	 ButtonGroup bgp=new ButtonGroup();
	 bgp.add(rbtn1);
	 bgp.add(rbtn2);
	 bgp.add(rbtn3);
	 
	 btn=new JButton("��ѯ");
	 btn.addActionListener(this);
	 JLabel lb=new JLabel("�������:");
	 String[] kindname={"���˼�������塢ë��˼��","�ۺ���ͼ��","��ѧ","����ѧ����",
	 "���Ρ�����","����","����","�Ļ�����ѧ������������","��������","��ѧ","����ѧ�������ѧ",
	 "�����ѧ","ҽҩ������","ũҵ��ѧ","��ҵ����","����","��ʷ������","����","��Ȼ��ѧ����",
	 "������ѧ","���պ���","��ͨ"};
	 jcbx=new JComboBox(kindname);
	 JPanel pl=new JPanel();
	 pl.setLayout(new GridLayout(2,3,10,10));
	 pl.add(rbtn1);
	 pl.add(rbtn2);
	 pl.add(rbtn3);
	 pl.add(lb);
	 pl.add(jcbx);
	 pl.add(btn);
	 content.add(pl,BorderLayout.NORTH);
	 tableTest=new JTable(rowData,columnNames);
	 tableTest.setRowHeight(30);
	 tableTest.setRequestFocusEnabled(false);
	 tableTest.setPreferredScrollableViewportSize(new Dimension(500,60));
	 JScrollPane scrollPane=new JScrollPane(tableTest);
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
	 {System.err.println(e);
	 }
	 catch(SQLException e)
	 {System.err.println(e);
	 }
	 
	 
		
	}
	public void actionPerformed(ActionEvent e)
	{Object obj=(JButton)e.getSource();
	 String kindname,sqlStr;
	 ResultSet result;
	 int i=0;
	 java.util.Date today=new java.util.Date();
	 java.util.Date day;

	 
	 try
	 {
	 	if(obj==btn)
	 	{ if(rbtn1.isSelected())
	 	  {
	 	   today.setDate(today.getDate()-7);
	 	  }
	 	  if(rbtn2.isSelected())
	 	  {
	 	  today.setDate(today.getDate()-30);
	 	  }
	 	  if(rbtn3.isSelected())
	 	  {today.setDate(today.getDate()-90);
	 	  }
	 	  for(int j=0;j<rowData.length;j++)
	 	  { for(int k=0;k<5;k++)
	 	    {rowData[j][k]=null;
	 	    }
	 	  }
	 	  kindname=(String)jcbx.getSelectedItem();
	 	  sqlStr="select bookname,author,publishingcompany,publishtime,"+
	 	  "price,putintime from book where kindname="+"'"+kindname+"'";
	 	  result=stmt.executeQuery(sqlStr);
	 	  while(result.next())
	 	  {day=result.getDate("putintime");
	 	   if(day.after(today))
	 	   { if(i<rowData.length)
	 	     {
	 	   	rowData[i][0]=result.getString("bookname");
	 	   	rowData[i][1]=result.getString("author");
	 	   	rowData[i][2]=result.getString("publishingcompany");
	 	   	rowData[i][3]=result.getDate("publishtime");
	 	   	rowData[i][4]=result.getBigDecimal("price",2);
	 	   	 }
	 	   	i++;
	 	   }
	 	  	 JOptionPane.showMessageDialog(frame,""+i);
	 	  }
	 	 
	 	  tableTest.repaint();
	 	  
	 		
	 	}
	 
	 }
	 catch(SQLException sqle)
	 {
	 	System.err.println(sqle);
	 }
		
	}
	public static void main(String[]args)
	{new NewBookReport();
	}
}