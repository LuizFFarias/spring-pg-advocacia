package br.com.fiap.springpgadvocacia.repository;

import br.com.fiap.springpgadvocacia.entity.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {
}
