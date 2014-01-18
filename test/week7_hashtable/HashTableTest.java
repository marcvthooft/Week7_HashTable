/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package week7_hashtable;

import java.util.AbstractMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marc
 */
public class HashTableTest {
    HashTable divChainTable, divProbTable;
    
    public HashTableTest() {
    }
    
    @Before
    public void setUp() {
        divChainTable = new HashTable(true,true);
        divProbTable = new HashTable(true,false);
        for (int i = 0; i < 50; i++) {
            divProbTable.put(new AbstractMap.SimpleEntry(i, i));
        }
        for (int i = 0; i < 10; i++) {
            divChainTable.put(new AbstractMap.SimpleEntry(i, i));
        }
        divProbTable.put("fietsbel");
        divProbTable.put("henk");
        divChainTable.put("fietsbel");
        divChainTable.put("henk");
    }

    @Test
    public void testPut_AbstractMapSimpleEntry() {
        divProbTable.put(new AbstractMap.SimpleEntry(33, "tosti"));
        divChainTable.put(new AbstractMap.SimpleEntry(33, "gehakt"));
    }

    @Test
    public void testPut_String() {
        divProbTable.put("pizza");
        divChainTable.put("frikandel");
    }

    @Test
    public void testFind_int() {
        Object expResult = new AbstractMap.SimpleEntry(3, 3);
        Object probResult = divProbTable.find(3)[1];
        Object chainResult = divChainTable.find(3)[1];
        assertEquals(expResult, probResult);
        assertEquals(expResult, chainResult); 
        
        expResult = null;
        probResult = divProbTable.find(500);
        chainResult = divChainTable.find(500);
        assertEquals(expResult,probResult);
        assertEquals(expResult,chainResult);
    }

    @Test
    public void testFind_String() {
        Object expResult = new AbstractMap.SimpleEntry(Math.abs("fietsbel".hashCode()), "fietsbel");
        Object probResult = divProbTable.find("fietsbel")[1];
        Object chainResult = divChainTable.find("fietsbel")[1];
        assertEquals(expResult,probResult);
        assertEquals(expResult,chainResult);
        
        expResult = null;
        probResult = divProbTable.find("gomgom");
        chainResult = divChainTable.find("gomgom");
        assertEquals(expResult,probResult);
        assertEquals(expResult,chainResult);
    }

    @Test
    public void testRemove_int() {        
        Object expResult = new AbstractMap.SimpleEntry(4, 4);
        Object probResult = divProbTable.remove(4);
        Object chainResult = divChainTable.remove(4);
        assertEquals(expResult,probResult);
        assertEquals(expResult,chainResult);
        
        expResult = null;
        probResult = divProbTable.remove(60);
        chainResult = divChainTable.remove(60);
        assertEquals(expResult,probResult);
        assertEquals(expResult,chainResult);
    }

    @Test
    public void testRemove_String() {
        Object expResult = new AbstractMap.SimpleEntry(Math.abs("henk".hashCode()), "henk");
        Object probResult = divProbTable.remove("henk");
        Object chainResult = divChainTable.remove("henk");        
        assertEquals(expResult,probResult);
        assertEquals(expResult,chainResult);
        
        expResult = null;
        probResult = divProbTable.remove("jan");
        chainResult = divChainTable.remove("jan"); 
        assertEquals(expResult,probResult);
        assertEquals(expResult,chainResult);
    }
}