# GLOBAL-SOLUTION-BUSINESS

# usuario

get:
[
    {
        "id": 1,
        "nome": "nieke",
        "username": "nike",
        "senha": "nike"
    }
]

post:
{
    "nome":"nieke",
    "username":"nike",
    "senha": "nike"
}

put:
body
{
    "nome":"java",
    "username":"java",
    "senha": "java"
}

response
{
    "id": 1,
    "nome": "java",
    "username": "java",
    "senha": "java"
}

Delete:
só manda a URL e ele responde 204


PERGUNTAS
- equalsandhashcode
- databaseseeder
- conexão com o banco oracle
- JsonProperty
- paginação, busca e ordenação


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