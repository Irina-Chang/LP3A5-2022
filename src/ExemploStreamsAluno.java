package exemplos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploStreamsAluno<listOfAllIntegers> {

    public static void main(String[] args) {
        //exemplo de sorted como funcao intermediaria
        List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);

        System.out.println("lista antes de ordenar:");
        System.out.println(list);
        Collectors Collectors = null;
        List<Integer> sortedList = list.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Lista depois de utilizar o sorted");
        System.out.println(sortedList);

        //exemplo de flatmap
        List<Integer> list1 = Arrays.asList(10, 20, 30);
        List<Integer> list2 = Arrays.asList(40, 50, 60);
        List<Integer> list3 = Arrays.asList(70, 80, 90);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
        System.out.println("listas separadas antes do flatmap");
        System.out.println(listOfLists);
        List<Integer> listOfAllIntegers = listOfLists.stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
        System.out.println("junçao das listas em uma só, apos o flatmap");
        System.out.println(listOfAllIntegers);
    }
}