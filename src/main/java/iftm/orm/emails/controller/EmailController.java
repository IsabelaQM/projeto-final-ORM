package iftm.orm.emails.controller;

import iftm.orm.emails.model.Email;
import iftm.orm.emails.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<Email> salvarEmail(@Valid @RequestBody Email email) {
        Email emailSalvo = emailService.salvarEmail(email);
        return ResponseEntity.ok(emailSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Email>> listarEmails() {
        List<Email> emails = emailService.listarEmails();
        return ResponseEntity.ok(emails);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Email> buscarEmailPorId(@PathVariable Long id) {
        Email email = emailService.buscarEmailPorId(id);
        return ResponseEntity.ok(email);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<List<Email>> buscarEmailsPorCpf(@PathVariable String cpf) {
        List<Email> emails = emailService.buscarEmailsPorCpf(cpf);
        return ResponseEntity.ok(emails);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Email>> buscarEmailsPorNome(@PathVariable String nome) {
        List<Email> emails = emailService.buscarEmailsPorNome(nome);
        return ResponseEntity.ok(emails);
    }
}

