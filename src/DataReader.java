import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Arrays;
import java.util.AbstractMap.SimpleEntry;

public class DataReader {
  public static final int SPECIES = 24;
  public static final int FAMILY = 22;
  public static final int GENUS = 23;

  public static void readData(String filename, AnuranPrediction predictor) {
    BufferedReader buffer = DataReader.getDataBuffer(filename);
    DataReader.discardHeader(buffer);

    String currentLine;
    try {
      while((currentLine = buffer.readLine()) != null) {
        String[] lineElements = currentLine.split(",");

        //Extract output information
        predictor.species.add(lineElements[DataReader.SPECIES]);
        predictor.species_to_family.putIfAbsent(lineElements[DataReader.SPECIES], lineElements[DataReader.FAMILY]);
        predictor.species_to_genus.putIfAbsent(lineElements[DataReader.SPECIES], lineElements[DataReader.GENUS]);

        //Convert line to match desired input for network
        //TODO: Add correct output value(s) after they're decided (currently putting an array with the value 0 as output)
        predictor.dataRows.add(
          new SimpleEntry<>(
            Arrays.asList(Arrays.copyOfRange(lineElements, 0, DataReader.FAMILY)).stream().mapToDouble(Double::parseDouble).toArray(),
            new double[] {0}
          )
        );
      }
    }
    catch(IOException e) {
      e.printStackTrace();
    }
  }

  public static BufferedReader getDataBuffer(String filename) {
    BufferedReader dataBuffer = null;
    try {
      FileReader dataFile = new FileReader(filename);
      dataBuffer = new BufferedReader(dataFile);
    }
    catch (FileNotFoundException e) {
      System.out.println("Data set file not found, exiting");
      System.exit(-1);
    }

    return dataBuffer;
  }

  public static void discardHeader(BufferedReader buffer) {
    try {
      buffer.readLine();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
