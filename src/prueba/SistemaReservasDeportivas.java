package prueba;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Sistema de reservas deportivas que permite gestionar reservas de pistas
 * y el control de iluminación.
 * 
 * @author Volo
 */
public class SistemaReservasDeportivas {

    private List<Reserva> reservas;
    private boolean[] iluminacion;
    private static final int MAX_PISTAS = 10; // Número máximo de pistas

    /**
     * Constructor de la clase. Inicializa la lista de reservas y el estado de la iluminación.
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        iluminacion = new boolean[MAX_PISTAS];
    }

    /**
     * Realiza una reserva de pista.
     * 
     * @param reserva Objeto de tipo Reserva que contiene los detalles de la reserva.
     * @return true si la reserva se realiza con éxito, false si la pista no está disponible.
     */
    public boolean reservarPista(Reserva reserva) {
        if (!esFechaDisponible(reserva.getIdPista(), reserva.getFecha())) {
            return false;
        }
        reservas.add(reserva);
        return true;
    }

    /**
     * Cancela una reserva existente.
     * 
     * @param idReserva ID de la reserva a cancelar.
     * @return true si la cancelación es exitosa, false si no se encontró la reserva.
     */
    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Enciende la iluminación de una pista específica.
     * 
     * @param idPista Identificador de la pista.
     * @return true si la iluminación se activa correctamente, false si el ID es inválido.
     */
    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false;
        }
        iluminacion[idPista] = true;
        return true;
    }

    /**
     * Apaga la iluminación de una pista específica.
     * 
     * @param idPista Identificador de la pista.
     * @return true si la iluminación se desactiva correctamente, false si el ID es inválido.
     */
    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false;
        }
        iluminacion[idPista] = false;
        return true;
    }

    /**
     * Verifica si una pista está disponible en una fecha determinada.
     * 
     * @param idPista Identificador de la pista.
     * @param fecha   Fecha de la reserva.
     * @return true si la pista está disponible, false si ya está reservada.
     */
    private boolean esFechaDisponible(int idPista, LocalDate fecha) {
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false;
            }
        }
        return true;
    }
}
