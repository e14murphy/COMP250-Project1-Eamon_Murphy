//Eamon Murphy

/***********************************************************************
For this assignment you will create a program that will generate sets of 5 random positive integers
less than 720, and a 6th integer 720 − n1 − n2 − n3 − n4 − n5 .
You will write those sets to a file.
************************************************************************/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class setGenerator {

    public static void main(String[] args) throws IOException
    {
        //Taking user input to get number of sets
        boolean is_int = false;
        Scanner read = new Scanner(System.in);
        String string_num_of_sets = "";
        while (!is_int)
        {
            System.out.print("Enter an integer for how many sets you wish to generate: ");
            //Error trap to ensure I get an integer
            is_int = true;
            string_num_of_sets = read.nextLine();
            char[] char_arr_num_of_sets = string_num_of_sets.toCharArray();
            for (char digit : char_arr_num_of_sets)
            {
                if ("1234567890".indexOf(digit) == -1)
                {
                    System.out.println("Input must be an integer!");
                    is_int = false;
                }
            }
        }
        //converting string number of sets to int
        int num_of_sets = Integer.parseInt(string_num_of_sets);

        //Error trapping to get a new and valid file name
        String filename = "";
        File data_file;
        do
        {
            System.out.println("Enter the name of your data file: ");
            filename = read.nextLine();
            boolean is_valid_filename = false;
            while(!is_valid_filename)
            {
                is_valid_filename = true;
                char[] char_arr_filename = filename.toUpperCase().toCharArray();
                System.out.print(char_arr_filename);
                for (char character : char_arr_filename) {
                    if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ_()".indexOf(character) == -1)
                    {
                        System.out.println("Filename can only contain letters, underscores, or parenthesis.");
                        is_valid_filename = false;
                    }
                }
            }
            data_file = new File("data_files/" + filename + ".csv");
            if (data_file.exists())
            {
                System.out.println("That file name is already taken!");
            }
        }
        while(data_file.exists());

        //Generating data file
        Random rand = new Random();
        FileWriter new_data_file = new FileWriter("data_files/" + filename + ".csv", true);
        for (int line = 0; line <= num_of_sets; line++)
        {
            int[] set_values = new int[5];
            for (int place = 0; place < 5; place++)
            {
                set_values[place] = rand.nextInt(720);
            }
            String line_to_write = (set_values[0] + "," + set_values[1] + "," + set_values[2] + "," + set_values[3] + "," + set_values[4] + "," +
                    (720 - (set_values[0] + set_values[1] + set_values[2] + set_values[3] + set_values[4])));
            new_data_file.write(line_to_write + "\n");
        }
        new_data_file.close();

    }

}
