package adailton.dev.rmg.controller;

import adailton.dev.rmg.entity.AdministratorEntity;
import adailton.dev.rmg.repository.AdministratorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/administrador")
public class AdministratorController {

    private AdministratorRepository repository = null;
    private final PasswordEncoder encoder;

    public AdministratorController(AdministratorRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }
    @GetMapping("/listarTodos")
    public ResponseEntity<List<AdministratorEntity> >listarTodos(){
        return ResponseEntity.ok(repository.findAll());
    }
    @PostMapping("/salvar")
    public ResponseEntity<AdministratorEntity>salvar(@RequestBody AdministratorEntity administrator){
        administrator.setPassword(encoder.encode(administrator.getPassword()));
        return ResponseEntity.ok(repository.save(administrator));
    }
    @GetMapping("/validarSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String login,
                                                @RequestParam String password) {
        //Consulta administrador na lista pelo login, sem não encontrado UNAUTHORIZED
        Optional<AdministratorEntity> optAdministrator = repository.findByLogin(login);
        if (optAdministrator.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
        //Consulta se a senha é válida com a do banco de dados, se for HttpStatus.OK, se não UNAUTHORIZED
        //matches conpara a senha digitada com a senha encriptada
        AdministratorEntity administrator = optAdministrator.get();
        boolean valid = encoder.matches(password, administrator.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }

    }
