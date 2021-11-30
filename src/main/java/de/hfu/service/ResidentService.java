package de.hfu.service;

import java.util.List;

import de.hfu.domain.Resident;

/**
 * @author Stefan Betermieux
 */
public interface ResidentService {

  Resident getUniqueResident(Resident filterResident) throws  ResidentServiceException, ResidentServiceException;

  List<Resident> getFilteredResidentsList(Resident filterResident);

}