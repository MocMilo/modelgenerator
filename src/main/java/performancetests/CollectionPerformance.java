package performancetests;

import datagenerator.model.person.Person;
import training.java8streams.approach1.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionPerformance {
    public static void main(String[] args) throws IOException {
        arrayListVsArrayListWithSizeInit();
        arrayListVsLinkedList();
    }

    static void arrayListVsArrayListWithSizeInit() throws IOException {
        int objectsMultiplicator = 100000;
        int numberOfRepeats = 5;

        // adding Person to list vs adding Person to defined size list
        List<Person> testData = new ArrayList<>();
        List<Person> fileData = new FileUtil().getTasksModel();
        for (int n = 0; n < objectsMultiplicator; n++) {
            testData.addAll(fileData);
        }
        System.out.println("TEST DATA SIZE:" + testData.size());

        // adding items time
        for (int i = 0; i < numberOfRepeats; i++) {

            long start_1 = System.currentTimeMillis();
            List<Person> personArrayList = new ArrayList<>();
            personArrayList.addAll(testData);
            long stop_1 = System.currentTimeMillis();

            long start_2 = System.currentTimeMillis();
            List<Person> personArrayListDefinedSize = new ArrayList<>(testData.size());
            personArrayListDefinedSize.addAll(testData);
            long stop_2 = System.currentTimeMillis();


            System.out.println("** ArrayList VS ArrayListWithSize - AddAll");
            System.out.println("ArrayList [  no size  ] init size:" + personArrayList.size());
            System.out.println("ArrayList [ With Size ] init size:" + personArrayListDefinedSize.size());
            System.out.println("ArrayList [  no size  ] time:" + (stop_1 - start_1));
            System.out.println("ArrayList [ With Size ] time:" + (stop_2 - start_2));
        }
        // iteration time

        List<Person> personArrayList = new ArrayList<>();
        personArrayList.addAll(testData);

        List<Person> personArrayListDefinedSize = new ArrayList<>(testData.size());
        personArrayListDefinedSize.addAll(testData);

        for (int i = 0; i < numberOfRepeats; i++) {
            long start_3 = System.currentTimeMillis();
            personArrayList.forEach(x -> x.getName());
            personArrayList.get(testData.size()-10);
            long stop_3 = System.currentTimeMillis();

            long start_4 = System.currentTimeMillis();
            personArrayListDefinedSize.forEach(x -> x.getName());
            personArrayListDefinedSize.get(testData.size()-10);
            long stop_4 = System.currentTimeMillis();

            System.out.println("** ArrayList VS ArrayListWithSize - iteration get() by index");
            System.out.println("ArrayList [  no size  ] init size:" + personArrayList.size());
            System.out.println("ArrayList [ With Size ] init size:" + personArrayListDefinedSize.size());
            System.out.println("ArrayList [  no size  ] time:" + (stop_3 - start_3));
            System.out.println("ArrayList [ With Size ] time:" + (stop_4 - start_4));
        }
    }
        static void arrayListVsLinkedList() throws IOException {
            int objectsMultiplicator = 20000;
            int numberOfRepeats = 5;

            // data preparation
            List<Person> testData = new ArrayList<>();
            List<Person> fileData = new FileUtil().getTasksModel();
            for (int n = 0; n < objectsMultiplicator; n++) {
                testData.addAll(fileData);
            }
            System.out.println("** ArrayList vs LinkedList ***");
            System.out.println("TEST DATA SIZE:" + testData.size());

            // adding items time
            for (int i = 0; i < numberOfRepeats; i++) {

                long start_1 = System.currentTimeMillis();
                List<Person> personArrayList1 = new ArrayList<>();
                personArrayList1.addAll(testData);
                long stop_1 = System.currentTimeMillis();

                long start_2 = System.currentTimeMillis();
                List<Person> personLinkedList1 = new LinkedList<>();
                personLinkedList1.addAll(testData);
                long stop_2 = System.currentTimeMillis();


                System.out.println("** ArrayList VS LinkedList - AddAll");
                System.out.println("ArrayList  init size:" + personArrayList1.size());
                System.out.println("LinkedList init size:" + personLinkedList1.size());
                System.out.println("ArrayList  time:" + (stop_1 - start_1));
                System.out.println("LinkedList time:" + (stop_2 - start_2));
            }

            // adding item inside list

            List<Person> personArrayList = new ArrayList<>();
            personArrayList.addAll(testData);

            List<Person> personLinkedList = new LinkedList<>();
            personLinkedList.addAll(testData);
            Person person = testData.get(0);

            for (int i = 0; i < numberOfRepeats; i++) {

                long start_1 = System.currentTimeMillis();
                personArrayList.add(10, person);
                personArrayList.remove(40);
                long stop_1 = System.currentTimeMillis();

                long start_2 = System.currentTimeMillis();
                personLinkedList.add(10, person);
                personLinkedList.remove(40);
                long stop_2 = System.currentTimeMillis();


                System.out.println("** ArrayList VS LinkedList - Add/remove item by index (begining)");
                System.out.println("ArrayList  init size:" + personArrayList.size());
                System.out.println("LinkedList init size:" + personLinkedList.size());
                System.out.println("ArrayList  time:" + (stop_1 - start_1));
                System.out.println("LinkedList time:" + (stop_2 - start_2));
            }

            // iteration time
            List<Person> personArrayList2 = new ArrayList<>();
            personArrayList2.addAll(testData);

            List<Person> personLinkedList2 = new LinkedList<>();
            personLinkedList2.addAll(testData);

            for (int i = 0; i < numberOfRepeats; i++) {
                long start_1 = System.currentTimeMillis();
                personArrayList2.forEach(x -> x.getName());
                long stop_1 = System.currentTimeMillis();

                long start_2 = System.currentTimeMillis();
                personLinkedList2.forEach(x -> x.getName());
                long stop_2 = System.currentTimeMillis();

                System.out.println("** ArrayList VS LinkedList - iteration by all elements");
                System.out.println("ArrayList init size:" + personArrayList2.size());
                System.out.println("LinkedList init size:" + personLinkedList2.size());
                System.out.println("ArrayList time:" + (stop_1 - start_1));
                System.out.println("LinkedList time:" + (stop_2 - start_2));
            }

            // iteration time
            List<Person> personArrayList3 = new ArrayList<>();
            personArrayList3.addAll(testData);
            personArrayList3.addAll(testData);
            personArrayList3.addAll(testData);

            List<Person> personLinkedList3 = new LinkedList<>();
            personLinkedList3.addAll(testData);
            personLinkedList3.addAll(testData);
            personLinkedList3.addAll(testData);

            for (int i = 0; i < numberOfRepeats; i++) {
                long start_1 = System.currentTimeMillis();
                personArrayList3.get(3*testData.size()-1);
                long stop_1 = System.currentTimeMillis();

                long start_2 = System.currentTimeMillis();
                personLinkedList3.get(3*testData.size()-1);
                long stop_2 = System.currentTimeMillis();

                System.out.println("** ArrayList VS LinkedList - iteration get() by index (last)");
                System.out.println("ArrayList init size:" + personArrayList3.size());
                System.out.println("LinkedList init size:" + personLinkedList3.size());
                System.out.println("ArrayList time:" + (stop_1 - start_1));
                System.out.println("LinkedList time:" + (stop_2 - start_2));
            }
        }
}
