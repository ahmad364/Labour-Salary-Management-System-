package controler;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.io.Serializable;

public class Worker extends human implements Serializable
 {
     // declaring all the variables which we need to set record of worker
     public String name;
     public String father_name;
     public String phone_number;
     public int waging;
     public int salary=0;
     public int no_of_aphsents,no_of_presents;  // these variables will store total number of presents and aphsents in a working days
     public int no_of_half_presents;      // this variable will store total number of half days working
     public int halfday_waging;     // this variable will store waging of half days working
      // in this array list, date of working days will be added
     ArrayList<LocalDate> date=new ArrayList<>();
     ArrayList<String> day_name=new ArrayList<>();
     ArrayList<String> attendance=new ArrayList<>(); // int this array list, attendance of working days will be added
     public int advance_rupees=0;  // will store advance rupees
    public ArrayList<String> days_of_working= new ArrayList<>();
     public int remaining_rupes=0;
     public Worker(String n,String f_n,String p_n,int w)
     {
         name=n;
         father_name=f_n;
         phone_number=p_n;
         waging=w;
     }
     
     // setter methods
    public void setName(String n)
    {
        name=n;
    }
    public void setFather_name(String f_n)
    {
        father_name=f_n;
    }
    public void setPhone_number(String p_n)
    {
        phone_number=p_n;
    }
    public void setWaging(int w)
    {
        waging=w;
    }
    public void setRemaning(int r_r)
    {
        remaining_rupes=r_r;
    }
    // getters methods
    public String getName()
    {
        return name;
    }
    public String getFather_name()
    {
        return father_name;
    }
    public String getPhone_number()
    {
        return phone_number;
    }
    public int getWaging()
    {
        return waging;
    }
    public int getRemaning()
    {
        return remaining_rupes;
    }
    // this method will add attendance of worker in arraylist 
     public void setAttendance(String a)
     {
         attendance.add(a);  
     } 
      // this method will add date of worker in arraylist 
     public void setDate(LocalDate d)
     {
         date.add(d);    
     }
     public void setDay_name(String D_n)
     {
         day_name.add(D_n);
     }
     //this method will return the total number of days in which days worker was present
     public int getPresent()
     {
         no_of_presents=0;
        for(String f:attendance)
        {
            if(f.equalsIgnoreCase("P"))
            {
                no_of_presents++;   // adding the number of presents after checking the attendance
                        }
        }
         return no_of_presents;
        
     }
     //this method will return the total number of days in which days worker was not present
     public int getAphsent()
     {
         no_of_aphsents=0;
        for(String f:attendance)
        {
            if(f.equalsIgnoreCase("A"))
            {
                no_of_aphsents++;  // adding he number of aphsents after chaking attendance
                        }
        }
        return no_of_aphsents;
    
     }
     // this method will return the total number of days in which days worker done work in half days
     public int get_no_of_day_of_half_working()
     {    no_of_half_presents=0;
        for(String f:attendance)
        {
            if(f.equalsIgnoreCase("half"))
            {
               no_of_half_presents++;   // adding he number of half presents after chaking attendance
                        }
        }
        return no_of_half_presents;
         
     }
     // will set addvance rupees 
     public void setAddvance_rupees(int a_r)
     {
         advance_rupees=a_r;
     }
     public int getAddvance_rupees()
     {
         return advance_rupees;
     }
     //this method will cut advance rupees from salary of worker
     public void cut_addvance_rupees_from_salary()
     {
         salary=getSalary();
         salary=(salary-advance_rupees);
     }
     // this method will return salaries after cutting the advance rupees from salary
     public int get_salalry_after_cutting_addvance_rupees()
     {
         return salary;
     }
     //this method will return the salary of worker according to its attendace 
     public int getSalary()
     {
         halfday_waging=waging/2;   // getting half day waging by divid 2
         salary=waging*getPresent();
         for(String f:attendance)
         {
             if(f.equalsIgnoreCase("Half"))
             salary=salary+halfday_waging;   // adding hlaf day waging into salary after checking attendance

         }
         salary=salary+remaining_rupes;
         return (salary);
     }   
     public void get_days_of_working()
     {
         
         days_of_working.add(0, "Information about the Working days of "+getName());
         days_of_working.add(1,"Date                           Day                  Attendance");
         int index=2;

            {
                
                {
                 for(int ind=0;ind<attendance.size();ind++)
                 {
            
                days_of_working.add(index,date.get(ind).toString()+"               "+day_name.get(ind)+"                        "+attendance.get(ind) );
                 index++;
                 }
                }
         
            
            }
         
     }   
 }


    
