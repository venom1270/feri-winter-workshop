package com.example.demo.rest;

import com.example.demo.dao.BancniRacunRepo;
import com.example.demo.dao.OsebaRepo;
import com.example.demo.dto.BancniRacunDto;
import com.example.demo.dto.OsebaDto;
import com.example.demo.vao.BancniRacun;
import com.example.demo.vao.Oseba;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("bancniRacun")
public class BancniRacunRest {

    @Autowired
    private BancniRacunRepo bancniRacunRepo;

    static List<BancniRacunDto> translateToDto(Iterable<BancniRacun> list) {
        List<BancniRacunDto> ret = new ArrayList<>();
        for (var o : list) {
            ret.add(o.toDto());
        }
        return ret;
    }

    @GetMapping("racuni")
    public @ResponseBody Iterable<BancniRacunDto> getRacuni() {
        return translateToDto(bancniRacunRepo.findAll());
    }

    /*@GetMapping("racuni/{ime}")
    public @ResponseBody Iterable<OsebaDto> getOsebeByIme(@PathVariable("ime") String ime) {
        return translateOsebaToDto(osebaRepo.findAllByIme(ime));
    }*/

    @PostMapping("/racuni")
    public ResponseEntity<BancniRacunDto> postRacun(@RequestBody BancniRacunDto racun) {
        //validate
        Optional<BancniRacun> val = bancniRacunRepo.findById(racun.getStevilkaRacuna());
        if (!val.isEmpty()) {
            System.out.println("FOUND");
            //log.info("POST /products; ProductCategroy not found!");
            return new ResponseEntity("Oseba s tem id-jem že obstaja!", HttpStatus.NOT_ACCEPTABLE);
        }

        BancniRacun vao=new BancniRacun();
        vao.setCasOdprtja(LocalDateTime.now());
        vao.setCasZaprtja(null);
        vao.setKomitent(racun.getKomitent());
        vao.setStevilkaRacuna(racun.getStevilkaRacuna());
        vao.setZnesek(racun.getZnesek());
        bancniRacunRepo.save(vao);
        return ResponseEntity.ok(vao.toDto());
    }

    @DeleteMapping("/racuni/{id}")
    public ResponseEntity<String> deleteRacun(@PathVariable("id") String id) {
        //validate
        Optional<BancniRacun> val = bancniRacunRepo.findById(id);
        if (val.isEmpty()) {
            System.out.println("NOT FOUND");
            //log.info("POST /products; ProductCategroy not found!");
            return new ResponseEntity("Račun s tem id-jem NE obstaja!", HttpStatus.NOT_ACCEPTABLE);
        }

        BancniRacun br = val.get();
        br.setCasZaprtja(LocalDateTime.now());
        bancniRacunRepo.save(br);

        return ResponseEntity.ok("Račun z ID-jem " + id + " zaprt.");
    }

    @PutMapping("/racuni/{id}")
    public ResponseEntity<String> updateRacun(@PathVariable("id") String id, @RequestBody BancniRacunDto racun) {
        //validate
        Optional<BancniRacun> val = bancniRacunRepo.findById(id);
        if (val.isEmpty()) {
            System.out.println("NOT FOUND");
            //log.info("POST /products; ProductCategroy not found!");
            return new ResponseEntity("Račun s tem id-jem NE obstaja!", HttpStatus.NOT_ACCEPTABLE);
        }

        BancniRacun br = val.get();
        br.setKomitent(racun.getKomitent());
        br.setZnesek(racun.getZnesek());
        bancniRacunRepo.save(br);
        return ResponseEntity.ok("Račun z ID-jem " + id + " izbrisan.");
    }

}
