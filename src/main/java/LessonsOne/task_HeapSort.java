package LessonsOne;

import java.util.Random;

public class task_HeapSort {
    public static void main(String[] args) {

        int[] someArray = fillingRandomArray(20, -10, 11);
        printArray(someArray);
        heapSort(someArray);
        printArray(someArray);


    }

    public static void printArray(int[] array){
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static int[] fillingRandomArray(int volume, int minValue, int maxValue) {
        Random random = new Random();
        int[] array = new int[volume];
        for (int i = 0; i < volume; i++) {
            array[i] = random.nextInt(minValue, maxValue);
        }
        return array;
    }


    public static void heapSort(int[] array) {
        int size = array.length;

        //создаём дерево, построение кучи (перегруппируем массив)
        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(array, i, size);

        //Делаем сортировку массива, уже отсортированного дерева,
        //Один за другим извлекаем элементы из кучи
        for (int i = size - 1; i >= 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(array, 0, i);
        }

    }

    /**
     * Главный метод в котором будет меняться структура данных так чтоб родитель был максимальны элементом по сравнению
     * со своими детьми в дереве
     */
    private static void heapify(int[] array, int i, int n) {
        //левый ребёнок
        int leftChild = i * 2 + 1;

        //правый ребёнок
        int rightChild = i * 2 + 2;

        //Инициализируем наибольший элемент как корень
        int largest = i;

        //Проверка чтоб дети не стали больше чем родители
        //Если левый дочерний элемент больше корня
        if (leftChild < n && array[leftChild] > array[largest])
            largest = leftChild;

        //Если правый дочерний элемент больше,
        // чем самый большой элемент на данный момент
        if (rightChild < n && array[rightChild] > array[largest])
            largest = rightChild;

        //Если, ребёнок оказался больше родителя, то делаем обмен,
        //ребёнка с родителем. Если самый большой элемент не корень
        if (i != largest) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            //Проверяем ещё раз чтоб дети были меньше чем родители,
            //если, вдруг у детей есть свои дети
            //Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array, largest, n);
        }
    }
}
