# projeto-final-ORM

REQUISITOS FUNCIONAIS:
- Salvar um email: registra os novos leads capturados, incluindo nome, e-mail, telefone e assunto.
- Listar todos os e-mails: permite visualizar todos os leads capturados.
- Buscar e-mails por ID: permite visualizar os leads através do seu ID.
- Buscar emails por CPF: permite visualizar os leads através do seu CPF.
- Buscar e-mails por nome: permite visualizar os leads através do seu nome.

API
Documentação da API: Utiliza Swagger com OpeanApi 3.
ENDPOINTS: @RequestMapping("/emails")
- Salvar um email: @PostMapping
- Listar todos os e-mails: @GetMapping
- Buscar e-mails por ID: @GetMapping("/{id}")
- Buscar e-mails por CPF: @GetMapping("/cpf/{cpf}")
- Buscar e-mails por nome: @GetMapping("/nome/{nome}")
