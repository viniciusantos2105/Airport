<h2 align="center">Desafio técnico - Analista Sistemas Júnior </h2>
<br>
<p align="start">
 <h3>Sobre</h3> 
  • Padrão Adapter - Adotei o padrão de projeto estrutural, adapter que consiste em permitir transformar um objeto em outro, utilizei o modelMapper para isso 
  <p></p>
  • Padrão DTO - Adotei o padrão DTO, para transação de dados, que consiste em mandar requests e responses sem necessidade do objeto real
  <p></p>
  • Spring Security - Utilizei o spring security para garantir a segurança da aplicação, utilizando o token JWT e o Encoder para proteger a senha do usuario
  <p></p>
  • Swagger - Utilizei o swagger para documentar as rotas, link para o swagger : http://localhost:8080/swagger-ui/index.html#/
  <p></p>
  • Docker - Utilizei o docker para conteinerizar a aplicação e facilitar o build e execução do projeto
   <h3>Build</h3> 
   1 - Descompacte o projeto    
   <p></p>
   2 - Abra a pasta transaction-authorizer   
   <p></p>
   3 - Abra o terminal e rode o comando  mvn clean package -DskipTests   
   <p></p>
   4 - Volte para pasta desafio_tecnico e rode o comando  docker compose up -d --build
</p>
