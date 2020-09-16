import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Problem2 {

    private static final String FILE_NAME = "Problem2_input.txt";

    public static void main(String[] args) throws IOException {
        Path fileInputPath = Paths.get("C:\\tmp", "Problem2_input.txt");
//        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_NAME);
        Path fileOutputPath = Paths.get("C:\\tmp", "output.txt");
        List<Integer> list = new ArrayList<Integer>();
        //Reading input file
        try (Stream<String> lines = Files.lines(fileInputPath)) {
//            lines.forEach(System.out::println);
            lines.forEach(no -> list.add(Integer.valueOf(no)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Writing result into output file
        try (BufferedWriter writer = Files.newBufferedWriter(fileOutputPath)) {
            {
            int counter = 1;
            for( Integer num : list){
                for(int i= num;i>0;i--){
                    boolean result = getLuckyNumber(i);
                    if(result){
//                            System.out.println("lucky number"+i);
                        try {
                            writer.write("Requester -" + counter++ + ": " + i);
//                                writer.write(i);
                            writer.write("\n");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }

                }
            }

            }
        }
    }


    private static boolean getLuckyNumber(int num) {
        int temp, digit=0, tempDigit=0, count = 0, count1 = 0, tempNumber;
        boolean result = true ;
//        System.out.println("Input number is: "+num);
        //making a copy of the input number
        temp = num;
        tempNumber= num;
        //counting digits in the input number
        while(num > 0)
        {
            num = num / 10;
            count++;
        }
        while(temp > 0)
        {
            digit = temp % 10;
//            System.out.println("Digit at place "+count+" is: "+digit);
//            System.out.println("Temp Digit inside at place "+count+" is: "+tempDigit);
            if(count1>0 && (tempDigit < digit)){
                result = false;
//            	System.out.println("not a lucky number"+tempNumber);
                break;
            }
            tempDigit = digit;
            temp = temp / 10;
            count--;
            count1++;

        }
        return result ;


    }
}
