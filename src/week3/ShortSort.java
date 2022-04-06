package src.week3;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;  

import src.util.ConsoleColors;

public class ShortSort {
  
    public static void main(String[] args) {
    System.out.println("=-=-=-=-=-=SELECTION SORT=-=-=-=-=-=");
    analyze("selection");
    
    System.out.println("=-=-=-=-=-=BUBBLE SORT=-=-=-=-=-=");
    analyze("bubble");
    
    System.out.println("=-=-=-=-=-=INSERTION SORT=-=-=-=-=-=");
    analyze("insertion");

    System.out.println("=-=-=-=-=-=MERGE SORT=-=-=-=-=-=");
    analyze("merge");
  }

  public static void analyze(String method) {
    ArrayList<Integer> allTwelve = new ArrayList<Integer>();
    int TIMES = 12;
    int SIZE = 5000;
    int sum = 0;
    int time = 0;
    for(int i=0; i< TIMES; i++) {
        BigData s = new BigData(SIZE, method);
        for(int j = 0; j<s.getData().size(); j++) {
            // To see data, uncomment next line
            // System.out.println(s.getData());
            sum += s.getData().get(j);
        }

        time += s.getTimeElapsed();
        allTwelve.add(s.getTimeElapsed());
    }

    Collections.sort(allTwelve);
    
    System.out.println(ConsoleColors.WHITE_BOLD+ method+" Sort Analysis");

    //kian input
    int totalNan = 0;
    for (int a : allTwelve) {
      totalNan += a;
    }
    System.out.println("Total Nanoseconds (using array):" + totalNan);
    System.out.println("Total Seconds (using array): " + totalNan/1000000000.0);
    //finish...
    
    System.out.println("Total Nanoseconds: " + time );
    System.out.println("Total Seconds: " + time /1000000000.0);
    System.out.println("ALL times in Nanoseconds: " + allTwelve);
    System.out.println("Average time in seconds "+ConsoleColors.BLUE_UNDERLINED+"(with high and low): "+ConsoleColors.WHITE_BOLD+ time/12/1000000000.0);

    
    Integer allTen = 0;
    System.out.println("HIGH (in nano): "+allTwelve.remove(0)); // remove smallest
    System.out.println("LOW (in nano): "+allTwelve.remove(allTwelve.size()-1)); //remove largest
    for(Integer d : allTwelve) {
      allTen += d;
    }
    
    System.out.println("Average time in seconds "+ConsoleColors.BLUE_UNDERLINED+"(high low OMITTED): "+ConsoleColors.WHITE_BOLD+ allTen/10/1000000000.0);
    // System.out.println("Average random in ALL ITERATIONS: " + sum / (TIMES*SIZE));

    System.out.println(ConsoleColors.RESET);
   
  
  
    
  }
}
