# Comunicación con Sockets TCP
La comunicación entre clientes y servidos en TCP y UDP utiliza la abstracción de sockets para comunicarse
Esto consiste en la transmisión de mensajes entre sockets del cliente y del servidor. 

Inet Address
Permite la representación de direcciones IP, se puede acceder también mediante sus nombres de host en el DNS.

Métodos 
getByName(String nombreDNS) 
Crea la dirección destino del host y se puede utilizar para construir sockets

Comunicación cliente servidor con Sockets TCP
Interfaz Java:
1. ServerSocket: creación del socket en el puerto especificado y en que escucha las peticiones de conexión.
2. Socket: utilizado por el cliente y el servidor. El cliente crea un socket especificando el nombre de DNS del host y el puerto del servidor.

Métodos 
getInputStream
getOutputStream 
Permiten acceder a los flujos asociados a un socket. Para procesar los datos que devuelven se construyen objetos BufferedReader y PrintWriter.

Implementación
Cliente
1. Crear objeto de la clase Socket con host y puerto 
2. Obtener referencias del stream de entrada y salida 
3. Leer y escribir en el stream 
4. Cerrar streams y socket 

Servidor 
1. Crear objeto ServerSocket
2. Esperar solicitud de clientes
3. Al recibir una solicitud 
    - Acepta la conexión y recibe un objeto Socket 
    - Obtiene las referencias del stream de entrada y el de salida del socket anterior 
    - Leer datos del socket y procesarlos. Se puede mandar response escribiendo en el stream del socket.


http://www.it.uc3m.es/celeste/docencia/cr/2003/PracticaSocketsTCP/
