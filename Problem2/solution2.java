package com.coding.codemaster;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class solution2 {


    int numberOfMessages;



public static void main(String[] args){
	try {
		Files.deleteIfExists(Paths.get("C:\\Users\\A738261\\Desktop\\codemaster2\\CodeMaster-v3.0\\Problem2\\Problem2_output.txt"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    solution2 obj = new solution2();

    obj.process();


}
    public void process() {
        Formatter writein = null;
        Scanner dataScanner = null;

        try {
            File inputFile = new File("C:\\Users\\A738261\\Desktop\\codemaster2\\CodeMaster-v3.0\\Problem2\\Problem2_input.txt");
            dataScanner = new Scanner(inputFile); 
        } catch (SecurityException se) {
            System.out.println("You do have access to this file");
            System.exit(1);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error in creating file");
            System.exit(1);
        }

       // java.util.List<Message> messageList = new ArrayList<>();

        boolean fistLineNeedToBeOmmited = true;
        int messageNumber =1;

        while (dataScanner.hasNextLine()) {
            String firstLine =  dataScanner.nextLine();


            if(fistLineNeedToBeOmmited) {
                String[] data = firstLine.split(" ");
                numberOfMessages = Integer.valueOf(data[0]);
                fistLineNeedToBeOmmited = false;
            }else{
                if(firstLine!=null){
                	String[] split = firstLine.split(" ");
                    long cnumber = Long.parseLong(split[0]);
                	calc(cnumber,messageNumber);
                   
                    messageNumber++;
                }
            }
        }


    }
    
    public void calc(long l,int count){
    	Formatter writein = null;
    	try{
    		FileWriter f = new FileWriter("C:\\Users\\A738261\\Desktop\\codemaster2\\CodeMaster-v3.0\\Problem2\\Problem2_output.txt", true);
            writein = new Formatter(f);
    	outerloop:
    	for(long last=l;last>0;last--){
 
    	String s=String.valueOf(last);

    	String st=String.valueOf(s.charAt(0));
    	if(l<10){
    		writein.format("%s%d%s%s\n","Request-",count,": ",st);
    		
			break outerloop;
    	}
    	int first=0;
    	int second=0;
    	for(int i=0;i<s.length()-1;i++){
    		char a = s.charAt(i);
    		char b = s.charAt(i+1);
    		int p = Integer.parseInt("" + a);
    		int q = Integer.parseInt("" + b);
    		first=p;
    		second=q;
    		
    		if(first==second || first<second)
    		{
    			

    			st=st+second;

    				if(s.equals(st)){
    					writein.format("%s%d%s%s\n","Request-",count,": ",st);
    				break outerloop;
    			}
    		}else{
    			
    			break;
    		}
    	}

    	}
    	}
    	catch(Exception e){}
        finally{
        	writein.flush();
        	writein.close();
        }
    }

}
