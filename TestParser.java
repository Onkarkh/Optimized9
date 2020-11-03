import java.io.*;
import java.util.*;
class TestParser{
	
	//109.169.248.247 - - [12/Dec/2015:18:25:11 +0100] "GET /administrator/ HTTP/1.1" 200 4263 "-" "Mozilla/5.0 (Windows NT 6.0; rv:34.0) Gecko/20100101 Firefox/34.0" "-"	
		
	static List<String> retrivedData = new ArrayList<String>(); //Used Arraylist instead of Array[] due to Indexing issue.
	static HashSet<String> uniqueIpAddress = new HashSet<String>(); // Used HashSet to Print Unique Data.
	static HashSet<String> uniqueDates = new HashSet<String>();
	static HashSet<String> serverCode = new HashSet<String>();
	
	
	public static void dataParser(){
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("logs_sm.csv"));
			String line = reader.readLine();
			while (line != null) {
				retrivedData.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(String data : retrivedData){
			uniqueIpAddress.add(data.split(" ")[0]); //IP address over spaces
			
			String date = data.split(" ")[3]; //dates
			date = date.split(":")[0];
			uniqueDates.add(date.split("\\[")[1]);
			
			serverCode.add(data.split(" ")[8]); //server code over space
		}

	}	
	
	public static void printData(HashSet<String> map){
		for(String temp : map)
			System.out.println(temp);
	}
	
	public static void main(String args[]){
		dataParser();
		printData(serverCode); //uniqueIpAddress uniqueDates serverCode
	}
	
}