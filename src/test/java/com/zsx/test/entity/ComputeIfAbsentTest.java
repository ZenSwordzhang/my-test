package com.zsx.test.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ComputeIfAbsentTest {

    @Test
    void testComputeIfAbsent() {
        Map<String, Set<String>> map = new IdentityHashMap<>(16);
        Set<String> set1 = new LinkedHashSet<>(4);
        set1.add("A");
        set1.add("B");
        set1.add("C");
        Set<String> set = map.computeIfAbsent(this.getClass().getName(), key -> new LinkedHashSet<>(4));
        set.addAll(set1);
        System.out.println(map);
    }
}
