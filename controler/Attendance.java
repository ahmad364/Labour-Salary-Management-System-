package controler;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.lang.model.util.ElementScanner6;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

import controler.WorkerOrganizer;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.*;
import java.awt.Color;
import java.awt.Container;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class Attendance extends WorkerOrganizer 
{
    JFrame frame1=new JFrame();
    Container c1; 
    JLabel date=new JLabel("");
    
    JLabel label1=new JLabel("Worker Name");
    JLabel label2=new JLabel("Father Name ");
    public JTextField field=new JTextField();
    public JTextField field2=new JTextField();
    JCheckBox present=new JCheckBox("Present");
    JCheckBox aphsent=new JCheckBox("Absent");
    JCheckBox Half=new JCheckBox("Half");
    ButtonGroup group=new ButtonGroup();
    JButton attendanc=new JButton("Attendance");
    JLabel response=new JLabel("");
    JButton extButton=new JButton("Exit");
        
public String attendance;  // will store the attendance of worker which will be taken from user
public LocalDate date1;    // will store date of today
public String name=null;
boolean flag=false;  // flag variableswill be used for conditions in the class
public boolean main_flag=false;
public String father_name=null;
public String day_name=null;
public static int i=0;
public static int j=1;
public String worker_name=null;
public String Father_name=null;
public boolean date_flag=false;
public boolean flag_message=false;
public String date_name=null;
public int indaex=0;  // this will be indax number of  attendance type arraylist in which atendance user set attendance of worker firs

    JTextField field4=new JTextField();
    JTextField field5=new JTextField();
    JLabel error=new JLabel(" ");
    JLabel error2=new JLabel(" ");
    JButton extJButton=new JButton("Exit");

public boolean error_flag=false;
public boolean error_flag2=false;
//others variables will be used in the methods according to the need
    
// this method will take attendance of every worker and the store attendance in the record of worker
public void setAttendance() throws IndexOutOfBoundsException
{
    try
    {
    Format dateFormat=new SimpleDateFormat("EEE");
    String res= dateFormat.format(new Date());  // day name
    
    // comparing with the name of day and then assign complete name of day to day_name variable 
    if(res.equalsIgnoreCase("Mon"))
    {
        day_name="Monday";
    }
    else if(res.equalsIgnoreCase("Tue"))
    {
        day_name="Tuesday";
    }
    else if(res.equalsIgnoreCase("Thu"))
    {
        day_name="Thursday";
    }
    else if(res.equalsIgnoreCase("Wed"))
    {
        day_name="Wednesday";
    }
    else if(res.equalsIgnoreCase("Fri"))
    {
        day_name="Friday";
    }
    else if(res.equalsIgnoreCase("Sat"))
    {
        day_name="Saturday";
    }
    else
    {
        day_name="Sunday";
    }
    date1=LocalDate.now();

    // assigning worker's name to the array 
    String[] names1= new String[1000];
    names1[0]="The names of workers";
    int i=1;
    for(Worker f:super.worker)
    {
        try {
         names1[i]=f.getName();
         i++;
         
        } catch (Exception e) {
         
        }
    
     
    }


  frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
  frame1.setTitle("                                                                                                                                                                                                Workers  Salary  Management  System");
  c1=frame1.getContentPane();
  c1.setBackground(Color.DARK_GRAY);
  c1.setLayout(null);
  
  // setting properties of exit button
  extButton.setBounds(100,660,120,50);
  extButton.setForeground(Color.DARK_GRAY);
  extButton.setFont(new Font("Arial",Font.BOLD,25));
  extButton.setBackground(Color.white);
  extButton.addActionListener(new ActionListener()
  {
      public void actionPerformed(ActionEvent ev)
      {
          c1.revalidate();
          c1.repaint();
          frame1.dispose();
      }
  });

  c1.add(extButton);


  JComboBox<String> names=new JComboBox<>(names1);
  names.setBounds(250,60,300,70);
  names.setForeground(Color.DARK_GRAY);
  names.setBackground(Color.white);
  names.setFont(new Font("Arial",Font.BOLD,25));
  
  c1.add(names);
  date.setForeground(Color.WHITE);
  date.setBounds(1100, 50, 400, 100);
  date.setFont(new Font("Arial",Font.BOLD,30));
  date.setText(date1+"   "+day_name);
  c1.add(date);

  // response is a lebel which will tell that attendance has been marked or not
  response.setBounds(500,550,1100,200);
  response.setForeground(Color.WHITE);
  response.setFont(new Font("Arial",Font.BOLD,30));
  c1.add(response);
 
  for(Worker f2:super.worker)
  {
      
  attendanc.setBounds(550,60,300,70);
  attendanc.setForeground(Color.DARK_GRAY);
  attendanc.setBackground(Color.WHITE);
  attendanc.setCursor(new Cursor(Cursor.HAND_CURSOR));
  attendanc.setFont(new Font("Arial",Font.BOLD,30));
  attendanc.addActionListener(new ActionListener()
  {
         
      public void actionPerformed(ActionEvent e)
      {
        worker_name=(String)names.getSelectedItem();
        if(f2.getName().equalsIgnoreCase(worker_name))
        Father_name=f2.getFather_name();

      
  label1.setForeground(Color.WHITE);
  label1.setBounds(400, 180, 900, 100);
  label1.setFont(new Font("Arial",Font.BOLD,30));
  c1.add(label1);
  label2.setForeground(Color.WHITE);
  label2.setBounds(400, 300, 900, 100);
  label2.setFont(new Font("Arial",Font.BOLD,30));
  c1.add(label2);
  group.add(present);
  group.add(aphsent);
  group.add(Half);

  field.setBounds(750,218,400,40);
  field.setForeground(Color.DARK_GRAY);

  field.setFont(new Font("Arial",Font.BOLD,25));
  field.setText(worker_name);
  field.setVisible(true);
  c1.add(field);
  field2.setBounds(750,335,400,40);
  field2.setForeground(Color.DARK_GRAY);
  field2.setFont(new Font("Arial",Font.BOLD,25));
  field2.setText(Father_name);
  field2.setVisible(true);
  c1.add(field2);
 
  present.setBounds(300,460,200,80);
  present.setBackground(Color.GREEN);
  present.setForeground(Color.DARK_GRAY);
  present.setFont(new Font("Arail",Font.BOLD,30));
  aphsent.setBounds(700,460,200,80);
  aphsent.setBackground(Color.RED);
  aphsent.setForeground(Color.DARK_GRAY);
  aphsent.setFont(new Font("Arail",Font.BOLD,30));
  Half.setBounds(1100,460,200,80);
  Half.setBackground(Color.ORANGE);
  Half.setForeground(Color.DARK_GRAY);
  Half.setFont(new Font("Arail",Font.BOLD,30));
   
  present.addActionListener(new ActionListener()
  {
     
      public void actionPerformed(ActionEvent e1) 
      {
        
        
          {
             
             if(f2.getName().equalsIgnoreCase(names.getSelectedItem().toString())) 
              {
                try {
                    if(f2.date.get(f2.date.size()-1).equals(date1))
                    {
                        
                    response.setText("");
                    response.setBounds(400,550,1100,200);
                    response.setText("You have first taken attendance of this worker in the same day");

                    }
                    else
                    {
                        f2.setAttendance("P"); // stroing the "P" because worker is present 
                        f2.setDate(date1);  // for storing date
                        f2.setDay_name(day_name);    //for storing day name
                        response.setForeground(Color.GREEN);
                        response.setText("Attendance of "+f2.getName()+" has been marked as a present");
                        
                    }
                  } catch (Exception e)
                  {
           f2.setAttendance("P"); // stroing the "P" because worker is present 
            f2.setDate(date1);  // for storing date
            f2.setDay_name(day_name);    //for storing day name
            response.setForeground(Color.GREEN);
            response.setText("Attendance of "+f2.getName()+" has been marked as a present");
        
        
            
                  } 
        }
          }
      }
  });
  aphsent.addActionListener(new ActionListener() 
  {
      
      public void actionPerformed(ActionEvent e2) 
      {
    
          
        if(f2.getName().equalsIgnoreCase(names.getSelectedItem().toString())) 
          {
              try {
                if(f2.date.get(f2.date.size()-1).equals(date1))
                {
                    
                   response.setText("");
                   response.setBounds(400,550,1100,200);
                   response.setText("You have first taken attendance of this worker in the same day");
                   
                }
                else
                {
                    f2.setAttendance("A"); // stroing the "P" because worker is present 
                    f2.setDate(date1);  // for storing date
                    f2.setDay_name(day_name);    //for storing day name
                    response.setForeground(Color.RED);
                response.setText("Attendance of "+f2.getName()+" has been marked as a absent");
            
                }
              } catch (Exception e)
               {

                f2.setAttendance("A"); // stroing the "P" because worker is present 
                f2.setDate(date1);  // for storing date
                f2.setDay_name(day_name);    //for storing day name
                response.setForeground(Color.RED);
            response.setText("Attendance of "+f2.getName()+" has been marked as a absent");
            
              }
              
           
          }
      }
  });
  Half.addActionListener(new ActionListener()
  {
      
      public void actionPerformed(ActionEvent e3) 
      {

        
        if(f2.getName().equalsIgnoreCase(names.getSelectedItem().toString())) 
          {
            try {
                if(f2.date.get(f2.date.size()-1).equals(date1))
                {  
                    response.setText("");
                    response.setBounds(400,550,1100,200);
                    response.setText("You have first taken attendance of this worker in the same day");

                }
                else
                {
                    f2.setAttendance("Half"); // stroing the "P" because worker is present 
                    f2.setDate(date1);  // for storing date
                    f2.setDay_name(day_name);    //for storing day name
                    response.setForeground(Color.ORANGE);
                    response.setText("Attendance of "+f2.getName()+" has been marked as a half presence");
                    
                }
              } catch (Exception e)
              {
            f2.setAttendance("Half"); // stroing the "P" because worker is present 
            f2.setDate(date1);  // for storing date
            f2.setDay_name(day_name);    //for storing day name
            response.setForeground(Color.ORANGE);
            response.setText("Attendance of "+f2.getName()+" has been marked as a half presence");
            
              }
          }
      }
  });
   
  present.setVisible(true);
  c1.add(present);
  aphsent.setVisible(true);
  c1.add(aphsent);
  Half.setVisible(true);
  c1.add(Half);
  frame1.setVisible(true);

      }
    
});
 c1.add(attendanc);
c1.setVisible(true);
frame1.setVisible(true);
  }
}catch(Exception maybe)
{

}
 
}
//  this method will set attendance of specifics worker and this method will run when attendance of that worker will be taken firs
public  void setAttendance_of_specific_worker()
{
 
    try
    {
    date_name=super.worker.get(super.worker.size()-1).getName();
   
  JFrame frame2=new JFrame();
        Container c2; 
        frame2.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      frame2.setTitle("                                                                                                                                                                                                Workers  Salary  Management  System");
       c2=frame2.getContentPane();
      c2.setBackground(Color.DARK_GRAY);
      c2.setLayout(null);


extJButton.setBounds(100,600,135,50);
extJButton.setForeground(Color.DARK_GRAY);
extJButton.setFont(new Font("Arial",Font.BOLD,25));
extJButton.setBackground(Color.white);
extJButton.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent ou)
    {
        c2.revalidate();
        c2.repaint();
        frame2.dispose();
    }
});
c2.add(extJButton);

      // labels
      JLabel label=new JLabel("Change Attendance of  worker");
      JLabel label1=new JLabel("Worker's name");
      JLabel label2=new JLabel("Date of the attendance");
      JLabel error=new JLabel(" ");
      JLabel error2=new JLabel("  ");
      JButton button=new JButton("Apply");
      
      label.setForeground(Color.WHITE);
      label.setBounds(350, 60, 900, 100);
      label.setFont(new Font("Arial",Font.BOLD,50));
      c2.add(label);
      label1.setForeground(Color.WHITE);
      label1.setBounds(200, 200, 900, 100);
      label1.setFont(new Font("Arial",Font.BOLD,35));
      c2.add(label1);
      label2.setForeground(Color.WHITE);
      label2.setBounds(200, 350, 900, 100);
      label2.setFont(new Font("Arial",Font.BOLD,35));
      c2.add(label2);
      error.setBounds(580,262,420,60);
      error.setForeground(Color.RED);
      error.setFont(new Font("Arial",Font.BOLD,22));
      c2.add(error);
      error2.setBounds(630,402,1520,60);
      error2.setForeground(Color.RED);
      error2.setFont(new Font("Arial",Font.BOLD,17));
      c2.add(error2); 

      field4.setBounds(580,240,400,40);
      field4.setForeground(Color.DARK_GRAY);
      field4.setBackground(Color.WHITE);
      field4.setFont(new Font("Arial",Font.BOLD,25));
      c2.add(field4);
      field5.setBounds(630,380,355,40);
      field5.setForeground(Color.DARK_GRAY);
      field5.setBackground(Color.WHITE);
      field5.setFont(new Font("Arial",Font.BOLD,25));
      c2.add(field5);

      for(Worker f2:super.worker)
      {
      button.setForeground(Color.DARK_GRAY);
button.setBounds(1100,580,150,50);
button.setFont(new Font("Arial",Font.BOLD,29));
button.setForeground(Color.DARK_GRAY);
button.setBackground(Color.WHITE);
c2.add(button);
button.addActionListener(new ActionListener()

{
JFrame frame1=new JFrame();
Container c1;
JTextField field=new JTextField();
JTextField field2=new JTextField();
JTextField field3=new JTextField();
JLabel label=new JLabel("Father's Name");
JLabel label1=new JLabel("Worker's name");
JLabel label2=new JLabel("Date of the attendance");
JLabel response2=new JLabel("");

    public void actionPerformed(ActionEvent e)
    {
        
        
        String worker_nam=null;
        String type_date=null;
        LocalDate check_date=null;
      try {
         worker_nam=field4.getText().toString();
         type_date=field5.getText().toString();
         check_date=LocalDate.parse(type_date);
          
      } catch (Exception forDate) {
          if(flag_message==false)
          {
          JOptionPane.showMessageDialog(null,"\nKindly,Enter date according to the following formates\n2020-09-03         or        2020-10-15");
          flag_message=true;  
        }
        if(f2.getName().equalsIgnoreCase(date_name))
        {
            flag_message=false;
        }
            date_flag=true;
      }
      if(date_flag==false)
      {

      if(f2.getName().equalsIgnoreCase(worker_nam))
      {
          error.setText(" ");
         for(LocalDate searching_date:f2.date)
         {
             
             if(searching_date.equals(check_date))
             {
                error2.setText(" ");
       indaex=f2.date.indexOf(searching_date);          
      Father_name=f2.getFather_name();
      frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    frame1.setTitle("                                                                                                                                                                                                Workers  Salary  Management  System");
     c1=frame1.getContentPane();
    c1.setBackground(Color.DARK_GRAY);
    c1.setLayout(null);

    label.setForeground(Color.WHITE);
    label.setBounds(400, 180, 900, 100);
    label.setFont(new Font("Arial",Font.BOLD,30));
    c1.add(label);
    
label1.setForeground(Color.WHITE);
label1.setBounds(400,  80, 900, 100);
label1.setFont(new Font("Arial",Font.BOLD,30));
c1.add(label1);
label2.setForeground(Color.WHITE);
label2.setBounds(400, 300, 900, 100);
label2.setFont(new Font("Arial",Font.BOLD,30));
c1.add(label2);
group.add(present);
group.add(aphsent);
group.add(Half);

field.setBounds(750,218,400,40);
field.setForeground(Color.DARK_GRAY);
field.setText(Father_name);
field.setFont(new Font("Arial",Font.BOLD,25));
field.setVisible(true);
c1.add(field);
field2.setBounds(750,335,400,40);
field2.setForeground(Color.DARK_GRAY);
field2.setFont(new Font("Arial",Font.BOLD,25));
field2.setText(type_date);
field2.setVisible(true);
c1.add(field2);
field3.setBounds(750,118,400,40);
field3.setForeground(Color.DARK_GRAY);
field3.setFont(new Font("Arial",Font.BOLD,25));
field3.setText(worker_nam);
field3.setVisible(true);
c1.add(field3);
JButton extJButton=new JButton("Exit");
extJButton.setBounds(100,660,120,50);
extJButton.setForeground(Color.DARK_GRAY);
extJButton.setFont(new Font("Arial",Font.BOLD,25));
extJButton.setBackground(Color.white);
extJButton.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent ev)
    {
        c1.revalidate();
        c1.repaint();
        frame1.dispose();
    }
});
c1.add(extJButton);

present.setBounds(300,500,200,80);
present.setBackground(Color.GREEN);
present.setForeground(Color.DARK_GRAY);
present.setFont(new Font("Arail",Font.BOLD,30));
aphsent.setBounds(700,500,200,80);
aphsent.setBackground(Color.RED);
aphsent.setForeground(Color.DARK_GRAY);
aphsent.setFont(new Font("Arail",Font.BOLD,30));
Half.setBounds(1100,500,200,80);
Half.setBackground(Color.ORANGE);
Half.setForeground(Color.DARK_GRAY);
Half.setFont(new Font("Arail",Font.BOLD,30));
response2.setBounds(390, 640,900,100);
response2.setFont(new Font("Arial",Font.BOLD,30));
c1.add(response2);
present.addActionListener(new ActionListener()
{
   
    public void actionPerformed(ActionEvent e1) 
    {
      
        f2.attendance.remove(indaex);  // removing the attendance which was takenn first from the record
        f2.attendance.add(indaex, "P");  // and the setting the attendace in the same indaex  
          response2.setForeground(Color.GREEN);
          response2.setText("Attendance of "+f2.getName()+" has been marked as a present");
    
    }
});
aphsent.addActionListener(new ActionListener() 
{
    
    public void actionPerformed(ActionEvent e2) 
    {
  
        f2.attendance.remove(indaex);  // removing the attendance which was takenn first from the record
        f2.attendance.add(indaex, "A");  // and the setting the attendace in the same indaex
        response2.setForeground(Color.RED);
        response2.setText("Attendance of "+f2.getName()+" has been marked as a absent");
    }
});
Half.addActionListener(new ActionListener()
{
    
    public void actionPerformed(ActionEvent e3) 
    {

        
        f2.attendance.remove(indaex);  // removing the attendance which was takenn first from the record
        f2.attendance.add(indaex, "Half");  // and the setting the attendace in the same indaex
        response2.setForeground(Color.ORANGE);
        response2.setText("Attendance of "+f2.getName()+" has been marked as a half presence");
    }
});
 
present.setVisible(true);
c1.add(present);
aphsent.setVisible(true);
c1.add(aphsent);
Half.setVisible(true);
c1.add(Half);
frame1.setVisible(true);
error_flag2=true;
    } 

}
    if(error_flag2==false)
    {
        error2.setText("Kindly,Enter correct date of that attendance ");
    }
    else if(error_flag2==true)
    {
        error_flag2=false;
    }

    error_flag=true;
      }
      
}else if(date_flag==true)
{

}
    }
    

});
      }
      
      frame2.setVisible(true);
  
    }catch(Exception someThing)
    {
    }
}
}
