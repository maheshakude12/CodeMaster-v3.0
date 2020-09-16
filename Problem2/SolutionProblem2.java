import java.util.ArrayList;
import java.util.ListIterator;

public class SolutionProblem2 {
    public static void main(String[] argv) throws Exception
    {

        ArrayList<String> arrlist = new ArrayList<String>();
        arrlist.add("5");
        arrlist.add("100");
        arrlist.add("132");
        arrlist.add("1000");
        arrlist.add("7");
        arrlist.add("111111111111111110");

        for(int i=1;i<=Integer.parseInt(arrlist.get(0));i++){
            String value = arrlist.get(i) ;
            boolean isluckyNumber = false;
            long cuurentnum = Long.parseLong(value);
            if(value.length()!=1){

                do {
                    cuurentnum = cuurentnum - 1;
                    isluckyNumber = isValidLuckyNumber(cuurentnum);
                } while (!isluckyNumber);
            }
            System.out.println("Request-" + i + " : "+ cuurentnum);
        }

    }

    private static boolean isValidLuckyNumber(long cuurentnum) {

        char[] charArray = String.valueOf(cuurentnum).toCharArray();
        int currDigit,nextDigit,prevDigit = 0;
        StringBuilder output = new StringBuilder();
        for(int j=0;j<charArray.length-1;j++) {
            currDigit = Integer.parseInt(String.valueOf(charArray[j]));
            nextDigit = Integer.parseInt(String.valueOf(charArray[j+1]));
            if(currDigit>nextDigit){
                return false;
            }
        }
        return true;
    }
}

