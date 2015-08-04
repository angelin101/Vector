package vector;

/**
 * Created by Ангелин on 03.08.2015.
 */
public class Vector<T> {
    private T[] array;
    //private T ob;
    private int numberOfLinks;

    public Vector(){
        array = (T[]) new Object[10];
        //numberOfLinks = 0;
    }
    public Vector(T[] array){
        this.array = array;
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

    public void eraseArray(){
        array = (T[]) new Object[10];
    }

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

    public T getLink(int numberOfElement){
        if (numberOfElement < 0 || numberOfElement >= numberOfLinks) {
            throw new IndexOutOfBoundsException("Invalid numberOfElement index"); 
        }
        return array[numberOfElement];
    }

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

    @Override
    public String toString(){
        String res ="";    
        for (int i = 0; i < array.length; i++) {
            res += array[i]+" "; 
        }
        return "Vector[]: {"+res+'}';
    }
}
