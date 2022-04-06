package src.week3;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import src.week3.SortTypes.*;

public class BigData {
    private final ArrayList<Integer> data = new ArrayList<>();
    private final Duration timeElapsed;

    public BigData(int size, String method) {
        Instant start = Instant.now();  // time capture -- start
        // build an array
        for (int i = 0; i < size; i++) {
            data.add((int)(Math.random() * (size+1)));
        }
        // use Inheritance and Polymorphism to replace data.sort with your own algorithm test message
        //BubbleSort.doTheSort(data);

        switch(method) {
          case "selection":
            SelectionSort.SortSortSort(data);
            System.out.println();
            break;
          case "bubble": 
            BubbleSort.SortSortSort(data);
            System.out.println();
            break;
          case "insertion":
            InsertionSort.SortSortSort(data);
            break;
          case "merge":
            MergeSort.SortSortSort(data);
            break;
          default:
            System.out.println("invalid sort method");
        }

        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end);
      
    }
      public ArrayList<Integer> getData() {
        return data;
    }

    public int getTimeElapsed() {
        return timeElapsed.getNano();
    }
}
