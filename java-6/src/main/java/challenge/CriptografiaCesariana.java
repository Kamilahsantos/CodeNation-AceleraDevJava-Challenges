package challenge;

import java.util.logging.Logger;

public class CriptografiaCesariana implements Criptografia {

  Logger logger
    = Logger
    .getLogger("com.api.jar");

  int numPositions = 3;
  String encripted = "";

  private void checkText(String texto) {
    if (texto.isEmpty()) throw new IllegalArgumentException();
    logger.info("Empty text, a request could not be completed");


    if (texto==null) throw  new NullPointerException();
    logger.info("Null text, check text");

  }


  @Override
  public String criptografar(String texto) {
    this.checkText(texto);

    for (int i = 0; i < texto.length(); i++) {
      int charPosition = texto.toLowerCase().charAt(i);
      char charEncripted;

      if (charPosition >= 97 & charPosition <= 119) {
        charEncripted = (char) (charPosition + numPositions);
        logger.info(String.valueOf(charEncripted));
      } else if (charPosition >= 119 && charPosition <= 122) {
        charPosition = charPosition - 122;
        charEncripted = (char) (96 + (numPositions - charPosition));
        logger.info(String.valueOf(charEncripted));
      } else {
        charEncripted = (char) charPosition;
        logger.info(String.valueOf(charEncripted));
      }
      encripted = encripted + charEncripted;
    }
    return encripted;

  }

  @Override
  public String descriptografar(String textoCifrado) {

    this.checkText(textoCifrado);
    for (int i = 0; i < textoCifrado.length(); i++) {
      int charPosition = textoCifrado.toLowerCase().charAt(i);
      char charEncripted;

      if (charPosition >= 100 && charPosition <= 122) {
        charEncripted = (char) (charPosition - numPositions);
        logger.info(String.valueOf(charEncripted));
      } else if (charPosition >= 97 && charPosition <= 99) {
        charPosition = charPosition - 97;
        charEncripted = (char) (96 - (numPositions - charPosition));
        logger.info(String.valueOf(charEncripted));
      } else {
        charEncripted = (char) (charPosition);
      }
      encripted = encripted + charEncripted;
    }

    return encripted;

  }

}
