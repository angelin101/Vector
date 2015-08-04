package vector;

/**
 * Created by Ангелин on 03.08.2015.
 * Обобщенный класс для хранения ссылок на обьекты!!!
 */
public class Vector<T> {
    private T[] array;
    private int numberOfLinks;

    // конструктор по умолчанию создает массив на 5 эллементов
    public Vector(){
        array = (T[]) new Object[5];
    }
    public Vector(T[] array){
        this.array = array;
        numberOfLinks = array.length;
    }

    public int getNumberOfLinks() {
        return numberOfLinks;
    }

    public void setNumberOfLinks(int numberOfLinks) {
        this.numberOfLinks = numberOfLinks;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    // метод очищает весь массив
    public void eraseArray(){
        array = (T[]) new Object[5];
        numberOfLinks = 0;
    }

    // метод добавляет ссылку в массив. Если массив заполнен, то создается новый массив,
    // в 2 раза большего размера, куда копируються все ссылки и добовляется новая!
    public void putLink(T ob){
        if (numberOfLinks==array.length-1) {
            T[] array2 = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                array2[i] = array[i];
            }
            array = array2;
        }
        array[numberOfLinks] = ob;
        numberOfLinks++;
    }
    // метод для получения ссылки расположеной в массиве под j-ым эллементом!
    public T getLink(int numberOfElement){
        if (numberOfElement < 0 || numberOfElement >= numberOfLinks) {
            throw new IndexOutOfBoundsException("Invalid numberOfElement index");
        }
        return array[numberOfElement];
    }

    // метод удаляет ссылку в массиве под j-ым эллементом. При этом массив уменьшается!
    public void removeLink(int numberOfElement){
        if (numberOfElement < 0 || numberOfElement >= numberOfLinks) {
            throw new IndexOutOfBoundsException("Invalid numberOfElement index");
        }
        T[] array2 = (T[]) new Object[array.length-1];
        for (int i = 0; i < array2.length; i++) {
            if (i >= numberOfElement) {
                array2[i] = array[i+1];
            }
            else{
                array2[i] = array[i];
            }
        }
        array = array2;
        numberOfLinks--;
    }

    // метод выводит содержимое массива на экран
    @Override
    public String toString(){
        String res ="";
        for (int i = 0; i < array.length; i++) {
            res += array[i]+" ";
        }
        return "Vector[]: {"+res+"}";
    }
}
