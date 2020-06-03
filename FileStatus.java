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

public class FileStatus {
    public static void main(String[] args) throws IOException {
        String curDir = "C:/Users/Sandip/Documents/Languages/";// Providing current dirctory
        File fileName = new File(curDir);
        String[] fileList = fileName.list();// Listing the sub directory present

        /*
         * Printing the list of directories
         */
        for (String file : fileList) {
            System.out.println(file);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the directory which you wish to be listed ->");
        String check = sc.next();
        String fileCheck = curDir.concat(check);
        System.out.println(fileCheck);
        File existFile = new File(fileCheck);
        if (existFile.exists()) {
            System.out.println("Listing for directory: " + check);
            fileStatus(existFile, fileCheck);
        } else
            System.out.println("The Directory you entered doesn't exist.Sorry!! Try Again...");
        // Tests whether the directory denoted by this abstract pathname exists.
        /*
         * int i = 0; for (i = 0; i < l; i++) { if (f.equals(fileList[i]))
         * System.out.println("True"); else System.out.println("False"); }
         */

    }

    public static void fileStatus(File existFile, String filecheck) throws IOException {
        System.out.println("name\t\tlength\t\t  modified\t\tcode");
        String list[] = existFile.list();
        int l = list.length;
        int i = 0;
        for (i = 0; i < l; i++) {
            String join = filecheck.concat("/" + list[i]);
            // destination of files within the sub-dir
            // System.out.println(join);
            File f = new File(join);
            // Path path = Paths.get(join);
            // long length = Files.size(path);
            String test = " ";
            if (f.canRead() && f.canWrite())
                test = "rw";
            else if (f.canRead())
                test = "r-_";
            else if (f.canWrite())
                test = "_w";
            else
                test = "_ _";

            System.out.println(list[i] + "\t\t " + f.length() + "\t\t " + (f.lastModified()) + "\t\t" + test);
        }

    }
}
