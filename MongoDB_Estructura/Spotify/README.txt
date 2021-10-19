-------------BD Spotify---------------

He enfocado la bbdd en torno a Artistas y Usuarios, que interactúan mediante álbumes, canciones y playlists.

En la entidad Artistas recae toda la información sobre la música, incluidos álbumes, canciones y artistas
relacionados.

En la entidad Playlists se añaden canciones mediante la id, lo que automáticamente permite conocer álbum y 
artista.

En la entidad Usuarios, tenemos playlists, el método de pago (si lo hay) y las fechas de suscripción requeridas,
además del tipo de usuario.

Artistas y Usuarios se comunican mediante la playlist, es el nexo que los une mediante la id y permite
acceder a la información de las otras entidades.