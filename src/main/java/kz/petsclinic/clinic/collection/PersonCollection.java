package kz.petsclinic.clinic.collection;

import kz.petsclinic.clinic.Person;

/**
 * ��������� ��� ������ � ���������,
 * ������� ������� ArrayList
 */
public class PersonCollection {

    /**
     * ��������� ������
     * ������� �� ���������
     */
    private final static int DEFAULT_DATA_CAPACITY = 10;
    /**
     * ������ �������� �����
     * ������� data
     */
    private int size = 0;

    /**
     * ������� ������ Person
     */
    private Person[] data;

    public PersonCollection() {
        data = new Person[DEFAULT_DATA_CAPACITY];
    }

    /**
     *
     * @return ������ ��������
     * ����� �������
     */
    public int getSize() {
        return size;
    }

    /**
     * �������� ������� �� �������
     * @param index ������ ������
     * �������
     * @return ����������� �������
     */
    public Person get(final int index) {
        checkRange(index);
        return data[index];
    }

    /**
     * ���������� ����� �������
     * � ������
     * @param person ����� �������
     */
    public void add(final Person person) {
        checkCapacity();
        data[size++] = person;
    }

    /**
     * �������� ������� ��
     * ��������� �������
     * @param index ������
     * ��������� �������
     */
    public void remove(final int index) {
        checkRange(index);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
    }

    /**
     * ����� ������ ��� �������
     * @return ����� ������
     */
    public int getNewCapacity() {
        return (data.length * 3) / 2 + 1;
    }

    /**
     * �������� ���� ��
     * �������� ������
     * @return true ���� ����,
     * false ���� ���
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * ��������� Id ������� �������
     * �������� � ��������� ��������
     * @param person �������� �������
     * @return Id ������ ��� -1 ����
     * ����� ������� �� �������
     */
    public int getPersonId(Person person) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(person)) result = i;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sBuilder.append("[ " + i + ": " + data[i].toString() +" ]\n");
        }
        return sBuilder.toString();
    }

    /**
     * �������� �� ������ ��
     * ������ ��������� �������
     * �� ������ ��������� ��� ����������
     * ������ ��������,
     * � ����� ������ "���������������"
     * �������� ������ ���� �������
     */
    private void checkCapacity() {
        if (size + 1 > data.length)
            increaseCapacity();
    }

    /**
     * "����������" ������� ���������
     * �������
     */
    private void increaseCapacity() {
        Person[] newData = new Person[getNewCapacity()];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    /**
     * �������� �� ���������
     * ��������� ������� � ��������
     * ����� �������
     * @param index ������ ��� ��������
     */
    private void checkRange(final int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(
                    "index " + index + " out of 0.." + size);
    }


}
