package alami.anto.test.springboot.repository;

import alami.anto.test.springboot.model.Anggota;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnggotaRepository extends JpaRepository<Anggota, Long> {
    // all crud database methods

    @Query(value = "select t from Anggota t")
    public List<Anggota> getSemuaAnggota(Sort sort);

}
