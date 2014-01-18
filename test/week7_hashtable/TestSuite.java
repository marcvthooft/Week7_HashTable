/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package week7_hashtable;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Marc
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({week7_hashtable.HashTableTest.class, week7_hashtable.SpeedBenchmark.class})
public class TestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}