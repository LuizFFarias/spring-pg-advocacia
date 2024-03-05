package br.com.fiap.springpgadvocacia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "TP_ACAO")

public class TipoDeAcao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TP_ACAO")
    @SequenceGenerator(
            name= "SQ_TP_ACAO",
            sequenceName = "SQ_TP_ACAO",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_TP_ACAO")
    private Long id;

    @Column(name = "NM_TP_ACAO")
    private String nome;


}
