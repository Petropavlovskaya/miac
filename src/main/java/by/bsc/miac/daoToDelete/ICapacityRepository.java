package by.bsc.miac.daoToDelete;

import by.bsc.miac.entity.CapacityEntity;

import java.util.List;

public interface ICapacityRepository {
    CapacityEntity addCapacity(CapacityEntity capacity);
    CapacityEntity findCapacity(int id);
    boolean deleteCapacity(int id);
    boolean updateCapacity(int id);
    List<CapacityEntity> getAllCapacities();
}
