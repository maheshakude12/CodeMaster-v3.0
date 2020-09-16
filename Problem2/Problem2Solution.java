import java.io.*;
import java.util.ArrayList;

public class Problem2Solution {
    public static void main(String[] args) {


        BufferedReader reader;
        try {
            int noMsg;
            Long output;
            ArrayList outputList = new ArrayList();

            //  reader = new BufferedReader(new FileReader("C:\\Git\\CodeMaster-v3.0\\Problem2\\Problem2_input.txt"));
            reader = new BufferedReader(new FileReader("C:\\Git\\CodeMaster-v3.0\\Problem2\\Problem2_input.txt"));
            String line = reader.readLine();
            int msg = Integer.valueOf(line);


            for (int ii = 0; ii < msg; ii++) {
                line = reader.readLine();
                //System.out.println(line + " ----ii"+ii);
                //output= Long.valueOf(line);
                outputList.add("Request-"+ii+": "+ generateLuckyNo(line));
                System.out.println("Request-"+ii+": "+ generateLuckyNo(line));
            }


            File fout = new File("output.txt");
            FileOutputStream fos = new FileOutputStream(fout);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (int m = 0; m < outputList.size(); m++) {
                bw.write(outputList.get(m).toString());
                bw.newLine();
            }
            bw.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static boolean checkLuckyformat(Long no){


        Long number = no;
        int len = Long.toString(number).length();
        int cArrLen=0;
        boolean result;
        int index;
        Long[] iarray = new Long[len];
        for ( index = 0; index < len; index++) {
            iarray[index] = number % 10;
            number /= 10;

            //cArrLen = iarray.length-1;

            if(index >0){
                if(!(iarray[index]<= iarray[index-1])){
                    //  System.out.println("-----"+false+"==="+iarray[index]);
                    // System.out.println("-----"+false+"==="+iarray[index]);
                    return false;
                }
            }

            //  System.out.println("------------------"+iarray[index]);
        }

        if(!(iarray[index-1]<= iarray[index-2])){
            return false;
        }
        else{
            return true;}


    }
    static Long generateLuckyNo(String inputLine){

        Long inputNo = Long.valueOf(inputLine);
        Long newLucky=inputNo;

        if(inputNo <10){
            return inputNo;
        }
        else{
            while (true){
                if(checkLuckyformat(newLucky)&& !(newLucky <= 9) ){
                    System.out.println(checkLuckyformat(newLucky));
                    return Long.valueOf(newLucky);
                } else {
                    newLucky = newLucky-1;
                    //   System.out.println("newLucky"+newLucky);
                }
            }
        }
    }
}
