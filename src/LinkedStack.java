public class LinkedStack<E> implements Stack<E> {
    protected Node<E> top;
    protected int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    @Override
    public E pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        E poppedElement = top.getElement();
        top = top.getNext();
        size--;
        return poppedElement;
    }

    @Override
    public E top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        return top.getElement();
    }
}
