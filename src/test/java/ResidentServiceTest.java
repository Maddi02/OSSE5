
import de.hfu.ResidentRepositoryStub;
import de.hfu.domain.Resident;
import de.hfu.repository.ResidentRepository;
import de.hfu.service.BaseResidentService;
import de.hfu.service.ResidentService;
import de.hfu.service.ResidentServiceException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ResidentServiceTest {

    ResidentRepositoryStub residentRepositoryStub = new ResidentRepositoryStub();

    Resident Martin = new Resident("Martin", "Hummel","West Wien" , "Wien", new Date(2002,1,10));
    Resident Andi = new Resident("Andi", "Disch","In Fuwa" , "Freiburg", new Date(1998,1,8));
    Resident Jan = new Resident("Jan ", "Bühler","In Fuwa" , "Furtwangen", new Date(10,1,1994));

    @Test
    public void getUniqueResident() {
        BaseResidentService baseResidentService = new BaseResidentService();
        residentRepositoryStub.addUser(Martin);
        residentRepositoryStub.addUser(Andi);
        residentRepositoryStub.addUser(Jan);
        Resident nicht = new Resident("X", "Y","In Fuwa" , "Furtwangen", new Date(10,1,1994));
        baseResidentService.setResidentRepository(residentRepositoryStub);

        try
        {
            assertEquals(Martin, baseResidentService.getUniqueResident(Martin));
            assertEquals(Andi, baseResidentService.getUniqueResident(Andi));
            assertEquals(Jan, baseResidentService.getUniqueResident(Jan));
        }
         catch (ResidentServiceException e) {
             System.out.println("Bitte nicht");
        }

        try{
            baseResidentService.getUniqueResident(nicht);
            assertEquals(nicht, baseResidentService.getUniqueResident(nicht));
        }
        catch (ResidentServiceException e) {
            System.out.println("Bitte geb was aus");
        }
    }

    @Test
    public void getFilteredResidentsList() {
        BaseResidentService baseResidentService = new BaseResidentService();
        residentRepositoryStub.addUser(Martin);
        residentRepositoryStub.addUser(Andi);
        residentRepositoryStub.addUser(Jan);
        Resident suchMatixStraßeFamilyName = new Resident("", "D*","In*" , "", null);
        Resident suchMatixStraße = new Resident("", "","In*" , "", null);
        Resident suchMatixFamilyName = new Resident("", "D*","" , "", null);
        Resident suchMatixGivenName = new Resident("M*", "","" , "", null);
        Resident suchMatixNotFound = new Resident("Z*", "","In*" , "", null);
        baseResidentService.setResidentRepository(residentRepositoryStub);

        List<Resident> list = baseResidentService.getFilteredResidentsList(suchMatixStraße);
        assertEquals(Andi.getFamilyName(),list.get(0).getFamilyName());
        assertEquals(Jan.getFamilyName(),list.get(1).getFamilyName());
        list = baseResidentService.getFilteredResidentsList(suchMatixNotFound);
        assertEquals(0,list.size());
        list = baseResidentService.getFilteredResidentsList(suchMatixStraßeFamilyName);
        assertEquals(Andi.getFamilyName(),list.get(0).getFamilyName());
        list = baseResidentService.getFilteredResidentsList(suchMatixGivenName);
        assertEquals(Martin.getGivenName(),list.get(0).getGivenName());
        list = baseResidentService.getFilteredResidentsList(suchMatixFamilyName);
        assertEquals(Andi.getGivenName(),list.get(0).getGivenName());




    }




}