SmartCash
Uma API de gestão financeira para pequenas empresas, com intuito de facilitar as finanças corporativas.
Endpoints
* Fluxo de Caixa 
    * Adicionar
* Movimentações
* Despesas
* Faturamento
* Relatório
#Adicionar
POST /Fluxo de Caixa 
Insere uma novo item
Corpo da Requisição:
campo	tipo	obrigatório	descrição
Entrada ou Saída 		✅	Opção para definir o tipo do valor 
valor	float	✅	Valor
Descrição 	string	✅	Descrição para o faturamento ou despesa 
Data	date	✅	Data
{
    "Entrada ou Saída ": "Entrada",
    "Valor": "R$1000,00"
    “Descrição ”:”Produto”
    “Data”:”01/01/2024”
}
Exemplo de resposta:
{
    "id": 1,
    "Entrada ou Saída ": "Entrada",
    "Valor": "R$1000,00"
    “Descrição ”:”Produto”
    “Data”:”01/01/2024”
}
Códigos de Status
201	Categoria criada com sucesso
404	Id da categoria não encontrado

