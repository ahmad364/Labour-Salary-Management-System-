import controler.*;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JTextArea;

 public class Main implements ActionListener
    {
        Print_Record obj=new Print_Record();
   
        public  String name=null,phone_number=null,father_name=null;
        public  int waging=0;
        JFrame frame=new JFrame();
        JButton button=new JButton("Save");
        Container c;
        JTextField field;
        JTextField field1;
        JTextField field2;
        JTextField field3;
    
        JTextArea text=new JTextArea();
        JMenuBar menuBar=new JMenuBar();
        JMenu menu=new JMenu("Menu");
        JButton exiJMenu=new JButton("Exit");
        JMenuItem i1=new JMenuItem("Save Workers");
        JMenuItem i2=new JMenuItem("Save Workers");
        JMenuItem i3=new JMenuItem("Save Workers");
        JMenuItem i4=new JMenuItem("Save Workers");
        JMenuItem i5=new JMenuItem("Save Workers");
        JMenuItem i6=new JMenuItem("Save Workers");
        JMenuItem i7=new JMenuItem("Save Workers");
        JMenuItem i8=new JMenuItem("Save Workers");
        JMenuItem i9=new JMenuItem("Save Workers");
        JMenuItem i10=new JMenuItem("Save Workers");
        JMenuItem i11=new JMenuItem("Save Workers");
        JMenuItem i12=new JMenuItem("");
        JMenuItem i13=new JMenuItem(" ");
       
        public Main()
        {
            try {
                obj.read_worker();
                
            } catch (Exception e)
             {
                // when file of data base is empty and if in this condition we call method of red-Workers then there is exception
                // so with the help of exception we ressolve this issue
            }
           obj.frame();
        }
        public void firstPage()
        {
            String name="\n       Labour Salary\n  Management System";
            text.setFont(new Font("Arial",Font.BOLD,45));
            text.setBounds(550,280,500,220);
            text.setBackground(Color.WHITE);
            text.setForeground(Color.DARK_GRAY);
            text.setText(name);
            obj.c.add(text);
            text.setEditable(false);
        }
        public void Menu()
        {

        menuBar.setBackground(Color.DARK_GRAY); 

        menu.setFont(new Font("Arial",Font.BOLD,20));
        menu.setBackground(Color.DARK_GRAY);
        menu.setForeground(Color.WHITE);
         i1.setText("Save Workers");
        i1.setForeground(Color.DARK_GRAY);
        i1.setBackground(Color.WHITE);
        i1.setFont(new Font("Arial",Font.BOLD,20));
         i2.setText("Search Worker");
        i2.setForeground(Color.DARK_GRAY);
        i2.setBackground(Color.WHITE);
        i2.setFont(new Font("Arial",Font.BOLD,20));
         i3.setText("Remove Worker");
        i3.setForeground(Color.DARK_GRAY);
        i3.setBackground(Color.WHITE);
        i3.setFont(new Font("Arial",Font.BOLD,20));
        i4.setText("Names of All Workers");
        i4.setForeground(Color.DARK_GRAY);
        i4.setBackground(Color.WHITE);
        i4.setFont(new Font("Arial",Font.BOLD,20));
         i5.setText("Total Workers");
        i5.setForeground(Color.DARK_GRAY);
        i5.setBackground(Color.WHITE);
        i5.setFont(new Font("Arial",Font.BOLD,20));
         i6.setText("Attendance of Workers");
        i6.setForeground(Color.DARK_GRAY);
        i6.setBackground(Color.WHITE);
        i6.setFont(new Font("Arial",Font.BOLD,20));
         i7.setText("Change attendance of specific Worker");
        i7.setForeground(Color.DARK_GRAY);
        i7.setBackground(Color.WHITE);
        i7.setFont(new Font("Arial",Font.BOLD,20));
          i8.setText("Set Addvance rupees");
        i8.setForeground(Color.DARK_GRAY);
        i8.setBackground(Color.WHITE);
        i8.setFont(new Font("Arial",Font.BOLD,20));
         i9.setText("Record of all Workers");
        i9.setForeground(Color.DARK_GRAY);
        i9.setBackground(Color.WHITE);
        i9.setFont(new Font("Arial",Font.BOLD,20));
        i10.setText("Set remaining rupees");
        i10.setForeground(Color.DARK_GRAY);
        i10.setBackground(Color.WHITE);
        i10.setFont(new Font("Arial",Font.BOLD,20));
         i11.setText("Total of salaries of all workers");
        i11.setForeground(Color.DARK_GRAY);
        i11.setBackground(Color.WHITE);
        i11.setFont(new Font("Arial",Font.BOLD,20));
        i12.setText("Edit Worker");
        i12.setForeground(Color.DARK_GRAY);
        i12.setBackground(Color.WHITE);
        i12.setFont(new Font("Arial",Font.BOLD,20));
         i13.setText("Exit");
        i13.setForeground(Color.DARK_GRAY);
        i13.setBackground(Color.WHITE);
        i13.setFont(new Font("Arial",Font.BOLD,20));

        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);
        i6.addActionListener(this);
        i7.addActionListener(this);
        i8.addActionListener(this);
        i9.addActionListener(this);
        i10.addActionListener(this);
        i11.addActionListener(this);
        i12.addActionListener(this);
        i13.addActionListener(this);
        
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        menu.add(i4);
        menu.add(i5);
        menu.add(i6);
        menu.add(i7);
        menu.add(i8);
        menu.add(i9);
        menu.add(i10);
        menu.add(i11);
        menu.add(i12);
        menu.add(i13);

        menuBar.add(menu);

        obj.frame.setJMenuBar(menuBar);
        obj.frame.setVisible(true);
        }
        public void addWorkers()
        {
            // error label
            JLabel lable=new JLabel(" ");
            JButton extButton=new JButton("Exit");
           // frame
frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
frame.setTitle("Frame");
 c=frame.getContentPane();
c.setBackground(Color.DARK_GRAY);
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 frame.setResizable(false);
c.setLayout(null);
//Exit button
extButton.setBounds(245,650,135,50);
extButton.setForeground(Color.DARK_GRAY);
extButton.setFont(new Font("Arial",Font.BOLD,25));
extButton.setBackground(Color.white);
extButton.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent ev)
    {
        c.revalidate();
        c.repaint();
        lable.setText(" ");
        frame.dispose();
    }
});
c.add(extButton);
// jlabbel
JLabel label=new JLabel("Name");
JLabel label2=new JLabel("Save worker in the Record");
JLabel label3=new JLabel("Father Name");
JLabel label4=new JLabel("Phone Number");
JLabel label5=new JLabel("Wagging");//
// font
Font font=new Font("Arial",Font.BOLD,40);
Font font2=new Font("Arial",Font.BOLD,25);//
// j text field
JTextField field=new JTextField();
JTextField field1=new JTextField();
JTextField field2=new JTextField();
JTextField field3=new JTextField();//
//    JButton
Font font3=new Font("Arial",Font.BOLD,20);
 field.setBounds(800,180,310,30);
 c.add(field);
//field.setText(name); // for already written
 field.setFont(font3);  // set font for the above text which have been written as already text in text field
 field.setBackground(Color.WHITE); // set Background of text field
 field.setForeground(Color.DARK_GRAY); // setting color for the already text
 field1.setBounds(800,275,310,30);
 field1.setFont(font3);
 field1.setBackground(Color.WHITE);
 c.add(field1);
 field2.setBounds(800,375,310,30);
 field2.setFont(font3);
 field2.setBackground(Color.WHITE);
 c.add(field2);
 field3.setBounds(800,475,310,30);
 field3.setFont(font3);
 field3.setBackground(Color.WHITE);
 c.add(field3);
 field.setEditable(true);// for not allowing to edit by user
label2.setBounds(410,10,1200,100);
label2.setForeground(Color.WHITE );
label2.setFont(new Font("Arial",Font.BOLD,50));
c.add(label2);
label.setBounds(350,160,200,60);
label.setForeground(Color.WHITE);
label.setFont(font2);
c.add(label);
label3.setBounds(350,260,200,50);
label3.setForeground(Color.WHITE);
label3.setFont(font2);
c.add(label3);
label4.setBounds(350,360,200,50);
label4.setForeground(Color.WHITE);
label4.setFont(font2);
c.add(label4);
label5.setBounds(350,460,200,50);
label5.setForeground(Color.WHITE );
label5.setFont(font2);
c.add(label5);
// button

button.setBounds(1080, 650, 150,50);
button.setFont(new Font("Arial",Font.BOLD,30));
button.setForeground(Color.DARK_GRAY);
button.setBackground(Color.WHITE);
button.setCursor(new Cursor(Cursor.HAND_CURSOR));
// data
c.setLayout(null);
lable.setForeground(Color.RED);
lable.setBounds(800,510,400,25);
lable.setFont(new Font("Arial",Font.BOLD,17));
c.add(lable);

button.addActionListener(new ActionListener(){    public void actionPerformed(ActionEvent e)
    {
        lable.setText("");
        
        try {
           
            name=field.getText();
            father_name=field1.getText();
            phone_number=field2.getText();
            waging=Integer.parseInt(field3.getText());
            obj.add_Workers(new Worker(name,father_name,phone_number,waging));
            JOptionPane.showMessageDialog(null,name+" has been saved in the record");
            field.setText("");
            field1.setText("");
            field2.setText("");
            field3.setText("");
            
            
        } catch (Exception exv) 
        {
          
          field3.setText("");
          lable.setText("Kindly, Enter waging in the integer form");

        }
    }}); 

// add action of button
c.add(button);
button.setVisible(true);  
frame.setVisible(true);

        }
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==i1)
            {
              addWorkers();
              
            }
            else if(e.getSource()==i2)
            {
               obj.search_worker();  // will search and then disply
            }
            else if(e.getSource()==i3)
            {
                obj.remove_worker();
            }
            else if(e.getSource()==i4)
            {
                obj.print_name_of_all_workers();
            }
            else if(e.getSource()==i5)
            {
                obj.size_of_workers();
            }
            else if(e.getSource()==i6)
            {
                obj.setAttendance();
              
            }
            else if(e.getSource()==i7)
            {
               obj.setAttendance_of_specific_worker();  // set attnedance of spesifics worker
            }
            else if(e.getSource()==i8)
            {
                obj.set_addvance_rupees();
            }
            else if(e.getSource()==i9)
            {
             obj.print_Record_of_Every_worker();   
            }
            else if(e.getSource()==i10)
            {
              obj.set_Remaining_Rupees();
            }
            else if(e.getSource()==i11)
            {
                obj.sum_of_Salaries_of_all_workers();
            }
            else if(e.getSource()==i12)
            {
                obj.Edit_worker();
            }
            else if(e.getSource()==i13)
            {
                try {
                    obj.write_Workers();   
                } catch (Exception exe) {  }
                
                System.exit(0);
            }
        }

        public static void main(String args[])
        {
            Main workers=new Main();
             //  store_workers_in_files obj1=new store_workers_in_files();
      Print_Record obj=new Print_Record();//his is the class by which we can access data of all the 
    
    


         workers.firstPage();
         workers.Menu();


        }
    }