package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ListAggregatorTest {
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
    public void sum() {

        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new ListDeduplicator(list));

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void max_bug_7263() {
        list.clear();
        list.add(-1);
        list.add(-4);
        list.add(-5);

        ListAggregator aggregator = new ListAggregator(list);
        Assertions.assertEquals(-1, aggregator.max());
    }

    private class StubDistinct implements IListDeduplicator{
        @Override
        public List<Integer> deduplicate(IListSorter sorter) {
            List<Integer> ret = new ArrayList<>();
            ret.add(1);
            ret.add(2);
            ret.add(4);
            return  ret;
        }

    }

    @Test
    public void distinct_bug_8726(){
        list.clear();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        ListAggregator aggregator = new ListAggregator(list);
        Assertions.assertEquals(3, aggregator.distinct(new StubDistinct()));
    }
}
