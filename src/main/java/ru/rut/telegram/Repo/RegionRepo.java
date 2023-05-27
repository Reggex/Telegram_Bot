package ru.rut.telegram.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rut.telegram.Model.Employee;
import ru.rut.telegram.Model.Region;

import java.util.List;

public interface RegionRepo extends JpaRepository<Employee, Integer> {

    List<Region> findAllByNumberIn(List<Integer> numbers);
}
