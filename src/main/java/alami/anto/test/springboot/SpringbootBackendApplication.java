package alami.anto.test.springboot;

import alami.anto.test.springboot.repository.AnggotaRepository;
import alami.anto.test.springboot.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
