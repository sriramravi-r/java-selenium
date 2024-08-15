package org.streamapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream1 {
    @Test
    public void streamFilter(){
        ArrayList<String> name=new ArrayList<>();
        name.add("sriram");
        name.add("sai");
        name.add("rahul");
        name.add("ram");

        Long count=name
                .stream()
                .filter(s->s.startsWith("r"))
                .count();
        System.out.println(count);

        Stream<String> numberstream=name.stream();

        System.out.println(numberstream.filter(s -> s.endsWith("l") ).count());

        name
                .stream()
                .filter(a->a.length()>1)
                .limit(1)
                .forEach(System.out::println);

    }

    @Test
    public void streamMap(){
        Stream.of("sriram","sai","rahul","ram")
                .filter(s->s.startsWith("s"))
                .map(s->s.toUpperCase())
                .sorted()//modify our stream filter value
                .forEach(System.out::println);
    }

    @Test
    public void concat(){
        ArrayList<String> name=new ArrayList<>();
        name.add("sriram");
        name.add("sai");
        name.add("rahul");
        name.add("ram");

        ArrayList<String> name2=new ArrayList<>();
        name2.add("pai");
        name2.add("sai");
        name2.add("rah");
        name2.add("mar");

        Stream
                .concat(name.stream(),name2.stream())
                .forEach(System.out::println);
    }

    @Test
    public void anyMatch(){
        ArrayList<String> name=new ArrayList<>();
        name.add("sriram");
        name.add("sai");
        name.add("rahul");
        name.add("ram");

        boolean flag=name
                .stream()
                .anyMatch(s -> s.equalsIgnoreCase("SRIRAM"));
        Assert.assertTrue(flag);
    }

    @Test
    public void collect(){
        ArrayList<String> name=new ArrayList<>();
        name.add("sriram");
        name.add("sai");
        name.add("rahul");
        name.add("ram");

        List<String> username=name.stream()
                .filter(s->s.endsWith("m"))
                .map(s->s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(username.get(1));
    }

    @Test
    public void distict(){
        List<Integer> listremoveduplicate=Stream.of(1,1,2,2,3,3,4,4,5,6)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(listremoveduplicate);
    }
}
