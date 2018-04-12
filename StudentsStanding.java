//Christian Brannon, ID: 1593881
//ITSE 2317-5001, 03.11.18
//Assignment: Shipping Prices

//StudentsStanding: Main File

/*
 * This program reads student info from files designated as students in good academic standing ("GoodBoys.txt"), and
 * ones below good academic standing into "BadBoys.txt".  It can display the list of students read from the files to the
 * user, and allows the user to add new students to the list read from files, and write to the correct file upon
 * termination of program.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;

public class StudentsStanding
{
	private static List<StudentInfo> students = new ArrayList<StudentInfo>();

    public static void main(String[] args) throws InterruptedException, Exception
    {
		ReadFromFile("GoodBoys");
		ReadFromFile("BadBoys");
		Scanner scanner = new Scanner(System.in);
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
                        CLS();
						AddStudents();
						break;
					case 2:
                        CLS();
						PrintStudents();
						break;
					case 3:
                        CLS();
                        About();
                        break;
                    case 4:
                        CLS();
                        WriteToFile();
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

    private static void pressAnyKeyToContinue() throws InterruptedException
    {
        Thread.sleep (2500);
        System.out.println("Press Enter key to continue...");
        try{ System.in.read(); }
        catch(Exception e){}
    }
	private static void About() throws InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Why aren't you nosy...");
        pressAnyKeyToContinue();
    }	
	
	private static void PrintStudents()
	{
        for (StudentInfo student : students)
            System.out.println("\n" +
                    student.getLastName() + ", " + student.getFirstName() +
                    ", ID: " + student.getID() + ", GPA: " + student.getGPA());
	}

	private static void AddStudents() throws InterruptedException
	{

	    Scanner scanner = new Scanner(System.in);
		students.add(new StudentInfo());
		System.out.println("\nStudent Added!");
        pressAnyKeyToContinue();
	}

    private static void ReadFromFile(String whichFile) throws FileNotFoundException
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
				students.add(new StudentInfo(
				        tokens[tokens.length - 4],
                        tokens[tokens.length - 3],
                        Integer.parseInt(tokens[tokens.length - 2]),
                        Double.parseDouble(tokens[tokens.length - 1])));
			}
		}
		catch (FileNotFoundException ex)
		{
			System.out.println(
				"\nFile not found for " + whichFile + "! Program Instability!\n" +
				CD + "\\" + whichFile + ".txt");
		}
    }
    private static void WriteToFile() throws IOException
    {
        try
        {

            FileWriter writerForGood = new FileWriter("GoodBoys.txt");
            FileWriter writerForBad = new FileWriter("BadBoys.txt");
            for (StudentInfo student : students)
            {
                if (student.getGPA() >= 1.5)
                    writerForGood.write(student.getFirstName() + ";" +
                                            student.getLastName() + ";" +
                                            student.getID() + ";" +
                                            student.getGPA() + String.format("%n"));
                else
                    writerForBad.write(student.getFirstName() + ";" +
                                           student.getLastName() + ";" +
                                           student.getID() + ";" +
                                           student.getGPA() + String.format("%n"));
            }
            writerForGood.close();
            writerForBad.close();
        }
        catch (IOException e)
        {
            System.out.println("No File!");
        }
    }
}