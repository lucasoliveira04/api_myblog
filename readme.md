# API MyBlog

Bem-vindo à documentação da API MyBlog. Esta API fornece endpoints para gerenciar projetos em um blog.

URL Base : `https://api-myblog-jtlo.onrender.com`

## Rotas Disponíveis

### Listar todos os projetos

Endpoint:
```
GET /api/projects/get/projects
```

Descrição:
Este endpoint retorna todos os projetos cadastrados no blog.

### Listar projetos por linguagem

Endpoint:
```
GET /api/projects/get/projects/lang/{languageName}
```

Parâmetros:
- `{languageName}`: O nome da linguagem dos projetos a serem listados.

Descrição:
Este endpoint retorna os projetos do blog que estão escritos na linguagem especificada.

### Listar projetos por framework

Endpoint:
```
GET /api/projects/get/projects/framework/{frameworkName}
```

Parâmetros:
- `{frameworkName}`: O nome do framework dos projetos a serem listados.

Descrição:
Este endpoint retorna os projetos do blog que estão relacionados ao framework especificado.
