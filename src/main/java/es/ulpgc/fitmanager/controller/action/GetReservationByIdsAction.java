package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.view.repository.ReservationRepository;
import es.ulpgc.fitmanager.model.Reservation;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class GetReservationByIdsAction {

    public GetReservationByIdsAction() {
        reservationRepository = new ReservationRepository();
    }

    private final ReservationRepository reservationRepository;

    public Reservation execute(Connection conn, Integer clientId, Integer activityId) {
        return reservationRepository.getReservation(conn, clientId, activityId);
    }
}
