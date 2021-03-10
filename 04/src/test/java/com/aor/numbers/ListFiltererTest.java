package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ListFiltererTest {
    List<Integer> list;
    public IListFilter filter = Mockito.mock(IListFilter.class);

    @BeforeEach
    public void prep(){
        list = new ArrayList<>();
        list.add(-1);
        list.add(1);
        list.add(12);
        list.add(-5);
        list.add(7);
        list.add(-15);
    }

    @Test
    public void filterPositive() {
        List<Integer> pos = new ArrayList<>();
        pos.add(1);
        pos.add(12);
        pos.add(7);

        ListFilterer filterer = new ListFilterer(list);
        Assertions.assertEquals(pos, filterer.filter(new PositiveFilter()));
    }

    @Test
    public void filterPositiveMock() {
        List<Integer> pos = new ArrayList<>();
        pos.add(1);
        pos.add(12);
        pos.add(7);

        Mockito.when(filter.accept(Mockito.anyInt())).thenAnswer(f -> (int)(f.getArgument(0)) > 0);
        ListFilterer filterer = new ListFilterer(list);
        Assertions.assertEquals(pos, filterer.filter(filter));
    }

    @Test
    public void divisibleByFilterMock() {
        List<Integer> pos = new ArrayList<>();
        pos.add(12);
        pos.add(-15);

        Mockito.when(filter.accept(Mockito.anyInt())).thenAnswer(f -> (int)(f.getArgument(0))% 3 == 0);
        ListFilterer filterer = new ListFilterer(list);
        Assertions.assertEquals(pos, filterer.filter(filter));
    }

}
