#language:es

Característica: Calendario - Funcionalidad

  Como usuario
  Quiero probar la funcionalidad del calendario
  Para poder seleccionar una fecha

  Antecedentes:
    Dado el usuario accede a la web principal de JQuery Datepicker

  @reserva
  Esquema del escenario:Reserva de una cita seleccionando una fecha en el calendario
    Dado el usuario da click en el campo de fecha
    Cuando el usuario ingresa el mes actual y el dia
      | dia   |
      | <dia> |
    Entonces el usuario deberia ver la fecha seleccionada correctamente
    Ejemplos:
      | dia |
      | 15  |

  @messiguiente
  Esquema del escenario:Selección de una fecha específica en un mes diferente
    Dado el usuario da click en el campo de fecha
    Cuando el usuario seleciona  el mes siguiente y el dia
      | dia   |
      | <dia> |
    Entonces el usuario deberia ver la fecha específica seleccionada
    Ejemplos:
      | dia |
      | 10  |

  @campovacio
  Escenario:Validación de campo bloqueado
    Dado el usuario da click en el campo de fecha
    Cuando el usuario intensa ingresar manualmente una fecha
    Entonces el usuario deberia ver el campo vacio
