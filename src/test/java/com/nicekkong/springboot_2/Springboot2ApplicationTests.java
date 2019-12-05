package com.nicekkong.springboot_2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

@SpringBootTest
class Springboot2ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testFlux() {
        Flux.just("alpha", "brabo", "chalie").subscribe(System.out::println);
    }

    @Test
    void testFlux2() {
        Flux.just(
                (Supplier<String>) () -> "alpha2",
                (Supplier<String>) () -> "brabo2",
                (Supplier<String>) () -> "chalie2")
                .subscribe(supplier -> System.out.println(supplier.get()));

    }

    @Test
    void testFlux3() {
        Flux.just("alpha", "brabo", "chalie")
                .map(String::toUpperCase)
                .flatMap(s -> Flux.fromArray(s.split("")))
                .groupBy(String::toString)
                .sort((o1, o2) -> o1.key().compareTo(o2.key()))
                .flatMap(group -> Mono.just(group.key()).and(group.count()))
                .map(keyAndCount -> keyAndCount.toString())
                .subscribe(System.out::println);

    }
}
