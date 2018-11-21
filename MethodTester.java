/* Filename: MethodTester.java 
* Created by: Shuaiqi Xia, cs8a3 and Tony Xia, cs8a4
* Date: 
* 
* This class should be used to test all the new methods you have written in Picture.java class
* You can run the existing tests and add new tests to test your methods.
*/
import java.io.*;

public class MethodTester extends Picture
{
  public static void main (String[] args) throws IOException
  {
    
    // **** Test cases for method embedDigits2 *******
    int result = embedDigits2(182,2);
    System.out.println( "The result of embedDigits2(182,2) is " + result );
    if ( result == 182 ) {
      System.out.println( "This is correct!" );
    }
    else {
      System.out.println( "This is WRONG!  Should be 182" );
    }
    int result1 = embedDigits2(13,1); // Adding a similar test case to test this method for embedding 1 in 13;
    
    
    // **** Test cases for method embedDigitsN *******
    result = embedDigitsN(31,0,4);
    System.out.println( "The result of embedDigitsN(31,0,4) is " + result );
    if ( result == 16 ) {
      System.out.println( "This is correct!" );
    }
    else {
      System.out.println( "This is WRONG!  Should be 16" );
    }
    
    result1 = embedDigitsN(64,2,5); // Adding a test case to test embedDigitsN method when contextVal= 64,  messageVal=2 and N=5
    
    
     // **** Test cases for method getLeastSignificant2 *******
    result = getLeastSignificant2(255);
    System.out.println( "The result of getLeastSignificant2(255) is " + result );
    if ( result == 3 ) {
      System.out.println( "This is correct!" );
    }
    else {
      System.out.println( "This is WRONG!  Should be 3" );
    } 
    result1 = getLeastSignificant2(63);  // Adding a test case to test getLeastSignificant2 method when method arguments  63
    
    
     // **** Test cases for method getLeastSignificantN *******
    result = getLeastSignificantN(15,3);
    System.out.println( "The result of getLeastSignificantN(15,3) is " + result );
    if ( result == 7 ) {
      System.out.println( "This is correct!" );
    }
    else {
      System.out.println( "This is WRONG!  Should be 7" );
    }
    result1 = getLeastSignificantN(28,4); // Adding a test case to test getLeastSignificantN method when method arguments  num= 28, N = 4
  }
}



