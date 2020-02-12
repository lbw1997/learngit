package com.company.Stream;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Stream流的创建
 */
public class StreamCreat {
    public static void main(String[] args) {
        /*静态工厂方法*/
        /**
         * of方法，其生成的Stream是有限长度的，Stream的长度为其内的元素个数。*/
        Stream<Integer> stream = Stream.of(1,2,3);
        Stream<String> stringStream = Stream.of("A");
        /*generator*/
        /**
         * 返回一个无限长度的Stream,其元素由Supplier接口的提供。在Supplier是一个函数接口，
         * 只封装了一个get()方法，其用来返回任何泛型的值，该结果在不同的时间内，
         * 返回的可能相同也可能不相同，没有特殊的要求。
         */
        double tmpDouble = 0.7554;
        Stream<Double> generatorA = Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {
                return java.lang.Math.random();
            }
        }).filter(i->i<tmpDouble)
                .limit(10);
        Stream<Double> generatorB = Stream.generate(()-> java.lang.Math.random());
        Stream<Double> generatorC = Stream.generate(java.lang.Math::random);
        /*generatorA.forEach(System.out::println);
        generatorB.forEach(System.out::println);
        generatorC.forEach(System.out::println);*/
        /*iterate*/
        /**
         *其返回的也是一个无限长度的Stream，与generate方法不同的是，
         *其是通过函数f迭代对给指定的元素种子而产生无限连续有序Stream，
         *其中包含的元素可以认为是：seed，f(seed),f(f(seed))无限循环。
         */
        Stream.iterate(1,item->item*2)
                .limit(10)
                .forEach(System.out::println);
        /*empty*/
        /**
         * empty方法返回一个空的顺序Stream，该Stream里面不包含元素项。
         */
        Stream.empty();
        /*Collection接口和数组的默认方法*/
        List<String> list = new ArrayList<>();
        list.stream();
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.stream();
        Set<String> set = new LinkedHashSet<>();
        set.stream();
        Set<String> hashSet = new HashSet<>();
        hashSet.stream();
        /**
         * 在Arrays类，封装了一些列的Stream方法，
         * 不仅针对于任何类型的元素采用了泛型，更对于基本类型作了相应的封装，以便提升Stream的处理效率。
         */
        int[] intArr = new int[]{1,2,3,4};
        Arrays.stream(intArr);
        double[] doubleArr = new double[]{1.1,2.2};
        Arrays.stream(doubleArr);
    }
}
