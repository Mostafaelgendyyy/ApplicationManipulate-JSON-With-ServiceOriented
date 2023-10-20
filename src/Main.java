import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        JSON JSON=new JSON();
        while(true){
            try {
                Scanner Input = new Scanner(System.in);
                System.out.println("1- Add New Record");
                System.out.println("2- Read the JSON File ");
                System.out.println("3- Search in JSON File ");
                System.out.println("4- Delete from JSON File ");
                System.out.println("5- to Exit");
                System.out.println("Enter your choose");
                String choose = Input.nextLine();
                File Path_JSON_FILE = new File("C:\\Users\\Mostafa Elgendy\\IdeaProjects\\JSON Assignment\\src\\JSFile.json");
                if(choose.equals("1")){
                    JSON.Add_Records(Path_JSON_FILE);
                }
                else if(choose.equals("2")){
                    System.out.println(JSON.Read_File_JSON_ARRAY(Path_JSON_FILE));
                }
                else if(choose.equals("3")){
                    System.out.println("1-Search By City");
                    System.out.println("2-Search By Foundation Year");
                    String type = Input.nextLine();
                    System.out.println("Enter search query: ");
                    String query = Input.nextLine();
                    JSON.searchByKey(type, query);
                }
                else if(choose.equals("4")){
                    System.out.println("1-Delete By BlName");
                    System.out.println("2-Delete By Foundation Year");
                    String type = Input.nextLine();
                    System.out.println("Enter search query: ");
                    String query = Input.nextLine();
                    JSON.delete(type,query);
                }
                else if(choose.equals("5")){
                    System.exit(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

}
