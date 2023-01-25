package com.example.demo;

import com.example.demo.dao.BancniRacunRepo;
import com.example.demo.dao.OsebaRepo;
import com.example.demo.rest.BancniRacunRest;
import com.example.demo.vao.BancniRacun;
import com.example.demo.vao.Oseba;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DemoApplicationTests {

	@Autowired
	OsebaRepo osebaRepo;

	@Autowired
	BancniRacunRepo bancniRacunRepo;

	@Autowired
	BancniRacunRest brRest;

	@BeforeAll
	void setup() {
		Oseba o = new Oseba();
		o.setEmail("sadsad");
		o.setIme("sadsad");
		o.setPriimek("sadsad");
		o.setIdKomitenta("sadsad");

		osebaRepo.save(o);

		BancniRacun br = new BancniRacun();
		br.setKomitent(o);
		br.setStevilkaRacuna("SI56123");
		bancniRacunRepo.save(br);

		BancniRacun br2 = new BancniRacun();
		br.setKomitent(o);
		br.setStevilkaRacuna("DE123");
		bancniRacunRepo.save(br);

		Oseba o2 = new Oseba();
		o2.setEmail("zzzz");
		o2.setIme("zzz");
		o2.setPriimek("zz");
		o2.setIdKomitenta("zz");
		osebaRepo.save(o2);
	}

	@Test
	void contextLoads() {
		assertEquals(1, 1);
	}

	@Test
	void zapiranjeRacuna() {
		Optional<BancniRacun> br = bancniRacunRepo.findById("DE123");
		brRest.deleteRacun(br.get().getStevilkaRacuna());

		assertEquals(2, bancniRacunRepo.count());
	}

	@Test
	void zapiranjeRacunaExpection() {
		Exception exception = assertThrows(NoSuchElementException.class, () -> {
			Optional<BancniRacun> br = bancniRacunRepo.findById("NE_OBSTAJA");
			brRest.deleteRacun(br.get().getStevilkaRacuna());
		});
	}

}
