import java.io.*;
import java.util.*;

class FindFile {
    public void findFile(String filename, String file) {
        String foundFile = recursiveSearch(file, filename);

        if (foundFile == "") {
            System.out.println("Suche erfolglos.");
        } else {
            System.out.println("Datei gefunden!");
        }
    }

    public String recursiveSearch(String i_pathname, String filename) {
        String[] pathnames = new File(i_pathname).list();
        String foundpath = "";

        for (String pathname : pathnames) {
            if (foundpath == "") {
                if (new File(i_pathname + "\\" + pathname).isFile()) {
                    if (filename.equals(pathname)) {
                        foundpath = i_pathname + "\\" + pathname;
                    }
                } else {
                    foundpath = recursiveSearch(i_pathname + "\\" + pathname, filename);
                }
            }
        }
        return foundpath;
    }

    public static void main(String[] args) {
        FindFile ff = new FindFile();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the file to be searched.. ");
        String filename = scan.next();
        System.out.println("Enter the directory where to search ");
        String directory = scan.next();
        ff.findFile(filename, directory);
    }
}