# 🧠 WaBrain

> ⚠️ **Projeto em Construção / Work in Progress**  
> Este projeto está em estágio ativo de desenvolvimento inicial. Estruturas de dados, contratos de API e regras de
> negócio podem sofrer alterações frequentes.

**WaBrain** é uma API moderna para gerenciamento de anotações interconectadas no modelo *Second Brain* (segundo
cérebro), projetada para organizar conhecimento com alta performance e integração contextual.

---

## 🎯 Visão do Projeto

- **Notas Interconectadas:** Criação de redes de conhecimento e grafos de referências entre notas.
- **Lembretes Inteligentes via Sintaxe:** Notificações contextuais disparadas por padrões de texto nas notas (exemplo:
  `Comprar mantimentos !remember(daily)` gerando notificações recorrentes via WebSocket).
- **Análise Semântica com IA:** Recursos futuros de inteligência artificial para sugerir conexões ocultas, agrupamentos
  e sínteses entre anotações.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 25
- **Framework:** [Quarkus 3.40.1](https://quarkus.io/)
- **Banco de Dados:** PostgreSQL
- **Persistência:** Hibernate ORM com Panache
- **Migrações de Banco:** Flyway
- **Segurança & Autenticação:**
    - MicroProfile JWT / SmallRye JWT (Criptografia assimétrica **RS256**)
    - Elytron Security (Hashing de senhas com Bcrypt)
    - Jakarta REST & Hibernate Validator
- **Infraestrutura Local:** Docker & Docker Compose
- **Qualidade de Código:** Maven Checkstyle Plugin (Google Checks)

---

## 🚀 Como Executar o Projeto

### 1. Pré-requisitos

- **Java 25+** instalado
- **Docker** e **Docker Compose** instalados
- Git

### 2. Clonar o Repositório

```bash
git clone https://github.com/walefy/wa-brain.git
cd wa-brain
```

### 3. Configurar as Variáveis de Ambiente

Copie o arquivo de exemplo:

```bash
cp .env.example .env
```

Gere o par de chaves RSA (2048 bits) para a autenticação JWT em formato Base64 de linha única:

```bash
# 1. Gerar chave privada RSA (PKCS#8)
openssl genpkey -algorithm RSA -out private_key.pem -pkeyopt rsa_keygen_bits:2048

# 2. Extrair a chave pública
openssl rsa -pubout -in private_key.pem -out public_key.pem

# 3. Extrair as chaves em linha única e preencher no .env:
echo "JWT_PRIVATE_KEY=$(grep -v -- '-----' private_key.pem | tr -d '\n')" >> .env
echo "JWT_PUBLIC_KEY=$(grep -v -- '-----' public_key.pem | tr -d '\n')" >> .env

# 4. Remover os arquivos PEM locais por segurança
rm private_key.pem public_key.pem
```

Exemplo do `.env` final:

```env
DB_USERNAME=postgresql
DB_PASSWORD=wabrainpass
DB_URL=jdbc:postgresql://localhost:5432/wabraindb
JWT_PRIVATE_KEY=MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwgg...
JWT_PUBLIC_KEY=MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgK...
```

### 4. Subir o Banco de Dados

```bash
docker compose up -d
```

### 5. Iniciar a Aplicação em Modo Dev (Hot-Reload)

```bash
./mvnw quarkus:dev
```

A API estará disponível em: `http://localhost:8080`  
O Dev UI do Quarkus estará acessível em: `http://localhost:8080/q/dev/`

---

## 🔍 Qualidade de Código & Linter

O projeto utiliza o Checkstyle configurado com o padrão **Google Java Style**:

```bash
./mvnw checkstyle:check
```

---

## 📄 Licença

Este projeto é desenvolvido para fins de estudo e uso pessoal.
