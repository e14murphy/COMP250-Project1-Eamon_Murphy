//Eamon Murphy

/*******************************************************
 * You will then read that data from the file and output if those 6 numbers could be valid angle measures
 * for a hexagon.
 * (If n6 is < 1 the answer is false, otherwise true)
 *****************************************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class hexagonFinder
{
    public static void main(String[] args)
    {
        //Asking user what file they want to check
        Scanner read = new Scanner(System.in);
        //filename validity check
        String filename = "";
        boolean is_valid_filename = false;
        while(!is_valid_filename)
        {
            System.out.println("Enter the name of the data file to read: ");
            filename = read.nextLine();
            is_valid_filename = true;
            char[] char_arr_filename = filename.toUpperCase().toCharArray();
            for (char character : char_arr_filename) {
                if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ_()".indexOf(character) == -1)
                {
                    System.out.println("Filename can only contain letters, underscores, or parenthesis.");
                    is_valid_filename = false;
                }
            }
        }
        //parsing file and checking for vaild hexagons
        BufferedReader parse = new BufferedReader(new FileReader("data_files/" + filename + ".csv"));
        //getting number of data lines from first line
        int num_of_lines = parse.readLine().split(",")[0];
        String[] current_line;
        String validity;
        for(int line_num = 0; line_num <= num_of_lines; line_num++)
        {
            current_line = parse.readLine().split(",");
            if (current_line[6] < 1)
            {validity = "This hexagon is invalid";}
            else
            {validity = "This hexagon is valid";}
            System.out.println(current_line[0] + ", " + current_line[1] + ", " + current_line[2] + ", "
            + current_line[3] + ", " + current_line[4] + ", " + current_line[5] + ", " + validity);
        }
    }
}