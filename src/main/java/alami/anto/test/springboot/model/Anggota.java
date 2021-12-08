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
@Table(name = "customer_data")
public class Anggota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long customer_id;

    @Column(name = "customer_name")
    private String customer_name;

    @Column(name = "customer_address")
    private String customer_address;

    @Column(name = "customer_dob")
    private Date customer_dob;

    @Column(name = "customer_balance")
    private String customer_balance;
}
