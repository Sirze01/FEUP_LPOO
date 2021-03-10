package com.aor.numbers;

public class PositiveFilter implements IListFilter{
    private int nr;

    public PositiveFilter(){}

    @Override
    public boolean accept(Integer number) {
        return number > 0;
    }
}
