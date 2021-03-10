package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListDeduplicatorTest {
    public List<Integer> list;

    @BeforeEach
    public void prep(){
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }

    @Test
    public void deduplicate() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new ListSorter(list));

        Assertions.assertEquals(expected, distinct);
    }

    private class StubListSorter implements IListSorter{
        @Override
        public List<Integer> sort() {
            List<Integer> ret = new ArrayList<>();
            ret.add(1);
            ret.add(2);
            ret.add(2);
            ret.add(4);

            return ret;
        }
    }

    @Test
    public void bug_8726() {
        list.clear();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new StubListSorter());

        Assertions.assertEquals(expected, distinct);
    }
}
