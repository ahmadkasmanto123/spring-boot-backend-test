package alami.anto.test.springboot.repository;

import alami.anto.test.springboot.model.Anggota;
import alami.anto.test.springboot.model.Transaksi;
import alami.anto.test.springboot.model.TransaksiAll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {
    // all crud database methods

    @Query(value = "SELECT trx.transaction_id, csd.customer_name,trx_type.transaction_type_name, trx.transaction_amount, cast (trx.transaction_date as text) transaction_date FROM \"transaction\" AS trx JOIN customer_data AS csd ON csd.customer_id = trx.customer_id JOIN transaction_type AS trx_type ON trx_type.transaction_type_id = trx.transaction_type_id ORDER BY trx.transaction_id ASC",nativeQuery = true)
    public List<Object[]> getSemuaTransaksi();

    @Query(value = "SELECT trx.transaction_id, csd.customer_name,trx_type.transaction_type_name, trx.transaction_amount, cast (trx.transaction_date as text) transaction_date FROM \"transaction\" AS trx JOIN customer_data AS csd ON csd.customer_id = trx.customer_id JOIN transaction_type AS trx_type ON trx_type.transaction_type_id = trx.transaction_type_id where trx.customer_id = :customer_id ORDER BY trx.transaction_id ASC",nativeQuery = true)
    public List<Object[]> getTransaksiAnggotaId(@Param("customer_id") long customer_id);


//    @Query(value = "SELECT trx.transaction_id, csd.customer_name,trx_type.transaction_type_name, trx.transaction_amount, cast (trx.transaction_date as text) transaction_date FROM \"transaction\" AS trx JOIN customer_data AS csd ON csd.customer_id = trx.customer_id JOIN transaction_type AS trx_type ON trx_type.transaction_type_id = trx.transaction_type_id where trx.customer_id = :id ORDER BY trx.transaction_id DESC",nativeQuery = true)
//    public List<Object[]> getSemuaTransaksiById(@Param("customer_id") Integer customer_id);

}
