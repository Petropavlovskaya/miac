package by.bsc.miac.daoToDelete.hibernate;

import by.bsc.miac.daoToDelete.IReportRepository;
import by.bsc.miac.entity.MaterialEntity;
import by.bsc.miac.entity.OrganizationEntity;
import by.bsc.miac.entity.ReportEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HibernateReportRepository implements IReportRepository {
    // persistenceUnitName take from file "persistence.xml"
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("MIAC");

    @Override
    public ReportEntity addReport(float produceAll, float produceMonth, float onvrAll, float onvrMonth,
                                  float exportUnitAll, float exportUnitMonth, float exportMoneyAll, float exportMoneyMonth,
                                  Date date, OrganizationEntity organizationEntity, MaterialEntity materialEntity) {

        final EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();

        EntityTransaction entityTransaction = null;
        ReportEntity reportEntity = new ReportEntity();
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            reportEntity.setProduceAll(produceAll);
            reportEntity.setProduceMonth(produceMonth);
            reportEntity.setOnvrAll(onvrAll);
            reportEntity.setOnvrMonth(onvrMonth);
            reportEntity.setExportUnitAll(exportUnitAll);
            reportEntity.setExportUnitMonth(exportUnitMonth);
            reportEntity.setExportMoneyAll(exportMoneyAll);
            reportEntity.setExportMoneyMonth(exportMoneyMonth);

            entityManager.persist(reportEntity);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        } finally {
            entityManager.close();
        }
        return reportEntity;
    }

    @Override
    public ReportEntity findReport(int id) {
        return null;
    }

    @Override
    public boolean deleteReport(int id) {
        return false;
    }

    @Override
    public boolean updateReport(int id) {
        return false;
    }

    @Override
    public List<ReportEntity> getAllReports() {
        final EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        String sqlQuery = "SELECT s FROM ReportEntity s"; // "SELECT s FROM Student s" - Student here is a class name
        TypedQuery<ReportEntity> query = entityManager.createQuery(sqlQuery, ReportEntity.class);
        List<ReportEntity> resultList = new ArrayList<>();
        try {
            resultList.addAll(query.getResultList());
        } finally {
            entityManager.close();
        }
        return resultList;
    }
}
/*
    private static void updateStudent(int id, String newPhone) {
        final EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;
        Student student;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            student = entityManager.find(Student.class, id);
            student.setPhone(newPhone);
            entityManager.persist(student);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
        }finally {
            entityManager.close();
        }

    }
*/
