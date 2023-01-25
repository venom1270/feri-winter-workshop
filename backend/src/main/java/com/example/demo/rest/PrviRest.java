package com.example.demo.rest;

import com.example.demo.dao.OsebaRepo;
import com.example.demo.dto.OsebaDto;
import com.example.demo.vao.Oseba;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("prvi")
public class PrviRest {

    @Autowired
    private OsebaRepo osebaRepo;

    static List<OsebaDto> translateOsebaToDto(Iterable<Oseba> list) {
        List<OsebaDto> ret = new ArrayList<>();
        for (var o : list) {
            ret.add(o.toDto());
        }
        return ret;
    }

    @GetMapping("info")
    public String test() {
        return "qwe";
    }

    @GetMapping("osebe")
    public @ResponseBody Iterable<OsebaDto> getOsebe() {
        return translateOsebaToDto(osebaRepo.findAll());
    }

    @GetMapping("osebe/{ime}")
    public @ResponseBody Iterable<OsebaDto> getOsebeByIme(@PathVariable("ime") String ime) {
        return translateOsebaToDto(osebaRepo.findAllByIme(ime));
    }

    @PostMapping("/osebe")
    public ResponseEntity<OsebaDto> postOseba(@RequestBody OsebaDto oseba) {
        //validate
        Optional<Oseba> val = osebaRepo.findById(oseba.getId());
        if (!val.isEmpty()) {
            System.out.println("NOT FOUND");
            //log.info("POST /products; ProductCategroy not found!");
            return new ResponseEntity("Oseba s tem id-jem že obstaja!", HttpStatus.NOT_ACCEPTABLE);
        }

        Oseba vao=new Oseba();
        vao.setId(oseba.getId());
        vao.setIme(oseba.getIme());
        vao.setPriimek(oseba.getPriimek());
        vao.setIdKomitenta(oseba.getIdKomitenta());
        vao.setEmail(oseba.getEmail());
        osebaRepo.save(vao);
        return ResponseEntity.ok(vao.toDto());
    }

    @DeleteMapping("/osebe/{id}")
    public ResponseEntity<String> deleteOseba(@PathParam("id") Integer id) {
        //validate
        Optional<Oseba> val = osebaRepo.findById(id);
        if (val.isEmpty()) {
            System.out.println("NOT FOUND");
            //log.info("POST /products; ProductCategroy not found!");
            return new ResponseEntity("Oseba s tem id-jem NE obstaja!", HttpStatus.NOT_ACCEPTABLE);
        }

        osebaRepo.delete(val.get());
        return ResponseEntity.ok("Oseba z ID-jem " + id + " izbrisana.");
    }

}
