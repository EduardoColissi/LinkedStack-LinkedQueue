public class LinkedQueue<E> implements Queue<E> {
    protected Node<E> front;
    protected Node<E> rear;
    protected int size;

    public LinkedQueue() {
        front = null;
        rear = null;
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
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);

        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }

        rear = newNode;
        size++;
    }

    @Override
    public E dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        E dequeuedElement = front.getElement();
        front = front.getNext();
        size--;

        if (isEmpty()) {
            rear = null;
        }

        return dequeuedElement;
    }

    @Override
    public E front() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        return front.getElement();
    }

    @Override
    public E back() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        return rear.getElement();
    }
}

