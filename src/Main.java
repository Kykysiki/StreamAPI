import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        findMinMax(Stream.of(23, 12, 5, 3, -5, 52), Integer::compareTo, (min, max) -> {
            System.out.printf("min: %d, max: %d %n", min, max);
        });
        task2Stream();
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> comparator,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.sorted(comparator).collect(Collectors.toList());
        minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
    }

    private static void task2Stream() {
        Stream.iterate(2, i -> i + 2).limit(20).forEach(System.out::println);
    }
}