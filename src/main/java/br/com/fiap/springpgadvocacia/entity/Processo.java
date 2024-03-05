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
@Table(name= "TB_PROCESSO")
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROCESSO")
    @SequenceGenerator(
            name= "SQ_PROCESSO",
            sequenceName = "SQ_PROCESSO",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_PROCESSO")
    private Long id;

    @Column(name = "NMR_PROCESSO")
    private String numero;

    @Column(name = "PRO_BONO")
    private String proBono;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "ADVOGADO",
            referencedColumnName = "ID_ADVOGADO"
            , foreignKey = @ForeignKey(name = "FK_PROCESSO_ADVOGADO")
    )
    private Advogado advogado;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "TP_ACAO",
            referencedColumnName = "ID_TP_ACAO"
            , foreignKey = @ForeignKey(name = "FK_PROCESSO_TP_ACAO")
    )
    private TipoDeAcao tipoDeAcao;

}
