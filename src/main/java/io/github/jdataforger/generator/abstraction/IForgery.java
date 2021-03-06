package io.github.jdataforger.generator.abstraction;

/***
 *
 * Interface base para gerar dados falsos.
 *
 * @author Hadil
 * @since 04-24-2021
 */
public interface IForgery<T> {

 /**
  * Forge fake data
  * @return
  */
 public T fake();

}
