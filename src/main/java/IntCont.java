public class IntCont 
{

    private static class Node
    {
        int value;
        Node next;

        Node(int value) 
        {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public IntCont() 
    {
        head = null;
        size = 0;
    }

    public void add(int value)
    {
        Node newNode = new Node(value);

        if (head == null) 
        {
            head = newNode;
        } 
        else 
        {
            Node current = head;
            while (current.next != null) 
            {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public int get(int index) 
    {
        checkIndex(index);
        Node current = head;
        for (int i = 0; i < index; i++) 
        {
            current = current.next;
        }
        return current.value;
    }

    public int remove(int index) 
    {
        checkIndex(index);

        if (index == 0)
        {
            int value = head.value;
            head = head.next;
            size--;
            return value;
        }

        Node prev = head;
        for (int i = 0; i < index - 1; i++)
        {
            prev = prev.next;
        }

        int value = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return value;
    }

    public int size() 
    {
        return size;
    }

    public boolean isEmpty() 
    {
    	
        return size == 0;
    }

    private void checkIndex(int index) 
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() 
    {
        if (isEmpty()) 
        {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) 
        {
            sb.append(current.value);
            if (current.next != null) 
            {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}