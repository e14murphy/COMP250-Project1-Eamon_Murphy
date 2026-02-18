//Eamon Murphy

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class hexagonFinder
{
    public static void main(String[] args) throws IOException
    {
        //Asking user what file they want to check
        Scanner read = new Scanner(System.in);
        //Error trapping to get a valid file
        String filename = "";
        File data_file;
        do
        {
            //filename validity check
            boolean is_valid_filename = false;
            while(!is_valid_filename)
            {
                System.out.println("Enter the name of your data file: ");
                filename = read.nextLine();
                is_valid_filename = true;
                char[] char_arr_filename = filename.toUpperCase().toCharArray();
                for (char character : char_arr_filename) {
                    if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ_()1234567890".indexOf(character) == -1)
                    {
                        System.out.println("Filename can only contain letters, numbers, underscores, or parenthesis.");
                        is_valid_filename = false;
                        break;
                    }
                }
            }
            //file exists check
            data_file = new File("data_files/" + filename + ".csv");
            if (!data_file.exists())
            {
                System.out.println("That file does not exist.");
            }
        }
        while(!data_file.exists());
        //parsing file and checking for vaild hexagons
        BufferedReader parse = new BufferedReader(new FileReader("data_files/" + filename + ".csv"));
        //getting number of data lines from first line
        int num_of_lines = Integer.parseInt(parse.readLine().split(",")[0]);
        String[] current_line;
        String validity;
        for(int line_num = 0; line_num <= num_of_lines; line_num++)
        {
            current_line = parse.readLine().split(",");
            if (Integer.parseInt(current_line[5]) < 1)
            {validity = "This hexagon is invalid";}
            else
            {validity = "This hexagon is valid";}
            System.out.println(current_line[0] + ", " + current_line[1] + ", " + current_line[2] + ", "
            + current_line[3] + ", " + current_line[4] + ", " + current_line[5] + ", " + validity);
        }
    }
}