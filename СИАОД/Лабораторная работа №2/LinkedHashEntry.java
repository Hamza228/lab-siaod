package SecondLab;

public class LinkedHashEntry {  // Метод цепочек
    private int key;
    private int value;
    LinkedHashEntry next;
    public LinkedHashEntry(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
    int getKey() {
        return key;
    }
    int getValue() {
        return value;
    }
    void setValue(int value) {
        this.value = value;
    }
    LinkedHashEntry getNext() {
        return next;
    }
    void setNext(LinkedHashEntry next) {
        this.next = next;
    }
}
