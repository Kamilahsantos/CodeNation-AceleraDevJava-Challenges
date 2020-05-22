package com.challenge.desafio;

import  com.challenge.interfaces.Calculavel;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.util.Arrays;
import java.math.BigDecimal;
import java.lang.reflect.Field;
import java.lang.annotation.Annotation;

public class CalculadorDeClasses implements Calculavel {

  private BigDecimal calcularClasses(Object object, Class<? extends Annotation> annotation) {
    return Arrays.asList(fields(object))
      .stream()
      .filter(field -> field.isAnnotationPresent(annotation))
      .map(field -> filtrar(field, object))
      .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  private Field[] fields(Object object){
    return object.getClass().getDeclaredFields();
  }

  private BigDecimal filtrar (Field field, Object object){
    try{
      field.setAccessible(true);
      return (BigDecimal) field.get(object);

    } catch (IllegalAccessException e){
      return BigDecimal.ZERO;
    }

  }

  @Override
  public BigDecimal somar (Object object){
    return calcularClasses(object, Somar.class);

  }
  @Override
  public BigDecimal subtrair (Object object){
    return calcularClasses(object, Subtrair.class);

  }

  @Override
  public BigDecimal totalizar (Object object){
    return somar(object).subtract(subtrair(object));

  }



}
