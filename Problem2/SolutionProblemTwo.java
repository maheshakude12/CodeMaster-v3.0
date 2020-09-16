package techforum.codemaster;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class SolutionProblemTwo {

	public static void main(String[] args) {
		String sourceFilePath = "C:\\Users\\A632920\\Desktop\\TechForum\\cmd\\Input.txt";
		String destinationFilePath = "C:\\Users\\A632920\\Desktop\\TechForum\\cmd\\Output.txt";
		
		/*
		 * String l1 = "3"; String l2 = "424"; String l3 = "6"; String l4 = "10000";
		 */
		try {
			FileReader fr = new FileReader(new File(sourceFilePath));
			FileOutputStream fos = new FileOutputStream(new File(destinationFilePath), true);
			BufferedReader br = new BufferedReader(fr);
			String l1;
			if ((l1 = br.readLine()) != null) {
				int noOfRequests_R = Integer.valueOf(l1);
				String[] outputLines = new String[noOfRequests_R];
				for (int i = 1; i <= noOfRequests_R; i++) {
					String l2;
					if ((l2 = br.readLine()) != null) {
						long lastCountedNo_C = getPreviousLuckyNumber(Long.valueOf(l2));
						// Add output
						outputLines[i-1] = "Request-" + i + ": " + lastCountedNo_C;
					}
				}
				for (String currLine : outputLines) {
					fos.write(currLine.getBytes());
					fos.write(System.getProperty("line.separator").getBytes());
				}
			}
			br.close();
			fos.close();
			System.out.println("Done!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static long getPreviousLuckyNumber(long lastLuckyNo_LN) {
		do {				
			boolean isValid = true;
			System.out.println("Currently evaluating: " + lastLuckyNo_LN);
			// separate digits
			long[] separatedDigits = getSeparatedDigits(String.valueOf(lastLuckyNo_LN).length() != 1 ? --lastLuckyNo_LN : lastLuckyNo_LN);
			long comparator = separatedDigits[0];
			
			if (separatedDigits.length > 0)
				for (int j = 1; j < separatedDigits.length; j++) {
					if (comparator <= separatedDigits[j]) {
						comparator = separatedDigits[j];
					}
					else {
						isValid = false;
						break;
					}
				}
			
			if (isValid)
				break;
			
			// check if digit order is as required
			
		} while (true);
		
		return lastLuckyNo_LN;
	}

	private static long[] getSeparatedDigits(long l) {

		long[] separatedDigits = new long [String.valueOf(l).length()];
		
		for (int j = separatedDigits.length - 1; j >= 0; j--) {
			long oncePlaceDigit = l % 10;
			long remainingDigits = l / 10;
			l = remainingDigits;
			separatedDigits[j] = oncePlaceDigit;
		}
		
		return separatedDigits;
	}

}
