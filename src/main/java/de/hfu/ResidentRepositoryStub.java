package de.hfu;

import de.hfu.domain.Resident;
import de.hfu.repository.ResidentRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResidentRepositoryStub implements ResidentRepository {

    List<Resident> residentUser = new ArrayList<>();

    public void addUser(Resident resident)
    {

        residentUser.add(resident);
    }

    @Override
    public List<Resident> getResidents() {
        return residentUser;
    }
}
