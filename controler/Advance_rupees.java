package controler;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

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

public class Advance_rupees extends Attendance implements ActionListener
{
    //declaring ui componenets
    JTextField field=new JTextField();
    JTextField field2=new JTextField();
    JLabel error=new JLabel(" ");
    JLabel error2=new JLabel(" ");

    // declaring all the variables which we need to declare 
    public int advance_rupees;
    public String string_advance_rupees;  
    public String name=null;
    
    boolean flage=false;
    boolean flage2=false;
    
    public void set_addvance_rupees()
    { 

  try
   {
    
      JFrame frame1=new JFrame();
      Container c1; 
      frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame1.setTitle("                                                                                                                                                                                                Workers  Salary  Management  System");
      c1=frame1.getContentPane();
      c1.setBackground(Color.DARK_GRAY);
      c1.setLayout(null);

      JButton extJButton=new JButton("Exit");

      extJButton.setBounds(240,580,135,50);
      extJButton.setForeground(Color.DARK_GRAY);
      extJButton.setFont(new Font("Arial",Font.BOLD,25));
      extJButton.setBackground(Color.white);

      extJButton.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent ou)
    {
        c1.revalidate();
        c1.repaint();
        frame1.dispose();
    }
    });

    // adding exit button in container
    c1.add(extJButton);

      // labels
      JLabel label=new JLabel("Set addvance rupees of the worker");
      JLabel label1=new JLabel("Worker Name");
      JLabel label2=new JLabel("Addvance Rupees");
     
      JButton button=new JButton("Set");
      
      // setting properties of labels
      label.setForeground(Color.WHITE);
      label.setBounds(320, 60, 900, 100);
      label.setFont(new Font("Arial",Font.BOLD,50));
      c1.add(label);

      label1.setForeground(Color.WHITE);
      label1.setBounds(300, 200, 900, 100);
      label1.setFont(new Font("Arial",Font.BOLD,35));
      c1.add(label1);

      label2.setForeground(Color.WHITE);
      label2.setBounds(300, 350, 900, 100);
      label2.setFont(new Font("Arial",Font.BOLD,35));
      c1.add(label2);

      error.setBounds(780,262,420,60);
      error.setForeground(Color.RED);
      error.setFont(new Font("Arial",Font.BOLD,22));
      c1.add(error);

      error2.setBounds(780,402,420,60);
      error2.setForeground(Color.RED);
      error2.setFont(new Font("Arial",Font.BOLD,17));
      c1.add(error2); 

      
      field.setBounds(780,240,400,40);
      field.setForeground(Color.DARK_GRAY);
      field.setBackground(Color.WHITE);
      field.setFont(new Font("Arial",Font.BOLD,25));
      c1.add(field);

      field2.setBounds(780,380,400,40);
      field2.setForeground(Color.DARK_GRAY);
      field2.setBackground(Color.WHITE);
      field2.setFont(new Font("Arial",Font.BOLD,25));
      c1.add(field2);

      // set button
      button.setForeground(Color.DARK_GRAY);
      button.setBounds(1140,580,150,50);
      button.setFont(new Font("Arial",Font.BOLD,29));
      button.setForeground(Color.DARK_GRAY);
      button.setBackground(Color.WHITE);

      // adding in the container
      c1.add(button);
      button.addActionListener(this);
      frame1.setVisible(true);
    }catch(Exception maybe)
    {   }

    }

    public void actionPerformed(ActionEvent e)
    {
        name=field.getText();

        // checking entered name exist or not
        for(Worker f1:super.worker)
        {
            if(f1.getName().equalsIgnoreCase(name))
            {
                error.setText(" ");
            }
        }
        
        error2.setText(" ");

        try
        {
        advance_rupees=Integer.parseInt(field2.getText());// converting string to int
        }
        catch (NumberFormatException ex)
                 {
                    error2.setText("Kindly,Enter addvance rupees in the integer form");
                }

        for(Worker f:super.worker)
        {
            if(f.getName().equalsIgnoreCase(name))
            {
                error.setText(" ");
                error2.setText(" ");
                flage=true;
                try
                {
                advance_rupees=Integer.parseInt(field2.getText());// converting string to int
                }
                catch (NumberFormatException ex)
                         {
                            error2.setText("Kindly,Enter addvance rupees in the integer form");
                            flage2=true;
                        }
               if(flage2==false)
                 {      

                f.advance_rupees=f.advance_rupees+advance_rupees;
                f.setAddvance_rupees(f.advance_rupees);  // storeing the advance rupees 
                flage=true;
                JOptionPane.showMessageDialog(null,"The addvance rupees have been saved in the record of "+name);
                
                  } 
                  else if(flage2==true)
                  {
                        flage2=false;
                  }
            }
        }
        if(flage==false)
        {

        error.setText("Kindly, Enter correct name of worker");
        
        }
        else if(flage==true)
        {
            flage=false;
        }
    }
    
}