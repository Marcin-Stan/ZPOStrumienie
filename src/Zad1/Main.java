package Zad1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        try {

            Stream<String> stream = Files.lines(Paths.get("test.txt"));

            List<Person> person = stream
                    .map(line -> line.split((" ")))
                    .map(a -> new Person(a[0], a[1], a[2], Integer.parseInt(a[3])))
                    .filter(a -> a.getCountry().equals("PL"))
                    .sorted(Comparator.comparingInt(Person::getPension))
                    .collect(Collectors.toList());

            System.out.println("Najmniej zarabiajacy Polak: " + person.get(0).getName() + " " + person.get(0).getSurname() + " Kwota:" + person.get(0).getPension()
                    + "\nDrugi w kolejnosc najmniej zarabiajacy Polak " + person.get(1).getName() + person.get(1).getSurname() + " Kwota:" + person.get(1).getPension()
                    + "\nSuma ich zarobkow: " + (person.get(0).getPension() + person.get(1).getPension())
                    + "\nNajlepiej zarabiajacy Polak: " + person.get(person.size() - 1).getName() + " " + person.get(person.size() - 1).getSurname() + " Kwota:" + person.get(person.size() - 1).getPension()
                    + "\nDrugi Najlepiej zarabiajacy Polak " + person.get(person.size() - 2).getName() + " " + person.get(person.size() - 2).getSurname() + " Kwota:" + person.get(person.size() - 2).getPension()
                    + "\nSuma ich zarobkow: " + (person.get(person.size() - 1).getPension() + person.get(person.size() - 2).getPension())
            );

            stream.close();

            Stream<String> stream2 = Files.lines(Paths.get("test.txt"));

            List<Person> person2 = stream2
                    .map(line -> line.split((" ")))
                    .map(a -> new Person(a[0], a[1], a[2], Integer.parseInt(a[3])))
                    .collect(Collectors.toList());

            Map<String, Long> countryMap = person2.stream()
                    .collect(Collectors.groupingBy(Person::getCountry, Collectors.counting()));
            System.out.println(countryMap);

            stream2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}







