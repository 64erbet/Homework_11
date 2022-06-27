import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClassStream {
    public static void main(String[] args) {
        ClassStream classStream = new ClassStream();
        List<String> list = new ArrayList();
        list.add("Ivan");
        list.add("Kolya");
        list.add("Zapp");
        list.add("Peter");
        list.add("Aurelii");
        list.add("Igor");
        list.add("Valera");

        String[] masString_1 = {"raz", "dva", "tri", "chetire", "pyat", "shest"};
        String[] masString_2 = {"1", "5", "8", "10"};

        System.out.println("odded(list) = " + classStream.odded(list));
        System.out.println("upperCase(list) = " + classStream.upperCase(list));
        System.out.println("classStream.getDigits(masString_2) = " + classStream.getDigits(masString_2));
////        System.out.println("zip(Arrays.stream(masString_1), Arrays.stream(masInteger_1)) = " +
                zip(Arrays.stream(masString_2), Arrays.stream(masString_1)).forEach(e -> System.out.println(e));
////        System.out.println("classStream.getGenerator(25214903917L, 11L,  2^48L, 1L) = " +
//          classStream.getGenerator(25214903917L, 11L, 2 ^ 48L, 1L)
//                  .forEach(System.out::println);
    }

    public String odded(List<String> list) {
        return list.stream()
                .map(element -> list.indexOf(element)+1 + ". " + element)
                .filter(element -> list.indexOf(element.substring(3))%2 == 0)
                .collect(Collectors.toList()).toString();
    }

    public List<String> upperCase(List<String> list) {
        return list.stream()
                .map(s -> s.toUpperCase())
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public ArrayList<Integer> getDigits(String[] mas) {
        ArrayList<Integer> rezult = new ArrayList();
        Arrays.stream(mas)
                .sorted()
                .forEach(string -> Arrays.stream(string.split(", "))
                                .map(chisloString -> Integer.parseInt(chisloString))
                                .sorted()
                                .forEach(chislo -> {
                                    rezult.add(chislo);
                                }));
        return (rezult);
    }

    public Stream<Long> getGenerator(Long a, Long c, Long m, Long seed) {
        return Stream.iterate(seed,e -> (a * e + c) % m);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        T[] arrayFirst = (T[]) first.toArray();
        T[] arraySecond = (T[]) second.toArray();
        ArrayList<T> rez = new ArrayList<>();
        if (arrayFirst.length >= arraySecond.length) {
            for (int i=0; i< arraySecond.length; i++) {
                rez.add(arrayFirst[i]);
                rez.add(arraySecond[i]);
            }
        } else {
            for (int i=0; i< arrayFirst.length; i++) {
                rez.add(arrayFirst[i]);
                rez.add(arraySecond[i]);
            }
        }
        return (rez.stream());
    }
}
