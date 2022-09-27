package controler;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import controler.Worker;

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
public class WorkerOrganizer 
{
// gui
  public JFrame frame=new JFrame();
    public Container c; 
   
     public String name=null;
     public String name2=null;
     public boolean flage=false;
     public boolean flage2=false;
     public String name3=null;
     // declaring all the variables which we need to declare 
    public int remanining_rupees=0;
    public String string_advance_rupees=null;  
    public String name1=null;
    
    boolean flage3=false;
    boolean flage4=false;
    // all the variables have be declared in different methods accordint to need
  public  ArrayList<Worker> worker=new ArrayList<>();
        // this method will add workers in arraylist
        
   public void add_Workers(Worker w) 
   {  
      
       worker.add(w);
       
       
   }
   // this method will write objects into array list
   public void write_Workers() throws FileNotFoundException,IOException,ClassNotFoundException
   {
       
        ObjectOutputStream write_workers=new ObjectOutputStream(new FileOutputStream("Database.txt"));
        write_workers.writeObject(worker);
        write_workers.close(); 
       

   }
   // this mthod will read data from file and store into array list
   @SuppressWarnings("unchecked")
   public void read_worker() throws FileNotFoundException,IOException,ClassNotFoundException
   { 
    ObjectInputStream read=new ObjectInputStream(new FileInputStream("DataBase.txt"));
     worker=(ArrayList<Worker>)read.readObject();
     read.close();
     
      
   }

    // this method will search worker and then print record of that worker
    public void search_worker() 
    
    {
       
        JFrame frame1=new JFrame();
        Container c1; 
        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setTitle("                                                                                                                                                                                                Workers  Salary  Management  System");
        c1=frame1.getContentPane();
      c1.setBackground(Color.DARK_GRAY);
      c1.setLayout(null);
  // button
  JButton extButton=new JButton("Exit");
  extButton.setBounds(100,590,135,50);
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

        JLabel label6=new JLabel("Enter the name of worker who you want to find ");
        JLabel label2=new JLabel("The searched Worker is in the following ");
        JLabel error=new JLabel("");
        JTextField field1=new JTextField();
        JButton button=new JButton("Search");

        // font
Font font=new Font("Arial",Font.BOLD,40);
Font font2=new Font("Arial",Font.BOLD,25);
Font font3=new Font("Arial",Font.BOLD,20);

label6.setBounds(380,120,1000,60);
label6.setForeground(Color.WHITE);
label6.setFont(new Font("Arial",Font.BOLD,40));
error.setBounds(580,270,420,60);
error.setForeground(Color.RED);
error.setFont(new Font("Arial",Font.BOLD,22));
c1.add(error);
label6.setFont(new Font("Arial",Font.BOLD,40));
c1.add(label6);
field1.setBounds(580,240,420,40);
field1.setFont(font3);
field1.setBackground(Color.WHITE);

c1.add(field1);
button.setForeground(Color.DARK_GRAY);
button.setBounds(700,350,180,60);
button.setFont(new Font("Arial",Font.BOLD,29));
button.setForeground(Color.DARK_GRAY);
button.setBackground(Color.WHITE);
c1.add(button);
button.setVisible(true);  

button.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
        name=field1.getText();
        
        if(e.getSource()==button)
        {
           

        for(Worker f:worker)
        {

            if(f.getName().equalsIgnoreCase(name))   // camparing name of worker annd after it print record
            {
                error.setText(" ");
             JFrame frame2=new JFrame();
             Container c2;   
             frame2.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame2.setTitle("                                                                                                                                                                                                Workers  Salary  Management  System");
                 c2=frame2.getContentPane();
                c2.setBackground(Color.DARK_GRAY);
                c2.setLayout(null);
            
label2.setBounds(350,100,1000,60);
label2.setForeground(Color.WHITE);
label2.setFont(font);
c2.add(label2);
// button
JButton extButton=new JButton("Exit");
extButton.setBounds(100,670,135,50);
extButton.setForeground(Color.DARK_GRAY);
extButton.setFont(new Font("Arial",Font.BOLD,25));
extButton.setBackground(Color.white);
extButton.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent ev)
    {
        c2.revalidate();
        c2.repaint();
        frame2.dispose();
    }
});
c2.add(extButton);

JLabel label=new JLabel("Name");
JLabel label3=new JLabel("Father Name");
JLabel label4=new JLabel("Phone Number");
JLabel label5=new JLabel("Wagging");


// j text field

JTextField field4=new JTextField();
JTextField field5=new JTextField();
JTextField field6=new JTextField();
JTextField field7=new JTextField();

 field4.setBounds(710,240,310,30);
 c2.add(field4);
 field4.setFont(font3);  // set font for the above text which have been written as already text in text field
 field4.setBackground(Color.WHITE); // set Background of text field
 field4.setForeground(Color.DARK_GRAY); // setting color for the already text
 field5.setBounds(710,335,310,30);
 field5.setFont(font3);
 field5.setBackground(Color.WHITE);
 c2.add(field5);
 field6.setBounds(710,435,310,30);
 field6.setFont(font3);
 field6.setBackground(Color.WHITE);
 c2.add(field6);
 field7.setBounds(710,535,310,30);
 field7.setFont(font3);
 field7.setBackground(Color.WHITE);
 c2.add(field7);
 try{
    field4.setText(f.getName());
    field5.setText(f.getFather_name());
    field6.setText(f.getPhone_number());
    field7.setText(String.valueOf(f.getWaging()));
    
    } catch(Exception ex)
    {
        ///
    }

label.setBounds(400,220,200,60);
label.setForeground(Color.WHITE);
label.setFont(font2);
c2.add(label);
label3.setBounds(400,320,200,50);
label3.setForeground(Color.WHITE);
label3.setFont(font2);
c2.add(label3);
label4.setBounds(400,420,200,50);
label4.setForeground(Color.WHITE);
label4.setFont(font2);
c2.add(label4);
label5.setBounds(400,520,200,50);
label5.setForeground(Color.WHITE );
label5.setFont(font2);
c2.add(label5);
frame2.setVisible(true);
flage=true;
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
});


frame1.setVisible(true);
        
    }
    // this method will take name from user and the  remove that worker from the record
   public void remove_worker()
   {
       
    JFrame frame1=new JFrame();
    Container c1; 
    frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
  frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
  frame1.setTitle("                                                                                                                                                                                                Workers  Salary  Management  System");
   c1=frame1.getContentPane();
  c1.setBackground(Color.DARK_GRAY);
  c1.setLayout(null);
  JButton extButton=new JButton("Exit");
  extButton.setBounds(100,590,135,50);
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

    JLabel label6=new JLabel("Enter the name of worker who you want to remove ");
    JLabel error=new JLabel("");
    JTextField field1=new JTextField();
    JButton button=new JButton("Remove");

    // font
Font font=new Font("Arial",Font.BOLD,40);
Font font2=new Font("Arial",Font.BOLD,25);
Font font3=new Font("Arial",Font.BOLD,20);

label6.setBounds(380,120,1000,60);
label6.setForeground(Color.WHITE);
label6.setFont(new Font("Arial",Font.BOLD,40));
error.setBounds(580,270,420,60);
error.setForeground(Color.RED);
error.setFont(new Font("Arial",Font.BOLD,22));
c1.add(error);
label6.setFont(new Font("Arial",Font.BOLD,40));
c1.add(label6);
field1.setBounds(580,240,420,40);
field1.setFont(font3);
field1.setBackground(Color.WHITE);

c1.add(field1);
button.setForeground(Color.DARK_GRAY);
button.setBounds(700,350,180,60);
button.setFont(new Font("Arial",Font.BOLD,29));
button.setForeground(Color.DARK_GRAY);
button.setBackground(Color.WHITE);
c1.add(button);
button.setVisible(true);  
button.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
        name2=field1.getText();
        if(e.getSource()==button)
        {
        Iterator<Worker> itr=worker.iterator();
        while(itr.hasNext())
        {
            
            if(itr.next().getName().equalsIgnoreCase(name2)) //comparing
            {
                error.setText(" ");
            itr.remove();
            JOptionPane.showMessageDialog(null,name2+" has been deleted from the record");
            flage2=true;
        }

        }
    }
    if(flage2==false)
    {
    error.setText("Kindly, Enter correct name of worker");
    
    }
    else if(flage2==true)
    {
        flage2=false;
    }

}
});
frame1.setVisible(true);
}
      // this method will print name of all workers
   public void print_name_of_all_workers() 
   {
      
       String[] names1= new String[100000];
       names1[0]="The names of workers";
    ArrayList<JLabel> list=new ArrayList<>();
    int i=1;
       for(Worker f:worker)
       {
           try {
            names1[i]=f.getName();
            i++;
            
           } catch (Exception e) {
            
           }
       
        
       }
       JFrame frame1=new JFrame();
       Container c1; 
       frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
     frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
     frame1.setTitle("                                                                                                                                                                                                Workers  Salary  Management  System");
      c1=frame1.getContentPane();
     c1.setBackground(Color.DARK_GRAY);
     c1.setLayout(null);
     JLabel heading=new JLabel("The names of all workers");
  heading.setForeground(Color.WHITE);
  heading.setBounds(400, 60, 900, 100);
  heading.setFont(new Font("Arial",Font.BOLD,55));
  c1.add(heading);
     JButton extButton=new JButton("Exit");
     extButton.setBounds(100,590,135,50);
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
     names.setBounds(600,300,300,70);
     names.setForeground(Color.DARK_GRAY);
     names.setBackground(Color.white);
     names.setFont(new Font("Arial",Font.BOLD,25));
     c1.add(names);
 frame1.setVisible(true);     

   }
    // this method will tell you about totao number of workers
   public void size_of_workers() 
   {
    JFrame frame1=new JFrame();
    Container c1; 
  frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
  frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
  frame1.setTitle("                                                                                                                                                                                                Workers  Salary  Management  System");
   c1=frame1.getContentPane();
  c1.setBackground(Color.DARK_GRAY);
  c1.setLayout(null);
  JLabel heading=new JLabel("Total numbers of workers");
  heading.setForeground(Color.WHITE);
  heading.setBounds(375, 60, 900, 100);
  heading.setFont(new Font("Arial",Font.BOLD,55));
  c1.add(heading);
  JButton extButton=new JButton("Exit");
  extButton.setBounds(100,590,135,50);
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

  JLabel lab=new JLabel();
  lab.setBounds(480,220,800,200);
  lab.setFont(new Font("Arial",Font.BOLD,40));
  lab.setForeground(Color.WHITE);
  lab.setText("The total workers are : "+worker.size());
  c1.add(lab);
  frame1.setVisible(true);
    
   }
   // this method will change the name ,phone number adn waging of the worker
   public void Edit_worker() 
   {
          
    JFrame frame5=new JFrame();
    Container c5; 
    frame5.setExtendedState(JFrame.MAXIMIZED_BOTH);
  frame5.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
  frame5.setTitle("                                                                                                                                                                                                Workers  Salary  Management  System");
   c5=frame5.getContentPane();
  c5.setBackground(Color.DARK_GRAY);
  c5.setLayout(null);
  JButton extButton=new JButton("Exit");
  extButton.setBounds(100,590,135,50);
  extButton.setForeground(Color.DARK_GRAY);
  extButton.setFont(new Font("Arial",Font.BOLD,25));
  extButton.setBackground(Color.white);
  extButton.addActionListener(new ActionListener()
  {
      public void actionPerformed(ActionEvent ev)
      {
          c5.revalidate();
          c5.repaint();
          frame5.dispose();
      }
  });
  c5.add(extButton);
    JLabel label6=new JLabel("Enter the name of worker who you want to Edit  ");
    JLabel error=new JLabel("");
    JTextField field1=new JTextField();
    JButton button5=new JButton("Enter");

    // font
Font font=new Font("Arial",Font.BOLD,40);
Font font2=new Font("Arial",Font.BOLD,25);
Font font3=new Font("Arial",Font.BOLD,20);

label6.setBounds(380,120,1000,60);
label6.setForeground(Color.WHITE);
label6.setFont(new Font("Arial",Font.BOLD,40));
error.setBounds(580,270,420,60);
error.setForeground(Color.RED);
error.setFont(new Font("Arial",Font.BOLD,22));
c5.add(error);
label6.setFont(new Font("Arial",Font.BOLD,40));
c5.add(label6);
field1.setBounds(580,240,420,40);
field1.setFont(font3);
field1.setBackground(Color.WHITE);

c5.add(field1);
button5.setForeground(Color.DARK_GRAY);
button5.setBounds(700,350,180,60);
button5.setFont(new Font("Arial",Font.BOLD,29));
button5.setForeground(Color.DARK_GRAY);
button5.setBackground(Color.WHITE);
c5.add(button5);
button5.setVisible(true);  
button5.addActionListener(new ActionListener()
{
    JFrame frame6=new JFrame();
Container c6;
    public void actionPerformed(ActionEvent e)
    {
        JButton button=new JButton("Save");
error.setText(" ");

frame6.setExtendedState(JFrame.MAXIMIZED_BOTH);
frame6.setTitle("                                                                                                                                                                                                Workers  Salary  Management  System");
 c6=frame6.getContentPane();
c6.setBackground(Color.DARK_GRAY);
frame6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 frame6.setResizable(false);
c6.setLayout(null);
JButton extJButton=new JButton("Exit");
extJButton.setBounds(225,650,135,50);
extJButton.setForeground(Color.DARK_GRAY);
extJButton.setFont(new Font("Arial",Font.BOLD,25));
extJButton.setBackground(Color.white);
extJButton.addActionListener(new ActionListener()
{
    public void actionPerformed(ActionEvent ou)
    {
        c6.revalidate();
        c6.repaint();
        frame6.dispose();
    }
});
c6.add(extJButton);
        name3=field1.getText();
        if(e.getSource()==button5)
        {
     for(Worker f: worker)
     {
         if(f.getName().equalsIgnoreCase(name3))
         {

// jlabbel
JLabel label=new JLabel("Name");
JLabel label2=new JLabel("Edit the record of worker");
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
 field.setBounds(800,160,310,30);
 c6.add(field);
//field.setText(name); // for already written
 field.setFont(font3);  // set font for the above text which have been written as already text in text field
 field.setBackground(Color.WHITE); // set Background of text field
 field.setForeground(Color.DARK_GRAY); // setting color for the already text
 field1.setBounds(800,255,310,30);
 field1.setFont(font3);
 field1.setBackground(Color.WHITE);
 c6.add(field1);
 field2.setBounds(800,355,310,30);
 field2.setFont(font3);
 field2.setBackground(Color.WHITE);
 c6.add(field2);
 field3.setBounds(800,455,310,30);
 field3.setFont(font3);
 field3.setBackground(Color.WHITE);
 c6.add(field3);
 field.setText(f.getName());
 field1.setText(f.getFather_name());
 field2.setText(f.getPhone_number());
 field3.setText(String.valueOf(f.getWaging()));
 field.setEditable(true);// for not allowing to edit by user
label2.setBounds(450,10,600,100);
label2.setForeground(Color.WHITE );
label2.setFont(font);
c6.add(label2);
label.setBounds(300,140,200,60);
label.setForeground(Color.WHITE);
label.setFont(font2);
c6.add(label);
label3.setBounds(300,240,200,50);
label3.setForeground(Color.WHITE);
label3.setFont(font2);
c6.add(label3);
label4.setBounds(300,340,200,50);
label4.setForeground(Color.WHITE);
label4.setFont(font2);
c6.add(label4);
label5.setBounds(300,440,200,50);
label5.setForeground(Color.WHITE );
label5.setFont(font2);
c6.add(label5);
// button

button.setBounds(1080, 650, 150,50);
button.setFont(new Font("Arial",Font.BOLD,30));
button.setForeground(Color.DARK_GRAY);
button.setBackground(Color.WHITE);
button.setCursor(new Cursor(Cursor.HAND_CURSOR));
// data
JLabel lable=new JLabel(" ");
c6.setLayout(null);
lable.setForeground(Color.RED);
lable.setBounds(800,490,400,25);
lable.setFont(new Font("Arial",Font.BOLD,17));
c6.add(lable);
button.addActionListener(new ActionListener(){  
    
    public void actionPerformed(ActionEvent e)
    {
        lable.setText("");
        
        try {
           
         String  n=field.getText();
         String father_name=field1.getText();
         String phone_number=field2.getText();
         int waging=Integer.parseInt(field3.getText());
        f.setName(n);
        f.setFather_name(father_name);
        f.setPhone_number(phone_number);
        f.setWaging(waging);
       JOptionPane.showMessageDialog(null,name3+" has been saved in the record after changing its record");
            
            
        } catch (NumberFormatException exv) 
        {
           
          lable.setText("Kindly, Enter waging in the integer form");

        }
    }}); 

// add action of button
c6.add(button);
button.setVisible(true);  
frame6.setVisible(true);
flage2=true;
     }
    }
    }
    if(flage2==false)
    {
    error.setText("Kindly, Enter correct name of worker");
    
    }
    else if(flage2==true)
    {
        flage2=false;
    }

}
});


frame5.setVisible(true);


    
   }
// this method will sum of rupees of all salaries of workers
public void sum_of_Salaries_of_all_workers() 
{
    
    int sum_of_rupees=0;
    for(Worker f:worker)
    {
        sum_of_rupees=sum_of_rupees+f.getSalary();
    }
    
    JFrame frame1=new JFrame();
    Container c1; 
    frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
  frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
  frame1.setTitle("                                                                                                                                                                                                Workers  Salary  Management  System");
   c1=frame1.getContentPane();
  c1.setBackground(Color.DARK_GRAY);
  c1.setLayout(null);
  JLabel heading=new JLabel("Total of salaries of all workers");
  heading.setForeground(Color.WHITE);
  heading.setBounds(350, 60, 900, 100);
  heading.setFont(new Font("Arial",Font.BOLD,55));
  c1.add(heading);
  JButton extButton=new JButton("Exit");
  extButton.setBounds(100,590,135,50);
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
  JLabel lab=new JLabel();
  lab.setBounds(310,220,1600,200);
  lab.setFont(new Font("Arial",Font.BOLD,40));
  lab.setForeground(Color.WHITE);
  lab.setText("The sum of salaries of all workers is  :  "+sum_of_rupees);
  c1.add(lab);
  frame1.setVisible(true);
}
public void frame()
{
    Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
    
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    //frame.setBounds(0,0,(int) dim.getWidth(),(int) dim.getHeight());
    //frame.setUndecorated(true);
    
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setTitle("                                                                                                                                                                                                Workers  Salary  Management  System");
    frame.setIconImage(new ImageIcon("Capture.PNG").getImage());
    c=frame.getContentPane();
    c.setBackground(Color.DARK_GRAY);
    c.setLayout(null);
    
}
public void set_Remaining_Rupees()
{
    JTextField field=new JTextField();
    JTextField field2=new JTextField();
    JLabel error=new JLabel(" ");
    JLabel error2=new JLabel(" ");
try
{
        JFrame frame1=new JFrame();
        Container c1; 
        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
c1.add(extJButton);

      // labels
      JLabel label=new JLabel("Set remaining rupees of the worker");
      JLabel label1=new JLabel("Worker Name");
      JLabel label2=new JLabel("Remaining Rupees");
     
      JButton button=new JButton("Set");
      
      label.setForeground(Color.WHITE);
      label.setBounds(310, 60, 900, 100);
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

      button.setForeground(Color.DARK_GRAY);
button.setBounds(1140,580,150,50);
button.setFont(new Font("Arial",Font.BOLD,29));
button.setForeground(Color.DARK_GRAY);
button.setBackground(Color.WHITE);
c1.add(button);
button.addActionListener(new ActionListener()

{
 
    public void actionPerformed(ActionEvent e)
    {
        name=field.getText();
        for(Worker f1:worker)
        {
            if(f1.getName().equalsIgnoreCase(name))
            {
                error.setText(" ");
            }
        }
        
        error2.setText(" ");
        try
        {
        remanining_rupees=Integer.parseInt(field2.getText());// converting string to int
        }
        catch (NumberFormatException ex)
                 {
                    error2.setText("Kindly,Enter remaining rupees in the integer form");
                }
        for(Worker f:worker)
        {
            if(f.getName().equalsIgnoreCase(name))
            {
                error.setText(" ");
                error2.setText(" ");
                flage=true;
                try
                {
                remanining_rupees=Integer.parseInt(field2.getText());// converting string to int
                }
                catch (NumberFormatException ex)
                         {
                            error2.setText("Kindly,Enter remaining rupees in the integer form");
                            flage4=true;
                        }
                        if(flage4==false)
                        {
                    f.setRemaning(remanining_rupees);
                flage3=true;
                JOptionPane.showMessageDialog(null,"The remaining rupees have been saved in the record of "+name);
                
                        }
                        else if(flage4==true)
                        {
                            flage4=false;
                        }
            }
        }
        if(flage3==false)
        {
        error.setText("Kindly, Enter correct name of worker");
        
        }
        else if(flage3==true)
        {
            flage3=false;
        }
    }
}

);
      frame1.setVisible(true);
}catch(Exception maybe)
{
    ////////////
}
}



}


