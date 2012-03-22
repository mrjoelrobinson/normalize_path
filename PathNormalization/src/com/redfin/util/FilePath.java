package com.redfin.util;


/**
 *
 * @author joel
 */
public final class FilePath {

    String path;

    FilePath (String pathParameter) {
        setPath(pathParameter);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void normalizePath(){
        String nonNormalizedPath = this.path;
        String normalizedPath = null;
        int indexOfDotDot;
        int indexOfPathSeparator1;
        int indexOfPathSeparator2;

        //could make this a while loop
        if(nonNormalizedPath.contains("..")){

            indexOfDotDot = nonNormalizedPath.indexOf("..");
            indexOfPathSeparator1 = nonNormalizedPath.substring(0, indexOfDotDot).lastIndexOf("//");
            indexOfPathSeparator2 = nonNormalizedPath.substring(0, indexOfPathSeparator1 - 1).lastIndexOf("//");

            //find the position of the // before the ..
            if (indexOfPathSeparator2 > 0)
            {
                nonNormalizedPath = nonNormalizedPath.substring(0, indexOfPathSeparator2) +
                                    nonNormalizedPath.substring(indexOfDotDot + 1, nonNormalizedPath.length());
            }


        }
        if(nonNormalizedPath.contains(".")){
            nonNormalizedPath = nonNormalizedPath.replaceAll("\\d*[.]{1}", "");
        }

        this.setPath(nonNormalizedPath);
    }





}
