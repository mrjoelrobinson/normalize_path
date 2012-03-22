package com.redfin.util;

/**
 *
 * @author joel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FilePath myPath = new FilePath("c://foo//..//");
        System.out.println("the path before normalization is: " + myPath.getPath());
        myPath.normalizePath();
        System.out.println("the path after normalization is: " + myPath.getPath());

  }
  

}
