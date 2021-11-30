package de.hfu.repository;

import java.util.List;

import de.hfu.domain.Resident;


/**
 * @author Stefan Betermieux
 */
public interface ResidentRepository {

  List<Resident> getResidents();

}