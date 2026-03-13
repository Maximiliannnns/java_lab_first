/**
 * Контейнер для хранения произвольного количества чисел
 * Создан на основе односвязнного списка без использования встроенных колекций
 * Поддерживает следующие операции: добавление, получение по индексу, удаление, получение размера, проверка на пустоту
 * 
 */
public class IntCont 
{

	/**
	 * Внутренний класс, реализующий один узел односвязного списка
	 */
    private static class Node
    {
    	/**
    	 * значение
    	 */
        int value;
        /**
         * ссылка на след узел
         */
        Node next;

        /**
         * создаёт новый узел с указанным значением
         * @param value значение, хранящиеся в узле
         */
        Node(int value) 
        {
            this.value = value;
            this.next = null;
        }
    }
    
    /**
     * голова(первый элемент) списка
     */
    private Node head;
    /**
     * размер контейнера
     */
    private int size;

    /**
     * создаёт новый пустой контейнер
     */
    public IntCont() 
    {
        head = null;
        size = 0;
    }

    /**
     * добавляет число в конец контейнера
     * @param value число, которое нужно добавить
     */
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

    
    /**
     * возвращает иднекс запрашиваемого элемента
     * индексация начинается с 0
     * @param index индекс запрашиваемого элемента (должен быть в диапазоне [0, size()-1])
     * @return значение элемента по указанному индексу
     * @throws IndexOutOfBoundsException если индекс <0 или >= size()
     */
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

    /**
     * удаляет элемент по указанному индексу и возвращает его значение
     * @param index индекс удаляемого элемента (должен быть в диапазоне [0, size()-1])
     * @return значение удалённого элемента
     * @throws IndexOutOfBoundsException если индекс <0 или >= size()
     */
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
    
    /**
     * возвращает размер контейнера
     * @return количество элементов в контейнере
     */
    public int size() 
    {
        return size;
    }

    /**
     * проверяет пуст ли контейнер
     * @return {@code true} если в контейнере нет элементов, иначе {@code false}
     */
    public boolean isEmpty() 
    {
    	
        return size == 0;
    }

    /**
     * проверяет корректность индекса
     * Если индекс выходит за границы, бросаем исключение
     * @param index проверяемый индекс
     * @throws IndexOutOfBoundsException если индекс < 0 или индекс >= size
     */
    private void checkIndex(int index) 
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * возвращает содержимое контейнера в виде строки
     * Формат:или [] или [элементы]
     * @return строковое представление контейнера
     */
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