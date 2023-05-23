package ru.rut.telegram.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rut.telegram.Model.Work;

import java.util.List;

@Repository
public interface WorkDao extends JpaRepository<Work, Integer> {

    List<Work> findAllByEmployeeLogin(String login);
}