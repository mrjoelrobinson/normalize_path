package com.redfin.util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joel
 */
public class FilePathTest {

    /**
     * Test of normalizePath method, of class FilePath.
     */
    @Test
    public void testNormalizePath() {
        System.out.println("normalizePath");
        FilePath instance = new FilePath("//foo");
        instance.normalizePath();
        assertEquals("//foo", instance.getPath());

        instance.setPath("//foo//bar");
        instance.normalizePath();
        assertEquals("//foo//bar", instance.getPath());

        instance.setPath("//foo.//bar");
        instance.normalizePath();
        assertEquals("//foo//bar", instance.getPath());

        instance.setPath("foo//bar//..//baz");
        instance.normalizePath();
        assertEquals("foo//baz", instance.getPath());

        instance.setPath("//foo//bar//..//baz");
        instance.normalizePath();
        assertEquals("//foo//baz", instance.getPath());

        instance.setPath("..//baz");
        instance.normalizePath();
        assertEquals("//baz", instance.getPath());

        instance.setPath("foo//bar//baz");
        instance.normalizePath();
        assertEquals("foo//bar//baz", instance.getPath());

        instance.setPath("foo//bar//..//baz//..");
        instance.normalizePath();
        assertEquals("foo", instance.getPath());


    }

}