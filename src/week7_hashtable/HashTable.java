package week7_hashtable;

import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.Random;

public class HashTable {
    int tblSize = 997;
    LinkedList<SimpleEntry>[] chainTable;
    SimpleEntry[] probTable;
    
    Random random = new Random();
    double A = (Math.sqrt(5) - 1)/2;
    Boolean divisionAlg, boolChainTable;
    String algorithm;
    
    /**
     * true, true for division algorithm and chaining
     * false, false for multiplication algorithm and probing
     * or a combination.
     * @param alg 
     */
    public HashTable(Boolean divisionAlg, Boolean boolChainTable) {
        this.divisionAlg = divisionAlg;
        this.boolChainTable = boolChainTable;
        
        if (boolChainTable) {
            chainTable = new LinkedList[tblSize];
            for (int cel = 0; cel < tblSize; cel++) {
                chainTable[cel] = new LinkedList();
            }
        } else {
            probTable = new SimpleEntry[tblSize];
        }        
    }
    
    public int hash(int K) {
        if (divisionAlg) {
            return  K % tblSize;
        } else {                //multiplicationAlg
            return (int) (tblSize * (K * A % 1));
        }
    }
    
    /**
     * Next 4 methods are connected.
     * @param item 
     */
    public void put(SimpleEntry item) {
        if (boolChainTable) {
            chainingPut(item);
        } else {
            probingPut(item);
        }        
    }
    
    public void put(String item) {
        put(new SimpleEntry(Math.abs(item.hashCode()),item));
    }
    
    private void chainingPut(SimpleEntry item) {
        int h = hash((int) item.getKey());
        chainTable[h].add(item);
    }
    
    private void probingPut(SimpleEntry item) {
        int i = 0;
        int h = hash((int) item.getKey());
        while (probTable[h]!=null && probTable[h].getKey().equals("AVAILABLE")==false) {
            h = (h + 1) % tblSize;
            //Stop after a certain amount of attempts.
            i++;
            if (i==tblSize) {
                System.err.println("table is full, item not added!");
                return;
            }
        }
        probTable[h] = item;
    }
    
    /**
     * Next 4 methods are connected.
     * @param K 
     */
    public Object[] find(int K) {
        if (boolChainTable) {
            return chainingFind(K);
        } else {
            return probingFind(K);
        }        
    }
    
    public Object[] find(String item) {
        return find(Math.abs(item.hashCode()));     
    }
    
    //vreemde while loop
    private Object[] chainingFind(Integer K) {
        int i = 0;
        int h = hash(K);
        try {
            while (chainTable[h].get(i)!=null) {            
                if (chainTable[h].get(i).getKey().toString().equals(K.toString())) {
                    Object[] item = {h,chainTable[h].get(i),i};
                    return item;
                }
                i++;
            } 
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        return null;
    }
    
    private Object[] probingFind(Integer K) {
        int i = 0;
        int h = hash(K);
        while (probTable[h]!=null) {
            i++;
            if (probTable[h].getKey().toString().equals(K.toString())) {
                Object[] item = {h,probTable[h]};
                return item;
            } else if (i==tblSize) {
                return null;
            }
            h = (h + 1) % tblSize;
        }
        return null;
    }
    
    public Object remove(int K) {
        Object[] found = find(K);
        if (found==null) {
            return null;
        }
        
        if (boolChainTable) {
            chainTable[(int)found[0]].remove((int)found[2]);
        } else {
            probTable[(int)found[0]] = new SimpleEntry("AVAILABLE","AVAILABLE");
        }
        return found[1];
    }
    
    public Object remove(String item) {
        return remove(Math.abs(item.hashCode()));
    }

    public static void main(String[] args) {
    }
}
