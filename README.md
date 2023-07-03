## Exercícios - Exceções

  1. Faça um programa de controle de lista de compras de acordo com
as seguintes especificações:

a. O programa deve ter um menu que peça para a pessoa usuária
definir qual o tipo de alimento ela quer incluir na lista.

b. A pessoa usuária só pode incluir alimentos do tipo: VERDURA,
LEGUMES, GRÃOS e OUTROS.

i. Caso a pessoa tente incluir outro tipo de alimento, o
programa deve estourar uma exception do tipo
IllegalArgumentException com a mensagem “Tipo de
alimento inválido”.

c. Se a pessoa escolher alimento do tipo VERDURA ou GRÃOS,
ela deve informar a quantidade em gramas, dessa forma, a
quantidade deve ser do tipo double.

i. Caso a quantidade que a pessoa informar para
VERDURA for do tipo inteiro, o programa deve estourar
uma exception do tipo NumberFormatException com
a mensagem “Para verdura, a quantidade deve ser
informada com ponto”.

ii. Caso a quantidade que a pessoa informar para GRÃOS
for do tipo inteiro, o programa deve estourar uma
exception do tipo NumberFormatException com a
mensagem “Para grãos, a quantidade deve ser
informada com ponto”.

d. Se a pessoa escolher alimento do tipo LEGUME ou OUTROS,
ela deve informar a quantidade em unidades, dessa forma, a
quantidade deve ser do tipo inteiro.

i. Caso a quantidade que a pessoa informar para LEGUME
for do tipo double, o programa deve estourar uma exception do tipo NumberFormatException com a
mensagem “Para legume, a quantidade deve ser
informada em unidades inteiras”.

ii. Caso a quantidade que a pessoa informar para OUTROS
for do tipo double, o programa deve estourar uma
exception do tipo NumberFormatException com a
mensagem “Para outros, a quantidade deve ser
informada em unidades inteiras”.

e. Para qualquer tipo de alimento, se a pessoa tentar inserir uma
quantidade vazia, ou seja, “” [abre e fecha aspas duplas sem
nada dentro], o programa deve estourar uma exception do tipo
UnsupportedOperationException com a mensagem “Não é
permitido inserir valor vazio”.

f. Para qualquer tipo de alimento, se a pessoa tentar inserir uma
quantidade menor que zero, o sistema deve informar a pessoa
usuária que não é possível inserir número negativos e pedir
novamente a quantidade que precisa comprar do alimento.

g. Após inserir a quantidade, o sistema deve pedir para a pessoa
usuária o nome do alimento que será comprado.

i. Se a pessoa tentar inserir um nome vazio, ou seja, “” [abre
e fecha aspas duplas sem nada dentro], o programa deve
estourar uma exception do tipo
UnsupportedOperationException com a mensagem
“Não é permitido inserir nome vazio”.

h. O programa deve permitir a pessoa usuária inserir quantos
alimentos quiser até que decida encerrar o processo.

i. Quando a pessoa decidir encerrar o processo, o sistema
deve retornar a lista de compras com as informações de
cada item a ser comprado de cada tipo.
Exemplo: nomeAlimento - quantidadeAlimento

ii. E, após mostrar em tela todos os alimentos a serem compradas, deve informar a quantidade de cada tipo de
alimento a ser comprado.

Exemplo de saída esperada:

Legumes:
[alface - 10.0 kg, catalonia - 10.0 kg, espinafre - 10.0kg]
A quantidade de alimentos do tipo verdura a ser comprada
é: 3


2. Elaborar um programa de conversão de moeda de acordo com as
seguintes especificações (sempre usando OOP):

a. O programa deve ter apresentar para a pessoa usuária “Boas
vindas ao conversor de moedas”

b. O programa deve perguntar qual a moeda que a pessoa quer
converter, sendo que o programa só pode aceitar as seguintes
opções de moeda:

i. Dólar americano
ii. Dólar canadense
iii. Euro
iv. Libra Esterlina

c. Caso a pessoa digite qualquer outra moeda fora das
mencionadas acima, o programa deve estourar uma exception
do tipo IllegalArgumentException com a mensagem “Tipo de
moeda inválido”.

d. Após escolher qual o tipo de moeda a ser convertida, o
programa deve informar a pessoa usuária que ele só sabe
converter dinheiro para Real (R$).

e. Após informar o tipo de moeda válida a ser convertida, o
sistema deve pedir o valor a ser convertido no formato BigDecimal.

i. Caso a pessoa digite qualquer texto ou valor vazio, o
programa deve estourar uma exception do tipo
NumberFormatException com a mensagem “Para
moeda, o valor monetário deve ser um número decimal”.

ii. Caso a pessoa digite um valor menor ou igual a zero, o
programa deve mostrar a seguinte mensagem para a
pessoa: “Valor inválido, por favor, tente novamente” E
permitir que a pessoa insira o valor a ser convertido de
novo.

f. Após as entradas, o sistema deve fazer a devida conversão da
moeda escolhida para Real (R$) de acordo com a cotação do
dia. Você pode pegar o valor do dia

g. Após a conversão o sistema deve mostrar a mensagem: “A
[MOEDA] na cotação de hoje [DIA ATUAL] está em [VALOR DA
COTAÇÃO], o valor que pediu para converter de [VALOR
INSERIDO] em reais é R$[VALOR CONVERTIDO]”.

h. Por fim, o programa deve perguntar se a pessoa deseja fazer
outra conversão.

i. Se sim, o programa reinicia.
ii. Se não, o programa encerra.

Valores a serem utilizados

COTACAO_DOLAR_AMERICANO - 5.25
COTACAO_DOLAR_CANADENSE - 4.15
COTACAO_EURO - 6.15
COTACAO_LIBRA_ESTERLINA - 7.50
