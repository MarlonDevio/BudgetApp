package io.marlondevio.helpers;

public class Helper {

  public static String firstLetterToUpperCase(String word) {
    return word.trim().substring(0, 1).toUpperCase() + word.trim().substring(1);
  }

}
