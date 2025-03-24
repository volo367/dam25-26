package prueba;
import java.time.LocalDate;

/**
 * Representa una reserva dentro del sistema de reservas deportivas.
 * 
 * @author Volo
 */
public class Reserva {
    private int idPista;
    private LocalDate fecha;
    private int duracion;

    /**
     * Constructor de la clase Reserva.
     * 
     * @param idPista  Identificador de la pista reservada.
     * @param fecha    Fecha de la reserva.
     * @param duracion Duración de la reserva en horas.
     */
    public Reserva(int idPista, LocalDate fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    /**
     * Obtiene el identificador de la pista reservada.
     * 
     * @return ID de la pista.
     */
    public int getIdPista() {
        return idPista;
    }

    /**
     * Obtiene la fecha de la reserva.
     * 
     * @return Fecha de la reserva.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Obtiene la duración de la reserva en horas.
     * 
     * @return Duración de la reserva.
     */
    public int getDuracion() {
        return duracion;
    }
}
