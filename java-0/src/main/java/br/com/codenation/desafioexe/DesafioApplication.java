package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

  public static List<Integer> fibonacci() {

    int n = 1;

    List<Integer> fibonacciNumbers = new ArrayList<>();
    fibonacciNumbers.add(0);
    fibonacciNumbers.add(1);

    while (n < 350) {
      n = Integer.sum(fibonacciNumbers.get(fibonacciNumbers.size() - 1), fibonacciNumbers.get(fibonacciNumbers.size() - 2));
      fibonacciNumbers.add(n);

    }
    return fibonacciNumbers;
  }
    public static Boolean isFibonacci (Integer a){
      return fibonacci().contains(a);
    }

  }

