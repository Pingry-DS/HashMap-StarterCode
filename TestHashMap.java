// Order is expected, actual

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class TestHashMap {

  private HashMap<String, String> e; // an empty one
  private HashMap<String, String> f; // a filled one

  @Before
  public void setUp(){
    e = new HashMap<>(4);
    f = new HashMap<>(4);
    f.put("hello", "world");
    f.put("what", "up");
    f.put("null", null);
    f.put(null, "null");
  }

  // Tests for put
  @Test
  public void testNormalPut(){
    e.put("hello", "world");
    assertEquals("world", e.get("hello"));
    assertEquals(1, e.size());
  }

  @Test
  public void testDuplicatePut(){
    int oldSize = f.size();
    assertEquals("world", f.put("hello", "mars"));
    assertEquals("mars", f.get("hello"));
    assertEquals(oldSize, f.size());
  }

  @Test
  public void testPutNullKey(){
    e.put(null, "null");
    assertEquals("null", e.get(null));
    assertEquals(1, e.size());
  }

  @Test
  public void testPutNullValue(){
    e.put("null", null);
    assertEquals(null, e.get("null"));
    assertEquals(1, e.size());
  }

  @Test
  public void testPutNullKeyAndValue(){
    e.put(null, null);
    assertEquals(null, e.get(null));
    assertEquals(1, e.size());
  }


  // Test for size
  @Test
  public void testInitialSizeIsZero(){
    assertEquals(0, e.size());
  }


  // Tests for get
  @Test
  public void testGetKeyInMap(){
    assertEquals("world", f.get("hello"));
  }

  @Test
  public void testGetKeyNotInMap(){
    assertEquals(null, f.get("non-existant key"));
  }

  @Test
  public void testGetNullKeyInMap(){
    assertEquals("null", f.get(null));
  }

  @Test
  public void testGetNullKeyNotInMap(){
    assertEquals(null, e.get(null));
  }


  // Tests for replace
  @Test
  public void testReplaceKeyInMap(){
    f.replace("hello", "newval");
    assertEquals("newval", f.get("hello"));
  }

  @Test
  public void testReplaceKeyNotInMap(){
    assertFalse(e.replace("hello", "newval"));
  }

  @Test
  public void testReplaceNullKeyInMap(){
    f.replace(null, "newval");
    assertEquals("newval", f.get(null));
  }

  @Test
  public void testReplaceNullKeyNotInMap(){
    assertFalse(e.replace(null, "newval"));
  }


  // Tests for remove
  @Test
  public void testRemoveKeyInMap1(){
    assertEquals("world", f.remove("hello"));
    assertFalse(f.containsKey("hello"));
  }

  @Test
  public void testRemoveKeyNotInMap(){
    assertEquals(null, e.remove("hello"));
  }

  @Test
  public void testRemoveNullKeyInMap(){
    assertEquals("null", f.remove(null));
    assertFalse(f.containsKey(null));
  }

  @Test
  public void testRemoveNullKeyNotInMap(){
    assertEquals(null, e.remove(null));
  }


  // Tests for containsKey
  @Test
  public void testContainsKeyTrue(){
    assertTrue(f.containsKey("hello"));
  }

  @Test
  public void testContainsKeyFalse(){
    assertFalse(f.containsKey("non-existant key"));
  }

  @Test
  public void testContainsNullKeyTrue(){
    assertTrue(f.containsKey(null));
  }

  @Test
  public void testContainsNullKeyFalse(){
    assertFalse(e.containsKey(null));
  }


  // Tests for isEmpty
  @Test
  public void testInitiallyEmpty(){
    assertTrue(e.isEmpty());
  }

  @Test
  public void testNotEmptyAfterAdding(){
    assertFalse(f.isEmpty());
  }

  @Test
  public void testBecomesEmptyAfterRemovingPairs(){
    e.put("hello", "world");
    e.remove("hello");
    assertTrue(e.isEmpty());
  }

  @Test
  public void testNotEmptyAfterRemovingOnePair(){
    e.put("hello", "world");
    e.put("what", "up");
    e.remove("hello");
    assertFalse(e.isEmpty());
  }

  @Test
  public void testNotEmptyAfterRemovingNonExistantKey(){
    e.put("hello", "world");
    e.remove("non-existant key");
    assertFalse(e.isEmpty());
  }

  // Tests for growing the data structure
  @Test
  public void testHandlesThousandsOfElements(){
    int times = 2000;

    for (int i = 0; i < times; i++){
      e.put("" + i, "duplicate values");
    }

    assertEquals(times, e.size());
  }

  // Tests for keySet
  @Test
  public void testEmptyKeySet(){
    assertTrue(e.keySet().isEmpty());
  }

  @Test
  public void testNonEmptyKeySet(){
    assertFalse(f.keySet().isEmpty());
  }

  @Test
  public void testKeySetContainsNull(){
    assertTrue(f.keySet().contains(null));
  }


  // Tests for putAll
  @Test
  public void testPutAllTargetEmpty(){
    e.putAll(f);
    assertTrue(e.keySet().equals(f.keySet()));
  }

  @Test
  public void testPutAllSourceEmpty(){
    f.putAll(e);
    assertEqual(4, f.keySet().size());
  }

  @Test
  public void testPutAllNoEmpty(){
    e.put("hi", "wo");
    e.put("who", "how");
    e.put("null", null);
    e.put(null, "null");
    f.putAll(e);
    assertEqual(6, f.size());
  }

  @Test
  public void testPutAllBothEmpty(){
    e.putAll(e);
    assertTrue(e.keySet().isEmpty());
  }
}
