package br.com.fiap.springpgadvocacia.resources;

import br.com.fiap.springpgadvocacia.entity.Advogado;
import br.com.fiap.springpgadvocacia.entity.Processo;
import br.com.fiap.springpgadvocacia.repository.AdvogadoRepository;
import br.com.fiap.springpgadvocacia.repository.ProcessoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/processo")
public class ProcessoResource {
    @Autowired
    private ProcessoRepository processoRepository;

    @GetMapping
    public List<Processo> findAll(){return processoRepository.findAll();}

    @GetMapping(value = "/{id}")
    public ResponseEntity<Processo> findById(@PathVariable(name = "id") Long id){
        Processo processo = processoRepository.findById(id).orElse(null);
        if (Objects.isNull(processo)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(processo);
    }


    @PostMapping
    @Transactional
    public ResponseEntity<Processo> persist(@RequestBody Processo processo){
        Processo saved = processoRepository.save(processo);
        return ResponseEntity.ok(saved);
    }
}
