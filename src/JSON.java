import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static javax.script.ScriptEngine.FILENAME;

public class JSON {
    public static void Add_Records(File File) throws SAXException, IOException, ParseException {
        Scanner input = new Scanner(System.in);
        JSONArray Buildings = null;
        if(File.exists()){
            Buildings = Read_File_JSON_ARRAY(File);
        }else{
            Buildings = new JSONArray() ;
        }
        FileWriter F_Writer =new FileWriter(File);
        String BlName , city , FoundationYear;
        System.out.println("Enter BlName: ");
        BlName = input.nextLine();
        System.out.println("Enter city: ");
        city = input.nextLine();
        System.out.println("Enter FoundationYear: ");
        FoundationYear = input.nextLine();

        Building Building_Instance=new Building(BlName,city,FoundationYear);

        Map<String, String> JSON_MAP = new LinkedHashMap<>();
        JSON_MAP.put("BlName" , Building_Instance.getBlName());
        JSON_MAP.put("city" , Building_Instance.getCity());
        JSON_MAP.put("FoundationYear" , Building_Instance.getFoundationYear());
        Buildings.add(JSON_MAP);
        try {
            F_Writer.write(Buildings.toJSONString());
            F_Writer.close();
            System.out.println("Record is Added successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONArray Read_File_JSON_ARRAY(File file) throws IOException, ParseException{
        JSONParser jsonParser = new  JSONParser();
        FileReader reader = new FileReader(file);
        Object obj = jsonParser.parse(reader, new ContainerFactory(){
            @Override
            public Map createObjectContainer() {
                return new LinkedHashMap();
            }

            @Override
            public List creatArrayContainer() {
                return null;
            }
        });
        return (JSONArray) obj;
    }

    //Search in json code


    public void searchByKey(String type, String query) throws IOException, ParseException {

        JSONArray ARR = this.Read_File_JSON_ARRAY(new File("C:\\Users\\Mostafa Elgendy\\IdeaProjects\\JSON Assignment\\src\\JSFile.json"));
        ArrayList<Building> listdata = new ArrayList<>();

        //Checking whether the JSON array has some value or not
        if (ARR != null) {
            ArrayList<String> JSONData = new ArrayList<>();
            for(int i=0;i<ARR.size();++i)
            {
                JSONData.add(ARR.get(i).toString());
            }
            boolean result = false;
            for (String b : JSONData) {
                if (type.equals("1")) {
                    String STR="city="+query;
                    if (b.contains(STR)) {
                        System.out.println("========================= City is Found =========================");
                        System.out.println(b);
                        result=true;
                    }
                }
                else if (type.equals("2")) {
                    String STR="FoundationYear="+query;
                    if (b.contains(STR)) {
                        System.out.println("========================= FoundationYear is Found =========================");
                        System.out.println(b);
                        result=true;
                    }
                }
            }
            if (!result) {
                System.out.println("Sorry there is no Building that fits the criteria!");
            }
        }
    }

    public void delete(String type, String Query) throws IOException, ParseException {
        JSONArray ARR = this.Read_File_JSON_ARRAY(new File("C:\\Users\\Mostafa Elgendy\\IdeaProjects\\JSON Assignment\\src\\JSFile.json"));
        ArrayList<Building> listdata = new ArrayList<>();

        //Checking whether the JSON array has some value or not
        if (ARR != null) {
            ArrayList<String> JSONData = new ArrayList<>();
            for(int i=0;i<ARR.size();++i)
            {
                JSONData.add(ARR.get(i).toString());
            }
            boolean result = false;
            for (int i=0; i<JSONData.size();++i) {
                if (type.equals("1")) {
                    String STR="BlName="+Query;
                    if (JSONData.get(i).contains(STR)) {
                        System.out.println("========================= BlName is Found =========================");
                        //System.out.println(JSONData[i]);
                        ARR.remove(i);
                        System.out.println("========================= BlName is Deleted =========================");
                        result=true;
                    }
                }
                else if (type.equals("2")) {
                    String STR="FoundationYear="+Query;
                    if (JSONData.get(i).contains(STR)) {
                        System.out.println("========================= FoundationYear is Found =========================");
                        //System.out.println(JSONData[i]);
                        ARR.remove(i);
                        System.out.println("========================= FoundationYear is Deleted =========================");
                        result=true;
                    }
                }
            }
            if (!result) {
                System.out.println("Sorry there is no Building that fits the criteria!");
            }

            FileWriter file = new FileWriter("C:\\Users\\Mostafa Elgendy\\IdeaProjects\\JSON Assignment\\src\\JSFile.json");
            file.write(ARR.toJSONString());
            file.close();
        }
    }

}
