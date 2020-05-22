package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

  private static final int LIMITE_VAGAS = 10;
  private static final int MAIOR_DE_IDADE=18;
  private static final int MAXIMO_PONTOS=20;
  private static final int MOTORISTA_SENIOR=55;


  private final List<Carro> listaCarrosEstacionados = new ArrayList<>();

  private void verificarCarroAutonomo(Carro carro) {

    if (carro.getMotorista() == null) {
      throw new EstacionamentoException("o veiculo nao pode ser autonomo, e necessario um motorista");

    }

  }

  private void verificarMotoristaMenorDeIdade(Motorista motorista) {

    if (motorista.getIdade() < MAIOR_DE_IDADE) {
      throw new EstacionamentoException("o motorista nao pode ser menor de idade");
    }

  }

  private void verificarCarteiraValida(Motorista motorista) {

    if (motorista.getPontos() > MAXIMO_PONTOS) {
      throw new EstacionamentoException("a carteira tem que ser valida");
    }

  }

  private void verificarDados(Motorista motorista, Carro carro) {
    verificarCarroAutonomo(carro);
    verificarMotoristaMenorDeIdade(motorista);
    verificarCarteiraValida(motorista);
  }

  private void verificarVagas(Carro carro) {

    boolean motoristaSenior = true;

    for (int indice = 0; indice < listaCarrosEstacionados.size(); indice++) {
      if (listaCarrosEstacionados.get(indice).getMotorista().getIdade() < MOTORISTA_SENIOR) {
        motoristaSenior = false;
        listaCarrosEstacionados.remove(indice);
        listaCarrosEstacionados.add(indice, carro);
        return;
      }
    }

    if (motoristaSenior) {
      throw new EstacionamentoException("Nao temos vagas");
    }

  }


  public void estacionar(Carro carro) {

    verificarDados(carro.getMotorista(), carro);
    if (carrosEstacionados() == LIMITE_VAGAS) {
      verificarVagas(carro);
    } else {
      listaCarrosEstacionados.add(carro);
    }

  }

  public int carrosEstacionados() {
    return listaCarrosEstacionados.size();
  }

  public boolean carroEstacionado(Carro carro) {
    return listaCarrosEstacionados.contains(carro);
  }


}
