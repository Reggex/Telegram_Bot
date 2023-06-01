package ru.rut.telegram.Service;

import ru.rut.telegram.Model.Work;
import ru.rut.telegram.Model.WorkRegion;

import java.util.List;

public interface WorkRegionService {

    void save(WorkRegion workRegion);

    List<WorkRegion> getByWork(Work work);

}
