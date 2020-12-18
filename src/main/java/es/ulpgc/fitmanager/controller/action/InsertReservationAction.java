package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.controller.exceptions.ReservationAlreadyExistsException;
import es.ulpgc.fitmanager.controller.exceptions.ReservationNotFoundException;
import es.ulpgc.fitmanager.view.repository.ReservationRepository;
import es.ulpgc.fitmanager.model.Activity;
import es.ulpgc.fitmanager.model.Reservation;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class InsertReservationAction {

    public InsertReservationAction() {
        reservationRepository = new ReservationRepository();
    }

    private final ReservationRepository reservationRepository;

    public Reservation execute(Connection conn, Integer clientId, Activity activity) {
        try {
            reservationRepository.getReservation(conn, clientId, activity.getId());
            throw new ReservationAlreadyExistsException("Ya existe una reserva de la actividad " + activity.getName() + " para este usuario");
        } catch (ReservationNotFoundException ex) {
            reservationRepository.insertReservation(conn, clientId, activity.getId());
            return reservationRepository.getReservation(conn,clientId, activity.getId());
        }
    }
}
