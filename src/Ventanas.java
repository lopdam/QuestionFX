
/**
 *
 * @author roboto
 */
public class Ventanas {

    private Ventana first;
    private Ventana last;
    private int size;

    public Ventanas() {
        this.first = null;
        this.last = null;
        this.size = 0;

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(Ventana v) {
        if (v == null) {
            return false;
        }

        Ventana ventana = v;
        if (isEmpty()) {
            first = ventana;
            last = ventana;

            first.setNext(last);
            first.setPrevious(last);

            last.setPrevious(first);
            last.setNext(first);
            size++;
            return true;
        } else {
            Ventana tmp = last;

            last = ventana;

            tmp.setNext(last);
            last.setPrevious(tmp);

            first.setPrevious(last);
            last.setNext(first);

            size++;
            return true;
        }
    }

    public Ventana getFirst() {
        return first;
    }

    public Ventana getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

}
