package PROBLEM1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem1 {
	int c,p;
	static StringBuffer outputContent =  new StringBuffer();
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String inputTxt = Paths.get("")
				.toAbsolutePath()
				.toString()+"\\src\\PROBLEM1\\input.txt"; 
		String outputTxt = Paths.get("")
				.toAbsolutePath()
				.toString()+"\\src\\PROBLEM1\\output.txt"; 



		try (BufferedReader br = new BufferedReader(new FileReader(inputTxt))) {

			String numberOfScenarios = br.readLine();

			ArrayList<String> scenarios = new ArrayList<String>();

			for(int i=0; i<Integer.parseInt(numberOfScenarios); i++)
			{
				scenarios.add(br.readLine());

				String[] cAndP = scenarios.get(i).split(" "); 
				covid19Seating(Integer.parseInt(cAndP[0]), Integer.parseInt(cAndP[1]), i);
			}
		}



	}

	private static void covid19Seating(int C, int P, int senarioNumber) throws IOException {

		LinkedList<String> seaters = new LinkedList<String>();

		for(int seater=0; seater<C;seater++)
		{
			seaters.add("_");
		}

		for(int person = 0; person<P; person++)
		{
			LinkedList<String> currentseaters = new LinkedList<String>();

			if(seaters.contains("X"))
			{
				currentseaters = seaters;
			}
			else
			{
				currentseaters = seaters;
			}

			if(C%2 == 0)
			{
				rule2(currentseaters, C, senarioNumber);
			}
			else
			{
				rule1(currentseaters, C, senarioNumber);
			}
		}
	}

	private static void rule2(LinkedList<String> seaters, int capacity, int senarioNumber) throws IOException {

		seaters.remove(((capacity/2)-1));
		seaters.add(((capacity/2)-1), "X");

		updateRELE(seaters, senarioNumber);
	}

	private static void updateRELE(LinkedList<String> seaters, int scenarioNumber) throws IOException {

		List<String> subListLE = seaters.subList(0, seaters.indexOf("X"));
		List<String> subListRE = seaters.subList(seaters.indexOf("X")+1, seaters.size());

		int X = subListLE.size() < subListRE.size() ? subListRE.size() : subListLE.size();
		int Y = subListLE.size() < subListRE.size() ? subListLE.size() : subListRE.size();

		System.out.println("max - " +X+  ""+ "mini - "+Y);
		outputContent.append("Scenario-"+scenarioNumber+":"+X+ " "+ Y);

		File file = new File(Paths.get("")
				.toAbsolutePath()
				.toString()+"\\src\\PROBLEM1\\output.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file);
		fw.write(outputContent.toString());
	}

	private static void rule1(LinkedList<String> seaters, int capacity, int senarioNumber) throws IOException {
		seaters.remove(((capacity/2)));
		seaters.add(((capacity/2)), "X");
		updateRELE(seaters, senarioNumber);
	}

}
