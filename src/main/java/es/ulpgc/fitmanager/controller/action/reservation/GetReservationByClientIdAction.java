package es.ulpgc.fitmanager.controller.action.reservation;

import es.ulpgc.fitmanager.model.Activity;
import es.ulpgc.fitmanager.view.repository.ReservationRepository;

import java.sql.Connection;
import java.util.List;

public class GetReservationByClientIdAction {
    public GetReservationByClientIdAction() {
        reservationRepository = new ReservationRepository();
    }

    private final ReservationRepository reservationRepository;

    public List<Activity> execute(Connection conn, Integer userId) {
        return reservationRepository.getActivitiesByClientId(conn, userId);
    }
}