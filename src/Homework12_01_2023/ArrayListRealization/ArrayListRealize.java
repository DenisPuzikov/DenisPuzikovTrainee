package Homework12_01_2023.ArrayListRealization;

import jdk.internal.util.ArraysSupport;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class ArrayListRealize {
    private int size;
    private static int default_capacity = 10;
    private static final Object[] DEF_EMP_ELEMENTSDATA = {};
    private Object[] elements;

    public ArrayListRealize() {
        default_capacity = 10;
        size = 0;
        elements = new Object[default_capacity];
    }

    public void add(Object element) {
        if (size == default_capacity) {
            grow();
        }
        elements[size] = element;
        size++;
    }

//    public boolean addAll(int index, ArrayList<Object> list){
//        Object[] a = list.toArray();
//        int numNew = a.length;
//        if (numNew == 0)
//            return false;
//        Object[] elementData;
//        final int s;
//        if (numNew > (elementData = this.elements).length - (s = size))
//            elementData = grow(s + numNew);
//        System.arraycopy(a, 0, elementData, s, numNew);
//        size = s + numNew;
//        return true;
//    }

    public boolean addAll(ArrayList<Object> list) {
        Object[] a = list.toArray();
        int numNew = a.length;
        grow(size + numNew);
        System.arraycopy(a, 0, elements, size, numNew);
        size += numNew;
        return numNew != 0;
    }
    public void addAll(int index, ArrayList<Object> list) {
        rangeCheckForAdd(index);
        Object[] a = list.toArray();
        for (Object o : a) {
            elements[index++] = o;
        }
    }

    public void remove(int index) {
        int numMoved = size - index - 1;
        System.arraycopy(elements, index + 1, elements, index, numMoved);
        elements[--size] = null;
    }
    public Object get(int index){
        return elements[index];
    }


    private void grow() {
        default_capacity = (int) (default_capacity *  1.5);
        Object[] newElements = new Object[default_capacity];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }
    private Object[] grow(int minCapacity) {
        int oldCapacity = elements.length;
        if (oldCapacity > 0 || elements != DEF_EMP_ELEMENTSDATA) {
            int newCapacity = ArraysSupport.newLength(oldCapacity,
                    minCapacity - oldCapacity, /* minimum growth */
                    oldCapacity >> 1           /* preferred growth */);
            return elements = Arrays.copyOf(elements, newCapacity);
        } else {
            return elements = new Object[Math.max(default_capacity, minCapacity)];
        }
    }
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
}
