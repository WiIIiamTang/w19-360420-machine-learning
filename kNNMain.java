import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.io.*;
import java.util.*;



public class kNNMain
{

  public static void main(String... args) throws FileNotFoundException
  {

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
    List<DataPoint> points = new ArrayList<DataPoint>();
    List<DataPoint> training_set = new ArrayList<DataPoint>();
    List<DataPoint> test_set = new ArrayList<DataPoint>();

    String filelocation = new String(args[0]);

    points = DataSet.readDataSet(filelocation);

    DataSet.printDataSet(points);
    System.out.println("\nThe labels are " + DataSet.getLabels(points));

    System.out.println("\nExample point: take the first DataPoint in the list.");
    System.out.println(Arrays.toString(points.get(0).getX()) + " with label = " + points.get(0).getLabel());




    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
    training_set = DataSet.getTrainingSet(points, 0.70);
    test_set = DataSet.getTestSet(points, 0.30);

    // TASK 4: write a new method in DataSet.java which takes as arguments two DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)



    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label
    int numNeighbours = 3;
    KNNClassifier classifier = new KNNClassifier(numNeighbours);

    DataPoint[] nearest = classifier.getNearestNeighbors(training_set, test_set.get(0));

    System.out.println("\nTest: the " + numNeighbours + " nearest neighbours to the first point of the test set are: ");

    for(int i = 0; i < nearest.length; i++)
    {
      for (int j = 0; j < nearest[i].x.length; j++)
      {
          System.out.print(nearest[i].x[j] + " ");
      }
      System.out.println(nearest[i].getLabel());

    }



    System.out.println("This will predict " + classifier.predict(training_set, test_set.get(0)) + "\n");


    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.
    double good = 0;
    double bad = 0;
    double acc = 0;
    double averageAcc = 0;
    int repeats = 100;

    for(int iterations = 0; iterations < repeats; iterations++)
    {

      for(int i = 0; i < test_set.size(); i++)
      {
        if(test_set.get(i).getLabel().equalsIgnoreCase(classifier.predict(training_set, test_set.get(i))))
        {
          System.out.println(test_set.get(i).getLabel() + "\tgood\t" + classifier.predict(training_set, test_set.get(i)));
          good++;
        }
        else
        {
          System.out.println(test_set.get(i).getLabel() + "\tbad\t" + classifier.predict(training_set, test_set.get(i)));
          bad++;
        }
      }

      acc = 100*(good/(bad+good));
      averageAcc += acc;
    }

    averageAcc = averageAcc/repeats;

    System.out.printf("\nPredicted on test set, got an average accuracy of %.2f percent over %d tries\n", averageAcc, repeats);

  }

}
