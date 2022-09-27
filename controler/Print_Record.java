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

import controler.Advance_rupees;
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
public class Print_Record extends Advance_rupees
{
    // the declaration of all the variables which are required for checking conditions and storeing date in the following
    private int i;
    private int j;
    private int result,result1,result3,result4;  // thses are the varialbes for responsing input are used like yes or no
    private boolean flag=false;  // for the implementing the condition
    JFrame frame1=new JFrame();
    Container c1;
    JPanel panel=new JPanel();
    JPanel panel2=new JPanel();
    JPanel panel3=new JPanel();
    JPanel panel4=new JPanel();
    JLabel hading=new JLabel("");
    JButton extButton=new JButton("Exit");
    JPanel forHaPanel=new JPanel();
    JPanel forNPanel=new JPanel();

    public void print_Record_of_Every_worker()
    {
        try
        {
          
          frame1.setVisible(true);
        
          frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame1.setTitle("                                                                                                                                                                                                Workers  Salary  Management  System");
         c1=frame1.getContentPane();
        c1.setBackground(Color.DARK_GRAY);
      
        c1.setLayout(null);
        
        // heading
        hading.setText("Get record of all workers");
        hading.setBounds(420,100,900,80);
        hading.setForeground(Color.WHITE);
        hading.setFont(new Font("Arial",Font.BOLD,55));
        c1.add(hading);
        //
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

        //
        extButton.setBounds(650,600,120,50);
        extButton.setForeground(Color.DARK_GRAY);
        extButton.setFont(new Font("Arial",Font.BOLD,25));
        extButton.setBackground(Color.white);
        c1.add(extButton);
        extButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {

               
                frame1.dispose();
            }
        });

JComboBox<String> names=new JComboBox<>(names1);
  names.setBounds(250,330,300,70);
  names.setForeground(Color.DARK_GRAY);
  names.setBackground(Color.white);
  names.setFont(new Font("Arial",Font.BOLD,25));
   c1.add(names);
   JButton attendanc=new JButton("Get Record");
   for(Worker f:super.worker)
   {
  attendanc.setBounds(900,330,300,70);
  attendanc.setForeground(Color.DARK_GRAY);
  attendanc.setBackground(Color.WHITE);
  attendanc.setCursor(new Cursor(Cursor.HAND_CURSOR));
  attendanc.setFont(new Font("Arial",Font.BOLD,30));
  attendanc.addActionListener(new ActionListener()
 
  {
   
      JFrame frame=new JFrame();
      Container c;

      public void actionPerformed(ActionEvent e)
      {
      
    
        String name=names.getSelectedItem().toString();
          if(f.getName().equalsIgnoreCase(name))
          {
              
           
            
            JLabel namel=new JLabel("Name");
            JLabel fater_name=new JLabel("Father Name");
            JLabel waging=new JLabel("Waging");
            JLabel Presents=new JLabel("Presents");
            JLabel Leaves=new JLabel("Leaves");
            JLabel half=new JLabel("Half Presence");
            JLabel salary=new JLabel(" Total Salary");
            JLabel addvance_rupees=new JLabel("Addvance rupees");
            JLabel remaning_rupees=new JLabel("Remaining rupees");
            JLabel type_remaining_rupees=new JLabel("Enter remianing rupees");
          
            
      
            JButton hading=new JButton("Record of the worker");
            JTextField namField=new JTextField();
            JTextField FatherField=new JTextField();
            JTextField leaveField=new JTextField();
            JTextField wagingField=new JTextField();
            JTextField presentField=new JTextField();
            JTextField halfField=new JTextField();
            JTextField aphsentField=new JTextField();
            JTextField addvanceField=new JTextField();
            JTextField salaryField=new JTextField();
            JTextField advanceField=new JTextField();
            JTextField remaningField=new JTextField();
            JTextField tRemaningField=new JTextField();
            JCheckBox addvacnCheckBox=new JCheckBox();
            JCheckBox cutCheckBox=new JCheckBox();
            JButton save=new JButton("Save");
            f.days_of_working.clear();
            f.get_days_of_working();
            JComboBox<String> days_working=new JComboBox<String>();
            // adding items
            for(String f7:f.days_of_working)
            days_working.addItem(f7);

            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setTitle("                                                                                                                                                                                                          Workers  Salary  Management  System");
     c=frame.getContentPane();
    c.setBackground(Color.DARK_GRAY);
    c.setLayout(null);
    days_working.setBounds(800,370,580,50);
    days_working.setForeground(Color.DARK_GRAY);
    
    days_working.setFont(new Font("Arial",Font.BOLD,25));
     c.add(days_working);
   hading.setBackground(Color.LIGHT_GRAY);
   hading.setFont(new Font("Arial",Font.BOLD,35));
   hading.setForeground(Color.DARK_GRAY);
   hading.setBounds(-10,8,1550,40);
   c.add(hading);
   namel.setBounds(60,80,200,35);
   namel.setFont(new Font("Arial",Font.BOLD,30));
   namel.setForeground(Color.white);
   c.add(namel);
   namField.setBounds(240,85,320,32);
   namField.setForeground(Color.DARK_GRAY);
   namField.setFont(new Font("Arial",Font.BOLD,22));
   namField.setBackground(Color.white);
   namField.setText(" "+name);
   c.add(namField);
   fater_name.setBounds(60,180,200,35);
   fater_name.setFont(new Font("Arial",Font.BOLD,30));
   fater_name.setForeground(Color.white);
   c.add(fater_name);
   FatherField.setBounds(285,185,275,32);
   FatherField.setForeground(Color.DARK_GRAY);
   FatherField.setFont(new Font("Arial",Font.BOLD,22));
   FatherField.setBackground(Color.white);
   FatherField.setText(" "+f.getFather_name());
   c.add(FatherField);
   waging.setBounds(60,280,200,35);
   waging.setFont(new Font("Arial",Font.BOLD,30));
   waging.setForeground(Color.white);
   c.add(waging);
   wagingField.setBounds(240,285,320,32);
   wagingField.setForeground(Color.DARK_GRAY);
   wagingField.setFont(new Font("Arial",Font.BOLD,22));
   wagingField.setBackground(Color.white);
   wagingField.setText(" "+f.getWaging());
   c.add(wagingField);
   Presents.setBounds(800,80,1020,35);
   Presents.setFont(new Font("Arial",Font.BOLD,30));
   Presents.setForeground(Color.white);
   c.add(Presents);
   presentField.setBounds(1020,85,320,32);
   presentField.setForeground(Color.DARK_GRAY);
   presentField.setFont(new Font("Arial",Font.BOLD,22));
   presentField.setBackground(Color.GREEN);
   presentField.setText(" "+f.getPresent());
   c.add(presentField);
   Leaves.setBounds(800,280,200,35);
   Leaves.setFont(new Font("Arial",Font.BOLD,30));
   Leaves.setForeground(Color.white);
   c.add(Leaves);
   leaveField.setBounds(1020,285,322,32);
   leaveField.setForeground(Color.DARK_GRAY);
   leaveField.setFont(new Font("Arial",Font.BOLD,22));
   leaveField.setBackground(Color.RED);
   leaveField.setText(" "+f.getAphsent());
   c.add(leaveField);
   half.setBounds(800,180,600,35);
   half.setFont(new Font("Arial",Font.BOLD,30));
   half.setForeground(Color.white);
   c.add(half);
   halfField.setBounds(1070,185,270,32);
   halfField.setForeground(Color.DARK_GRAY);
   halfField.setFont(new Font("Arial",Font.BOLD,22));
   halfField.setBackground(Color.ORANGE);
   halfField.setText(" "+f.get_no_of_day_of_half_working());
   c.add(halfField);
   remaning_rupees.setBounds(60,380,500,35);
   remaning_rupees.setFont(new Font("Arial",Font.BOLD,30));
   remaning_rupees.setForeground(Color.white);
   c.add(remaning_rupees);
   remaningField.setBounds(400,385,250,32);
   remaningField.setForeground(Color.DARK_GRAY);
   remaningField.setFont(new Font("Arial",Font.BOLD,22));
   remaningField.setBackground(Color.white);
   remaningField.setText(" "+f.getRemaning());
   c.add(remaningField);
   type_remaining_rupees.setBounds(60,480,500,35);
   type_remaining_rupees.setFont(new Font("Arial",Font.BOLD,30));
   type_remaining_rupees.setForeground(Color.white);
   c.add(type_remaining_rupees);
   tRemaningField.setBounds(424,485,130,32);
   tRemaningField.setForeground(Color.DARK_GRAY);
   tRemaningField.setFont(new Font("Arial",Font.BOLD,22));
   tRemaningField.setBackground(Color.white);
   c.add(tRemaningField);
   save.setBounds(550,485,100,32);
   save.setFont(new Font("Arial",Font.BOLD,22));
   save.setForeground(Color.DARK_GRAY);
   save.addActionListener(new ActionListener()
   {
       
       public void actionPerformed(ActionEvent save)
        {
           try {
               int rem_rupees=Integer.parseInt(tRemaningField.getText());
            f.setRemaning(rem_rupees);
            remaningField.setText(" "+rem_rupees);

           } catch (Exception e) {
        
           }
           
       }
   });
   c.add(save);
    addvance_rupees.setBounds(60,580,500,35);
    addvance_rupees.setFont(new Font("Arial",Font.BOLD,30));
    addvance_rupees.setForeground(Color.white);
    c.add(addvance_rupees);
    addvanceField.setBounds(400,585,250,32);
    addvanceField.setForeground(Color.DARK_GRAY);
    addvanceField.setFont(new Font("Arial",Font.BOLD,22));
    addvanceField.setBackground(Color.white);
    addvanceField.setText(" "+f.getAddvance_rupees());
     c.add(addvanceField);
     salary.setBounds(800,480,500,35);
     salary.setFont(new Font("Arial",Font.BOLD,30));
     salary.setForeground(Color.white);
     c.add(salary);
     salaryField.setBounds(1020,485,300,32);
     salaryField.setForeground(Color.DARK_GRAY);
     salaryField.setFont(new Font("Arial",Font.BOLD,22));
     salaryField.setBackground(Color.white);
     salaryField.setText(" "+f.getSalary());
      c.add(salaryField);

      cutCheckBox.setText("Do you want to cut the record of "+f.getName()+" ?");
      cutCheckBox.setFont(new Font("Arial",Font.BOLD,26));
      
      cutCheckBox.setBounds(800,585,590,50);
      cutCheckBox.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent cut)
          {
            f.attendance.clear();
            f.date.clear();
            f.day_name.clear();
            f.days_of_working.clear();
              presentField.setText(" "+f.getPresent());
              aphsentField.setText(" "+f.getAphsent());
              halfField.setText(" "+f.get_no_of_day_of_half_working());
              salaryField.setText(" "+f.getSalary());
              days_working.removeAllItems();
              f.setRemaning(0);

          }
      });
      c.add(cutCheckBox);
     addvacnCheckBox.setText("Do you want to cut addvance rupees from the salary?");
     addvacnCheckBox.setFont(new Font("Arial",Font.BOLD,22));
     addvacnCheckBox.setBounds(60,680,600,50);
    
     addvacnCheckBox.addActionListener(new ActionListener()
     {
         public void actionPerformed(ActionEvent cutAddvance)
         {
             // this method will cut the advance rupees from the salary and disply remaing salary after cutting advance rupees
             f.cut_addvance_rupees_from_salary();
          //   JOptionPane.showMessageDialog(null,"\nAfter cutting advance rupees\n\nSalary is  :  "+f.get_salalry_after_cutting_addvance_rupees()+"\n\n");
             salaryField.setText(" "+f.get_salalry_after_cutting_addvance_rupees());   
          if(f.get_salalry_after_cutting_addvance_rupees()<=0)
          {
             f.setAddvance_rupees(Math.abs(f.get_salalry_after_cutting_addvance_rupees())); // if salary of worker is less than the advance rupees then remaing rupees is set as advance rupees
             addvanceField.setText(" "+f.getAddvance_rupees());
            }
             if(f.get_salalry_after_cutting_addvance_rupees()>=0)
             {
             f.setAddvance_rupees(0);
             addvanceField.setText(" "+f.getAddvance_rupees());
            }}
     });
     c.add(addvacnCheckBox);
    JButton extJButton=new JButton("Exit");
    extJButton.setBounds(1100,690,135,50);
    extJButton.setForeground(Color.DARK_GRAY);
    extJButton.setFont(new Font("Arial",Font.BOLD,25));
    extJButton.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ou)
        {
            days_working.removeAll();
            SwingUtilities.updateComponentTreeUI(frame);
                frame.invalidate();
                frame.validate();
                frame.repaint();
            frame.dispose();
        }
    });
    c.add(extJButton);

    frame.setVisible(true);
      }
    }
  }

  );
  c1.add(attendanc);
c1.setVisible(true);
  frame1.setVisible(true);
    }
        }catch(Exception anything)
        {
            ///////////
        }
    
}
    
}