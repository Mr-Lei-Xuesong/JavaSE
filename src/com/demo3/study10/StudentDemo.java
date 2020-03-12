package com.demo3.study10;

public class StudentDemo {
    public static void main(String[] args) {
        /*useStudentBuilder((String name,int age)->{
            return new Student(name,age);
        });*/

        useStudentBuilder((name,age)->new Student(name,age));

        useStudentBuilder(Student::new);
    }

    public static void useStudentBuilder(StudentBuilder sb){
        Student s = sb.build("雷雪松", 22);
        System.out.println(s.getName()+","+s.getAge());
    }
}
