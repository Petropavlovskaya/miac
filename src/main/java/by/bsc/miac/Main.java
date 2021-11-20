package by.bsc.miac;

import by.bsc.miac.entity.OrganizationEntity;

public class Main {
    public static void main(String[] args) {
        OrganizationEntity entity = new OrganizationEntity();
        entity.setId(5);
        entity.setName("BSC");
        entity.setMAiS(true);

        System.out.println(entity.toString());
    }
}
