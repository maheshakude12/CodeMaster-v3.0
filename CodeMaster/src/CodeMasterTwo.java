import java.io.*;
import java.io.FileWriter;


public class CodeMasterTwo {


	public static void main(String[] args) {
		BufferedReader reader;   
		
		
		boolean isLucky = false;
		  String s="Request- ";    
		try 
		{
			File file = new File("C:\\Users\\A707182\\git\\CodeMaster-v3.0\\Problem2\\Output.txt");
			FileOutputStream outputStream = new FileOutputStream("Output.txt");
			reader = new BufferedReader(new FileReader("C:\\Users\\A707182\\git\\CodeMaster-v3.0\\Problem2\\Problem2_input.txt"));
			int Rqst = Integer.parseInt(reader.readLine());
			System.out.println("Number of times user requested to find lucky numbers: " + Rqst);
	
			for(int i = 1 ; i <= Rqst ; i++)
			 {
			   String Number = reader.readLine();
			   int Length = Number.length();
			   int[] arr = new int[Rqst]; 
			   
				if (Length == 1)
				{
				 arr[i] = Integer.parseInt(Number);
				 isLucky = true;
				}
				else {
			   for ( int j = 0 ; j < Length - 1; j++ )
			   {
				   
				   if( Number.charAt(j) <= Number.charAt(j+1) )
						   {
					        arr[i] =  Integer.parseInt(Number);
							
							  byte b[]=s.getBytes(); outputStream.write(b); outputStream.write(arr[i]);
							  outputStream.write(':'); outputStream.write(Integer.parseInt(Number));
							  outputStream.write('\n');
							 
					        
					        isLucky = true;
					    
						   }
				  
				   else
				   {
					
					   Number = String.valueOf((Integer.parseInt(Number)-1));
					   isLucky = false;
					   break;
				   }
				   
				  }
				}
			
			   
			   
			   System.out.println("Request-" + i + ":" + Number);
			 }
			
			outputStream.close();
			
			

		   
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}


	

}
