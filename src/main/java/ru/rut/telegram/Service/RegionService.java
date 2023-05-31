package ru.rut.telegram.Service;

import ru.rut.telegram.Model.Region;

import java.util.List;

public interface RegionService {

    List<Region> getAllRegions();

    List<Region> getByNumbers(List<Integer> numbers);
}
