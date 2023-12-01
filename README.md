# Global Solution
Turma 2TDSPT - 2023

## Integrantes
- Bruno Barbosa Braga dos Santos - RM96685
- Igor Augusto Takeshigue Lemos - RM97012
- Joederson Oliveira Pereira - RM97192
- Mário Ito Bocchini - RM96950

## Apresentação
- Problema que a solução se propõe a solucionar / Maneira como se propõe a solucionar:

O EasyMed é um aplicativo desenvolvido para dispositivos Android, com o propósito de simplificar o tratamento medicamentoso, especialmente para pessoas com dificuldades visuais ou cognitivas.
O aplicativo é direcionado especialmente a indivíduos, principalmente idosos, que fazem uso de múltiplos medicamentos e podem encontrar dificuldades em lembrar-se dos horários de administração ou até mesmo em identificar cada medicamento em sua rotina.

Recursos Principais:
- Cadastro de Medicamentos:
Os usuários podem facilmente cadastrar todos os medicamentos que fazem parte de sua rotina de tratamento no EasyMed. Isso inclui nome do medicamento, dosagem, e quaisquer instruções específicas.
- Notificações:
O aplicativo permite que o usuário programe os horários específicos de cada dose, personalizando lembretes que se adaptam à sua rotina diária.
- Reconhecimento do medicamento por imagem:
Utilizando a câmera do celular, o EasyMed faz a identificação das caixas de medicamentos. O aplicativo reconhece o medicamento e fornece informações detalhadas, incluindo o nome do remédio e o horário recomendado para a administração.

Benefícios:
- Prevenção de Erros na Medicação:
Minimiza a probabilidade de erros na administração de medicamentos, garantindo que cada dose seja tomada no momento certo.
- Facilidade de Identificação:
Elimina a incerteza sobre a identificação de medicamentos ao oferecer informações claras e precisas através da câmera do dispositivo.


 ## Escopo do projeto de desenvolvimento
- **Objetivo:** 
  - Desenvolver um aplicativo Android que auxilie pessoas com dificuldade visual ou cognitiva a tomarem seus remédios.
- **Funcionalidades Principais:** 
    - Cadastro de medicamentos
    - Cadastro de horários de uso
    - Notificação de horários de uso
    - Reconhecimento de texto em caixas de remédio
    - Informação de nome, horário do medicamento
- **Entregáveis:**
  - Aplicativo Android não funcional
  - Aplicação Spring
  - Banco de dados Oracle
  - Código-fonte do Java com Spring
  - Vídeo Pitch
- **Recursos:**
  - 4 desenvolvedores com perfil full-stack
- **Entrega do MVP:**
  - 01/12/2023

## O que está fora do Escopo do MVP;
- Aplicativo Android funcional integrado com o back end
- Aplicativo Ios
- Aplicativo Web (Site)
- Back-end hospedado em servidor

## Tecnologias Utilizadas
- Java 17.0.8 - 2023-07-18 LTS
- React Native 0.72.6
- TypeScript 5.1.3
- Expo 49.0.15
- Spring 3.0.12
- Oracle Database 19c Enterprise Edition Release 19.0.0.0.0 - Production
- Python 3.11.5

## Script Docker e Docker Compose
- Não foi utilizado Docker

## Diagramas
- Diagrama de Classes Astah
![DIAGRAMA ASTAH](documentacao/diagrama-classes-astah.png)
<br><br>
- Diagrama de Classes Intellij
![DIAGRAMA INTELLIJ](documentacao/diagrama-classes-intellij.png)

- Diagrama de modelagem de Banco de dados
![DIAGRAMA BANCO](documentacao/diagrama-banco.jpg)

## Links 

- Imagem com link para video pitch<br>
[![LOGO DO PROJETO](documentacao/EasyMed.png)](https://youtu.be/yPsnZgKcqmQ)

<br><br>
- Imagem com link para video com teste das funcionalidades<br>
[![LOGO DO PROJETO](documentacao/EasyMed.png)](https://youtu.be/UXqQngKSsbg)

- Link para script do Postman 


[documentacao/EasyMed.postman_collection.json](https://github.com/nossodrivechallengefiap/api-easymed/blob/main/documentacao/EasyMed.postman_collection.json)



## Como executar o projeto
1. Clonar o repositório
2. Abrir o projeto em uma IDE Java (Eclipse, IntelliJ, etc)
3. Executar o arquivo `EasyMedApplication.java` como uma aplicação Java
4. Abrir o Postman, Insomnia ou outra aplicação de teste de API
5. Importar o arquivo `EasyMed.postman_collection.json` 
6. Executar as requisições

**OBS:** As instruções acima se aplicam ao ambiente local, a execução em servidor cloud não está no escopo do projeto e nem da disciplina
