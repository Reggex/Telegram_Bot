package ru.rut.telegram.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rut.telegram.Model.Employee;
import ru.rut.telegram.Model.Work;
import ru.rut.telegram.Model.WorkRegion;

import java.util.List;

public interface WorkRegionRepo extends JpaRepository<Employee, Integer> {

    List<WorkRegion> findByWork(Work work);
}
