/**
 *
 * Copyright (c) 2012.03.08
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0_01-b08
 * 
 */

/*
* @(#)CryptoProcessor.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.crypto.hash;

//~--- JDK imports ------------------------------------------------------------

import java.io.UnsupportedEncodingException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

//~--- classes ----------------------------------------------------------------

/**
 *
 * @author         nixdorfan
 */
public class CryptoProcessor
{

  //~--- fields ---------------------------------------------------------------

  private String encoding = "";
  HashMap<String,String> myReallyNiceRomanRoleDecryption=null;
  HashMap<String,String> myReallyNiceRomanRoleEncryption=null;

  //~--- constructors ---------------------------------------------------------

  /**
   */
  public CryptoProcessor()
  {
    this.encoding = "iso-8859-1";
    initialize();
  }




  /**
   *
   * @param encoding String
   */
  public CryptoProcessor(String encoding)
  {
    this.encoding = encoding;
    initialize();
  }



  private void initialize(){
      
      myReallyNiceRomanRoleDecryption = new HashMap<String,String>();
      
      myReallyNiceRomanRoleDecryption.put("a", "z");
      myReallyNiceRomanRoleDecryption.put("b", "v");
      myReallyNiceRomanRoleDecryption.put("c", "s");
      myReallyNiceRomanRoleDecryption.put("d", "t");
      myReallyNiceRomanRoleDecryption.put("e", "r");
      myReallyNiceRomanRoleDecryption.put("f", "u");
      myReallyNiceRomanRoleDecryption.put("g", "h");
      myReallyNiceRomanRoleDecryption.put("h", "j");
      myReallyNiceRomanRoleDecryption.put("i", "x");
      myReallyNiceRomanRoleDecryption.put("j", "w");
      myReallyNiceRomanRoleDecryption.put("k", "y");
      myReallyNiceRomanRoleDecryption.put("l", "o");
      myReallyNiceRomanRoleDecryption.put("m", "n");
      myReallyNiceRomanRoleDecryption.put("n", "p");
      myReallyNiceRomanRoleDecryption.put("o", "q");
      myReallyNiceRomanRoleDecryption.put("p", "m");
      myReallyNiceRomanRoleDecryption.put("q", "l");
      myReallyNiceRomanRoleDecryption.put("r", "k");
      myReallyNiceRomanRoleDecryption.put("s", "i");
      myReallyNiceRomanRoleDecryption.put("t", "g");
      myReallyNiceRomanRoleDecryption.put("u", "f");
      myReallyNiceRomanRoleDecryption.put("v", "d");
      myReallyNiceRomanRoleDecryption.put("w", "e");
      myReallyNiceRomanRoleDecryption.put("x", "a");
      myReallyNiceRomanRoleDecryption.put("y", "c");
      myReallyNiceRomanRoleDecryption.put("z", "b");
      myReallyNiceRomanRoleDecryption.put("1", "0");
      myReallyNiceRomanRoleDecryption.put("2", "9");
      myReallyNiceRomanRoleDecryption.put("3", "8");
      myReallyNiceRomanRoleDecryption.put("4", "7");
      myReallyNiceRomanRoleDecryption.put("5", "6");
      myReallyNiceRomanRoleDecryption.put("6", "5");
      myReallyNiceRomanRoleDecryption.put("7", "4");
      myReallyNiceRomanRoleDecryption.put("8", "3");
      myReallyNiceRomanRoleDecryption.put("9", "2");
      myReallyNiceRomanRoleDecryption.put("0", "1");
      myReallyNiceRomanRoleDecryption.put("#", "#");
      myReallyNiceRomanRoleDecryption.put("!", "!");
      
      myReallyNiceRomanRoleEncryption = new HashMap<String,String>();
      
      myReallyNiceRomanRoleEncryption.put("z", "a");
      myReallyNiceRomanRoleEncryption.put("v", "b");
      myReallyNiceRomanRoleEncryption.put("s", "c");
      myReallyNiceRomanRoleEncryption.put("t", "d");
      myReallyNiceRomanRoleEncryption.put("r", "e");
      myReallyNiceRomanRoleEncryption.put("f", "u");
      myReallyNiceRomanRoleEncryption.put("h", "g");
      myReallyNiceRomanRoleEncryption.put("j", "h");
      myReallyNiceRomanRoleEncryption.put("x", "i");
      myReallyNiceRomanRoleEncryption.put("w", "j");
      myReallyNiceRomanRoleEncryption.put("y", "k");
      myReallyNiceRomanRoleEncryption.put("o", "l");
      myReallyNiceRomanRoleEncryption.put("n", "m");
      myReallyNiceRomanRoleEncryption.put("p", "n");
      myReallyNiceRomanRoleEncryption.put("q", "o");
      myReallyNiceRomanRoleEncryption.put("m", "p");
      myReallyNiceRomanRoleEncryption.put("l", "q");
      myReallyNiceRomanRoleEncryption.put("k", "r");
      myReallyNiceRomanRoleEncryption.put("i", "s");
      myReallyNiceRomanRoleEncryption.put("g", "t");
      myReallyNiceRomanRoleEncryption.put("f", "u");
      myReallyNiceRomanRoleEncryption.put("d", "v");
      myReallyNiceRomanRoleEncryption.put("e", "w");
      myReallyNiceRomanRoleEncryption.put("a", "x");
      myReallyNiceRomanRoleEncryption.put("c", "y");
      myReallyNiceRomanRoleEncryption.put("b", "z");
      myReallyNiceRomanRoleEncryption.put("u", "f");
      myReallyNiceRomanRoleEncryption.put("0", "1");
      myReallyNiceRomanRoleEncryption.put("9", "2");
      myReallyNiceRomanRoleEncryption.put("8", "3");
      myReallyNiceRomanRoleEncryption.put("7", "4");
      myReallyNiceRomanRoleEncryption.put("6", "5");
      myReallyNiceRomanRoleEncryption.put("5", "6");
      myReallyNiceRomanRoleEncryption.put("4", "7");
      myReallyNiceRomanRoleEncryption.put("3", "8");
      myReallyNiceRomanRoleEncryption.put("2", "9");
      myReallyNiceRomanRoleEncryption.put("1", "0");
      myReallyNiceRomanRoleEncryption.put("#", "#");
      myReallyNiceRomanRoleEncryption.put("!", "!");
  }

  //~--- methods --------------------------------------------------------------

  /**
   *
   * @param data byte[]
   * @return Konvertierter String in Hexadezimal-Schreibweise
   */
  public final static String convertToHex(byte[] data)
  {

    StringBuffer buf = new StringBuffer();

    for(int i = 0; i < data.length; i++)
    {
      int halfbyte  = (data[i] >>> 4) & 0x0F;
      int two_halfs = 0;

      do
      {
        if((0 <= halfbyte) && (halfbyte <= 9))
        {
          buf.append((char)('0' + halfbyte));
        }
        else
        {
          buf.append((char)('a' + (halfbyte - 10)));
        }

        halfbyte = data[i] & 0x0F;
      }
      while(two_halfs++ < 1);
    }

    return buf.toString();

  }

  /**
   *
   * @param text String
   * @return Konvertierter String (mit implizitem Aufruf der convertToHex-Funktion
   *
   * @throws NoSuchAlgorithmException
   * @throws UnsupportedEncodingException
   */
  public final String processToMD5Hash(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    MessageDigest md      = MessageDigest.getInstance("MD5");
    byte[]        md5hash = new byte[32];

    md.update(text.getBytes(this.encoding), 0, text.length());

    md5hash = md.digest();

    return convertToHex(md5hash);
  }
  
  
  
  public String doAReallyHeavyDecryption(String password){
 
      String theReallyPWD = password.substring(3,password.length() - 3);
      
      char[] singleCharacters = theReallyPWD.toCharArray();
      char[] newSingleCharacters = new char[singleCharacters.length];
      
      
      for(int i = 0;i<singleCharacters.length;i++){

          newSingleCharacters[i] = myReallyNiceRomanRoleDecryption.get(singleCharacters[i]+"").toCharArray()[0];
      }
      
      String decrypted="";
      for(int i=0;i<newSingleCharacters.length;i++){
          decrypted += newSingleCharacters[i];
      }
      
      return decrypted;
  }
  
  public String doAReallyHeavyEncryption(String wordToPassword){
 
      char[] singleCharacters = wordToPassword.toCharArray();
      char[] newSingleCharacters = new char[singleCharacters.length];
      
      
      for(int i = 0;i<singleCharacters.length;i++){
          try{
            newSingleCharacters[i] = myReallyNiceRomanRoleEncryption.get(singleCharacters[i]+"").toCharArray()[0];
          } catch(NullPointerException ex){
            
          }
      }
      
      String decrypted="";
      for(int i=0;i<newSingleCharacters.length;i++){
          decrypted += newSingleCharacters[i];
      }
      
      //System.out.println(decrypted);
      return "dib" + decrypted + "ilm";
  }
}


/* ||\
 * ---------------------------------------------------------
 */
