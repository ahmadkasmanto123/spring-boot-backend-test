package alami.anto.test.springboot.controller;

import alami.anto.test.springboot.exception.ResourceNotFoundException;
import alami.anto.test.springboot.model.Anggota;
import alami.anto.test.springboot.repository.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/anggota")
public class AnggotaController {
    @Autowired
    private AnggotaRepository anggotaRepository;

//    @GetMapping
//    public List<Anggota> getAllAnggota() {
////        return anggotaRepository.findAll(Sort.by(Sort.Direction.ASC,"customer_id"));
//        return anggotaRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
//    }

    @GetMapping
    public List<Anggota> getAllAnggota() {
        return anggotaRepository.getSemuaAnggota(Sort.by("customer_id"));
    }

    @GetMapping("{customer_id}")
    public ResponseEntity<Anggota> getAnggotaById(@PathVariable  long customer_id){
        Anggota anggota = anggotaRepository.findById(customer_id).orElseThrow(() -> new ResourceNotFoundException("Anggota error:" + customer_id));
        return ResponseEntity.ok(anggota);
    }

    @PostMapping
    public Anggota createAnggota(@RequestBody Anggota anggota) {
        return anggotaRepository.save(anggota);
    }

    @PutMapping("{customer_id}")
    public ResponseEntity<Anggota> updateAnggota(@PathVariable long customer_id,@RequestBody Anggota anggotaData) {
        Anggota updateAnggota = anggotaRepository.findById(customer_id)
                .orElseThrow(() -> new ResourceNotFoundException("Anggota error: " + customer_id));

        updateAnggota.setCustomer_name(anggotaData.getCustomer_name());
        updateAnggota.setCustomer_dob(anggotaData.getCustomer_dob());
        updateAnggota.setCustomer_address(anggotaData.getCustomer_address());
        updateAnggota.setCustomer_balance(anggotaData.getCustomer_balance());
        anggotaRepository.save(updateAnggota);

        return ResponseEntity.ok(updateAnggota);
    }

    @DeleteMapping("{customer_id}")
    public ResponseEntity<HttpStatus> deleteAnggota(@PathVariable long customer_id){

        Anggota anggota = anggotaRepository.findById(customer_id)
                .orElseThrow(() -> new ResourceNotFoundException("Anggota error: " + customer_id));

        anggotaRepository.delete(anggota);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
