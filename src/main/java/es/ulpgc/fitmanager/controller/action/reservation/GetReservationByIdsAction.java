package es.ulpgc.fitmanager.controller.action.reservation;

import es.ulpgc.fitmanager.view.repository.ReservationRepository;
import es.ulpgc.fitmanager.model.Reservation;

import java.sql.Connection;

public class GetReservationByIdsAction {
    public GetReservationByIdsAction() {
        reservationRepository = new ReservationRepository();
    }

    private final ReservationRepository reservationRepository;

    public Reservation execute(Connection conn, Integer clientId, Integer activityId) {
        return reservationRepository.getReservationByIds(conn, clientId, activityId);
    }
}
