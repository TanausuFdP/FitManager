package es.ulpgc.fitmanager.controller.action.reservation;

import es.ulpgc.fitmanager.view.repository.ReservationRepository;

import java.sql.Connection;

public class CancelReservationAction {
    public CancelReservationAction() { reservationRepository = new ReservationRepository(); }

    private final ReservationRepository reservationRepository;

    public void execute(Connection conn, Integer userId, Integer activityId) {
        reservationRepository.cancelReservation(conn, userId, activityId);
    }
}
