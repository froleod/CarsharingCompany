package com.ldf.carsharingcompany.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
@Slf4j
public class TripService {

    @PersistenceContext
    private EntityManager entityManager;

    public int getTripCountForUser(String username) {
        // Создаем SQL запрос для получения количества поездок для пользователя
        String sqlQuery = "SELECT COUNT(*) FROM trip WHERE user_id = (SELECT id FROM users WHERE username = ?)";

        // Создаем запрос с помощью EntityManager
        Query query = entityManager.createNativeQuery(sqlQuery);
        query.setParameter(1, username);

        // Выполняем запрос и получаем результат
        Number result = (Number) query.getSingleResult();

        // Возвращаем количество поездок
        log.info("User " + username + " has " + result.intValue() + " trips");
        return result.intValue();
    }
}
