package adailton.dev.rmg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Administradores")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AdministratorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" )
    private Integer id;

    @Column(name = "nome_administrador",nullable = false, length = 150)
    private String nomeAdministrador;

    @Column(name = "cpf_administrador",nullable = false, length = 11)
    private String cpfAdministrador;

    @Column(name = "email",nullable = false, length = 32)
    private String email;

    @Column(name = "login",nullable = false, length = 32)
    private String login;

    @Column(name = "password",nullable = false, length = 8)
    private String password;




}
