/**
 * Contrato de capacidad: cualquier objeto que pueda recibir notificaciones del sistema (R13).
 * No dice quién es el objeto ni cómo se entrega el mensaje; solo que sabe recibirlo.
 */
public interface Notificable {
    void notificar(String mensaje);
}
