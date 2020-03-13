# UDP Sockets

Java cuenta con tres clases para permitir la comunicación vía datagramas UDP en java.net
- DatagramSocket
- DatagramPacket
- MulticastSocket

## DatagramPacket
Permiten la creación y manejo de instancias a partir de los datagramas recibidos y por enviar
### Constructores
1. Creación de datagramas para enviar
El datagrama se construye con el mensaje en un arreglo de bytes, longitud del mensaje, IP y puerto destino.
```
DatagramPacket(byte[] buf, int length)
DatagramPacket(byte[] buf, int length, InetAddress address, int port);
```
2. Recepción de datagramas
Con estos constructores se crean instancias de los datagramas recibidos, se construye con la cadena de bytes, longitud y offset dentro de la cadena.
```
 DatagramPacket(byte[] buf, int offset, int length)
 DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port).
```

La clase DatagramPacket también proporciona métodos para el manejo de los datagramas
- getData() : para obtener el mensaje contenido en el datagrama.
- getAddress() : para obtener la dirección IP.
- getPort(): para obtener el puerto.

## DatagramSocket
Manejador de sockets para el envío y recepción de datagramas UDP
### Constructores
- DatagramSocket(): El sistema escoge un puerto libre y seleeciona una de las direcciones locales.
- DatagramSocket(int port): Para procesos que necesitan un número de puerto específico.
- DatagramSocket(int port, InetAddress laddr): Para escoger el número de puerto y una determinada dirección local.

La clase DatagramSocket proporciona varios métodos, los más utilizados son:

- send(DatagramPacket p): Recibe un DatagramPacket con el mensaje y el destino
- receive(DatagramPacket p): Recibe un DatagramPacket vacío para colocar el mensaje, la longitud y origen.
Ambos métoods manejan las excepciones con IOException

- setSoTimeout(int timeout): Permite fijar un tiempo de espera, el método recieve se bloquea y una vez agotado el tiempo lanza un InterruptedIOException
- connect(InetAddress address, int port): Permite la conexión a un puerto remoto y a una dirección de internet.
