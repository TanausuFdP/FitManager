package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.view.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class CancelReservationAction {

    public CancelReservationAction() { reservationRepository = new ReservationRepository(); }

    private final ReservationRepository reservationRepository;

    public void execute(Connection conn, Integer userId, Integer activityId) {
        reservationRepository.cancelReservation(conn, userId, activityId);
    }
}
