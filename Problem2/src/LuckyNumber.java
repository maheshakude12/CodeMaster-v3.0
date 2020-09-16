
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LuckyNumber {

	static long recordCount = 0;
	static BigInteger previousLuckyNumber= new BigInteger("0");
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
					previousLuckyNumber = new BigInteger(line);
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
	
	public static String processor(BigInteger number){

		BigInteger tmpnumber = number;
		while (number.compareTo(new BigInteger("0")) > 0) {

			boolean flag = isLuckyNumber(number);
			if(flag) {
				//System.out.println("Lucky Number is "+number);
				tmpnumber = new BigInteger(""+number);
				break;
			}
			number = number.subtract(new BigInteger("1"));

		}
		return ""+tmpnumber;
	}

	public static boolean isLuckyNumber(BigInteger value) {
		boolean flg = true;
		while(value.compareTo(new BigInteger("0")) > 0) {
			BigInteger digit1 =  value.mod(new BigInteger("10")); 
			value = value.divide(new BigInteger("10")); 
			BigInteger digit2 =  value.mod(new BigInteger("10")); 

			if(digit1.compareTo(digit2) >= 0) {
				continue;
			} else {
				flg = false;
				break;
			}
		}

		return flg;

	}




}