package Tasks;

public class MyHashMap {
    private Node[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new Node[10];
        size = 0;
    }

    public void put(Object key, Object value) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode % buckets.length);

        Node newNode = new Node(key, value);
        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            Node current = buckets[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = newNode;
            }
        }
        size++;
    }

    public void remove(Object key) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode % buckets.length);

        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        buckets = new Node[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode % buckets.length);

        Node current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    private static class Node {
        private final Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
