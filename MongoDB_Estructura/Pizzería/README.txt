-----------BD PIZZERÍA-----------

Esta base de datos se basa en una web que permita hacer pedidos online, por lo tanto, se esperan muchos 
pedidos de muchos lugares.

Aunque el grueso de los datos se centra en los pedidos, donde se coge toda la información de los mismos y 
es donde se encuentra la variabilidad, las tiendas suscritas a la web y sus localizaciones, son estáticas,
por lo tanto, he decidido crear entidades de localidades adscritas a provincias, y a su vez darle esas
localidades a Tiendas físicas, que reciben los pedidos y los tramitan.

Si bien queda "cutre" en un ejemplo de bbdd de este tamaño, en una bbdd de gran tamaño, sí que cobrarian más
sentido las localidades y provincias, ya que si están repartidos por toda España o todo el mundo, habría
muchos datos con los que trabajar y podríamos tenerlos automatizados mediante un id, ya que son estáticos.

Incluso podría eliminarse la entidad de provincia, ya que nos da información, pero no es útil, porque finalmente
utilizamos la localidad, el código postal y la dirección para la interacción entre cliente y tienda.

También he decicido incluir una entidad de Cliente, ya que la web podría tener pedidos de personas registradas
y no registradas, en ese caso si que podría automatizar el proceso de añadir un cliente mediante la id.

En cuanto a los productos, también queda cutre con pocos ejemplos, pero referenciar productos muy complejos,
como por ejemplo con muchos ingredientes extra sí que podría ser útil. Igualmente, he dudado mucho entre incluirlos
como una entidad aparte o simplemente añadir la descripción en los pedidos.