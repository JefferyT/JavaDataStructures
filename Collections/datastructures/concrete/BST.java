package datastructures.concrete;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/*
 * Jeffery Tian
 * 
 */
public class BST<K extends Comparable<K>, V> implements Map<K, V> {

    private SearchTreeNode<K, V> overallRoot;
    private int size;
    public BST() {
        overallRoot = null;
    }
    
    @Override
    public void clear() {
        size = 0;
        overallRoot = null;
        
    }
    
    @Override
    public boolean containsKey(Object key) {
        // TODO Auto-generated method stub
        return containsKey((K) key, overallRoot);
    }
    
    private boolean containsKey(K key, SearchTreeNode<K, V> node) {
        if (node == null) {
            return false;
        } else if (node.key.equals(key)) {
            return true;
        } else {
            return containsKey(key, node.left) || containsKey(key, node.right);
        }
    }

    @Override
    public boolean containsValue(Object arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public V get(Object arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    
    public V get(K key) {
        return get(key, overallRoot);
    }
    
    private V get(K key, SearchTreeNode<K, V> node) {
        if (node == null) {
            return null;
        } else if (key.equals(node.key)) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return get(key, node.left);
        } else {
            return get(key, node.right);
        }
    }
    
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Set<K> keySet() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public V put(K key, V value) {
        STNWithValue<K, V> stn = put(overallRoot, key, value);
        overallRoot = stn.node;
        return stn.otherValue;
    }
    
    private STNWithValue<K, V> put(SearchTreeNode<K, V> node, K key, V value) {
        STNWithValue<K, V> newN = new STNWithValue<K, V>(node, null);
        if (node == null) {
            size++;
            return new STNWithValue<K, V>(new SearchTreeNode<K, V>(key, value), null);
        } else if (node.key.compareTo(key) == 0) {
            return new STNWithValue<K, V>(new SearchTreeNode<K, V>(key, value, node.left, node.right), node.value);
        } else if (node.key.compareTo(key) > 0) {
            STNWithValue<K, V> newNN = put(node.left, key, value);
            node.left = newNN.node;
            newN.otherValue = newNN.otherValue;
        } else if (node.key.compareTo(key) < 0) {
            STNWithValue<K, V> newNN = put(node.right, key, value);
            node.right = newNN.node;
            newN.otherValue = newNN.otherValue;
        }
        return newN;
    }
    

    @Override
    public void putAll(Map<? extends K, ? extends V> arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public V remove(Object arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public Collection<V> values() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public String preOrder() {
        return preOrder(overallRoot);
    }
    
    private String preOrder(SearchTreeNode<K, V> node) {
        String ret = "";
        if (node != null) {
            ret += node.toString();
            ret += preOrder(node.left);
            ret += preOrder(node.right);
        }
        return ret;
    }
    
    private final class SearchTreeNode <K extends Comparable<K>, V>{
        private final K key;
        private final V value;
        private SearchTreeNode<K, V> left;
        private SearchTreeNode<K, V> right;
        private SearchTreeNode(K key, V value, SearchTreeNode<K, V> left, SearchTreeNode<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
        
        private SearchTreeNode(K key, V value) {
            this(key, value, null, null);
        }
        
        public String toString() {
            return "<" + key + ", " + value + ">";
        }
    }
    
    private final class STNWithValue <K extends Comparable<K>, V> {
        private final SearchTreeNode<K, V> node;
        private V otherValue;
        private STNWithValue(SearchTreeNode<K, V> node, V value) {
            this.node = node;
            this.otherValue = value;
        }
    }
}
