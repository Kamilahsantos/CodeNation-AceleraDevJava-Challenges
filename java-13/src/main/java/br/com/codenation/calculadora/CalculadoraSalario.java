package br.com.codenation.calculadora;


public class CalculadoraSalario {
  private static final double INSS_PRIMEIRO_VALOR_TETO_SALARIAL = 1500;
  private static final double INSS_SEGUNDO_VALOR_TETO_SALARIAL = 4000;
  private static final double IRRF_PRIMEIRO_VALOR_TETO_SALARIAL = 3000;
  private static final double IRRF_SEGUNDO_VALOR_TETO_SALARIAL = 6000;
  private static final double VALOR_SALARIO_MINIMO = 1039.0;
  private static final double INSS_PRIMEIRO_VALOR_ALIQUOTA=0.08;
  private static final double INSS_SEGUNDO_VALOR_ALIQUOTA=0.09;
  private static final double INSS_TECEIRO_VALOR_ALIQUOTA=0.11;
  private static final double IRRF_PRIMEIRO_VALOR_ALIQUOTA=0.075;
  private static final double IRRF_SEGUNDO_VALOR_ALIQUOTA=0.15;

  public long calcularSalarioLiquido(double salarioBase) {
    if(salarioBase < VALOR_SALARIO_MINIMO) return 0;
    double salarioLiquido = descontarInss(salarioBase);
    salarioLiquido = descontarIRRF(salarioLiquido);
    return Math.round(salarioLiquido);
  }

  //Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
  private double descontarInss(double salario) {
    if(salario <= INSS_PRIMEIRO_VALOR_TETO_SALARIAL)
      return salario - (salario * INSS_PRIMEIRO_VALOR_ALIQUOTA);
    if(salario > INSS_PRIMEIRO_VALOR_TETO_SALARIAL && salario <= INSS_SEGUNDO_VALOR_TETO_SALARIAL)
      return salario - (salario * INSS_SEGUNDO_VALOR_ALIQUOTA);
    if(salario > INSS_SEGUNDO_VALOR_TETO_SALARIAL)
      return salario - (salario * INSS_TECEIRO_VALOR_ALIQUOTA);
    return 0.0;
  }

  private double descontarIRRF(double salario){
    if(salario > IRRF_PRIMEIRO_VALOR_TETO_SALARIAL && salario <= IRRF_SEGUNDO_VALOR_TETO_SALARIAL)
      return salario -= (salario * IRRF_PRIMEIRO_VALOR_ALIQUOTA);
    if(salario > IRRF_SEGUNDO_VALOR_TETO_SALARIAL)
      return salario -= (salario * IRRF_SEGUNDO_VALOR_ALIQUOTA);
    return salario;
  }

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar!
*/
