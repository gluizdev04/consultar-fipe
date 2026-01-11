#  Buscador de Tabela FIPE

Aplicação de consulta de preços médios de veículos (Carros, Motos e Caminhões), desenvolvida em Java com Spring Boot. O sistema consome a API pública da Tabela FIPE para trazer dados atualizados do mercado automobilístico brasileiro.

##  Sobre o Desafio

Este projeto foi desenvolvido como **solução para o Desafio Final** do módulo de **Java: trabalhando com lambdas, streams e Spring Framework**

O objetivo foi colocar em prática, **de forma autônoma**, os conhecimentos em consumo de APIs, manipulação de fluxos de dados e desserialização de objetos.

##  Funcionalidades

- **Menu Interativo:** Navegação fluida para escolha do tipo de veículo.
- **Consulta de Marcas:** Listagem dinâmica das marcas disponíveis na API.
- **Filtragem Inteligente:** Permite buscar modelos digitando apenas um trecho do nome (ex: digitar "Palio" e o sistema filtrar todas as versões do Palio).
- **Histórico de Preços:** Exibe o valor do veículo selecionado para todos os anos disponíveis na tabela.

##  Tecnologias e Conceitos Aplicados

- **Java 21** e **Spring Boot 4**
- **Consumo de API REST:** Integração com serviço externo via HTTP.
- **Java Streams & Lambdas:** Uso intensivo para filtrar, mapear e ordenar grandes listas de dados trazidas da API.
- **Jackson Library:** Conversão de JSON para Objetos Java.
- **Generics:** Implementação de uma interface genérica para transformar o JSON em classes Record/DTOs, permitindo reaproveitamento de código.

##  Como executar o projeto

### Pré-requisitos
Certifique-se de ter o **Java 17+** e o **Maven** instalados.

```bash
# 1. Clone o repositório
git clone [https://github.com/gluizdev04/consultar-fipe.git](https://github.com/gluizdev04/consultar-fipe.git)

# 2. Entre na pasta do projeto
cd consultar-fipe

# 3. Execute a aplicação via terminal
mvn spring-boot:run
