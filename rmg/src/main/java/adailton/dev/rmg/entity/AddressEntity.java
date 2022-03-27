package adailton.dev.rmg.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {
    //Fazendo a geração do ID de forma automatica com @Id e @Generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String endereco;

    @Column(nullable = false, length = 20)
    private String numero;

    @Column(length = 255)
    private String complemento;

    @Column(nullable = false, length = 8)
    private String cep;

    @Column(nullable = false, length = 50)
    private String bairro;

    @Column(nullable = false, length = 50)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String uf;
}
