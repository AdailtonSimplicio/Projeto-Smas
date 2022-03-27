package adailton.dev.rmg.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity {

    //Fazendo a geração do ID de forma automatica com @Id e Generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@Column para mapear e especificar os detalhes da coluna no BD
    @Column(name = "NOME_COMPLETO", nullable = false, length = 150)
    private String nomeCompleto;

    @Column(name = "NOME_DA_MAE", nullable = false, length = 150)
    private String nomeMae;

    //@JsonFormat usada para serializar um tipo específico em um formato específico
    @Column(name = "DATA_NASCIMENTO", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Column(name = "NIS_RF", nullable = false, length = 11)
    private Integer nis;

    @Column(name = "CPF_RF", nullable = false, length = 11)
    private String cpf;

    @Column()
    private String sexo;
    @Column()
    private String etnia;

    private String escolaridade;

    private List<AddressEntity> endereco;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    /*Prepersistir ele coloca a data de cadatro atual pega do computador*/
    @PrePersist
    public void prePersist() {
        setDataCadastro(LocalDate.now());
    }
}
