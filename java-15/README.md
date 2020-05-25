# Order Service

Em um sistema de gerenciamento de pedidos, surgiram alguns requisitos novos para serem implementados. Sua tarefa é realizar a implementação dessas funcionalidades conforme as instruções abaixo.

Você deve implementar os métodos da classe **OrderServiceImpl**, uma implementação da Interface **OrderService**. A implementação de seus métodos deve utilizar a seguir as regras abaixo. 

**Double calculateOrderValue(List<OrderItem> items)**

Esse método deverá receber uma lista de OrderItem (Classe que contem o id do produto e sua quantidade no pedido) e deve retornar o valor total do pedido.
Para calcular o valor total, deve-se obter o valor de cada item do pedido (OrderItem) multiplicando a quantidade de itens pelo valor do produto e, caso o produto tenha o atributo isSale igual a true, deve-se aplicar um desconto de 20%.

**Set<Product> findProductsById(List<Long> ids)**

Esse é um método de mapeamento, que deve receber uma lista de ids de produtos e devolver um conjunto de produtos.


**Double calculateMultipleOrders(List<List<OrderItem>> orders)**
	
Esse método deverá calcular o valor total de todos os pedidos, sendo que cada pedido corresponde a uma lista de OrderItem. Para calcular o valor total de cada pedido, você deve seguir as mesmas regras do método calculateOrderValue.

**Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds)**

Esse método deverá receber uma lista de ids de produtos e retornar um mapa com os produtos agrupados de acordo com o atributo isSale.

**Observações**
Para implementar os métodos acima, deverão ser utilizados os métodos disponíveis na **Interface ProductRepository**
Todos os métodos devem **ignorar id inválidos**
Todos os método devem ser implementados utilizando a Stream API


## Tópicos

Neste desafio, você utilizará:

- Programação Funcional
- Java Stream API
- Java Collections API
- Classe Optional

## Requisitos
Para este desafio, você precisará:

- Java 8++

Para instalar no MacOS, usando o HomeBrew, basta executar:

    brew cask install java

Para instalar no Linux e no Windows, confira os links na seção de conteúdo.