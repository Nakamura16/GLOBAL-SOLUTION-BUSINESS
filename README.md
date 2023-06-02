# GLOBAL-SOLUTION-BUSINESS

# apresentação do projeto


# Endpoints


## Usuario
- Listar Todos usuários
- Buscar usuário
- Cadastrar usuário
- Atualizar usuário
- Deletar usuário

## Telefone
- Listar telefones por ID de usuário
- Cadastrar telefone 
- Atualizar telefone
- Deletar telefone

## Terreno
- Listar terrenos por ID de usuário
- Cadastrar terreno 
- Atualiza terreno
- Deleta terreno

## Hortaliça
- Listar hortaliças
- Buscar Hortaliça
- Cadastrar hortaliças
- Atualizar hortaliças
- deletar hortaliças

## Tipo das Hortaliças
- Listar tipos de hortaliças
- Buscar tipo de hortaliça
- Cadastrar tipo hortaliças
- Atualizar um tipo de hortaliças
- deletar tipo de hortaliças

---
padrão

GET 
- endpoint
- exemplo corpo de resposta
- http responses

POST
- endpoint
- tabela de atributos para request
- exemplo corpo de request
- exemplo corpo de resposta 
- http responses

PUT
- endpoint
- tabela de atributos para request
- exemplo corpo de request
- exemplo corpo de resposta 
- http responses

DELETE
- endpoint 
- exemplo de request 
- não há corpo de resposta 
- http responses
---

## Usuário

### Listar_Usuários

`GET` /globalSolutio/api/usuarios

**Exemplo Corpo de resposta**

```JS
[
    {
        "id": 1,
        "nome": "nieke",
        "username": "nike",
        "senha": "nike"
    },
    {
        "id": 2,
        "nome": "nieke",
        "username": "nike",
        "senha": "nike"
    }
]
```
**HTTP responses para GET**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Buscar_Usuário

`GET` /globalSolutio/api/usuarios/{id}

**Exemplo Corpo de resposta**
```JS
{
    "id": 1,
    "nome": "nieke",
    "username": "nike",
    "senha": "nike"
}
```
**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Cadastrar_Usuário

`POST` /globalSolutio/api/usuarios

**Atributos do request**
|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
|     Nome     |String|     Sim     | Campo para preenchimento de nome de usuario
|    Username  |String|     Sim     | Campo para que insira um nome para usar no aplicativo
|     Senha    |String|     Sim     | O usuario deve criar uma senha  para uso do aplicativo


```js
{
    nome: "Jose Augusto da Silva",
    username: "JoseGuto",
    senha: "222222"
}
```

**HTTP responses para POST**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Atualizar_Usuário

`PUT` /globalSolutio/api/usuarios/{id}

**Atributos do request**
{...}

**Exemplo Corpo do request**

```JS
{
    "nome":"java",
    "username":"java",
    "senha": "java"
}
```

**Exemplo Corpo do response**
```JS
{
    "id": 1,
    "nome": "java",
    "username": "java",
    "senha": "java"
}
```

**Respostas que podem aparecer no `PUT` :**
| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Deletar_Usuário

`Delete` /globalSolutio/api/usuarios/{id}

Retorna um arquivo JSON vazio.

**Respostas que podem aparecer no DELETE :**

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

## Telefone

### Listar_Telefone_por_ID
`GET` globalSolution/api/telefones/?idUsuario=1

```JS
{
    "id": 1,
    "telefone": "956783112",
    "ddd": "011",
    "ddi": "+55"
    "usuario": {
        "id": 1,
        "nome": "Maria",
        "username": "carlitos",
        "senha": "alo"
    }
}
```
**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Cadastar_Telefone_Usuario
`POST` globalSolutio/api/telefones

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
| telefone | String | Sim | Campo que contém o telefone do usuário até 9 digitos 
| ddd | String | Sim | Contém o código de endereçamento urbano brasileiro
| ddi | String | Sim | Contém o codigo de discagem direta internacional
| usuario | Object | Sim | Contém um objeto referente a um usuário contendo ID, nome e username

**Exemplo do Corpo do Request**
```JS
{
    "telefone":"123456",
    "ddd":"011",
    "ddi":"55555",
    "usuario": {
        "id": 1,
        "nome": "Maria",
        "username": "carlitos",
        "senha": "alo"
    }
}
```
**Exemplo do Corpo do Response**
```JS
{
    "id": 1,
    "telefone": "111111111",
    "ddd": "123",
    "ddi": "55555",
    "usuario": {
        "id": 1,
        "nome": "Carlos",
        "username": "carlitos",
        "senha": "alo"
        }
},
```
**Respostas que podem aparecer no POST :**
| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Atualizar_Telefone

`PUT` globalSolutio/api/telefones/{id_usuario}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
| telefone | String | Sim | Campo que contém o telefone do usuário até 9 digitos 
| ddd | String | Sim | Contém o código de endereçamento urbano brasileiro
| ddi | String | Sim | Contém o codigo de discagem direta internacional
| usuario | Object | Sim | Contém um objeto referente a um usuário contendo ID, nome e username

**Exemplo do Corpo do Request**
```JS
{
    "telefone":"123456",
    "ddd":"011",
    "ddi":"55555",
}
```
**Exemplo do Corpo do Response**
```JS
{
    "id": 1,
    "telefone": "111111111",
    "ddd": "123",
    "ddi": "55555",
    "usuario": {
        "id": 1,
        "nome": "Carlos",
        "username": "carlitos",
        "senha": "alo"
        }
},
```
**Respostas que podem aparecer no PUT :**
| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---
### Deletar_Telefone

`Delete` /globalSolutio/api/telefones/{id}

Retorna um arquivo JSON vazio.

**Respostas que podem aparecer no `DELETE` :**

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

## Terreno

### Listar_terrenos_por_ID


`GET` globalSolution/api/terrenos/?idUsuario=1

**Exemplo do Corpo do Request `GET`**

```JS
            {
        
			"id": 1,
			"tamanho": "125m",
			"descricao": "grande da roça",
			"logradouro": "Rua n/a",
			"numeroLogradouro": "1225",
			"regiao": "ZS",
			"usuario": {
				"id": 1,
				"nome": "Maria",
				"username": "carlitos",
				"senha": "alo"
			},
			"hortalica": {
				"id": 1,
				"nome": "cenoura",
				"mesInicio": "fevereiro",
				"mesFim": "agosto",
				"tipoHortalica": {
					"id": 3,
					"nome": "c",
					"familiaBotanica": "alou"
				}
			}
        }
```

**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Cadastrar_Terreno 
`POST` globalSolution/api/terrenos

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
| tamanho | String | Sim | Contém o tamanho do terreno sendo cadastrado
| descricao | String | Sim | Contém a descrição e observações sobre o terreno
| logradouro | String | Sim | Contém o endereço do terreno cadastrado
| numeroLogradouro | String | Sim | Contém o numero do logradouro do terreno
| regiao | String | Sim | Contém a região do terreno cadastrado contendo apenas 2 caracteres
| usuario | Object | Sim | Contém o objeto que referencia o usuário que está cadastrando o terreno contendo ID, nome e username
| hortalica | obejct | Sim | Contém o objeto que referencia a hortliça que está sendo cultivada no terreno contendo ID, nome, mesInicio, mesFim e tipoHortalica

**Exemplo do Corpo do Request `POST`**
```JSON
{
    "tamanho": "125m",
    "descricao": "grande da roça",
    "logradouro": "Rua n/a",
    "numeroLogradouro": "1225",
    "regiao": "ZS",
        "usuario": {
        "id": 1,
        "nome": "Maria",
        "username": "carlitos",
        "senha": "alo"
    },
    "hortalica": {
        "id": 1,
        "nome": "cenoura",
        "mesInicio": "fevereiro",
        "mesFim": "agosto",
        "tipoHortalica": {
            "id": 3,
            "nome": "c",
            "familiaBotanica": "alou"
        }
    }
}
```
**Exemplo do Corpo do Response**
```JSON
{
    "id": "1",
    "tamanho": "125m",
    "descricao": "grande da roça",
    "logradouro": "Rua n/a",
    "numeroLogradouro": "1225",
    "regiao": "ZS",
        "usuario": {
        "id": 1,
        "nome": "Maria",
        "username": "carlitos",
        "senha": "alo"
    },
    "hortalica": {
        "id": 1,
        "nome": "cenoura",
        "mesInicio": "fevereiro",
        "mesFim": "agosto",
        "tipoHortalica": {
            "id": 3,
            "nome": "c",
            "familiaBotanica": "alou"
        }
    }
}
```
**Respostas que podem aparecer no POST :**
| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---
### Atualizar_Terreno
`PUT` globalSolution/api/terrenos/{id_usuario}

|    Campo     | Tipo | Obrigatorio | Descrição
|--------------|------|:-----------:|----------|
| tamanho | String | Sim | Contém o tamanho do terreno sendo cadastrado
| descricao | String | Sim | Contém a descrição e observações sobre o terreno
| logradouro | String | Sim | Contém o endereço do terreno cadastrado
| numeroLogradouro | String | Sim | Contém o numero do logradouro do terreno
| regiao | String | Sim | Contém a região do terreno cadastrado contendo apenas 2 caracteres
| usuario | Object | Sim | Contém o objeto que referencia o usuário que está cadastrando o terreno contendo ID, nome e username
| hortalica | obejct | Sim | Contém o objeto que referencia a hortliça que está sendo cultivada no terreno contendo ID, nome, mesInicio, mesFim e tipoHortalica

**Exemplo do Corpo do Response `PUT`**
```JSON
{
    "id": "1",
    "tamanho": "125m",
    "descricao": "grande da roça",
    "logradouro": "Rua n/a",
    "numeroLogradouro": "1225",
    "regiao": "ZS",
        "usuario": {
        "id": 1,
        "nome": "Maria",
        "username": "carlitos",
        "senha": "alo"
    },
    "hortalica": {
        "id": 1,
        "nome": "cenoura",
        "mesInicio": "fevereiro",
        "mesFim": "agosto",
        "tipoHortalica": {
            "id": 3,
            "nome": "c",
            "familiaBotanica": "alou"
        }
    }
}
```

**Exemplo do Corpo do Response `PUT`**

```js
		{
			"id": 1,
			"tamanho": "180m",
			"descricao": "grande da vila",
			"logradouro": "Rua n/a",
			"numeroLogradouro": "1900",
			"regiao": "ZN",
			"usuario": {
				"id": 1,
				"nome": "Maria",
				"username": "carlitos",
				"senha": "alo"
			},
			"hortalica": {
				"id": 1,
				"nome": "cenoura",
				"mesInicio": "fevereiro",
				"mesFim": "agosto",
				"tipoHortalica": {
					"id": 3,
					"nome": "c",
					"familiaBotanica": "alou"
				}
			}
        }
```

**Respostas que podem aparecer no `PUT` :**
| Código | Descrição |
|---|---|
| `201` | criado com sucesso (success)|
| `400` | Bad request|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não 
---
### Deletar_Terreno

`Delete` /globalSolutio/api/terrenos/{id}

Retorna um arquivo JSON vazio.

**Respostas que podem aparecer no `DELETE` :**

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `401` | Dados de acesso inválidos|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|


























---



PERGUNTAS
- equalsandhashcode (equals do object)
- JsonProperty (JSON -> objeto | Objeto -> JSON)
- paginação     public Page<Despesa> index(@RequestParam(required = false) String descricao "busca" , @PageableDefault(size = 5) Pageable pageable)
- busca
- ordenação


[
    {
        "id": 1,
        "telefone": "111111111",
        "ddd": "123",
        "ddi": "55555",
        "usuario": {
            "id": 1,
            "nome": "Carlos",
            "username": "carlitos",
            "senha": "alo"
        }
    },
    {
        "id": 2,
        "telefone": "222222",
        "ddd": "13",
        "ddi": "784",
        "usuario": {
            "id": 1,
            "nome": "Carlos",
            "username": "carlitos",
            "senha": "alo"
        }
    }
]