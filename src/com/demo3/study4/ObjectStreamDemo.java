package com.demo3.study4;

import java.io.*;

public class ObjectStreamDemo {
    public static void main(String[] args) {

    }

    private static void write() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E://StudyTest/Object.txt"));
        Student s = new Student("雷雪松", 21);
        oos.writeObject(s);
        oos.close();
    }

    private static void reader() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E://StudyTest/Object.txt"));
        Object obj = ois.readObject();
        Student s = (Student) obj;
        System.out.println(s.getName() + "," + s.getAge());
        ois.close();
    }
}
