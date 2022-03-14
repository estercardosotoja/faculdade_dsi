# REDE PERCEPTRON

### Treinamento
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
    * Compara o resultado esperado do treinamento (d[i]) - a saída do neuronio.
    * Em caso de ter saír um valor diferente de zero é ajustado os valores dos pesos:
      * **eta** e a constante (taxa) de aprendizagem
        * Não pode ter um valor muito baixo = aprendizagem lenta
        * Não pode ter um valor muito alto = não aprende 

### Generalização
* Recebe os novos dados digitados pelo usuário
* E apresenta o valor do campo induzido
  
