# PharmaWeb
Uma aplicação para gerenciar usuários de uma farmácia, pedidos, etc

## Backlog

### US.1 - Registro de Usuário
Como usuário quero poder me associar ao PharmaWeb através de um registro

#### Critérios de aceitação
- Para o registro é necessário informar:
    - Nome Completo
    - E-mail
- Todos os campos são obrigatórios

### US.2 - Edição de Usuário
Como usuário registrado quero poder editar o meu registro.

#### Critérios de aceitação
- Apenas o dono do perfil deve poder editar as informações;
- A regra de aceitação dos campos é a mesma para a criação de um registro;
- Após a edição, os novos valores devem ser salvos e visíveis ao usuário.

### US.3 - Remoção de Usuário
Como usuário registrado quero poder remover meu registro do PharmaWeb.

#### Critérios de aceitação
- Apenas o dono do perfil deve poder remover o seu registro;
- Após a confirmação de remoção, o usuário deve ser removido do PharmaWeb.

### US.4 - Busca de produtos
Como usuário quero poder buscar produtos na loja por vários critérios (nome, código, departamentos, categorias)

#### Critérios de aceitação
- A busca deve retornar apenas resultados em que seus pelo menos um dos seus campos sejam correspondentes ao texto informado na busca

### US.5 - Autenticação
Como usuário registrado quero poder me autenticar com o sistema

#### Critérios de aceitação
- O resultado da autenticação deve produzir um token que será usado nas operações que o usuário for fazer

### US.6 - Pedido de produtos
Como usuário quero poder efetuar um pedido com os produtos selecionados

#### Critérios de aceitação
- Um pedido só poderá ser efetuado se o usuário que o faz estiver autenticado com o sistema
- O pedido deve ser efetuado e enviado para a farmácia responsável
- Um pedido pode conter vários produtos
