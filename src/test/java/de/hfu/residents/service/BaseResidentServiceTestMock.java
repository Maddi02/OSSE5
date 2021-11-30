package de.hfu.residents.service;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class BaseResidentServiceTestMock {

    BaseResidentService baseResidentService = new BaseResidentService();
    List<Resident> list = new ArrayList<Resident>();
    Resident Martin = new Resident("Martin", "Hummel","West Wien" , "Wien", new Date(2002,1,10));
    Resident Andi = new Resident("Andi", "Disch","In Fuwa" , "Freiburg", new Date(1998,1,8));
    Resident Jan = new Resident("Jan ", "Bühler","In Fuwa" , "Furtwangen", new Date(10,1,1994));
    Resident limit  = new Resident("*", "*", "*", "*",null);

    @Test
    public void getUniqueResident() throws ResidentServiceException {

        ResidentRepository residentRepository = createMock(ResidentRepository.class);
        list.add(Martin);
        list.add(Andi);
        list.add(Jan);

        expect(residentRepository.getResidents()).andReturn(list).times(3);
        baseResidentService.setResidentRepository(residentRepository);
        replay(residentRepository);

        Resident martin = baseResidentService.getUniqueResident(Martin);
        Resident martinTest = new Resident("Martin", "Hummel","West Wien" , "Wien", new Date(2002,1,10));
        assertEquals(martin.getFamilyName(),martinTest.getFamilyName());

        Resident andi = baseResidentService.getUniqueResident(Andi);
        Resident AndiTest = new Resident("Andi", "Disch","In Fuwa" , "Freiburg", new Date(1998,1,8));
        assertEquals(andi.getStreet(),AndiTest.getStreet());

        Resident jan = baseResidentService.getUniqueResident(Jan);
        Resident JanTest = new Resident("Jan ", "Bühler","In Fuwa" , "Furtwangen", new Date(10,1,1994));
        assertEquals(jan.getStreet(),JanTest.getStreet());

        verify(residentRepository);
    }

    @Test
    public void getFilteredResidentsList() {
        ResidentRepository residentRepository = createMock(ResidentRepository.class);
        list.add(Martin);
        list.add(Andi);
        list.add(Jan);

        expect(residentRepository.getResidents()).andReturn(list).times(6);
        baseResidentService.setResidentRepository(residentRepository);
        replay(residentRepository);


        Resident suchMatixStraßeFamilyName = new Resident("", "D*","In*" , "", null);
        Resident suchMatixStraße = new Resident("", "","In*" , "", null);
        Resident suchMatixFamilyName = new Resident("", "D*","" , "", null);
        Resident suchMatixGivenName = new Resident("M*", "","" , "", null);
        Resident suchMatixNotFound = new Resident("Z*", "","In*" , "", null);
        Resident suchMatixLimit = new Resident("", "","" , "", null);

        List<Resident> list = baseResidentService.getFilteredResidentsList(suchMatixFamilyName);
        assertThat(list.get(0).getFamilyName(), is(Andi.getFamilyName()));

        list = baseResidentService.getFilteredResidentsList(suchMatixStraßeFamilyName);
        assertThat(list.get(0).getFamilyName(), is(Andi.getFamilyName()));

        list = baseResidentService.getFilteredResidentsList(suchMatixStraße);
        assertThat(list.get(0).getFamilyName(),is(Andi.getFamilyName()));
        assertThat(list.get(1).getFamilyName(),is(Jan.getFamilyName()));

        list = baseResidentService.getFilteredResidentsList(suchMatixGivenName);
        assertThat(list.get(0).getGivenName(),is(Martin.getGivenName()));

        list = baseResidentService.getFilteredResidentsList(suchMatixNotFound);
        assertThat( list.size(), is(0));


        list = baseResidentService.getFilteredResidentsList(suchMatixLimit);
        assertThat(list.get(0).getGivenName(), is(Martin.getGivenName()));
        assertThat(list.get(1).getGivenName() , is(Andi.getGivenName()));
        assertThat(list.get(2).getGivenName() , is(Jan.getGivenName()));

        verify(residentRepository);
    }
}