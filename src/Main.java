import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задача №1");

        Stream<Integer> stream1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)).stream();
        findMinMax(stream1, Integer :: compareTo, (x, y) -> System.out.println("min " + x + " max " + y));

        System.out.println();
        System.out.println("Задача №2");

        Stream<Integer> integerStream = Stream.iterate(0, i -> ++i);
        integerStream
                .filter(i -> i % 2 == 0)
                .limit(20)
                .forEach(System.out::println);

        System.out.println();
        //  возьмем метод класса Stream — filter, который в качестве аргумента принимает Predicate
        //  и возвращает Stream только с теми элементами, которые удовлетворяют условию Predicate.
        List<Integer> numbers = Stream.of(11, 13, 14, 15, 16, 22, 23, 25)
                .filter(b -> b % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(numbers);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer)
    {
        List<T> items = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }


}