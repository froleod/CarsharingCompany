package com.ldf.carsharingcompany.Service;

import com.ldf.carsharingcompany.Entity.Trip;
import com.ldf.carsharingcompany.Repo.TripRepository;
import com.ldf.carsharingcompany.Repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Service
@Slf4j
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private UserRepository userRepository;

    public int getTripCountForUser(String username) {
        Long userId = userRepository.findByUsername(username).getId();
        if (userId == null) {
            log.error("Пользователь с именем {} не найден", username);
            return 0;
        }

        List<Trip> trips = tripRepository.findByUserId(userId);
        int tripCount = trips.size();

        log.info("Пользователь {} имеет {} поездок", username, tripCount);
        return tripCount;
    }

    public String getFormattedTripTimeForUser(String username) {
        Long userId = userRepository.findByUsername(username).getId();
        if (userId == null) {
            log.error("Пользователь с именем {} не найден", username);
            return "Нет данных о времени поездок";
        }

        List<Trip> trips = tripRepository.findByUserId(userId);
        int totalSeconds = 0;
        for (Trip trip : trips) {
            String[] timeParts = trip.getTripTime().split(":");
            int minutes = Integer.parseInt(timeParts[0]);
            int seconds = Integer.parseInt(timeParts[1]);
            totalSeconds += minutes * 60 + seconds;
        }

        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        String formattedTime = String.format("%d минут %d секунд", minutes, seconds);

        log.info("Время поездок для пользователя {}: {}", username, formattedTime);
        return formattedTime;
    }
}
