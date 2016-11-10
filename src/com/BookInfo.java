package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;
import java.sql.*;
import javax.swing.table.AbstractTableModel;
public class BookInfo implements ActionListener
{ 
private JFrame frame;
  private Statement stmt;
  private Connection con;
  private JTable tableTest;
  private String[]columnNames={"����","������","�����","������","�żܺ�","������",
  "��������","�������","״̬","���"};
  private Object[][]rowData=new Object[100][10];
  private JButton btn;
  private JRadioButton rbtn1,rbtn2;
  private JTextField jtfd;    
	public BookInfo()
	{    
	  Font s=new Font("����",Font.PLAIN,12);
       UIManager.put("Component.font",s);  
       UIManager.put("Label.font",s);  
       UIManager.put("ComboBox.font",s);  
       UIManager.put("Button.font",s); 
       UIManager.put("Menu.font",s); 	
       UIManager.put("MenuItem.font",s);
		frame=new JFrame("ͼ����Ϣ��ѯ");
		Container content=frame.getContentPane();
		
	    btn=new JButton("��ѯ");
	    jtfd=new JTextField();
	    JPanel pl=new JPanel();
	    rbtn1=new JRadioButton("����");
	    rbtn2=new JRadioButton("������");
	    rbtn1.setSelected(true);
	    btn.addActionListener(this);
	   
	    ButtonGroup group=new ButtonGroup();
	    group.add(rbtn1);
	    group.add(rbtn2);
	    pl.setLayout(new GridLayout(1,4,10,0));
	    pl.add(rbtn1);
	    pl.add(rbtn2);
	    pl.add(jtfd);
	    pl.add(btn);
	    tableTest=new JTable(rowData,columnNames);
		tableTest.setRowHeight(20);
	    
        tableTest.setPreferredScrollableViewportSize(new Dimension(500, 30));
        JScrollPane scrollPane=new JScrollPane(tableTest);
	    content.add(pl,BorderLayout.NORTH);
        content.add(scrollPane,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
     try
	{Class.forName("com.mysql.jdbc.Driver");
	 con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library", "root", "wsx7562482");
	 stmt=con.createStatement();
	}
	catch(ClassNotFoundException e)
	{System.err.println(e.getMessage());
	}
	catch(SQLException e)
	{System.err.println(e.getMessage());
	}
	
	}
	
	public void actionPerformed(ActionEvent e)
	{Object obj=e.getSource();
	 ResultSet result;
	  String sqlStr;
	 int i=0;
	 String str=jtfd.getText().trim();
	
	 if(rbtn2.isSelected())
	 {sqlStr="select bookname,bannercode,kindnumber,kindname,positionnumber,"+
	 "publishingcompany,publishtime,putintime,state,introduction from book where "+
	 "bannercode="+"'"+str+"'";
	 }
	  else
	 {
	 sqlStr="select bookname,bannercode,kindnumber,kindname,positionnumber,"+
	 "publishingcompany,publishtime,putintime,state,introduction from book where "+
	 "bookname like '"+str+"%'";
	 }
	 
	 try
	 {if(obj==btn)
	  {if(str.equals(""))
	    {JOptionPane.showMessageDialog(frame,"��ѯ���벻��Ϊ��!");
	     return;
	    }
	   result=stmt.executeQuery(sqlStr);
	   for(int j=0;j<rowData.length;j++)
	   { for(int k=0;k<10;k++)
	   	 rowData[j][k]=null;
	   }
	  tableTest.repaint();
	    while(result.next())
	    {
	     
	     if(i<rowData.length)
	     {
	     
	     rowData[i][0]=result.getString("bookname");
	     rowData[i][1]=result.getString("bannercode");
	     rowData[i][2]=result.getString("kindnumber");
	     rowData[i][3]=result.getString("kindname");
	     rowData[i][4]=result.getString("positionnumber");
	     rowData[i][5]=result.getString("publishingcompany");
	     rowData[i][6]=result.getDate("publishtime");
	     rowData[i][7]=result.getDate("putintime");
	     rowData[i][8]=result.getString("state");
	     rowData[i][9]=result.getString("introduction");
	     i++;
	     }
	     else{JOptionPane.showMessageDialog(frame,"please specify the bookname!");
	     }
	    }
	  
	  	jtfd.setText("");
	  }
	 	
	 }
	 catch(SQLException sqle)
	 {System.err.println(sqle);
	 }
	
	}
	public static void main(String[]args)
	{new BookInfo();
	}
	}

