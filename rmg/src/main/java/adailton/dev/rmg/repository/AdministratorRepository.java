package adailton.dev.rmg.repository;

import adailton.dev.rmg.entity.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministratorRepository extends JpaRepository <AdministratorEntity,Integer>{
    //Fazendo busca de administrator pelo login.
    //Optional evita problemas de exception, findByLogin repositorio faz busca no campo login.
    public Optional<AdministratorEntity> findByLogin(String login);
}
