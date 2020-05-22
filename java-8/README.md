# Calculador de Atributos de Classe

Você precisa somar ou subtrair determinados atributos do tipo *BigDecimal* de uma *classe*. Pra isso você deverá cria uma *annotation* ("Somar") para determinar quais atributos serão somados e outra *annotation* ("Subtrair") para todos os atributos que serão subtraídos. 
Você deverá criar uma interface  `Calculavel`. Esta interface possui 3 métodos:

- Somar
- Subtrair
- Totalizar

Você deverá também criar uma classe concreta que implementa Calculavel. O nome dessa classe deve ser `CalculadorDeClasses`. A implementação dos métodos deve obedecer os requisitos abaixo:

- **O método somar**: deverá somar todos os atributos  do tipo BigDecimal de uma classe recebida como parâmetro e retornar um BigDecimal.
- **O método subtrair**: deverá somar todos os atributos  do tipo BigDecimal de uma classe recebida como parâmetro e retornar um BigDecimal..
- **O método total**:  deverá subtrair os atributos annotados com "Subtrair" dos atributos annotados com "Somar".

- Caso a classe não tenha nenhum atributo com annotation, retornar
 BigDecimal.ZERO
- Caso o atributo não seja BigDecimal, retornar BigDecimal.ZERO
- Utilizar os packages existentes do projeto para crias as devidas classes.
