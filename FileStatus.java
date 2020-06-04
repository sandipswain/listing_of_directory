/*
 * CSW END TERM PROJECT
 */

/*
 * A program to display a listing of any directory contained in the current
 * directory
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

public class FileStatus {
    public static void main(String[] args) throws IOException {

        String curDir = "C:/Users/Sandip/Documents/Languages/";// Providing current dirctory
        File fileName = new File(curDir);// Converting to file format
        String[] fileList = fileName.list();// Listing the sub directory present

        /*
         * Printing the list of directories
         */
        for (String file : fileList) {
            System.out.println(file);
        }

        Scanner sc = new Scanner(System.in); // Scanner class
        System.out.print("Enter the name of the directory which you wish to be listed ->");// Message to enter a valid
                                                                                           // directory
        String check = sc.next(); // user input of directory
        String fileCheck = curDir.concat(check);// location of the entered directory
        System.out.println(fileCheck);
        File existFile = new File(fileCheck);// Converting to file format
        if (existFile.exists()) { // to check whether the directory or file exist
            System.out.println("Listing for directory: " + check);// printing the directories name
            fileStatus(existFile, fileCheck, check);
        } else
            System.out.println("The Directory you entered doesn't exist.Sorry!! Try Again...");// message if entered
                                                                                               // invalid file

    }

    /* Function to provide file status */
    public static void fileStatus(File existFile, String filecheck, String check) throws IOException {

        JFrame frame = new JFrame("<-----Current Directory Status----->");// Frame header name
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Specifying exit operation to stop the execution of
                                                             // program
        JPanel panel = new JPanel();// Declaring a panel
        panel.setBackground(Color.CYAN);// Frame color
        JLabel label2 = new JLabel("Listing for directory:" + check
                + "                                                                                          ");
        JLabel label1 = new JLabel(
                "name                                  length                         modified                             code");// heading
                                                                                                                                  // of
                                                                                                                                  // the
                                                                                                                                  // file
                                                                                                                                  // status
        panel.add(label2);
        panel.add(label1);

        String list[] = existFile.list();
        int l = list.length; // number of files present in the directory
        int i = 0;
        for (i = 0; i < l; i++) { // loop to execute the number of files status
            String join = filecheck.concat("/" + list[i]);// destination of files within the sub-dir
            // System.out.println(join);
            File f = new File(join); // To convert the specified location into file format
            String test = " ";
            if (f.canRead() && f.canWrite()) // To check whether a file is readable or writable
                test = "r-w";
            else if (f.canRead()) // To check whether a file is only readable or not
                test = "r-_";
            else if (f.canWrite()) // To check whethe a file is only writable or not
                test = "_-w";
            else
                test = "_-_"; // To check whether a file is neither writable nor readable

            JLabel label = new JLabel(list[i] + "                             " + f.length()
                    + "                             " + f.lastModified() + "                     " + test); // Printing
                                                                                                            // the file
                                                                                                            // status

            panel.add(label); // adding the label to panel

        }
        panel.setPreferredSize(new Dimension(800, 500)); // Setting the dimension and width of the framework
        frame.getContentPane().add(panel); // Adding the panel content to frame
        frame.pack(); // Setting the frame
        frame.setVisible(true); // The frame to be visible

    }

}
