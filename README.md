# 🎮 Puzzle Heros X Vilains

Projeto desenvolvido em Java, com interface gráfica construída utilizando Java Swing. O jogo simula um tabuleiro no qual um herói se movimenta automaticamente em busca de um vilão, seguindo um conjunto de regras e prioridades de movimentação.

O objetivo é fazer com que o herói alcance o vilão até que todas as suas vidas sejam eliminadas. Durante o percurso, o herói também pode encontrar um item bônus que aumenta o dano causado ao vilão.

## 📌 Sobre o projeto

O Puzzle Heros X Vilains é um jogo de movimentação automática baseado em coordenadas e regras condicionais.

O tabuleiro possui dimensões de 10 × 10, com posições identificadas por linhas e colunas. Os personagens são posicionados aleatoriamente, e o herói utiliza regras de decisão para determinar seus próximos movimentos.

Diferentemente de jogos tradicionais, não é necessário controlar o personagem manualmente: toda a movimentação acontece automaticamente, de acordo com as condições implementadas no código.

## 🎯 Objetivo do jogo

O herói (H) precisa alcançar o vilão (V). Sempre que os dois ocupam a mesma posição, o vilão perde vidas.

Durante o percurso, o herói pode encontrar um item bônus (X), que concede uma habilidade especial para o próximo encontro com o vilão.

## 🕹️ Personagens e elementos

| Símbolo | Descrição |
|---|---|
| H | Herói: personagem que realiza os movimentos automaticamente. |
| V | Vilão: personagem que deve ser alcançado pelo herói. |
| X | Bônus: item que permite causar o dobro de dano no próximo encontro com o vilão. |

## ⚙️ Regras de movimentação

A movimentação do herói é orientada por quatro regras, executadas de acordo com uma ordem de prioridade:

1. **Regra 2 – Movimentação para a esquerda:** quando a coluna do herói é maior que a coluna do vilão, o herói se desloca para a esquerda.
2. **Regra 3 – Movimentação para a direita:** quando a coluna do herói é menor que a coluna do vilão, o herói se desloca para a direita.
3. **Regra 4 – Movimentação para baixo:** quando a linha do herói é menor que a linha do vilão, o herói se desloca para baixo.
4. **Regra 5 – Movimentação para cima:** quando a linha do herói é maior que a linha do vilão, o herói se desloca para cima.

As regras seguem uma ordem de prioridade: primeiro são verificadas as diferenças entre as colunas e, depois, as diferenças entre as linhas.

## ⭐ Sistema de bônus e pontuação

O jogo possui um sistema de vidas e bônus:

- Quando o herói alcança o vilão sem possuir bônus, o vilão perde uma vida.
- Quando o herói alcança o vilão com o bônus ativo, o vilão perde duas vidas.
- Após o encontro, as posições dos personagens são geradas novamente.
- O jogo continua até que as vidas do vilão cheguem a zero.

Ao final, uma mensagem exibe a quantidade total de passos realizados pelo herói.

## 🖥️ Capturas de tela

### Tabuleiro e movimentação

![Tabuleiro inicial](jogo/screenshots/jogo-inicial.png)

### Finalização

![Fim de jogo](jogo/screenshots/fim-de-jogo.png)

## 🛠️ Tecnologias utilizadas

- Java
- Java Swing
- Programação Orientada a Objetos (POO)
- Estruturas de dados: List, ArrayList, Map e HashMap
- Manipulação de coordenadas e posições
- Estruturas condicionais e de repetição

## 🧩 Organização do código

O projeto foi organizado em classes com responsabilidades distintas:

- **Jogo:** concentra a lógica principal, controla a execução, a movimentação dos personagens, as vidas e a identificação de colisões.
- **ControleRegras:** define e organiza a ordem de prioridade das regras de movimentação.
- **Posicao:** representa a localização dos personagens no tabuleiro por meio de linha e coluna, incluindo a comparação entre posições.

## ▶️ Como executar o projeto

### Pré-requisitos

- Java JDK instalado.
- Uma IDE compatível com projetos Java, como IntelliJ IDEA, Eclipse ou Apache NetBeans.

### Passo a passo

1. Faça o download ou clone este repositório:

   ```bash
   git clone https://github.com/JoanaGeronimo/Puzzle-Heros-X-Vilains.git
   ```

2. Abra o projeto na sua IDE Java.

3. Verifique se o JDK está configurado corretamente.

4. Localize a classe principal que contém o método `public static void main(String[] args)`.

5. Execute essa classe para iniciar o jogo.

6. A interface gráfica será aberta e a execução acontecerá automaticamente.

## 👩‍💻 Autora

**Joana Geronimo**

- GitHub: [@JoanaGeronimo](https://github.com/JoanaGeronimo)

---

Projeto desenvolvido com o objetivo de praticar conceitos de Java, programação orientada a objetos, estruturas de dados e lógica de programação.
