# investment_quarkus

Projeto utilizando quarkus


## Rodando a aplicacao em dev mode

```shell script
./mvnw quarkus:dev
```

## Empacotando a aplicacao

```shell script
./mvnw package
```
Passo a passo para rodar o projeto

## Compile o projeto e gere os artefatos necessários:

```shell script
./mvnw clean package -DskipTests
```

## Suba os containers Docker:

```shell script
docker compose up -d --build
```

## Documentação da API:
```
Swagger UI: http://localhost:8080/q/swagger-ui/
```

# Considerações relacionadas ao desafio
Calculo do motor de busca foi baseado nos seguintes pesos e justificativas:
- Perfil de Risco da Carteira (Histórico): Peso = 60% (0.60):
  - O que o usuário realmente comprou é o indicador mais forte de sua tolerância ao risco.
- Frequência de Movimentações (Histórico): Peso = 20% (0.20)
  - Mede o quão ativo/passivo é o investidor.
- Perfil de Risco das Simulações: Peso = 20% (0.20)
  - O volume absoluto em R$ é um indicador fraco (alguém pode ter 1 milhão no Tesouro Selic e ser conservador). 
  - O que o usuário simula revela sua intenção futura e apetite para explorar.


- Fórmula Final: Pontuação Final = (Pontuação_Risco_Carteira * 0.6) + (Pontuação_Frequência * 0.2) + (Pontuação_Simulação * 0.2)

Definição dos Perfis (Mesmas faixas):
- Conservador: 1.0 a 3.9
- Moderado: 4.0 a 6.9
- Agressivo: 7.0 a 10.0