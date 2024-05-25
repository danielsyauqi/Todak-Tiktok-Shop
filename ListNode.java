public class ListNode
{
    Object data;
    ListNode next;
    public ListNode(Object o)
    {
        this(o, null);
    }
    
    public ListNode(Object o, ListNode nextNode)
    {
        data = o;
        next = nextNode;
    }
    
    Object getObject()
    {
        return data;
    }
         
    public ListNode getLink()
    {
        return next;
    }
}