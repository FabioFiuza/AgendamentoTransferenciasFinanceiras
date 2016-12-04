# Agendamento de Transferências Financeiras

Breve sistema para criar agendamentos de transações financeiras.

- Importar projeto no Eclipse ou em outra IDE como "Maven Projects".

# Resumo
- Tentei implementar o código da forma mais objetiva possivel, evitando acoplamentos e buscando separar ao máximo as responsabilidades entre as classes, assim facilitando a implementação de novas funcionalidades. Como padrões de projeto, foi utilizado como base o strategy e factory.

# Tomcat

- Versões a partir da 7.
- Utilizar a configuração (Use tomcat installation), ao invés da padrão. 
- Aumentar o tempo de inicialização do tomcat acima dos 500 segundos.

# Acessar aplicacão

- Para acessar local basta utilizar a url: http://localhost:8080/transferencia/

# Java 8
- Necessario ter ao menos algum JDK 8 na maquina. 
- Como biblioteca do projeto foi utilizado o mais recente JDk 8. 
- Foi utilizado a nova classe de datas do java 8 (LocalDate), ao invés das antigas bibliocates (Calendar e Date). Por conta da utilização do LocalDate, foi necessário criar alguns convertes, para que as datas sejam convertidas corretamente nas requisões do vraptor (LocalDateJsonDeserializer, LocalDateGsonConverter).

# Framework utilizado - VRAPTOR 4

- Foi utilizado este framework principalmente pela simplicidade de implementar um projeto java web e trabalhar com formatos de dados (como JSON). Não foi implementado validações nos campos e formatações dos campos.

# Framework frontend - Angular 1.6

- Mesmo não sendo pedido a utilizacão de um framework frontend, opitei por utilizar o Angular, pela simplicidade de implementação e integracão com framework utilizado neste projeto (vraptor). Visando também desacoplar o frontend do backend. 

# Maven

- Foi utilizado maven como ferramenta de build (Maven 4)

# Testes unitários

- Tentei abortar o máximo de testes possiveis, facilitando assim os testes, caso haja alguma mudança nos codigos implementados.
- Foi utilizado o Junit 4
