package by.bsc.miac.daoToDelete;

import by.bsc.miac.entity.MaterialEntity;

import java.util.List;

public interface IMaterialRepository {
    MaterialEntity addMaterial(MaterialEntity material);
    MaterialEntity findMaterial(int id);
    boolean deleteMaterial(int id);
    boolean updateMaterial(int id);
    List<MaterialEntity> getAllMaterials();
}
