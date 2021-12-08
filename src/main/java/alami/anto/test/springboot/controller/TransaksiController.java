package alami.anto.test.springboot.controller;

import alami.anto.test.springboot.exception.ResourceNotFoundException;
import alami.anto.test.springboot.model.Anggota;
import alami.anto.test.springboot.model.Transaksi;
import alami.anto.test.springboot.model.TransaksiAll;
import alami.anto.test.springboot.repository.TransaksiRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/transaksi")
public class TransaksiController {
    @Autowired
    private TransaksiRepository transaksiRepository;

//    @GetMapping
//    public List<Transaksi> getAllTransaksi(){
//        return transaksiRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
//    }

    @GetMapping
    public List<TransaksiAll> getAllTransaksi(){
        List<TransaksiAll> addData = new ArrayList<>();
        // Inserting the data into the object
        List<Object[]> data = transaksiRepository.getSemuaTransaksi();
        for(Object[] obj:data){
            TransaksiAll transaksiAll = new TransaksiAll();
            transaksiAll.setTransaction_id((Integer) obj[0]);
            transaksiAll.setCustomer_name((String) obj[1]);
            transaksiAll.setTransaction_type_name((String) obj[2]);
            transaksiAll.setTransaction_amount((Integer) obj[3]);
            transaksiAll.setTransaction_date((String) obj[4]);
            addData.add(transaksiAll);
        }
        return addData;
    }

    @GetMapping("{customer_id}")
    public List<TransaksiAll> getAllTransaksi(@PathVariable long customer_id){
        List<TransaksiAll> addData = new ArrayList<>();
        // Inserting the data into the object
        List<Object[]> data = transaksiRepository.getTransaksiAnggotaId(customer_id);
        for(Object[] obj:data){
            TransaksiAll transaksiAll = new TransaksiAll();
            transaksiAll.setTransaction_id((Integer) obj[0]);
            transaksiAll.setCustomer_name((String) obj[1]);
            transaksiAll.setTransaction_type_name((String) obj[2]);
            transaksiAll.setTransaction_amount((Integer) obj[3]);
            transaksiAll.setTransaction_date((String) obj[4]);
            addData.add(transaksiAll);
        }
        return addData;
    }

    @PostMapping
    public Transaksi createTransaksi(@RequestBody Transaksi transaksi){
        System.out.println("customer_id = "+transaksi.getCustomer_id());
        return transaksiRepository.save(transaksi);
    }

    @DeleteMapping("{transaksi_id}")
    public ResponseEntity<HttpStatus> deleteTransaksi(@PathVariable long transaksi_id){

        Transaksi transaksi = transaksiRepository.findById(transaksi_id)
                .orElseThrow(() -> new ResourceNotFoundException("transaksi id error: " + transaksi_id));

        transaksiRepository.delete(transaksi);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
