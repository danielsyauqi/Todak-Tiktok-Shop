import java.util.LinkedList;

public class Queue 
{
    protected LinkedList list;
    public Queue() 
    {
        list = new LinkedList();
    } 

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public int size()    
    {
        return list.size();
    }
    
    public void enqueue(Object element)    
    {
        list.addLast(element);
    } //method enqueue

    public Object dequeue()    
    {
        return list.removeFirst();
    } //method dequeue

    public Object front()    
    {
        return list.getFirst();
    } //method front
   
    public Object rear()    
    {
        return list.getLast();
    } //method rear

} // Queue class

