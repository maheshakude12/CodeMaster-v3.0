import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Solution {

	
		
      
            public static void main(String[] args) {
                int a = 100, b = 10000;
                Solution luckyNums = new Solution();
                ArrayList<Integer> luckyList = luckyNums.findLuckyNums(a, b);
                for(int i=1;i<=100;i++) {
                System.out.println("Request :"+i+":"+luckyList.indexOf(i));
                System.out.println(luckyList);
                }
            }

            private ArrayList<Integer> findLuckyNums(int a, int b) {
                ArrayList<Integer> luckyList = new ArrayList<Integer>();
                int size = ("" + b).length();
                Scanner in = new Scanner(System.in);
                int maxNum = 81 * 4; //9*2*b.length() - 9 is used, coz it's the max digit
               // System.out.println("Request-1 : " + size + " MaxNum : " + maxNum);
                boolean[] primeArray = sieve(maxNum);

                for(int i=a;i<=b;i++) {
                    String num = "" + i;
                    int sumDigits = 0;
                    int sumSquareDigits = 0;

                    for(int j=0;j<num.length();j++) {
                        int digit = Integer.valueOf("" + num.charAt(j));
                        sumDigits += digit;
                        sumSquareDigits += Math.pow(digit, 2);
                    }

                    if(primeArray[sumDigits] && primeArray[sumSquareDigits]) {
                        luckyList.add(i);
                        
                    }
                }

                return luckyList;
            }

            private boolean[] sieve(int n) {
                boolean[] prime = new boolean[n + 1];
                Arrays.fill(prime, true);
                prime[0] = false;
                prime[1] = false;
                int m = (int) Math.sqrt(n);

                for (int i = 2; i <= m; i++) {
                    if (prime[i]) {
                        for (int k = i * i; k <= n; k += i) {
                            prime[k] = false;
                        }
                    }
                }

                return prime;
            }
        
        
         
	}


