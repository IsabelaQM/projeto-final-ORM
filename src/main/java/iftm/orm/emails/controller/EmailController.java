package iftm.orm.emails.controller;

import iftm.orm.emails.model.Email;
import iftm.orm.emails.service.EmailService;
import iftm.orm.emails.service.exceptions.NaoEncontrado;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

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

    @Operation(summary = "Salva um email")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Email salvo com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Email.class))), 
          @ApiResponse(responseCode = "400", description = "Erro na requisição", content = @Content)     
    })
    @PostMapping
    public ResponseEntity<Email> salvarEmail(@Valid @RequestBody Email email) {
        Email emailSalvo = emailService.salvarEmail(email);
        return ResponseEntity.ok(emailSalvo);
    }

    @Operation(summary = "Lista todos os emails")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Lista de emails", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Email.class))),
          @ApiResponse(responseCode = "204", description = "Lista de emails vazia", content = @Content)         
    })
    @GetMapping
    public ResponseEntity<List<Email>> listarEmails() {
        List<Email> emails = emailService.listarEmails();
        return ResponseEntity.ok(emails);
    }

    @Operation(summary = "Busca um email por ID")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Email encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Email.class))),
          @ApiResponse(responseCode = "404", description = "Email não encontrado", content = @Content)         
    })
    @GetMapping("/{id}")
    public ResponseEntity<Email> buscarEmailPorId(@PathVariable Long id) {
        try{
            Email email = emailService.buscarEmailPorId(id);
            return ResponseEntity.ok(email);
	
		} catch (Exception e){
			throw new NaoEncontrado("Email não encontrado pelo ID fornecido: " + id);
		}

    }

    @Operation(summary = "Busca emails por CPF")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Emails encontrados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Email.class))),
          @ApiResponse(responseCode = "404", description = "Emails não encontrados", content = @Content)        
    })
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<List<Email>> buscarEmailsPorCpf(@PathVariable String cpf) {
        try{
            List<Email> emails = emailService.buscarEmailsPorCpf(cpf);
            return ResponseEntity.ok(emails);
		} catch (Exception e){
			throw new NaoEncontrado("Emails não encontrados pelo CPF fornecido: " + cpf);
		}
    }

    @Operation(summary = "Busca emails por nome")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Emails encontrados", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Email.class))),
          @ApiResponse(responseCode = "404", description = "Emails não encontrados", content = @Content)         
    })
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Email>> buscarEmailsPorNome(@PathVariable String nome) {
        try{
            List<Email> emails = emailService.buscarEmailsPorNome(nome);
            return ResponseEntity.ok(emails);
	
		} catch (Exception e){
			throw new NaoEncontrado("Email não encontrado para o nome fornecido" + nome);
		}
    }
}

