import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;


public class PhysiciansHelper
{
	HashMap<String, String> illnessesAndSymptons = new HashMap<String, String>();
	ArrayList<String> symptomList = new ArrayList<String>();
	
	PhysiciansHelper(){
		readfile();
	}
	
	public void addSymptom(String smyp){
		this.symptomList.add(smyp);
	}
	public void displaySymptomList(){
		for(String item : symptomList){
			System.out.println(item);
		}
	}
	
	public void displayPossibleIllness(){
		for(String item : symptomList){
			//System.out.println(item);
			System.out.println((String)this.illnessesAndSymptons.get(item));
		}
	}
	

	public void readfile(){
		BufferedReader br = null;
		FileReader fr = null;
		try {
	
			fr = new FileReader("C:\\Users\\Computer\\workspace\\chap 19 pro 5\\illnesses.txt");
			br = new BufferedReader(fr);
	
			String sCurrentLine;
	
			br = new BufferedReader(new FileReader("C:\\Users\\Computer\\workspace\\chap 19 pro 5\\illnesses.txt"));
	
			while ((sCurrentLine = br.readLine()) != null) {
				String[] first = sCurrentLine.split(":");
				String[] symptoms = first[1].split(",");
				for(int i = 0; i < symptoms.length; i++){
					//System.out.println(first[0]);
					this.illnessesAndSymptons.put((String)symptoms[i], (String)first[0]);
				}
			}
	
		} catch (IOException e) {
	
			e.printStackTrace();
	
		} finally {
	
			try {
	
				if (br != null)
					br.close();
	
				if (fr != null)
					fr.close();
	
			} catch (IOException ex) {
	
				ex.printStackTrace();
	
			}
	
		}
	}

} 
