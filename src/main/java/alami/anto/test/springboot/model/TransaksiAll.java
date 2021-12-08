package alami.anto.test.springboot.model;

import lombok.*;


@Data
public class TransaksiAll {
    private Integer transaction_id;
    private String customer_name;
    private String transaction_type_name;
    private Integer transaction_amount;
    private String transaction_date;

    public TransaksiAll() {
    }

    public TransaksiAll(Integer transaction_id, String customer_name, String transaction_type_name, Integer transaction_amount, String transaction_date) {
        this.transaction_id = transaction_id;
        this.customer_name = customer_name;
        this.transaction_type_name = transaction_type_name;
        this.transaction_amount = transaction_amount;
        this.transaction_date = transaction_date;
    }

}
