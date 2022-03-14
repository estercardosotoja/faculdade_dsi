# REDE PERCEPTRON

### Etapa 1 (Entendendo a programação):
- Analise o código e entenda como cada uma das etapas de implementação são constituídas, faça um pequeno relato
  em modo texto. Podem ser inseridos códigos para auxiliar nas explicações.

#### Treinamento
* A primeira fase é o treinamento que tem como objetivo ajustar os valores dos pesos (**W**n):
  * Apresentado os dados para o treinamento.
  * É composto por um loop que se repete no tamanho do vetor **x1**;
  * Temos duas equações:
    * **Função calculaY**: 
        * Chama a função calculaV;
        * Recebe com retorno o valor do campo induzido (**y**)
        * Tem como objetivo ser a função de ativação = (que representa a saída do neurônio)
        * Neste exemplo, usamos a função **Degrau Bipolar**: 
            * Se o retorno for positvo ou nulo, retorna 1
            * Se o retorno for negativo retorna 0
  * **Função calculaV**:
    *  Calcula o valor do campo induzido:
    
  * **Calcula o erro**:
    * Compara o resultado esperado do treinamento (d[i]) - a saída do neurônio.
    * Em caso de ter retornar um valor diferente de zero é ajustado os valores dos pesos:
      * **eta** e a constante (taxa) de aprendizagem
        * Não pode ter um valor muito baixo = aprendizagem lenta
        * Não pode ter um valor muito alto = não aprende 

#### Generalização
* Recebe os novos dados digitados pelo usuário
* E apresenta o valor do campo induzido
  
### Etapa 2 (Testando a Rede):
Execute:
 * **I** - Altere a constante de aprendizado (eta) para valores como 2, 0.5 e 0.001 e verifique se com esses valores influenciam
  no número de épocas do treinamento e, nos ajustes dos pesos. Relate o que ocorreu e a teoria do porquê influenciaram
  ou não.
   
   
   " [...]  A taxa de aprendizado é um parâmetro constante no intervalo [0,1] que interfere na convergência do processo de aprendizado. 
A influência deste parâmetro está relacionada à mudança nos pesos sinápticos. Assim, uma taxa de aprendizado muito pequena 
implica numa trajetória suave e pequena mudanças nos pesos a cada iteração. No entanto, requer-se um tempo de treinamento muito
longo, e dependendo da utilização dos pesos é possível cair no problema de mínimo local, pois ANN nesse caso não consegue 
calcular uma mudança nos pesos que faça a rede sair no mínimo local. [...]"

" [..] Se a taxa de aprendizado for muito grande, (perto de 1), ocorre uma maior mudança nos pesos, aumentando a velocidade do aprendizado,
o que pode levar a oscilações em torno do mínimo global. Assim, a taxa de aprendizado não deve ser muito pequena, nem muito grande. [...]"

Fonte da Resposta: https://www.maxwell.vrac.puc-rio.br/32823/32823_4.PDF

Ao executar o programa alterando os parâmetros o tempo de execução:

* [2]


 ![img_4.png](img_4.png)


* [0.5]


  ![img_2.png](img_2.png)


* [0.001]


  ![img_1.png](img_1.png)


 * **II** - Altere a implementação para que reconheça a tabela OR e relate se continua funcionando ou não e, o porquê
  (respostas sem justificativas serão anuladas).

    - No caso do OR funciona pois as entradas diferentes de [0,0] retornam 1.
    - Assim é possivel separar os resultados por uma reta, conforme na imagem, separando os resultados.   
  
  ![img_5.png](img_5.png)
        

 * **III** - Altere a implementação para que reconheça a tabela XOR e relate se continua funcionando ou não e, o porquê
  (responsas sem justificativas serão anuladas).

   - No caso do XOR não funciona pois as entradas [0,1] e [1,0] retornam 1.
   - Não é possivel separar os resultados por uma reta.

  ![img.png](img.png)