# SmartCash API

SmartCash é uma API de gestão financeira para pequenas empresas, projetada para facilitar as finanças corporativas. A API oferece endpoints para realizar operações relacionadas ao fluxo de caixa, movimentações financeiras, despesas, faturamento e geração de relatórios.

## Endpoints

### Fluxo de Caixa

#### Adicionar
Insere um novo item no fluxo de caixa.

- **Método:** POST
- **Endpoint:** `/fluxo-de-caixa`
- **Corpo da Requisição:**

| Campo              | Tipo    | Obrigatório | Descrição                              |
|--------------------|---------|-------------|----------------------------------------|
| Entrada ou Saída  | string  | ✅          | Opção para definir o tipo do valor     |
| Valor              | float   | ✅          | Valor                                  |
| Descrição          | string  | ✅          | Descrição para o faturamento ou despesa|
| Data               | date    | ✅          | Data                                   |

Exemplo de corpo da requisição:
```json
{
    "Entrada ou Saída": "Entrada",
    "Valor": 1000.00,
    "Descrição": "Produto",
    "Data": "01/01/2024"
}
```

- **Exemplo de resposta (status 201):**
```json
{
    "id": 1,
    "Entrada ou Saída": "Entrada",
    "Valor": 1000.00,
    "Descrição": "Produto",
    "Data": "01/01/2024"
}
```

### Movimentações
(em desenvolvimento)

### Despesas
(em desenvolvimento)

### Faturamento
(em desenvolvimento)

### Relatório
(em desenvolvimento)

## Códigos de Status

- **201:** Item criado com sucesso
- **404:** Id do item não encontrado