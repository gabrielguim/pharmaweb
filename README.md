# PharmaWeb
Uma aplicação para gerenciar usuários de uma farmácia, pedidos, etc

## Backlog

## CRUD Usuário
### US.1 - Registro de Usuário
Como usuário gostaria de poder me associar ao PharmaWeb através de um registro.

#### Critérios de aceitação
- Para o registro é necessário informar:
    - Nome Completo;
    - E-mail (deve ser validado).
- Todos os campos são obrigatórios;
- Um pedido de confirmação deve ser enviado ao e-mail informado no registro;

### US.2 - Confirmação de Registro
Como usuário, gostaria de finalizar o meu registro clicando no link de confirmação recebido no e-mail informado no cadastro.

#### Critérios de aceitação
- O usuário só deve ter seu registro finalizado após confirmar o e-mail.

### US.3 - Visualização de Usuário
Como usuário registrado gostaria de poder visualizar minhas informações de registro.

#### Critérios de aceitação
- As informações devem ser visíveis apenas para o usuário ROOT e para o próprio usuário.

### US.4 - Edição de Usuário
Como usuário registrado gostaria de poder editar o meu registro.

#### Critérios de aceitação
- Apenas o dono do perfil deve poder editar as informações;
- A regra de aceitação dos campos é a mesma para a criação de um registro;
- Após a edição, os novos valores devem ser salvos e visíveis ao usuário.

### US.5 - Remoção de Usuário
Como usuário registrado gostaria de poder remover meu registro do Watchme.

#### Critérios de aceitação
- Apenas o dono do perfil deve poder remover o seu registro;
- Após a confirmação de remoção, o usuário deve ser removido do PharmaWeb.
