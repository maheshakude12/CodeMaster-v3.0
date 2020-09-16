package com.wl.codemaster.p1;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class SocialDistancing {
	
	public static void main(String[] args){		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter Scenario Count: ");  
		int scenarioCount = scanner.nextInt();	
		
		List<String> inputValues= new ArrayList<String>();
		System.out.println("Please enter "+ scenarioCount*2 +" C P Numbers for your "+ scenarioCount +" scenarios: "); 
		for(int i=0;i<scenarioCount+1;i++){			
			inputValues.add(i,scanner.nextLine());
		}
		
		for (ListIterator<String> itr=inputValues.listIterator();itr.hasNext();) {
		    int count=0;
		    String eachLine=itr.next();
		    String cpValue[]=eachLine.split(" ");
		    int scenario=inputValues.indexOf(eachLine);
		    int max=0;
		    int min=0;
		    if(cpValue.length==2){
		    	Integer cValue= Integer.valueOf(cpValue[0]);
			    Integer pValue= Integer.valueOf(cpValue[1]);
			    System.out.println("Values-"+cValue+": "+pValue); 
			    if(cValue == pValue){
			    	max=0;
			    	min=0;
			    }
			    else if(cValue > pValue){			    	
			    	int diff=cValue-pValue;
			    	if(diff==1){
			    		max=0;
			    	    min=0;
			    	}
			    	else{
			    		String res=rule1(cValue,pValue);
			    	}
			    		
			    }
			    else{
			    	System.out.println("Please enter geater C value than P value");  
			    }
			    
		    }
		    System.out.println("Scenario-"+scenario+": "+max+" "+min); 
		    
		}
	 
		 
		
	}
	
	public static String rule1(int cValue,int pValue){
		String val="";
		return val;
	}
	
    public static String rule2(int cValue,int pValue){
    	String val="";
		return val;    	
    }
	
}
