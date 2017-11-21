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
  // put with null value
  // put with null key and value

  // get key not in map
  // get key in map
  // get null key (in map)
  // get null value

  // replace where key exists
  // replace where key doesn't exist
  // replace null key (not in map)
  // No size change after replace

  // remove key not in map
  // remove key in map
  // remove null key (in map)

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
