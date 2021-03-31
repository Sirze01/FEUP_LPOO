package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> lines;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        lines.add(new OrderLine(product, quantity));
    }

    private double getTotal(){
        double total = 0;

        for (OrderLine line : lines)
            total += pricePerLine(line.getProduct().getPrice(), line.getQuantity());

        return total;
    }

    public boolean isElegibleForFreeDelivery() {
        return getTotal() > 100;
    }

    private double pricePerLine(double price, int quantity){
        return price * quantity;
    }

    public String printOrder() {
        StringBuilder printBuffer = new StringBuilder();

        for (OrderLine line : lines)
            printBuffer.append(line.getLineString());

        printBuffer.append("Total: ").append(getTotal());

        return printBuffer.toString();
    }
}