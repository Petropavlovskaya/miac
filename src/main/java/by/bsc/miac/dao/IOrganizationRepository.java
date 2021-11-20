package by.bsc.miac.dao;

import by.bsc.miac.entity.OrganizationEntity;

import java.util.List;

public interface IOrganizationRepository {
    OrganizationEntity addOrganization(OrganizationEntity organization);
    OrganizationEntity findOrganization(int id);
    boolean deleteOrganization(int id);
    boolean updateOrganization(int id);
    List<OrganizationEntity> getAllOrganizations();
}
