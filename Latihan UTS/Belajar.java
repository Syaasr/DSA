class NodeLink<T>{
    T data;
    NodeLink<T> next;
    NodeLink<T> prev;

    NodeLink(T data){
        this.data = data;
    }
}

class MyLinkedList<T>{
    private NodeLink<T> head = null;
    private NodeLink<T> tail = null;
    private int size = 0;

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public int find(T data){
        NodeLink<T> nodeIndex = head;
        for (int i = 0; i < size; i++) {
            if (nodeIndex.data.equals(data)) {
                return i;
            } else {
                nodeIndex = nodeIndex.next;
            }
        }
        return -1;
    }

    public T getAt(int index){
        NodeLink<T> nodeIndex;
        if (index <= size / 2) {
            nodeIndex = head;
            for (int i = 0; i < index; i++) {
                nodeIndex = nodeIndex.next;
            }
        } else {
            nodeIndex = tail;
            for (int i = size - 1; i > index; i--) {
                nodeIndex = nodeIndex.prev;
            }
        }
        return nodeIndex.data;
    }

    public boolean contains(T data){
        return find(data) >= 0;
    }

    public void addFirst(T data){
        NodeLink<T> newNode = new NodeLink<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data){
        NodeLink<T> newNode = new NodeLink<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void addAt(T data, int index){
        if (index < 0){
            addFirst(data);
            return;
        }
        if (index >= size) {
            addLast(data);
            return;
        }
        NodeLink<T> newNode = new NodeLink<>(data);
        if (index <= size / 2) {
            NodeLink<T> nodeIndex = head;
            for (int i = 0; i < index; i++) {
                nodeIndex = nodeIndex.next;
            }
            newNode.next = nodeIndex;
            newNode.prev = nodeIndex.prev;
            nodeIndex.prev = newNode;
            newNode.prev.next = newNode;
        } else {
            NodeLink<T> nodeIndex = tail;
            for (int i = size - 1; i > index; i--) {
                nodeIndex = nodeIndex.prev;
            }
            newNode.next = nodeIndex;
            newNode.prev = nodeIndex.prev;
            nodeIndex.prev = newNode;
            newNode.prev.next = newNode;
        }
        size++;
    }

    public void removeFirst(){
        if (isEmpty()) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public void removeLast(){
        if (isEmpty()) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void removeAt(int index){
        if (index < 0 || index >= size){
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        if (index <= size / 2) {
            NodeLink<T> nodeIndex = head;
            for (int i = 0; i < index; i++) {
                nodeIndex = nodeIndex.next;
            }
            nodeIndex.prev.next = nodeIndex.next;
            nodeIndex.next.prev = nodeIndex.prev;
        } else {
            NodeLink<T> nodeIndex = tail;
            for (int i = size - 1; i > index; i--) {
                nodeIndex = nodeIndex.prev;
            }
            nodeIndex.prev.next = nodeIndex.next;
            nodeIndex.next.prev = nodeIndex.prev;
        }
        size--;
    }

    public void remove(T data){
        int index = find(data);
        if (index < 0) {
            return;
        }
        removeAt(index);
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }
}

class MyArrayList<T>{
    private int size = 0;
    private int capacity = 10;
    Object[] array = new Object[capacity];

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean contains(T data){
        return find(data) >= 0;
    }

    public void resize(){
        capacity = capacity * 2;
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public T getAt(int index){
        if (index >= 0 && index < size ) {
            return (T) array[index];
        } else {
            return null;
        }
    }

    public int find(T data){
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public void addFirst(T data){
        if (isFull()) {
            resize();
        }
        for (int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = data;
        size++;
    }

    public void addLast(T data){
        if (isFull()) {
            resize();
        }
        array[size] = data;
        size++;
    }

    public void addAt(T data, int index){
        if (index < 0 || index > size){
            return;
        }
        if (index == 0){
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        if (isFull()) {
            resize();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i-1];
        }
        array[index] = data;
        size++;
    }

    public void removeFirst(){
        if (!isEmpty()) {
            for (int i = 0; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = null;
            size--;
        }
    }

    public void removeLast(){
        if (!isEmpty()) {
            array[size - 1] = null;
            size--;
        }
    }

    public void removeAt(int index){
        if (!isEmpty()) {
            if (index < 0 || index >= size) {
                return;
            }
            if (index == 0) {
                removeFirst();
                return;
            }
            if (index == size - 1) {
                removeLast();
                return;
            }
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i+1];
            }
            array[size - 1] = null;
            size--;
        }
    }

    public void remove(T data) {
        int index = find(data);
        if (index >= 0) {
            removeAt(index);
        }
    }

    public void clear(){
        size = 0;
        capacity = 10;
        array = new Object[capacity];
    }
}

class MyStack<T>{
    private MyLinkedList<T> stack = new MyLinkedList<>();

    public void push(T data){
        stack.addLast(data);
    }

    public T pop(){
        if (isEmpty()) {
            return null;
        }
        T result = stack.getAt(stack.getSize() - 1);
        stack.removeLast();
        return result;    
    }

    public T peek(){
        return stack.getAt(stack.getSize() - 1);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int getSize(){
        return stack.getSize();
    }

    public void clear(){
        stack.clear();
    }
}

class MyQueue<T>{
    private MyLinkedList<T> queue = new MyLinkedList<>();

    public void enqueue(T data){
        queue.addLast(data);
    }

    public T dequeue(){
        if (isEmpty()) {
            return null;
        }
        T result = queue.getAt(0);
        queue.removeFirst();
        return result;    
    }

    public T peek(){
        return queue.getAt(0);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public int getSize(){
        return queue.getSize();
    }

    public void clear(){
        queue.clear();
    }
}

class MySet<T>{
    MyArrayList<T> set = new MyArrayList<>();
    
    public boolean isEmpty(){
        return set.getSize() == 0;
    }

    public int getSize(){
        return set.getSize();
    }

    public void add(T data){
        if (!contains(data)) {
            set.addLast(data);
        } else {
            System.out.println(data + " sudah ada");
        }
        
    }

    public void remove(T data){
        set.remove(data);
    }

    public boolean contains(T data){
        return set.contains(data);
    }

    public MySet<T> union(MySet<T> otherSet) { 
        MySet<T> result = new MySet<>();
        for (int i = 0; i < set.getSize(); i++) {
            result.add(set.getAt(i));
        }
        for (int i = 0; i < otherSet.getSize(); i++) {
            result.add(otherSet.set.getAt(i));
        }
        return result;
    }

    public boolean isEqual(MySet<T> otherSet) {
        if (this.getSize() != otherSet.getSize()) {
            return false;
        }
        
        for (int i = 0; i < set.getSize(); i++) {
            T element = set.getAt(i);
            if (!otherSet.contains(element)) {
                return false;
            }
        }
        return true;
    }

    public MySet<T> intersection(MySet<T> otherSet) {
        MySet<T> result = new MySet<>();
        
        for (int i = 0; i < set.getSize(); i++) {
            T element = set.getAt(i);
            if (otherSet.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public MySet<T> setDifference(MySet<T> otherSet) {
        MySet<T> result = new MySet<>();
        
        for (int i = 0; i < set.getSize(); i++) {
            T element = set.getAt(i);
            if (!otherSet.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
    
    public MySet<T> copy() {
        MySet<T> result = new MySet<>();
        
        for (int i = 0; i < set.getSize(); i++) {
            result.add(set.getAt(i));
        }
        return result;
    }
    
    public boolean isSubset(MySet<T> otherSet) {
        if (this.getSize() > otherSet.getSize()) {
            return false;
        }
        
        for (int i = 0; i < set.getSize(); i++) {
            T element = set.getAt(i);
            if (!otherSet.contains(element)) {
                return false;
            }
        }
        return true;
    }
}

class Entry<K, V>{
    K key;
    V value;
    
    Entry(K key, V value){
        this.key = key;
        this.value = value;
    }
}

class Map<K, V>{
    int size = 0;
    int capacity = 10;
    Entry<K, V>[] array = (Entry<K, V>[]) new Entry[capacity];
    
    public void resize(){
      Entry<K, V>[] newArray = (Entry<K, V>[]) new Entry[capacity * 2];
        for(int i = 0;i < size;i++){
        newArray[i] = array[i];
        }
      capacity *= 2;
        array = newArray;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public int size(){
        return size;
    }
    
    private boolean isFull(){
        return size == capacity;
    }
    
    public boolean contains(K key){
        for(int i = 0;i < size;i++){
            if(array[i].key.equals(key)){
                return true;
            }
        }
        return false;
    }
    
    public void add(K key, V value){
        if(contains(key)){
            System.out.println(key + " sudah ada");
        return;
        }
        if(isFull()){
            resize();
        }
        array[size] = new Entry<>(key, value);
        size++;
    }
    
    public void delete(K key){
        int index = find(key);
        if(index == -1){
            System.out.println(key + " tidak ada");
        return;
        }
        for(int i = index;i < size - 1;i++){
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }
    
    public int find(K key){
        for(int i = 0;i < size;i++){
            if(array[i].key.equals(key)){
                return i;
            }
        }
        return -1;
    }
    
    public void clear(){
    size = 0;
    capacity = 10;
    array = (Entry<K, V>[]) new Entry[capacity];
    }
}

class AVLNode<T extends Comparable<T>> {
    T data;
    AVLNode<T> left;
    AVLNode<T> right;
    int height;
    
    AVLNode(T data) {
        this.data = data;
        this.height = 1;
    }
}

class AVLTree<T extends Comparable<T>> {
    private AVLNode<T> root;
    private int size = 0;
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    /* Fungsi untuk mendapatkan tinggi node */
    private int height(AVLNode<T> node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    
    /* Fungsi untuk mendapatkan balance factor node */
    private int getBalance(AVLNode<T> node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }
    
    /* Fungsi untuk rotasi kanan */
    private AVLNode<T> rightRotate(AVLNode<T> y) {
        AVLNode<T> x = y.left;
        AVLNode<T> T2 = x.right;
        
        // Rotasi
        x.right = y;
        y.left = T2;
        
        // Update tinggi
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        
        return x;
    }
    
    /* Fungsi untuk rotasi kiri */
    private AVLNode<T> leftRotate(AVLNode<T> x) {
        AVLNode<T> y = x.right;
        AVLNode<T> T2 = y.left;
        
        // Rotasi
        y.left = x;
        x.right = T2;
        
        // Update tinggi
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        
        return y;
    }
    
    /* Fungsi untuk insert node */
    public void insert(T data) {
        root = insert(root, data);
        size++;
    }
    
    private AVLNode<T> insert(AVLNode<T> node, T data) {
        // 1. Lakukan insert BST biasa
        if (node == null) {
            return new AVLNode<>(data);
        }
        
        int compareResult = data.compareTo(node.data);
        
        if (compareResult < 0) {
            node.left = insert(node.left, data);
        } else if (compareResult > 0) {
            node.right = insert(node.right, data);
        } else {
            // Nilai yang sama tidak diperbolehkan dalam BST
            System.out.println(data + " sudah ada dalam tree");
            size--; // Karena size++ di method publik
            return node;
        }
        
        // 2. Update tinggi ancestor
        node.height = 1 + Math.max(height(node.left), height(node.right));
        
        // 3. Dapatkan balance factor dan lakukan balancing jika perlu
        int balance = getBalance(node);
        
        // Kasus Left Left
        if (balance > 1 && data.compareTo(node.left.data) < 0) {
            return rightRotate(node);
        }
        
        // Kasus Right Right
        if (balance < -1 && data.compareTo(node.right.data) > 0) {
            return leftRotate(node);
        }
        
        // Kasus Left Right
        if (balance > 1 && data.compareTo(node.left.data) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        // Kasus Right Left
        if (balance < -1 && data.compareTo(node.right.data) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        return node;
    }
    
    /* Fungsi untuk mencari node dengan nilai minimum */
    private AVLNode<T> minValueNode(AVLNode<T> node) {
        AVLNode<T> current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    
    /* Fungsi untuk menghapus node */
    public void delete(T data) {
        root = delete(root, data);
    }
    
    private AVLNode<T> delete(AVLNode<T> root, T data) {
        // 1. Lakukan delete BST biasa
        if (root == null) {
            return root;
        }
        
        int compareResult = data.compareTo(root.data);
        
        if (compareResult < 0) {
            root.left = delete(root.left, data);
        } else if (compareResult > 0) {
            root.right = delete(root.right, data);
        } else {
            // Node dengan satu anak atau tanpa anak
            if ((root.left == null) || (root.right == null)) {
                AVLNode<T> temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }
                
                // Kasus tanpa anak
                if (temp == null) {
                    temp = root;
                    root = null;
                } else { // Kasus dengan satu anak
                    root = temp;
                }
                size--;
            } else {
                // Node dengan dua anak
                AVLNode<T> temp = minValueNode(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
                // Note: size dikurangi di pemanggilan rekursif
            }
        }
        
        // Jika tree hanya memiliki satu node
        if (root == null) {
            return root;
        }
        
        // 2. Update tinggi
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        
        // 3. Dapatkan balance factor
        int balance = getBalance(root);
        
        // Jika unbalanced, ada 4 kasus
        
        // Kasus Left Left
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }
        
        // Kasus Left Right
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        
        // Kasus Right Right
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }
        
        // Kasus Right Left
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        
        return root;
    }
    
    /* Fungsi untuk mencari nilai dalam tree */
    public boolean search(T data) {
        return search(root, data);
    }
    
    private boolean search(AVLNode<T> root, T data) {
        if (root == null) {
            return false;
        }
        
        int compareResult = data.compareTo(root.data);
        
        if (compareResult == 0) {
            return true;
        } else if (compareResult < 0) {
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }
    
    /* Fungsi untuk traversal inorder */
    public void inorder() {
        System.out.print("Inorder traversal: ");
        inorder(root);
        System.out.println();
    }
    
    private void inorder(AVLNode<T> root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    
    /* Fungsi untuk traversal preorder */
    public void preorder() {
        System.out.print("Preorder traversal: ");
        preorder(root);
        System.out.println();
    }
    
    private void preorder(AVLNode<T> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    /* Fungsi untuk mendapatkan tinggi AVL tree */
    public int getHeight() {
        return height(root);
    }
    
    /* Fungsi untuk memeriksa apakah tree seimbang */
    public boolean isBalanced() {
        return isBalanced(root);
    }
    
    private boolean isBalanced(AVLNode<T> node) {
        if (node == null) {
            return true;
        }
        
        int balance = getBalance(node);
        
        // Balance factor harus dalam rentang [-1, 1]
        if (balance > 1 || balance < -1) {
            return false;
        }
        
        return isBalanced(node.left) && isBalanced(node.right);
    }
}

public class Belajar {
    public static void main(String[] args) {
        System.out.println("Belajar SDA");
    }
}
