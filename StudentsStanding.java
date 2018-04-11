//Christian Brannon, ID: 1593881
//ITSE 2317-5001, 03.11.18
//Assignment: Shipping Prices

//StudentsStanding: Main File

/*
 *This program informs the user of prices to ship packages based on zip code and
 *the weight of the package. 
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.stream.IntStream;
import java.util.stream.DoubleStream;

public class StudentsStanding
{
	public static List<StudentInfo> students = new ArrayList<StudentInfo>();

    public static void main(String[] args) throws Exception, InterruptedException
    {
		ReadFromFile("GoodBoys");
		ReadFromFile("BadBoys");
		
		boolean exit = false;
        int selection;
		String rawInput;
		while(!exit)
        {
            CLS();
            System.out.print(
                "\n------Main Menu------\n" +
                "1: Add Student\n" +
                "2: View Students\n" +
                "3: About Program\n" +
                "4: Exit\n" + "\n->");
            rawInput = scanner.nextLine();
            if (tryParseInt(rawInput))
            {
                selection = Integer.parseInt(rawInput);
                switch (selection)
                { 
					case 1:
						AddStudents();
						CLS();
						break;
					case 2:
						PrintStudents();
						CLS();
						break;
					case 3:
                        CLS();
                        About();
                        break;
                    case 4:
                        CLS();
                        System.out.print("\nGoodbye!");
                        Thread.sleep (2500);
                        exit = true;
                        break;
					default:
                        System.out.print("\nThat was an invalid selection....  Please select again\n");
                        Thread.sleep (2500);
                        break;
                }
            }
            else
            {
                System.out.print("\nInvalid Input!");
                Thread.sleep (2500);
            }
        }
    }

	private static boolean tryParseInt(String value) 
    {  
        try 
        {  
            Integer.parseInt(value);  
            return true;  
        } 
        catch (NumberFormatException e) 
        {  
            return false;  
        }  
    }

    private static void CLS() throws IOException, InterruptedException 
	{ new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); }

	public static void About() throws InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Why aren't you nosy...");
        Thread.sleep (2500);
        System.out.println("Press any key to continue...");
        scanner.next();
    }	
	
	static void PrintStudents() 
	{
		for (int i = 0; i < students.size(); i++)
			System.out.println("\n" + 
				students.get(i).getLastName() + ", " + students.get(i).getFirstName() + 
				", ID: " + students.get(i).getID() + ", GPA: " + students.get(i).getGPA());
	}

	static void AddStudents()
	{
		students.add.StudentsInfo();
		System.out.println("\nStudent Added!");
		Thread.sleep (2500);
        System.out.println("Press any key to continue...");
        scanner.next();
	}

    static void ReadFromFile(String whichFile) throws FileNotFoundException
    {
	String CD = "";
	File file;
		try
		{
			CD = System.getProperty("user.dir");
			file = new File(CD + "\\" + whichFile + ".txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext())
			{
				String[] tokens = scanner.nextLine().split(";");
				students.add(new StudentInfo(tokens[tokens.length - 4], tokens[tokens.length - 3], Integer.parseInt(tokens[tokens.length - 2]), Double.parseDouble(tokens[tokens.length - 1])));
			}
		}
		catch (FileNotFoundException ex)
		{
			System.out.println(
				"\nFile not for Good Boys! Program Instability!\n" +
				CD + "\\" + whichFile + ".txt");
		}
    }
    static void WriteToFile() throws FileNotFoundException
    {

    }
}