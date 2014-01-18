/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package week7_hashtable;

import java.util.AbstractMap;
import java.util.Random;
import org.junit.Test;

/**
 *
 * @author Marc
 */
public class SpeedBenchmark {
    HashTable table;
    Random random;
    
    public SpeedBenchmark() {
        random = new Random();
        this.table = new HashTable(true,true);
    }

    @Test
    public void testPut_WithKey() {
        Integer key;
        for (int i = 0; i < 750; i++) {
            key = random.nextInt(200);
            table.put(new AbstractMap.SimpleEntry(key, i));
        }
    }

    @Test
    public void testPut_WithoutKey() {
        Integer value;
        for (Integer i = 0; i < 750; i++) {
            value = random.nextInt(200);
            table.put(value.toString());
        }
    }

    @Test
    public void testFind_WithKey() {
        Integer key;
        for (int i = 0; i < 300; i++) {
            key = random.nextInt(200);
            table.find(key);
        }
    }

    @Test
    public void testFind_WithoutKey() {
        Integer value;
        for (Integer i = 0; i < 300; i++) {
            value = random.nextInt(200);
            table.find(value.toString());
        }
    }
}