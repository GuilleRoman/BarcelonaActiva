
						Trabajo Final (Joc de Daus)


Funcionamiento del programa:

El flujo es el siguiente:

1-Usuario se registra en el enlace /register, introduciendo usuario y contraseña
2-Usuario se autentica en el enlace /autenticate, introduciendo el mismo usuario y contraseña
  Una vez realizado este paso, se obtiene un token que permitirá el acceso al resto de enlaces, que sin este
token están protegidos.
3-Se crea un jugador con el nombre de usuario registrado.
4-Ya se pueden realizar el resto de funcionalidades del programa (tirar los dados, borrar partidas, cambiar el nombre
de un jugador...)


Planteamiento del proyecto:

He decidido realizar 3 programas para poder plasmar en la entrega los diferentes niveles que pide el
proyecto.

En un principio, realicé un front-end con la plantilla thymeleaf, que permitiese, mediante una interfaz,
controlar todo el flujo del programa. En los controladores de los mismos, se verá el código anterior comentado,
así como las plantillas usadas en src/main/resources. He decidido dejarlo ahí para que se vea el proceso.

Me ví con el problema de que no era capaz de encontrar una manera de devolver el token automáticamente en
el front-end, y, aunque encontré maneras de hacerlo (con Angular por ejemplo), por falta de tiempo he decidido
hacerlo de esta manera, que además pienso que es la que se pide mediante información en formato JSON.

En cuanto al testing, he realizado los tests de los servicios del programa y pasan correctamente, sin embargo,
por falta de tiempo, no me puedo permitir ponerme con los contract tests y realizar los demás tests del proyecto,
ya que tengo otra formación que debo empezar, sin embargo lo dejo pendiente para más adelante aprender a hacerlo,
y entiendo que esto afectará negativamente a mi calificación.




Diferencias entre programas:

JocDeDaus- Para el programa con MySQL, las entidades incluyen los dados, que he decidido no usar en los
siguientes programas, ya que no veía su utilidad, sino carga innecesaria de código, métodos y dependencias.

También, para este programa he desarrollado la entidad Rolls, que gestiona la interacción de todas las
entidades y permite obtener todos los valores de la base de datos de una manera clara.

En cuanto a los servicios, también he incluido los servicios de todas las entidades por separado, y los 
he incluido en un único controlador, con el que puedo acceder a todos ellos. Esta parte última la he 
utilizado en el resto de programas.

JuegoDados- Para este programa, he utilizado MySQL y MongoDB para la persistencia de datos.
 
La entidad de Player utiliza MySQL y el documento Games utiliza MongoDB, por lo que el flujo del programa ha seguido una ruta
mucho más sencilla en mi opinión, ya que la flexibilidad que ofrece MongoDB me permitía acceder a los datos más fácilmente.

JuegoDados-Mongo- Para este he utilizado solo MongoDB en la persistencia, lo que me ha presentado un único problema, y es que a 
la hora de acceder a la id en las llamadas a la api para seleccionar un jugador específico, he cambiado el campo ID, por el campo NAME,
de esta manera el único cambio existente entre el funcionamiento es que en este programa, en lugar de acceder mediante, por ejemplo,
/players/{id}/games, será mediante /players/{name}/games, donde name será un nombre válido de jugador introducido previamente.

Ya que el método de hacer que la id en MongoDB siga una secuencia clara me parecía rebuscado, he decidido seguir las "normas" de MongoDB y
utilizar esta otra manera para hacerlo. También podría haber definido otro campo de ID y haber hecho la secuencia, pero así creo que es más real.


