/* Filename: Picture.java 
* Created by: Shuaiqi Xia, cs8a3 and Tony Xia, cs8a4
* Date: 
*/ 

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    
    return output;
    
  }
  
  /*
   * This method  preserve the 2 most significant (i.e. leftmost) bits in each 8-bit number
   * Example: The most significant 2 bits of 250 (11111010) are 11 in binary which is equal to 3 in decimal. 
   */
  public static int mostSignificant2( int num )
  {
    return num >> 6;
  }  
   
  
  /* 
   * This method  preserve the N most significant (i.e. leftmost) bits in each 8-bit number
   * Example: If N=3 ,the most significant 3 bits of 250 (11111010) are 111 in binary which is equal to 7 in decimal. 
   */
  public static int mostSignificantN( int num, int N )
  {
    return num >> (8-N);  
  }
  
  public static int shift2BitsTo8( int num )
  {
    return num << 6;
  }
  
  /* 
   * This method  converts num with N bits into 8 bits
   * Example: If if num is 2 and N is 3, it means num is 010 in binary. This method will convert it into 01000000,
   * which is eual to 64 in decimal.
   */
  public static int shiftNBitsTo8( int num, int N )
  {
    return num << (8-N);  // You must implement this
  }
 
   
  /*
   * This method creates a copy of picture passed in the parameter. It changes the red, blue and green components 
   * of each pixel in copied picture. It uses the method mostSignificant2 to convert the 8-bit values into 2 bit values
   *
   *  Hence if you call this method, it will give you a copy of the picture passed in the parameter. But the copied picture has only 2 bits of 
   * information per color. For example, if blue color value for  any pixel in the picture is 01000000 (64 in decimal), the correspoding value 
   * of red color in copied picuture would be just 00000001 (1 in decinal)
   *
   */
  public static Picture degradeColors2Bits(Picture sourcePicture) {
    Picture picCopy = new Picture( sourcePicture.getWidth(), sourcePicture.getHeight() );
    for ( int x = 0; x < sourcePicture.getWidth(); x++ ) {
      for ( int y = 0; y < sourcePicture.getHeight(); y++ ) {
        Pixel source = sourcePicture.getPixel( x, y );
        Pixel target = picCopy.getPixel( x, y );
        
        int red = source.getRed();
        int green = source.getGreen();
        int blue = source.getBlue();
       
        red = mostSignificant2( red );
        green = mostSignificant2( green );
        blue = mostSignificant2( blue );
        
        red = shift2BitsTo8( red);
        green = shift2BitsTo8( green);
        blue = shift2BitsTo8( blue);
        
        target.setRed( red );
        target.setGreen( green );
        target.setBlue( blue );
      }
    }
    return picCopy;
  
 }  

  /*
   This method creates a copy of the picture passed in the parameter. It changes the red, blue and green components 
   of each pixel in copied picture. It uses the method mostSignificantN to convert the 8-bit values into N bit values
   and then shift it back to 8 bit values.
   Hence if you call this method with the Picture as one of the parameters, it will give you a copy of the picture. 
   But the copied picture has only N bits of information per color.
   */
  public static Picture degradeColorsNBits(Picture sourcePicture,int N) {
    Picture picCopy = new Picture( sourcePicture.getWidth(), sourcePicture.getHeight() );
    for ( int x = 0; x < sourcePicture.getWidth(); x++ ) {
      for ( int y = 0; y < sourcePicture.getHeight(); y++ ) {
        Pixel source = sourcePicture.getPixel( x, y );
        Pixel target = picCopy.getPixel( x, y );
        int red = source.getRed();
        int green = source.getGreen();
        int blue = source.getBlue();
        
        red = mostSignificantN( red, N );
        green = mostSignificantN( green, N);
        blue = mostSignificantN( blue, N);
        
        red = shiftNBitsTo8( red, N );
        green = shiftNBitsTo8( green, N);
        blue = shiftNBitsTo8( blue, N);
        
        target.setRed( red );
        target.setGreen( green );
        target.setBlue( blue );
      }
    }
    return picCopy;
 } 
  
  //Implement this method
  public static Picture hideSecretMessage2Bits(Picture context, Picture message, int x, int y){
    return null;
  }
  
  //Implement this method
  public static Picture recoverSecretMessage2Bits(Picture picWithMessage, int x, int y){
    return null;
  }
  //This method will use shift operators (and addition) to replace the two least significant digits in contextVal with the value of messageVal. 
  public static int embedDigits2( int contextVal, int messageVal ){
    contextVal = contextVal >> 2;
    contextVal = contextVal << 2;
    return contextVal + messageVal; //embedding digits 
    
  }
 
  //This method will embed an integer of N bits, messageVal, in contextVal. 
  public static int embedDigitsN( int contextVal, int messageVal, int N ){
    contextVal = contextVal >> N;
    contextVal = contextVal << N; 
    return contextVal + messageVal;  //returning the result (new value after embedding) 
  }
  
  //This method will return the 2 least significant digits in decimal from the input num, which will always be an integer between 0 and 255 inclusive.  
  public static int getLeastSignificant2( int num ){
    num = num >> 30; //32 bits in a integer
    num = num << 30; 
    return num; 
  }
  
  //This method will return the N least significant digits of parameter num.   
  public static int getLeastSignificantN( int num, int N ){
    num = num >> 30; //32 bits in a integer
    num = num << 30; 
    return num + N; 
  }
  
      
}// this } is the end of class Picture, put all new methods before this
 
