# Health Diary

![GitHub Tag](https://img.shields.io/github/v/tag/sammid37/HealthDiary?style=for-the-badge) ![GitHub Actions Workflow Status](https://img.shields.io/github/actions/workflow/status/sammid37/HealthDiary/unit-test.yml?style=for-the-badge)

Uma aplicação para monitoramento de hábitos desenvolvida durante o [#7DaysOfCode da Alura](https://7daysofcode.io/matricula/spring-diario-saude).

- [Tecnologias](#tecnologias)
- [Como executar](#como-executar)
- [Demonstração](#demonstração)
- [Desafios e Próximos Passos](#desafios-e-próximos-passos)
- [Licença](#licença)

---

## Tecnologias
![Spring](https://img.shields.io/badge/spring-40a02b.svg?style=for-the-badge&logo=spring&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-4c4f69?style=for-the-badge&logo=swagger&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-4c4f69.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)

![DaisyUI](https://img.shields.io/badge/daisyui-7287fd?style=for-the-badge&logo=daisyui&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-4c4f69.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-4c4f69.svg?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-4c4f69.svg?style=for-the-badge&logo=javascript&logoColor=white)

![MySQL](https://img.shields.io/badge/mysql-1e66f5.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Redis](https://img.shields.io/badge/redis-d20f39.svg?style=for-the-badge&logo=redis&logoColor=white)

### Protótipo 
[![Figma - Link do Protótipo](https://img.shields.io/badge/Figma-Prot%C3%B3tipo%20em%20desenvolvimento-e64553?style=for-the-badge&logo=figma&logoColor=white)](https://www.figma.com/proto/QU9GdtNrtX61UA8SGLlhwr/Health-Diary?node-id=0-1&t=kGOuMqTFcLaZRG7P-1)

Antes da implementação, o projeto foi prototipado no **Figma** utilizando a biblioteca de componentes **daisyUI**, garantindo consistência visual e agilidade no desenvolvimento.

![Previa do protótipo Health Diary](link-da-imagem-ou-gif.png)

## Como executar
1. Clone e acesse o diretório do repositório;
2. Configure o banco de dados em `src/main/resources/application.properties`;
3. Execute o projeto pelo IntelliJ ou execute o comando
```bash
./mvnw spring-boot:run
```
4. Acesse a aplicação pelo endereço `http://localhost:8080`

### Documentação da API 
A documentação da API é gerada automaticamente pelo **Swagger** e pode ser acessada pelo endpoint **[`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)**. 

## Desafios e  Próximos passos.

[![Backlog](https://img.shields.io/badge/Backlog-issues-209fb5?style=for-the-badge&logo=github&logoColor=white)](https://github.com/sammid37/HealthDiary/issues/1)
![GitHub Issues or Pull Requests](https://img.shields.io/github/issues-raw/sammid37/HealthDiary?style=for-the-badge)
[![Changelog](https://img.shields.io/badge/Changelog-available-df8e1d?style=for-the-badge)](CHANGELOG.md)

O projeto, em sua versão inicial (proposta pelo #7DaysOfCode da Alura), tem como objetivo principal implementar um CRUD para gerenciar três hábitos: sono, exercícios e alimentação.

Como próximos passos, um dos principais desafios são: 
- Implementação de testes de unidade utilizando JUnit;
- Implementação de **autenticação e login**, permitindo que cada usuário tenha acesso seguro e personalizado aos seus registros;
- E aplicação de padrões de resiliência, para quando um recurso não estiver disponível não atrapalhar a experiência do usuário.

Outras melhorias, evoluções e novas funcionalidades podem ser via Backlog e Changelog do projeto.

## License
Em breve.