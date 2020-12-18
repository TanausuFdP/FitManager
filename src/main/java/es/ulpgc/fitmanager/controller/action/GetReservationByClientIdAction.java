package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.view.repository.ReservationRepository;
import es.ulpgc.fitmanager.model.Activity;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class GetReservationByClientIdAction {

    public GetReservationByClientIdAction() {
        reservationRepository = new ReservationRepository();
    }

    private final ReservationRepository reservationRepository;

    public List<Activity> execute(Connection conn, Integer userId) {
        return reservationRepository.getActivities(conn, userId);
    }
}
