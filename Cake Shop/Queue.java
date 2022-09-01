/*
Author: Johan Zafri bin Johar

This is the Queue Java class
*/
public class Queue extends LinkedList 
{
    public Queue() {}
    
    public void enqueue(Cake element) {
        addLast(element);
    }
    
    public Cake dequeue() {
        return removeFirst();
    }
    
    public Cake getFront() {
        return getFirst();
    }
}
