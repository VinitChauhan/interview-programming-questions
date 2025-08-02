package org.example.string;

import org.example.model.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Stream.iterate(40,n->n+2).limit(20).forEach(System.out::println);

        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));

//        String collect = productList.stream().map(product -> product.name()).collect(Collectors.joining(",","[","]"));
//        Map<Integer, List<Product>> collect = productList.stream().collect(Collectors.groupingBy(Product::price));
        Map<Boolean, List<Product>> collect = productList.stream().collect(Collectors.partitioningBy(product -> product.price() >= 14));

//         productList.stream().map()


    }
}
