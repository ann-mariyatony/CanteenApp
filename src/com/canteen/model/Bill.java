package com.canteen.model;

public class Bill {
    private Order order;
    private static final double TAX_RATE = 0.05; // 5% GST

    public Bill(Order order) {
        this.order = order;
    }

    public double getSubtotal() {
        
        return order.getTotalAmount();
    }
    
    public double getTax() {
        return getSubtotal() * TAX_RATE;
    }

    public double getTotal() {
        return getSubtotal() + getTax();
    }

    public String generateBillText() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- CANTEEN BILL ---\n\n");
        
        
        for (OrderItem item : order.getItems()) {
            sb.append(String.format("%-15s (x%d)\n", item.getItem().getName(), item.getQuantity()));
            sb.append(String.format("  @ Rs. %.2f each = Rs. %.2f\n", 
                item.getItem().getPrice(), item.getTotalPrice()));
        }
        
        sb.append("\n--------------------\n");
        sb.append(String.format("%-15s Rs. %.2f\n", "Subtotal:", getSubtotal()));
        sb.append(String.format("%-15s Rs. %.2f\n", "Tax (5%):", getTax()));
        sb.append("--------------------\n");
        sb.append(String.format("%-15s Rs. %.2f\n", "TOTAL:", getTotal()));
        
        return sb.toString();
    }
}
