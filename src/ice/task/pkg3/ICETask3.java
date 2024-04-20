/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ice.task.pkg3;

/**
 *
 * @author lab_services_student
 */
import java.lang.Math;
import java.util.Scanner;

public class ICETask3 {

    /**
     * @param args the command line arguments
     */
    //Question 1
    public static boolean isValid(String testString) {
        // If the length of the string is odd, it can't be valid
        if (!(testString.length() % 2 == 0) || (testString.length() == 0) ) {
            return false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testString.length(); i++) {
            char p = testString.charAt(i);
            if (p == '(' || p == '[' || p == '{') {
                sb.append(p);
            } else {
                if (sb.length() == 0) {
                    return false; // More closing brackets than opening ones
                }
                char lastOpen = sb.charAt(sb.length() - 1);
                if ((p == ')' && lastOpen == '(') ||
                    (p == ']' && lastOpen == '[') ||
                    (p == '}' && lastOpen == '{')) {
                    sb.deleteCharAt(sb.length() - 1); // Match found, remove the open parenthesis
                } else {
                    return false; // Mismatched parentheses
                }
            }
        }
        // If there are still open parentheses remaining
        return sb.length() == 0;
    }
    
    
    
    //Question 2
    public static double odd_squares_sum(int limit){
    
        int num = 0, count;
        double answer = 0;

        for(count = 0; count <= limit; count++){
        if (!(num % 2 == 0)){
        answer = answer + Math.pow(num, 2);
        }
        num++;
        }
         return answer; 
    }
    
    //Question 3
    public static int  greatest_common_divisor(int num1, int num2){
    // values from user 
    int var1, var2, divisor = 0;
    var1 = num1;
    var2 = num2;
    
    if ( var1 > var2){
     for (int count = 1; count < var1; count++){
     if (((var1 % count == 0) && (var2 % count == 0)) && count <= var1){
     divisor = count;
     }
     }
    }
    else if ( var2 > var1){
     for (int count = 1; count < var2; count++){
     if (((var2 % count == 0) && (var1 % count == 0)) && count<= var2){
     divisor = count;
     }
     }
    }
    return divisor;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        String[] testCases = {"{}{)}", "", "{[}]", "()", "({[]})"};
        for (String testCase : testCases) {
            System.out.println(testCase + " - " + isValid(testCase));
        }
        
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);
        Scanner question1 = new Scanner(System.in);
        
       // Prompt the user to enter the first number
        System.out.print("Enter a number limit: ");
        // Read the first variable from the user input
        int numLimit = question1.nextInt();
        
        // Prompt the user to enter the first number
        System.out.print("Enter the first number: ");
        // Read the first variable from the user input
        int num1 = scanner.nextInt();
        
        // Prompt the user to enter the second variable
        System.out.print("Enter the second number: ");
        // Read the second variable from the user input
        int num2 = scanner.nextInt();
        
        // Display the values entered by the user
        System.out.println("The funtion odd squares sum yields the final sum of "+ odd_squares_sum(numLimit) );
        // Display the values entered by the user
        System.out.println("The greatest common divisor is "+ greatest_common_divisor(num1,num2) );
        
    }
    
}
