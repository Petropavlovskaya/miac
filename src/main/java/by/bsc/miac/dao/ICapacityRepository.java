package by.bsc.miac.dao;

import by.bsc.miac.entity.CapacityEntity;
import by.bsc.miac.entity.OrganizationEntity;

import java.util.List;

public interface ICapacityRepository {
    CapacityEntity addCapacity(CapacityEntity capacity);
    CapacityEntity findCapacity(int id);
    boolean deleteCapacity(int id);
    boolean updateCapacity(int id);
    List<CapacityEntity> getAllCapacities();
}
