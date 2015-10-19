import java.util.Scanner;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
public class HashMapEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> myMap = new HashMap<String, String>();
		myMap.put("1",  "one");
		myMap.put("2",  "two");
		myMap.put("3",  "three");
		myMap.put("4",  "four");
		myMap.put("5",  "fove");
		myMap.put("6",  "six");
		
	   // show keys
		for (String key : myMap.keySet()) {
			System.out.print("Key= " + key + "\t");
		}
		System.out.println("");
	   // show keys
    	for (String key : myMap.keySet()) {
				System.out.print("Values= " + myMap.get(key) + "\t");
     	}
		System.out.println("");
    	//save map to a file
    	String fileName = System.getProperty("user.dir") + File.separatorChar + "findNumber.txt";
    	System.out.println(fileName);
    	PrintWriter writer = null;
    	try {
    		writer = new PrintWriter(new File(fileName));
        	for (String key : myMap.keySet()) {
        		writer.println(key + "\t" + myMap.get(key));	
        	}   		
    		writer.close();
    	} catch (FileNotFoundException e) {
    		System.out.println("FIle does not exist!");
    	}
    	//read from the file
    	HashMap<String, String> fileMap = new HashMap<String, String>(); 
    	BufferedReader reader = null;
    	String line = "";
    	System.out.println("Reading file: " + fileName);
		try{
			reader = new BufferedReader(new FileReader(fileName));
			while (line != null) {
				line = reader.readLine();
				if (line != null) {					
					System.out.println("Read in a line: " + line) ;
					String[] keyValuePair = line.split("\t");
					fileMap.put(keyValuePair[0], keyValuePair[1]);					
				}
			} 
		} catch (IOException e) {
			System.out.println(fileName + " not found. Can not read.");
		}
    	String keyNum;
    	String response;    	
    	do {
        	System.out.println("Enter a number  1-6:?");
        	keyNum = sc.next();
        	if (fileMap.containsKey(keyNum)) {
        		System.out.println("Response: You entered " + fileMap.get(keyNum));
        	} else {
        		System.out.println("Your input is out of range.");
        	}
        	System.out.println("Keep going? Y/N");
        	response = sc.next();
    	} while (response.equalsIgnoreCase("Y"));
    	System.out.println("Bye!");
	}

}
