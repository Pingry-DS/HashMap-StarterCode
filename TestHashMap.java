// Order is expected, actual

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class TestHashMap {

  private HashMap<String, String> e; // an empty one
  private HashMap<String, String> f; // a filled one
  //private HashMap<String, String> d; // a dummy one

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
  }

  @Test
  public void testPutNullKey(){
    e.put(null, "null");
    assertEquals("null", e.get(null));
  }

  @Test
  public void testPutNullValue(){
    e.put("null", null);
    assertEquals(null, e.get("null"));
  }

  @Test
  public void testPutNullKeyAndValue(){
    e.put(null, null);
    assertEquals(null, e.get(null));
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
    f.remove("hello");
    assertFalse(f.containsKey("hello"));
  }

  @Test
  public void testRemoveKeyInMap2(){
    assertEquals("world", f.remove("hello"));
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

  // containsKey true
  // containsKey false
  // containsKey null

  // size increases when putting new key
  // size does not grow when putting dupe key same value
  // size does not grow when putting dupe key new value
  // size is zero to start

  // isempty is true to start
  // isempty is false after adding
  // isempty is true after removing all
  // isempty is false after removing some

  // keySet for empty map
  // keySet for non empty map
  // keySet for map with null

  // putAll with target empty
  // putAll with m empty
  // putAll with neither empty
  // putAll with both empty
}
