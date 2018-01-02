package homework;

public class AddNode {
    Node head;

   public class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }


    public void push(int new_data)
    {
        if(new_data>Integer.MAX_VALUE || new_data<Integer.MIN_VALUE){
            throw new RuntimeException("invalid input");
        }
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void append(int new_data)
    {
        if(new_data>Integer.MAX_VALUE || new_data<Integer.MIN_VALUE){
            throw new RuntimeException("invalid input");
        }
        Node new_node = new Node(new_data);
        if (head == null)
        {
            head = new Node(new_data);
            return;
        }
        new_node.next = null;
        Node last = head;
        while (last.next != null)
            last = last.next;
        last.next = new_node;
        return;
    }


    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
    }


}