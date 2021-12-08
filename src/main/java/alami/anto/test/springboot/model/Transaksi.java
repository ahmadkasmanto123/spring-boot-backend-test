package alami.anto.test.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private long transaction_id;

    @Column(name = "transaction_type_id")
    private long transaction_type_id;

    @Column(name = "transaction_amount")
    private long transaction_amount;

    @Column(name = "customer_id")
    private long customer_id;

    @Column(name = "transaction_date")
    private Date transaction_date;


}
