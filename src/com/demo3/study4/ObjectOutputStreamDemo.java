package com.demo3.study4;

import java.io.*;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("E://StudyTest/Object.txt"));
        Student s=new Student("雷雪松",21);
        oos.writeObject(s);
        oos.close();*/

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E://StudyTest/Object.txt"));
        Student obj = (Student) ois.readObject();
        System.out.println(obj.getName()+","+obj.getAge());
        ois.close();
    }
}
