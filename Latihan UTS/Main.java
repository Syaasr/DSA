class Node<T>{
    T data;
    Node<T> prev;
    Node<T> next;
    int mantap;

    Node(T data){
        this.data = data;
    }
}

class LinkList<T>{
    Node<T> head = null;
    Node<T> tail = null;
    private int size = 0;

    private Node<T> nodeAt(int index){
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> temp = head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addFirst(T data){
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode; 
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data){
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void addAt(T data, int index){
        if (index <= 0) {
            addFirst(data);
            return;
        }
        if (index >= size) {
            addLast(data);
            return;
        }
        Node<T> newNode = new Node<>(data);
        newNode.next = nodeAt(index);
        newNode.prev = newNode.next.prev;
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
        size++; 
    }

    public void removeAt(int index){
        if (index == 0) {
            head = head.next;
            if (head != null) head.prev = null;
            size--;
            return;
        }
        if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }        
        Node<T> temp = nodeAt(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
    }

    public T getAt(int index){
        if (index < 0 || index >= size) return null;
        Node<T> temp = nodeAt(index);
        return temp.data;
    }

    public int getSize(){
        return size;
    }

    public boolean contains(T data){
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    public int indexOf(T data){
        Node<T> temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == data) {
                return index;
            } else {
                temp = temp.next;
                index++;
            }
        }
        return -1;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public void print(){
        Node<T> temp = head; 
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

class ArrayList{
    private Object[] array;
    private int size = 0;
    private int capacity = 10;

    public ArrayList(){
        this.array = new Object[capacity];
    }

    public void resize(){
        int newCapacity = capacity * 2;
        Object[] newArray = new Object[newCapacity];
        for (int i = 0;i < size;i++) {
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    public void add(Object data){
        if (size >= capacity) {
            resize();
        }
        array[size] = data;
        size++;
    }

    public void addAt(Object data, int index){
        if (size >= capacity) {
            resize();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i-1];
        }
        array[index] = data;
        size++;
    }

    public Object getAt(int index){
        if (index >= size || index < 0) {
            return null;
        }
        return array[index];
    }

    public void setAt(Object data, int index){
        if (index >= size || index < 0) {
            System.out.println("Index melebihi batas");
            return;
        }
        array[index] = data;
    }

    public void removeAt(int index){
        if (index >= size || index < 0) {
            System.out.println("Index melebihi batas");
            return;
        }
        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }
        size--;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        size = 0;
    }

    public boolean contains(Object data){
        for (Object object : array) {
            if (object.equals(data)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object data){
        for (int i = 0;i < size;i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

public class Main {
    public static void main(String[] args){
        LinkList<String> list = new LinkList<>();

        System.out.println("== ADD ==");
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        list.addLast("D");
        list.addAt("X", 2);  // A -> B -> X -> C -> D
        list.print();

        System.out.println("\n== GET ==");
        System.out.println("Element at index 2: " + list.getAt(2));
        System.out.println("Element at index 4: " + list.getAt(4));

        System.out.println("\n== SEARCH ==");
        System.out.println("Contains 'X'? " + list.contains("X"));
        System.out.println("Index of 'D': " + list.indexOf("D"));
        System.out.println("Index of 'Z': " + list.indexOf("Z"));

        System.out.println("\n== REMOVE ==");
        list.removeAt(2);  // remove 'X'
        list.print();

        System.out.println("\n== SIZE ==");
        System.out.println("Size: " + list.getSize());

        System.out.println("\n== CLEAR ==");
        list.clear();
        System.out.println("Is empty? " + list.isEmpty());
        list.print(); // Should print nothing

        ArrayList alist = new ArrayList();

        System.out.println("\n== ADD ==");
        alist.add("Apple");
        alist.add("Banana");
        alist.add("Cherry");
        alist.print(); // Apple Banana Cherry

        System.out.println("\n== ADD AT ==");
        alist.addAt("Date", 1); // Insert at index 1
        alist.print(); // Apple Date Banana Cherry

        System.out.println("\n== GET ==");
        System.out.println("Index 2: " + alist.getAt(2)); // Banana

        System.out.println("\n== SET ==");
        alist.setAt("Blueberry", 2);
        alist.print(); // Apple Date Blueberry Cherry

        System.out.println("\n== CONTAINS & INDEX OF ==");
        System.out.println("Contains 'Date'? " + alist.contains("Date")); // true
        System.out.println("Index of 'Cherry': " + alist.indexOf("Cherry")); // 3

        System.out.println("\n== REMOVE AT ==");
        alist.removeAt(1); // remove 'Date'
        alist.print(); // Apple Blueberry Cherry

        System.out.println("\n== SIZE & EMPTY ==");
        System.out.println("Size: " + alist.getSize()); // 3
        System.out.println("Is empty? " + alist.isEmpty()); // false

        System.out.println("\n== TO STRING ==");
        System.out.println(alist); // [Apple, Blueberry, Cherry]

        System.out.println("\n== CLEAR ==");
        alist.clear();
        System.out.println("Is empty? " + alist.isEmpty()); // true
        alist.print(); // (empty)
    }
}
