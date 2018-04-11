import java.io.*;
import java.util.Scanner;
import java.lang.Integer;
import java.lang.Double;
public class StudentInfo
{
    protected String FirstName; 
    protected String LastName;
    protected int ID;
    protected double GPA;
    
    public void setFirstName()
    { 
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter the Students's First Name: ");
        String FirstName = input.nextLine();
        this.FirstName = FirstName;
    }
    public void setLastName()
    { 
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter " + this.FirstName + "\'s First Name: ");
        String LastName = input.nextLine();
        this.LastName = LastName; 
    }
    public void setID()
    { 
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter " + this.FirstName + " " + this.LastName + "\'s ID: ");
        int ID = Integer.parseInt(input.nextLine());
        this.ID = ID; 
    }
    public void setGPA()
    { 
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter " + this.FirstName + " " + this.LastName + "\'s GPA: ");
        double GPA = Double.parseDouble(input.nextLine());
        this.GPA = GPA; 
    }

    public void setFirstName(String FirstName)
    { this.FirstName = FirstName; }
    public void setLastName(String LastName)
    { this.LastName = LastName; }
    public void setID(int ID)
    { this.ID = ID; }
    public void setGPA(double GPA)
    { this.GPA = GPA; }

    public String getFirstName()
    { return this.FirstName; }
    public String getLastName()
    { return this.LastName; }
    public int getID()
    { return this.ID; }
    public double getGPA()
    { return this.GPA; }

    StudentInfo()
    {
        setFirstName();
        setLastName();
        setID();
        setGPA();
    }

    StudentInfo(String FirstName, String LastName, int ID, double GPA)
    {
        setFirstName(FirstName);
        setLastName(LastName);
        setID(ID);
        setGPA(GPA);
    }
}