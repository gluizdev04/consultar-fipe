# Buscador de Tabela FIPE

Aplicação em Java para consulta de valores de veículos (Carros, Motos e Caminhões) utilizando a API pública da Tabela FIPE.

Desenvolvido como parte do desafio do curso de **Java: Trabalhando com Lambdas, Streams e Spring Framework** da Alura.

## Funcionalidades

- **Menu Interativo:** Escolha entre Carros, Motos ou Caminhões.
- **Busca por Marcas:** Lista todas as marcas disponíveis.
- **Filtragem de Modelos:** Permite digitar um trecho do nome (ex: "Palio") para filtrar a lista de modelos.
- **Valores por Ano:** Exibe o valor do veículo para todos os anos disponíveis na tabela FIPE.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot** (Framework principal)
- **Maven** (Gerenciador de dependências)
- **Jackson** (Desserialização de JSON)
- **Java Streams & Lambdas** (Manipulação e filtro de dados)

## Aprendizados

Neste projeto, apliquei conceitos fundamentais de manipulação de dados em Java:
- Consumo de API REST.
- Conversão de dados (JSON -> Objeto Java) utilizando a interface `Generic`.
- Uso de **Streams** para operações de fluxo de dados.
- Métodos como `.filter()`, `.map()`, `.sorted()` e `.collect()`.
- Manipulação de Listas e Collections.

## Como executar

Pré-requisitos: Java 17 instalado e Maven.

```bash
# Clone este repositório
git clone [https://github.com/gluizdev04/consultar-fipe.git](https://github.com/gluizdev04/consultar-fipe.git)

# Acesse a pasta do projeto no terminal/cmd
cd consultar-fipe

# Execute o projeto
mvn spring-boot:run
