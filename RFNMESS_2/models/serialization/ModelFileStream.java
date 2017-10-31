/*Class to read and write serialized Objects to flat file.
 * Can create a ModelFileStream object in whichever class
 * you want to send or receive data from. For example:
 * 
 * ModelFileStream m = new ModelFileStream(); [Uses default constructor]
 * List<Restaurant> restList = new ArrayList<>();
 * String filepath = "C:/home/restaurants.dat";
 * restList.add(blah, blah, blah); 
 * m.writeToFile(restList, filepath);
 * 
 * Will write a .dat file containing the restaurant objects. Can then
 * call these objects from this file using readFromFile();
 * 
 * List<Restaurant> newRestList = m.readFromFile(filepath);
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ModelFileStream {

   public void writeToFile(List<Object> list, String file) {
      ObjectOutputStream outStream = null;
      try {
         outStream = new ObjectOutputStream(new FileOutputStream(file));
         for (Object p : list) {
            outStream.writeObject(p);
         }

      } catch (IOException ioException) {
         System.err.println("Error opening file.");
      } catch (NoSuchElementException noSuchElementException) {
         System.err.println("Invalid input.");
      } finally {
         try {
            if (outStream != null)
               outStream.close();
         } catch (IOException ioException) {
            System.err.println("Error closing file.");
         }
      }
   }

   public List<Object> readFromFile(String file) {
      List<Object> list = new ArrayList<>();
      ObjectInputStream inputStream = null;
      try {
         inputStream = new ObjectInputStream(new FileInputStream(file));
         while (true) {
            Object p = (Object) inputStream.readObject();
            list.add(p);
         }
      } catch (EOFException eofException) {
         return list;
      } catch (ClassNotFoundException classNotFoundException) {
         System.err.println("Object creation failed.");
      } catch (IOException ioException) {
         System.err.println("Error opening file.");
      } finally {
         try {
            if (inputStream != null)
               inputStream.close();
         } catch (IOException ioException) {
            System.err.println("Error closing file.");
         }
      }
      return list;
   }

}
