package com.aor.numbers;

public class DivisibleByFilter implements IListFilter{
    private int nr;

    DivisibleByFilter(Integer i){
        this.nr = i;
    }

    @Override
    public boolean accept(Integer number) {
        return (number % nr == 0);
    }
}
