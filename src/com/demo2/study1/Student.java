package com.demo2.study1;

public class Student extends Object {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
       /* this --- s1
          o    --- s2
          == 表示是否地址相同
       */
        if (this == o) return true;//false
        /*判断参数是否为null
        判断两个对象是否来自同一个类
        两种情况只要有一种满足就返回false
        */
        if (o == null/*s2不等于空,不满足*/ || getClass() != o.getClass())/*s1和s2来自同一类，满足 */ return false;//false
        //向下转型
        Student student = (Student) o;//student=s2
        //比较年龄是否相同,
        if (age != student.age) return false;//年龄是相同的，所以true
        //比较姓名是否相同，因为姓名是String类型的，equals比较的就是类容是否相同
        //所以返回 true
        return name != null ? name.equals(student.name) : student.name == null;
    }
}
