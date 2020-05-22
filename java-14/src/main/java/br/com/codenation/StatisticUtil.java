package br.com.codenation;

import java.util.*;
import java.util.stream.Collectors;
public class StatisticUtil {


  public static int average(int[] elements) {
    int sum =0;

    if (elements==null)
      throw  new IllegalArgumentException("the elements can't be null");

    for (Integer i : elements){
      sum+=i;
    }
    return  sum/elements.length;
  }

  public static int mode(int[] elements) {
    if (elements==null)
      throw  new IllegalArgumentException("the elements can't be null");
    Map<Integer,Integer> count =new HashMap<>();
    for (Integer i : elements){
      Integer numTotal=count.get(i);
      count.put(i, (numTotal==null)?1:numTotal+1);
    }
    Map.Entry<Integer,Integer>maxEntryValue = null;
    for (Map.Entry<Integer,Integer>entry:count.entrySet()){
      if (maxEntryValue ==null || entry.getValue()>0){
        maxEntryValue=entry;
      }
    }
    return  maxEntryValue.getKey();
  }

  public static int median(int[] elements) {
    if (elements==null)
      throw  new IllegalArgumentException("the elements can't be null");
    List<Integer> arrayList = Arrays.stream (elements).boxed().collect(Collectors.toList());
    Array.sort;

    Integer arraySize = arrayList.size();
    if (arraySize % 2 ==0){
      return (arrayList.get(arraySize/2-1)+arrayList.get(arraySize/2))/2;

    }
    return  arrayList.get((arraySize-1)/2);
  }
}
