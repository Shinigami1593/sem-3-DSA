public class SeperateChaining {
    SinglyLinkedList hashtable[];
    int capacity;
    public SeperateChaining(int capacity){
        this.capacity = capacity;
        hashtable = new SinglyLinkedList[capacity];
        for(int i=0; i<hashtable.length; i++){
            hashtable[i] = new SinglyLinkedList();
        }
    }
    int findHash(int key){
        return (2*key+3) % 10;//for k(H) = 2k+3 % 10 method:
    }

    void add(int key){
        int tmp = findHash(key);
        hashtable[tmp].addNode(key);
    }
    int get(int key){
        int tmp = findHash(key);
        SinglyLinkedList.Node current = hashtable[tmp].head;
        while(current!=null){
            if (current.data == key) {
                return current.data;
            }
            current = current.next;
        }
        return -1;
    }
}
