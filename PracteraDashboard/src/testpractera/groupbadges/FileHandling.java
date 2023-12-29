package testpractera.groupbadges;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandling {

    private File file;

    public Scanner reader;

    private String path;
    private String name;

    public FileHandling(String thePath, String theName){
        path = thePath;
        name = theName;
    }

    public boolean load(){
        try{
            String str = path.concat(name);
            file = new File(str);
   //         System.out.println("FileHandling.filename string is: "+ str);
   //         System.out.println("Does this file exist "+file.exists());
            if(file.exists()){
                reader = new Scanner(file);
                return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
