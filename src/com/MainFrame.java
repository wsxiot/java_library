package com;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.Font;

public class MainFrame implements ActionListener
{private  JMenuBar JMB;
 private  JMenu M1,M2,M3,M4,M5;
 private  JLabel Jlb;
 private  Toolkit tool;
 private  Dimension wndsize;
 //private  JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11;
 public   JMenuItem menuItem1,menuItem2,menuItem3,menuItem4,
 menuItem5,menuItem6,menuItem7,menuItem8,menuItem9,menuItem10,menuItem11,
 menuItem12,menuItem13,menuItem14,menuItem15,menuItem16,menuItem17,menuItem18;
 
	public MainFrame()
	{  Font s=new Font("楷体",Font.PLAIN,12);
       UIManager.put("Component.font",s);  
       UIManager.put("Label.font",s);  
       UIManager.put("ComboBox.font",s);  
       UIManager.put("Button.font",s); 
       UIManager.put("Menu.font",s); 	
       UIManager.put("MenuItem.font",s);
	  //JFrame.setDefaultLookAndFeelDecorated(true);
	 JFrame frame=new JFrame();
	 frame.setTitle("主窗体");
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 Container content=frame.getContentPane();
	 content.setLayout(new BorderLayout());
	 tool=frame.getToolkit();
	 wndsize=tool.getScreenSize();
	 JMB=new JMenuBar();
	  M1=new JMenu("图书入库");
	 M2=new JMenu("图书证管理");
	 M3=new JMenu("图书流通管理");
	 M4=new JMenu("统计查询");
	 M5=new JMenu("帮助");
	
	 M1.setFont(new java.awt.Font("楷体", Font.PLAIN, 14));
	 M2.setFont(new java.awt.Font("楷体", Font.PLAIN, 14));
	 M3.setFont(new java.awt.Font("楷体", Font.PLAIN, 14));
	 M4.setFont(new java.awt.Font("楷体", Font.PLAIN, 14));
	 M5.setFont(new java.awt.Font("楷体", Font.PLAIN, 14));
	 
	 menuItem1=new JMenuItem("读者注册");
	 menuItem2=new JMenuItem("图书证暂停");
	 menuItem3=new JMenuItem("挂失");
	 menuItem4=new JMenuItem("取消挂失");
	 menuItem5=new JMenuItem("注销管理");
	 
	 
	 M2.add(menuItem1);
	 M2.add(menuItem2);
	 M2.add(menuItem3);
	 M2.add(menuItem4);
	 M2.add(menuItem5);
	    
	 
	 menuItem6=new JMenuItem("读者借书");
	 menuItem7=new JMenuItem("还书");
	 menuItem8=new JMenuItem("图书预约");
	 menuItem15=new JMenuItem("续借");
	 M3.add(menuItem6);
	 M3.add(menuItem7);
	 M3.add(menuItem15);
	 M3.add(menuItem8);
	 
	 
	 menuItem9=new JMenuItem("图书查询");
	 menuItem10=new JMenuItem("读者查询");
	 menuItem11=new JMenuItem("借阅统计");
	 menuItem12=new JMenuItem("借阅查询");
	 menuItem13=new JMenuItem("罚款统计");
	 menuItem14=new JMenuItem("图书入库");
	 menuItem16=new JMenuItem("新书通报");
	 menuItem17=new JMenuItem("图书催还");
	 menuItem18=new JMenuItem("帮助");
	 M4.add(menuItem9);
	 M4.add(menuItem10);
	 M4.add(menuItem11);
	 M4.add(menuItem12);
	 M4.add(menuItem13);
	 M4.add(menuItem16);
	 M4.add(menuItem17);
	 M1.add(menuItem14);
	 M5.add(menuItem18);
	 menuItem1.addActionListener(this);
	 menuItem2.addActionListener(this);
	 menuItem3.addActionListener(this);
	 menuItem4.addActionListener(this);
	 menuItem5.addActionListener(this);
	 menuItem6.addActionListener(this);
	 menuItem7.addActionListener(this);
	 menuItem8.addActionListener(this);
	 menuItem9.addActionListener(this);
	 menuItem10.addActionListener(this);
	 menuItem11.addActionListener(this);
	 menuItem12.addActionListener(this);
	 menuItem13.addActionListener(this);
	 menuItem14.addActionListener(this);
	 menuItem15.addActionListener(this);
	 menuItem16.addActionListener(this);
	 menuItem17.addActionListener(this);
     menuItem18.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
				
			try{	
				Runtime hello=Runtime.getRuntime();
				hello.exec("cmd /E:ON /c start ./dir/help.chm");
  				}catch(Exception e3){
  					System.out.println(e3);
  				}
	    	}
	    });
	 
	 menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
	 ActionEvent.ALT_MASK));
	 menuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
	 ActionEvent.ALT_MASK));
	 menuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
	 ActionEvent.ALT_MASK));
	 menuItem5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
	 ActionEvent.ALT_MASK));
	 menuItem6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
	 InputEvent.ALT_MASK));
	 menuItem7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
	 InputEvent.ALT_MASK|InputEvent.CTRL_MASK));
	 menuItem9.setAccelerator(KeyStroke.getKeyStroke("control shift B"));
	 menuItem10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.ALT_MASK));
	 menuItem15.setAccelerator(KeyStroke.getKeyStroke('R'));
	 menuItem14.setAccelerator(KeyStroke.getKeyStroke('B'));
	 menuItem16.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
	 InputEvent.ALT_MASK));
	 menuItem17.setAccelerator(KeyStroke.getKeyStroke("control alt C"));
	 menuItem12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,InputEvent.ALT_MASK));
	 JMB.add(M1);
	 JMB.add(M2);
	 JMB.add(M3);
	 JMB.add(M4);
	 JMB.add(M5);
	 
	
	 frame.setJMenuBar(JMB);
	 
     
	 Jlb=new JLabel(new ImageIcon("./images/01.jpg"));
	 Jlb.setBorder(BorderFactory.createLoweredBevelBorder());
	 content.add(Jlb,BorderLayout.CENTER);
	 frame.setSize(wndsize);
	 
	frame.setLocationRelativeTo(null);
	
	 frame.setVisible(true);
	 
	 
	}
	public void actionPerformed(ActionEvent e)
	{Object obj=e.getSource();
	 if(obj==menuItem1)
	 {new TransactCard();
	 }
	 else if(obj==menuItem14)
	 {new Book();
	 }
	 else if(obj==menuItem3|obj==menuItem4|obj==menuItem5)
	 {new CardManagement();
	 }
	 else if(obj==menuItem6)
	 {new Borrow();
	 }
	 else if(obj==menuItem7)
	 {new Return();
	 }
	 else if(obj==menuItem9)
	 {new BookInfo();
	 }
	 else if(obj==menuItem10)
	 {new UserQuery();
	 }
	 else if(obj==menuItem15)
	 {new Renew();
	 }
	 else if(obj==menuItem16)
	 {new NewBookReport();
	 }
	 else if(obj==menuItem17)
	 {new CallUpReturn();
	 }
	 else if(obj==menuItem12)
	 {new BorrowQuery();
	 }

	}
	public static void main(String[]args)
	{
		new MainFrame();
	}
}