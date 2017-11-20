public interface Map<K, V> {

  /**
   * Accesses the desired key.
   * @param key The key whose value is desired.
   * @return The associated value, or null if the key does not exist.
   */
  public V get(K key);

  /**
   * Inserts a new pair or updates an existing one.
   * @param key The key to update or insert
   * @param value The new value associated with the key
   * @return The previous value associated with the key (or null if the key didn't previously exist)
   */
  public V put(K key, V value);

  /**
   * Replace an already existing value iff key exists.
   * @param key The key to update
   * @param value The new value associated with the key
   * @return true iff the value was replaced, false otherwise
   */
  public boolean replace(K key, V value);

  /**
   * Removes the key and its assocaited value from the Map.
   * @param key The key to be removed
   * @return The previous value associated with the key, or null if
   * the key didn't previously exist.
   */
  public V remove(K key);

  /**
   * Tells whether there are more than zero pairs in the map.
   * @return Whethere there are more than zero pairs.
   */
  public boolean isEmpty();

  /**
   * Determine whether the given key is present in the Map.
   * @param key The key to check for
   * @return Wehther the key is present in the map
   */
  boolean containsKey(Object key);

  /**
   * Returns a Set containing all the keys in the map
   * See https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
   * @return the Set of all keys
   */
  public Set<K> keySet();

  /**
   * Extend this Map with given map.
   * @param m the Map of items to be added
   */
  public void putAll(Map<? extends K, ? extends V> m)

  /**
   * Tells the size of the current map
   * @return How many pairs are in the Map
   */
   public int size();
}
