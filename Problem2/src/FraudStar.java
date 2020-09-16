
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FraudStar {

	static long recordCount = 0;
	static long previousLuckyNumber= 0;
	public static void main(String[] args) {
		try {
			/**********************File Reader*************************/
			String basePath = new File("").getAbsolutePath();
			FileReader reader = new FileReader(basePath+"\\src\\Input\\Problem2_input.txt");  // Input File destination
			BufferedReader bufferedReader = new BufferedReader(reader);
			long noOfRecords = 0;
			long i = 0;
			String line; // To store Line Data
			List<String> inputDataLine = new ArrayList<String>();		// Storage for Input Line to be written in output file

			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);			// Output Per Line Data

				if(i == 0){
					noOfRecords = Long.valueOf(line);
				}else{
					previousLuckyNumber = Long.parseLong(line);
					recordCount++;
					inputDataLine.add("Request-"+""+recordCount+""+" : "+processor(previousLuckyNumber));  // write output
				}
				i++;
			}
			reader.close();
			/**************Send to Writer*******************/  
			outputWriter(inputDataLine);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void outputWriter(Object obj) throws IOException{	
		try {

			String basePath = new File("").getAbsolutePath();
			FileOutputStream outputStream = new FileOutputStream(basePath+"\\src\\Output\\output.txt");
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

			if(obj instanceof ArrayList)
			{
				List iterate  = (ArrayList)obj;
				for (Iterator iterator = iterate.iterator(); iterator.hasNext();) {
					String strLine = (String) iterator.next();
					bufferedWriter.write(strLine);
					bufferedWriter.newLine();
				}

				bufferedWriter.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	/***return New Lucky Number***/
	
	public static String processor(long number){

		long tmpnumber = number;
		while (number > 0) {

			boolean flag = isLuckyNumber(number);
			if(flag) {
				//System.out.println("Lucky Number is "+number);
				tmpnumber = number;
				break;
			}
			number = number - 1;

		}
		return ""+tmpnumber;
	}

	public static boolean isLuckyNumber(long value) {
		boolean flg = true;
		while(value > 0) {
			long digit1 =  value%10;

			value = value/10;

			long digit2 = value%10;

			if(digit1 > digit2 ||  digit1 == digit2) {
				continue;
			} else {
				flg = false;
				break;
			}
		}

		return flg;

	}




}