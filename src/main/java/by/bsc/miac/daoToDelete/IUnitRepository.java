package by.bsc.miac.daoToDelete;


import by.bsc.miac.entity.UnitEntity;

import java.util.List;

public interface IUnitRepository {
    UnitEntity addUnit(UnitEntity unit);
    UnitEntity findUnit(int id);
    boolean deleteUnit(int id);
    boolean updateUnit(int id);
    List<UnitEntity> getAllUnits();
}
