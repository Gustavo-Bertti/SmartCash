# SmartCash API

SmartCash é uma API de gestão financeira para pequenas empresas, projetada para facilitar as finanças corporativas. A API oferece endpoints para realizar operações relacionadas ao fluxo de caixa, movimentações financeiras, despesas, faturamento e geração de relatórios.

## Endpoints

- Fluxo de caixa
    - [Listar Todos](#listar-todos)
    - [Detalhar](#detalhar-fluxo-de-caixa)
    - [Cadastrar](#detalhar-fluxo-de-caixa)
    - [Apagar](#detalhar-fluxo-de-caixa)
    - [Editar](#detalhar-fluxo-de-caixa)

- Despesas
    - (em desenvolvimento)

- Faturamento
    - (em desenvolvimento)

- Relatório
    - (em desenvolvimento)

### Listar Todos
`GET` /fluxodecaixa

Retorna um array com todos os fluxos de caixa cadastrados.

**Exemplo de resposta:**

```js
[
    {
        "id": 1,
        "tipo": "Entrada",
        "valor": 1000.00,
        "descricao": "Produto",
        "data": "01/01/2024"
    }
]
```

**Códigos de Status**

| código | descrição | 
|--------|-----------|
|200|Dados retornados com sucesso

---

### Detalhar Fluxo de Caixa

`GET` /fluxodecaixa/{id}

Retorna os dados do fluxo de caixa com o `id` informado.

**Exemplo de resposta:**

```js
    {
        "id": 1,
        "tipo": "Entrada",
        "valor": 1000.00,
        "descricao": "Produto",
        "data": "01/01/2024"
    }
```
**Códigos de Status**

| código | descrição | 
|--------|-----------|
|200|Dados retornados com sucesso
|404| Id do fluxo de caixa não encontrado

---

### Cadastrar Categoria
`POST` /fluxodecaixa

Insere um novo fluxo de caixa.

**Corpo da Requisição:**

|campo|tipo|obrigatório|descrição 
|-----|----|:-----------:|-----------|
|tipo|string| ✅ |Tipo do fluxo de caixa, entrada ou saida
|valor|string|✅|Valor do fluxo de caixa
|descricao|string|✅|Descrição do fluxo de caixa
|data|string|✅|Data da inclusão do fluxo de caixa

```js

{
    "tipo": "Entrada",
    "valor": 1000.00,
    "descricao": "Produto",
    "data": "01/01/2024"
}

```

**Exemplo de resposta:**

```js

{
    "id": 1,
    "tipo": "Entrada",
    "valor": 1000.00,
    "descricao": "Produto",
    "data": "01/01/2024"
}

```

**Códigos de Status**

| código | descrição | 
|--------|-----------|
|201|Fluxo de caixa criado com sucesso
|400|Erro de validação - verifique o corpo da requisição

---

### Apagar Fluxo de Caixa

`DELETE` /fluxodecaixa/{id}

Apaga os dados do fluxo de caixa com o `id` informado.



**Códigos de Status**

| código | descrição | 
|--------|-----------|
|204|Fluxo de caixa apagado com sucesso
|404| Id da Fluxo de caixa não encontrado

---
### Editar Fluxo de Caixa

`PUT` /fluxodecaixa/{id}

Atualiza os dados da fluxo de caixa com o `id` informado.

|campo|tipo|obrigatório|descrição 
|-----|----|:-----------:|-----------|
|tipo|string| ✅ |Tipo do fluxo de caixa, entrada ou saida
|valor|string|✅|Valor do fluxo de caixa
|descricao|string|✅|Descrição do fluxo de caixa
|data|string|✅|Data da inclusão do fluxo de caixa

**Corpo da Requisição:**
```js

{
    "tipo": "Entrada",
    "valor": 1000.00,
    "descricao": "Produto",
    "data": "01/01/2024"
}

```

**Exemplo de resposta:**

```js

{
    "id": 1,
    "tipo": "Entrada",
    "valor": 1000.00,
    "descricao": "Produto",
    "data": "01/01/2024"
}

```

**Códigos de Status**

| código | descrição | 
|--------|-----------|
|200|Fluxo de caixa atualizado com sucesso
|400| A validação falhou - verifiue o corpo da requisição
|404| Id do fluxo de caixa não encontrado

---

