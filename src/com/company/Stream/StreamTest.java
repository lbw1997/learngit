package com.company.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/*Stream流的常见方法*/
/**
 * 外部迭代和内部迭代(聚合操作)都是对集合的迭代，但是在机制上还是有一定的差异：
 *
 * 1、迭代器提供next()、hasNext()等方法，开发者可以自行控制对元素的处理，以及处理方式，但是只能顺序处理；
 * 2、stream()方法返回的数据集无next()等方法，开发者无法控制对元素的迭代，迭代方式是系统内部实现的，
 * 同时系统内的迭代也不一定是顺序的，还可以并行，如parallelStream()方法。并行的方式在一些情况下，可以大幅提升处理的效率。
 */
public class StreamTest {
    public static void main(String[] args) {
        Student stuA = new Student(1, "A", "M", 184);
        Student stuB = new Student(2, "B", "G", 163);
        Student stuC = new Student(3, "C", "M", 175);
        Student stuD = new Student(4, "D", "G", 158);
        Student stuE = new Student(5, "E", "M", 170);
        List<Student> list = new ArrayList<>();
        list.add(stuA);
        list.add(stuB);
        list.add(stuC);
        list.add(stuD);
        list.add(stuE);
        //使用迭代器进行遍历
        /*首先调用iterator方法，产生一个新的Iterator对象，进而控制整
          个迭代过程，这就是外部迭代
          迭代过程通过显式调用Iterator对象的hasNext和next方法完成迭代*/
//        Iterator<Student> iterator = list.iterator();
//        while(iterator.hasNext()) {
//            Student stu = iterator.next();
//            if(stu.getSex().equals("G"))
//                System.out.println(stu.toString());
//        }
        //使用Srteam
        /*通过stream方法创建Stream，然后再通过filter方法对源数据进行过滤，最后通过foeEach方法进行迭代。在聚合操作中，
        与Labda表达式一起使用，显得代码更加的简洁。这里值得注意的是，我们首先是stream方法的调用，
        其与iterator作用一样的作用一样，该方法不是返回一个控制迭代的 Iterator 对象，
        而是返回内部迭代中的相应接口： Stream，其一系列的操作都是在操作Stream,直到foreach时才会操作结果，
        这种迭代方式称为内部迭代。*/
        list.stream()
                .filter(student -> student.getSex().equals("G"))
                .forEach(student -> System.out.println(student.toString()));
        long no = list.stream()
                .filter(student -> {
                    System.out.println(student.getName());
                    return student.getName().equals("C");
                })
                .count();
        System.out.println(no);
        //对intStream进行操作
        int numbers[] = {1,1,5,7,6,4,5,4,2,2,8,7,8,7,10,5,4};
        Arrays.stream(numbers)
                .filter(item->item%2==0)        //过滤
                .distinct()                     //去重
                .sorted()                       //排序
                .forEach(item->System.out.print(item+" "));
                //.forEach(System.out::print);
    }
}
class Student{
    int no;
    String name;
    String sex;
    float height;
    public Student(int no, String name, String sex, float height) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.height = height;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                '}';
    }
}
