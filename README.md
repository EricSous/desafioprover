# 🧠 Frase Analisador · JSF + PrimeFaces + WildFly + Java 8

> Uma aplicação web que entende (quase) tudo o que você diz – e conta palavra por palavra. 📊

---

## ✨ Sobre o Projeto

Frase Analisador é um sistema web desenvolvido para processar frases digitadas por usuários e retornar:
- ✅ Quantidade de **palavras distintas**
- 🔢 Número de **ocorrências de cada palavra**
- 💾 Armazenamento automático dos resultados no banco
- 📩 Envio opcional para uma **fila JMS**
- ✅ O codigo foi pensado para ignorar caracteres especiais e focar apenas nas palavras com acentuação e sem acentuação.

É o contador de palavras que você nunca soube que precisava — até agora.

---

## 💡 Tecnologias e Stacks Utilizadas

| Tecnologia       | Finalidade                                           |
|------------------|------------------------------------------------------|
| `Java 8`         | Linguagem principal                                  |
| `JSF 2.2`        | Framework web (faces)                                |
| `PrimeFaces 6`   | Componentes visuais modernos                         |
| `CDI`            | Injeção de dependência e escopos                     |
| `JPA + Hibernate` | ORM e persistência no banco                          |
| `H2`             | Banco relacional                                     |
| `JMS (ActiveMQ)` | Fila para mensageria assíncrona                      |
| `WildFly 10`     | Servidor de aplicação Java EE                        |
| `Maven`          | Gerenciamento de dependências e build                |
| `Junit`          | Testes unitarios para garantir a qualidade do codigo |

---

## 🖥️ Funcionalidades

- Entrada de frases via UI amigável
- Análise textual com separação e contagem
- Salvamento das palavras no banco
- Exibição visual clara dos resultados
- Integração com fila JMS (`FraseQueue`)

---

## 🚀 Como Rodar o Projeto Localmente

### 🔧 Pré-requisitos

- Java 8
- Maven 3.6+
- WildFly 10
- h2 rodando
- Driver JDBC (`h2-connector`) instalado como módulo no WildFly
- Para facilitar o uso adicionado o wildfly para rodar a aplicação com todas dependencias necessarias.

---

### 📦 Build do projeto

```bash
git clone https://github.com/seu-usuario/frase-analisador.git
cd frase-analisador
mvn clean install

### 📦 Url do projeto
- http://localhost:8080/frase-analisador-1.0/index.html