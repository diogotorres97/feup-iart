import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.AbstractMap.SimpleEntry;

public class AnuranPrediction {
  HashSet<String> species = new HashSet<>();
  HashMap<String, String> species_to_family = new HashMap<>();
  HashMap<String, String> species_to_genus = new HashMap<>();
  ArrayList<SimpleEntry<double[], double[]>> dataRows = new ArrayList<>();

  public static void main(String args[]) {
    AnuranPrediction predictor = new AnuranPrediction();
    //TODO: Validate args (when program call structure is defined)
    DataReader.readData(args[0], predictor);
    /*for(SimpleEntry<double[], double[]> a : predictor.dataRows) {
      System.out.println("Line Start ----");
      System.out.println("Input");
      for(double e : a.getKey())
        System.out.print(e + " ");
      System.out.println("Output");
      for(double i : a.getValue())
        System.out.print(i + " ");
      System.out.println("Line End ----");
    }

    for(String e : predictor.species)
      System.out.println(e);

    for(String e : predictor.species_to_family.keySet())
      System.out.println(e + ", part of family " + predictor.species_to_family.get(e));

    for(String e : predictor.species_to_genus.keySet())
      System.out.println(e + ", part of genus " + predictor.species_to_genus.get(e));
    */
  }
}
