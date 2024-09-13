package iftm.orm.emails.repository;

import iftm.orm.emails.model.Email;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    List<Email> findByCpf(String cpf);
    List<Email> findByNomeContainingIgnoreCase(String nome);
}
