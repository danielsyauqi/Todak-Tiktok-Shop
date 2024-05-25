public class LinkedList{
    private ListNode firstNode;
    private ListNode lastNode;
    private ListNode currNode; //traverse list
    
    //constructor an empty List with s as the name
    
    public LinkedList()
    {
        firstNode = lastNode = currNode = null;
    }
    
    //return true if the List is empty
    public boolean isEmpty(){return firstNode == null;}
    
    //insert an Object at the front of the List
    //If List is empty, firstNode and lastNode will refer to the same object. Otherwise, firstNode refers to new node
    
    public void insertAtFront(Object insertItem)
    {
        if(isEmpty())
            firstNode = lastNode = new ListNode(insertItem);
        else 
            firstNode = new ListNode(insertItem, firstNode);
    }
    
    public void insertAtBack(Object insertItem){
        if(isEmpty())
            firstNode = lastNode =new ListNode(insertItem);
        else
            lastNode = lastNode.next = new ListNode(insertItem);
    }
    
    //remove the first node from the List
    public Object removeFromFront() throws EmptyListException{
        Object removeItem = null;
        
        if(isEmpty())
            throw new EmptyListException();
        removeItem = firstNode.data;
        
        //reset the firstNode and lastNode references
        if(firstNode.equals(lastNode))
            firstNode = lastNode = null;
        else
            firstNode = firstNode.next;
        return removeItem;
    }
    
    //remove the last node from the List
    public Object removeFromBack() throws EmptyListException
    {
        Object removeItem = null;
        if(isEmpty())
            throw new EmptyListException();
        removeItem = lastNode.data;
        
        //reset the firstNode and lastNode references
        if(firstNode.equals(lastNode))
            firstNode =lastNode =null;
        else{
            ListNode current = firstNode;
            while(current.next != lastNode)//not last node
            {
                current = current.next; // move to next node   
            }
            lastNode =current;
            current.next = null;
        }
        return removeItem;
    }
        
    public Object removeFromSecond()
    {
        Object removeItem =null;
        if(isEmpty() || firstNode.next == null)
            removeItem =null;
        else{
            ListNode current = firstNode.next;
            removeItem = current.data;
            if(firstNode.next != lastNode)
            {
                firstNode.next = current.next;
                lastNode = current.next;
                current.next =null;
            }
        }
        return removeItem;
    }
    
    //return first element
    public Object getFirst()
    {
        if(isEmpty())
            return null;
        else{
            currNode = firstNode;
            return currNode.data;
        }
    }
    
    //return the next element
    public Object getNext()
    {
        if(currNode != lastNode){
            currNode = currNode.next;
            return currNode.data;
        }
        else
            return null;
    }

    public int getSize() {
        int size = 0;
        ListNode current = firstNode;

        while (current != null) {
            size++;
            current = current.next;
        }

        return size;
    }
    
    public void deleteAnyNode(int position) throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException();
        }

        if (position < 0 || position >= getSize()) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        if (position == 0)
        {
            // Deleting the first node
            removeFromFront();
        } 
        else
        {
            ListNode current = firstNode;
            
            //previous node of we want to delete
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }

            //node that we want to delete
            ListNode nodeDelete = current.next;
            
            //point the node
            current.next = nodeDelete.next;
            

            // If the deleted node is the last node, update lastNode
            if (nodeDelete == lastNode) {
                lastNode = current;
            }

            // Set next reference of the deleted node to null
            nodeDelete.next = null;
        }
    }    
}
