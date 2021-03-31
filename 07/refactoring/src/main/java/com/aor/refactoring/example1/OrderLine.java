package com.aor.refactoring.example1;

public class OrderLine {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public String getLineString(){
        return new StringBuilder().append(this.getProduct().getName()).append("(x")
                .append(this.getQuantity()).append("): ").append(this.getProduct().getPrice() * this.getQuantity())
                .append("\n").toString();
    }
}
