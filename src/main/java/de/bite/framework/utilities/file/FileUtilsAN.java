/**
 *
 * Copyright (c) 2013.06.14
 * M-net Telekommunikations GmbH
 * 
 * @author nixdorfan
 * Java-JDK : Java(TM) SE Runtime Environment 1.7.0-b147
 * 
 */

/*
* @(#)FileUtilsAN.java   11/12/17
*
* Copyright (c) 2011 M-net GmbH | bi/te
* @author nixdorfan
*
 */
package de.bite.framework.utilities.file;

//~--- non-JDK imports --------------------------------------------------------

import org.apache.log4j.Logger;

//~--- JDK imports ------------------------------------------------------------

import java.io.*;

import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

import java.util.ArrayList;
import java.util.List;

//~--- classes ----------------------------------------------------------------

/**
 * class for copying, reading and writing text- and binary-files
 * @author nixdorfan
 * started 22.04.2004
 * code sniplets added last 24.12.2006
 * last update 04.11.2009
 */
public class FileUtilsAN
{

  //~--- static fields --------------------------------------------------------

  private static Logger logger = Logger.getLogger(FileUtilsAN.class);

  //~--- methods --------------------------------------------------------------

  /**
   *  is File a Directory ?
   *
   * @param file File
   *
   * @return boolean
   */
  public static boolean isDirectory(File file)
  {
    return file.isDirectory();
  }

  /**
   *  is File a file ?
   *
   * @param file File
   *
   * @return boolean
   */
  public static boolean isFile(File file)
  {
    return file.isFile();
  }

  /**
   *   read Textfile (buffered) and returns string
   *
   * @param fileName String
   *
   * @return String
   */
  public static String readBuffered(String fileName)
  {

    // logger.debug(BiteConstants.debug_message + " starting readBuffered(String fileName)");
    if(fileName == null)
    {

      // logger.error(BiteConstants.error_message + " readBuffered(String fileName) FileName == NULL ");
      return null;
    }

    try
    {
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      StringBuffer   sb = new StringBuffer();
      String         line;

      while((line = br.readLine()) != null)
      {
        sb.append(line + "\n");
      }

      br.close();

      return sb.toString();
    }
    catch(IOException ex)
    {

      // logger.error(BiteConstants.error_message + " readBuffered(String fileName) " + ex);
      return null;
    }
  }

  /**
   *  read Textfile (buffered) and returns Vector consisting the lines of the textfile
   *
   * @param fileName String
   *
   * @return List
   */
  public static List readBufferedLine(String fileName)
  {

    // logger.debug(BiteConstants.debug_message + " starting readBufferedLine(String fileName)");
    if(fileName == null)
    {

      // logger.error(BiteConstants.error_message + " readBufferedLine(String fileName) FileName == NULL ");
      return null;
    }

    ArrayList vec = new ArrayList();
    String    line;

    try
    {
      BufferedReader br = new BufferedReader(new FileReader(fileName));

      while((line = br.readLine()) != null)
      {
        vec.add(line);
      }

      br.close();

      return vec;
    }
    catch(IOException ex)
    {

      // logger.error(BiteConstants.error_message + " readBufferedLine(String fileName) " + ex);
      return null;
    }
  }

  /**
   *    read Textfile (buffered) and returns List<String> consisting the lines of the textfile
   *    encoding can be set explicitly
   *
   *   @param fileName String
   *   @param encoding String
   *    @return List<String>
   *    @throws Exception
   */
  public static List< String > readBufferedLine(String fileName, String encoding) throws Exception
  {

    logger.debug(" starting readBufferedLine(String fileName, String encoding)");

    if(fileName == null)
    {
      logger.error(" readBufferedLine(String fileName, String encoding) FileName == NULL ");
      throw new Exception("no filename to process.");
    }

    if((encoding == null) || (encoding == ""))
    {
      logger.error(" readBufferedLine(String fileName, String encoding) encoding == NULL oder encoding == \"\" ");
      throw new Exception("no encoding set.");
    }

    ArrayList< String > vec = new ArrayList< String >();
    String              line;

    try
    {
      InputStream    fileInputStream = new FileInputStream(fileName);
      Reader         fileReader      = new InputStreamReader(fileInputStream, encoding);
      BufferedReader br              = new BufferedReader(fileReader);

      while((line = br.readLine()) != null)
      {
        vec.add(line);
      }

      br.close();

      return vec;
    }
    catch(IOException ex)
    {
      logger.error(" readBufferedLine( String fileName, String encoding ) " + ex);
      throw new RuntimeException(ex);
    }

  }

  /**
   *  write Textfile (buffered) and returns true or false (if exception takes place)
   *  writes only in a file which already exists
   *
   * @param fileName String
   * @param toSafe String
   *
   * @return boolean
   */
  public static boolean writeBuffered(String fileName, String toSafe)
  {

    if(fileName == null)
    {

      // logger.error(BiteConstants.error_message + " writeBuffered(String fileName,String toSafe) FileName == NULL ");
      return false;
    }

    if(toSafe == null)
    {

      // logger.error(BiteConstants.error_message + " writeBuffered(String fileName,String toSafe) toSafe == NULL ");
      return false;
    }

    try
    {
      BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

      bw.write(toSafe);
      bw.close();

      return true;
    }
    catch(IOException ex)
    {

      // logger.error(BiteConstants.error_message + " writeBuffered(String fileName,String toSafe) " + ex);
      return false;
    }

  }

  /**
   *  write Textfile (buffered) and returns true or false (if exception takes place)
   *  writes only in a file which already exists
   *
   * @param fileName String
   * @param toSafe String
   * @param encoding String
   *
   * @return boolean
   */
  public static boolean writeBuffered(String fileName, String toSafe, String encoding)
  {

    if(fileName == null)
    {
      logger.error(" writeBuffered(String fileName,String toSafe) FileName == NULL ");

      return false;
    }

    if(toSafe == null)
    {
      logger.error(" writeBuffered(String fileName,String toSafe) toSafe == NULL ");

      return false;
    }

    if((encoding == null) || (encoding == ""))
    {
      logger.error(" readBufferedLine(String fileName, String encoding) encoding == NULL oder encoding == \"\" ");

      return false;
    }

    try
    {
      OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fileName), encoding);

      out.write(toSafe);
      out.close();

      return true;
    }
    catch(IOException ex)
    {
      logger.error(" writeBuffered(String fileName,String toSafe) " + ex);

      return false;
    }

  }

  /**
   *  write Textfile (buffered) and returns true or false (if exception takes place)
   *  writes in new File
   *
   * @param Name String
   * @param Text String
   *
   * @return boolean
   */
  public static boolean writeBufferedText(String Name, String Text)
  {

    if(Name == null)
    {

      // logger.error(BiteConstants.error_message + " writeBuffered(String Name,String Text) Name == NULL ");
      return false;
    }

    if(Text == null)
    {

      // logger.error(BiteConstants.error_message + " writeBuffered(String Name,String Text) Text == NULL ");
      return false;
    }

    try
    {
      File           toWrite = new File(Name);
      BufferedWriter bw      = new BufferedWriter(new FileWriter(toWrite));

      bw.write(Text);
      bw.flush();
      bw.close();

      return true;
    }
    catch(IOException ex)
    {

      // logger.error(BiteConstants.error_message + " writeBufferedText(String Name,String Text) " + ex);
      return false;
    }

  }

  /**
   *  copy file (binary) and returns true or false (if exception takes place)
   *  correlated to java heap space. If file is bigger than heap space or about 1.4 GB than
   *  out of memory error
   *
   * @param readFile File
   * @param writeFile File
   *
   * @return boolean
   */
  public static boolean writeInputFile(File readFile, File writeFile)
  {

    if(readFile == null)
    {

      // logger.error(BiteConstants.error_message + " writeInputFile(File readFile, File writeFile) readFile == NULL ");
      return false;
    }

    if(writeFile == null)
    {

      // logger.error(BiteConstants.error_message + " writeInputFile(File readFile, File writeFile) writeFile == NULL ");
      return false;
    }

    try
    {
      FileInputStream  in  = new FileInputStream(readFile);
      FileOutputStream out = new FileOutputStream(writeFile);
      byte[]           buf = new byte[(int)readFile.length()];
      int              len;

      while((len = in.read(buf)) > 0)
      {
        out.write(buf, 0, len);
      }

      out.close();
      in.close();

      return true;
    }
    catch(IOException ex)
    {

      // logger.error(BiteConstants.error_message + " writeInputFile(File readFile, File writeFile) " + ex);
      return false;
    }

  }

  /**
   *
   * @param readFile File
   * @param writeFile File
   *
   * @return boolean
   */
  public static boolean copyFiles(File readFile, File writeFile)
  {

    if(readFile == null)
    {

      // logger.error(BiteConstants.error_message + " writeInputFile(File readFile, File writeFile) readFile == NULL ");
      return false;
    }

    if(writeFile == null)
    {

      // logger.error(BiteConstants.error_message + " writeInputFile(File readFile, File writeFile) writeFile == NULL ");
      return false;
    }

    try
    {
      FileInputStream  in            = new FileInputStream(readFile);
      FileOutputStream out           = new FileOutputStream(writeFile);
      FileChannel      inputChannel  = in.getChannel();
      FileChannel      outputChannel = out.getChannel();

      transfer(inputChannel, outputChannel, readFile.length(), 1024 * 1024 * 32 /* 32 MB */, true, true);
      in.close();
      out.close();

      return true;
    }
    catch(Exception ex)
    {

      // logger.error(BiteConstants.error_message + " copyFile " + ex.getLocalizedMessage());
      return false;
    }

  }

  /**
   *
   * @param fileChannel FileChannel
   * @param byteChannel ByteChannel
   * @param lengthInBytes long
   * @param chunckSizeInBytes long
   * @param verbose boolean
   * @param fromFile boolean
   *
   * @throws IOException
   */
  private static void transfer(FileChannel fileChannel, ByteChannel byteChannel, long lengthInBytes, long chunckSizeInBytes, boolean verbose, boolean fromFile) throws IOException
  {

    long overallBytesTransfered = 0L;
    long time                   = -System.currentTimeMillis();

    while(overallBytesTransfered < lengthInBytes)
    {
      long bytesTransfered = 0L;

      if(fromFile)
      {
        bytesTransfered = fileChannel.transferTo(0, Math.min(chunckSizeInBytes, lengthInBytes - overallBytesTransfered), byteChannel);
      }
      else
      {
        bytesTransfered = fileChannel.transferFrom(byteChannel, overallBytesTransfered, Math.min(chunckSizeInBytes, lengthInBytes - overallBytesTransfered));
      }

      overallBytesTransfered += bytesTransfered;

      /*
       * if (verbose) {
       *   System.out.printf(
       *           "overall bytes transfered: %s progress %s%%\n",
       *           overallBytesTransfered, Math
       *                   .round(overallBytesTransfered
       *                           / ((double) lengthInBytes) * 100.0));
       * }
       */
    }

    time += System.currentTimeMillis();

    /*
     * if (verbose) {
     *   System.out.printf("Transfered: %s bytes in: %s s -> %s kbytes/s",
     *           overallBytesTransfered, time / 1000,
     *           (overallBytesTransfered / 1024.0) / (time / 1000.0));
     * }
     */

  }
}


/* ||\
 * ---------------------------------------------------------
 */
