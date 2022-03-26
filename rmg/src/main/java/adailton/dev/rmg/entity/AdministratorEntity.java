package adailton.dev.rmg.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "administradores")
public class AdministratorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome_administrador")
    private String nomeAdministrador;

    @Column(name = "cpf_administrador")
    private String cpfAdministrador;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

}
