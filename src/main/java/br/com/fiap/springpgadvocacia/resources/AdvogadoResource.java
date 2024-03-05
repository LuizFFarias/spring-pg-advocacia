package br.com.fiap.springpgadvocacia.resources;

import br.com.fiap.springpgadvocacia.entity.Advogado;
import br.com.fiap.springpgadvocacia.repository.AdvogadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/advogados")
public class AdvogadoResource {

    @Autowired
    private AdvogadoRepository advogadoRepository;

    @GetMapping
    public List<Advogado> findAll(){return advogadoRepository.findAll();}

    @GetMapping(value = "/{id}")
    public ResponseEntity<Advogado> findById(@PathVariable(name = "id") Long id){
        Advogado advogado = advogadoRepository.findById(id).orElse(null);
        if (Objects.isNull(advogado)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(advogado);
    }


    @PostMapping
    @Transactional
    public ResponseEntity<Advogado> persist(@RequestBody Advogado advogado){
      Advogado saved = advogadoRepository.save(advogado);
      return ResponseEntity.ok(saved);
    }


}
