# Pesquisa de Integrações Assíncronas
### Nome: Vinícius Paes Marcelino, Gabriel Felix Faustina, Welligton Corrêa Delfino, Luiz Fabiano, Luiz Eduardo

## O que são Integrações Assíncronas?
Definição:
> Integrações assíncronas são formas de comunicação entre sistemas, serviços ou componentes em que o remetente não precisa esperar a resposta imediata do destinatário para continuar sua execução.

## Características Principais:
Sincronismo	Assincronismo
> O remetente espera a resposta.	O remetente continua sem esperar resposta.
> Bloqueia a execução.	Não bloqueia a execução.
> Exemplo: chamada REST tradicional (RestTemplate).	Exemplo: mensagem em fila (Kafka, RabbitMQ).

## Exemplo Prático (Ilustração):
Imagine que você está fazendo um pedido em um app de delivery:
> Sincrono: Você faz o pedido e espera o restaurante responder imediatamente se aceitou ou não.
> Assíncrono: Você faz o pedido, o sistema confirma o recebimento e você continua usando o app. A confirmação do restaurante vem depois.

## Como funciona uma integração assíncrona?
> Produtor envia uma mensagem para uma fila, tópico ou API reativa.
> A mensagem fica armazenada temporariamente em um intermediário (ex: Kafka, RabbitMQ).
> Consumidor consome a mensagem e processa de forma independente.
> Nenhuma das partes depende do tempo de resposta da outra.

## Tecnologias Usadas em Integrações Assíncronas:
| Tecnologia |	Tipo |	Descrição breve |
|-------|------------------------|---------------------------------------|
| Kafka |	Mensageria distribuída | Alta performance, tolerância a falhas |
| RabbitMQ | Broker de mensagens |	Flexível, com suporte a vários protocolos |
| WebFlux |	Reativo via HTTP | Assíncrono com Mono/Flux (Spring) |
| AWS SQS |	Fila na nuvem (AWS)	| Escalável e gerenciado |

Quando usar integrações assíncronas?
Casos ideais:
Processos longos (como gerar relatórios, envio de e-mails).
Alta concorrência (muitos pedidos ao mesmo tempo).
Comunicação entre microsserviços.
Tolerância a falhas e sistemas desacoplados.
 Evite quando:
Você precisa da resposta imediatamente.
A operação é crítica e exige confirmação direta.

Vantagens
 Escalabilidade: Serviços trabalham de forma independente.
 Performance: O sistema responde mais rápido ao usuário.
Desacoplamento: Produtor e consumidor não precisam estar ativos ao mesmo tempo.
 Resiliência: Permite reprocessamento de falhas.
