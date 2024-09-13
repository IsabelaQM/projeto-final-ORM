package iftm.orm.emails.service;

import iftm.orm.emails.model.Email;
import iftm.orm.emails.repository.EmailRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public Email salvarEmail(Email email) {
        return emailRepository.save(email);
    }

    public List<Email> listarEmails() {
        return emailRepository.findAll();
    }

    public Email buscarEmailPorId(Long id) {
        return emailRepository.findById(id).orElseThrow(() -> new RuntimeException("Email não encontrado"));
    }

    public List<Email> buscarEmailsPorCpf(String cpf) {
        return emailRepository.findByCpf(cpf);
    }

    public List<Email> buscarEmailsPorNome(String nome) {
        return emailRepository.findByNomeContainingIgnoreCase(nome);
    }
}
