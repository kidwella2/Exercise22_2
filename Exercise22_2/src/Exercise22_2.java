/*
 * Name: Austin Kidwell
 * Course Number: CSC 364-001
 * Description: This program finds the longest increasing subsequence
 * of a string entered.
 */
import java.util.Scanner;

public class Exercise22_2 {
  public static void main(String[] args) {
    //Create scanner to input a string
	Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    //Initialize string s as the inputed value
    String s = input.next();
    //Close scanner
    input.close();

    //score[] is used to keep track of increases in string s
    int score[] = new int[s.length()];
    //prev[] is used to find the indexes where s increases
    int prev[] = new int[s.length()];
    //Initialize value to find highest length of increses in s
    int maxLength = 1;
    //Value for i with highest increases
    int end = 0;

    //Two for loops used to give score[] and prev[] values
    for(int i = 0; i < s.length(); i++){
    	//Set starting values for score[] and prev[]
    	score[i] = 1;
    	prev[i] = -1;
    	for(int j = i-1; j >= 0; j--){
    		//Find increases in s and set values to score[] and prev[]
    		if(score[j] + 1 > score[i] && s.charAt(j) < s.charAt(i)){
    			score[i] = score[j] + 1;
    			prev[i] = j;
    		}
    		//Find highest length of increses in s
    		if(score[i] > maxLength){
    			maxLength = score[i];
    			end = i;
    		}
    	}
    }

    //Initialize array to hold results
	char result[] = new char[maxLength];
	//Use prev[] data to create an array that shows the
    //longest increasing subsequence
    for(int i = maxLength; i > 0; i--){
    	//While end != -1, prev[] shows order of max increasing subsequence
    	while(end != -1){
    		result[--i] = s.charAt(end);
    		end = prev[end];
    	}
    }

    //Print result for longest increasing subsequence
    for(int i = 0; i < maxLength; i++){
    	System.out.print(result[i]);
    }
  }
}