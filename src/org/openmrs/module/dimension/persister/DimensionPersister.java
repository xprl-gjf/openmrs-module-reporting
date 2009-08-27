package org.openmrs.module.dimension.persister;

import java.util.List;

import org.openmrs.api.APIException;
import org.openmrs.module.indicator.dimension.Dimension;

/**
 * This interface exposes the functionality required to access the Data Access
 * functionality for a particular set of Dimension implementations
 */
public interface DimensionPersister {

	/**
	 * Gets the {@link Dimension} that matches the given id
	 * 
	 * @param id the id to match
	 * @return the {@link Dimension} with the given id among those managed by this persister
	 * 
	 * @should return null when does not exist
	 * @should return dimension when exists
	 */
	public Dimension getDimension(Integer id);
	
	/**
	 * Gets the {@link Dimension} that matches the given uuid
	 * 
	 * @param uuid	the uuid to match
	 * @return the {@link Dimension} with the given uuid among those managed by this persister
	 * 
	 * @should return null when does not exist
	 * @should return dimension when exists
	 */
	public Dimension getDimensionByUuid(String uuid);
	
	/**
	 * @param includeRetired - if true, include retired {@link Dimension}s in the returned List
	 * @return All {@link Dimension}s whose persistence is managed by this persister
	 * 
	 * @should get all dimensions including retired
	 * @should get all dimensions not including retired
	 */
	public List<Dimension> getAllDimensions(boolean includeRetired);
	
	/**
	 * Returns a List of {@link Dimension} whose name contains the passed name.
	 * An empty list will be returned if there are none found. Search is case insensitive.
	 * 
	 * @param name The search string
	 * @param exactMatchOnly if true will only return exact matches
	 * 
	 * @throws APIException
	 * @return a List<Dimension> objects whose name contains the passed name
	 */
	public List<Dimension> getDimensions(String name, boolean exactMatchOnly);
	
	/**
	 * Saves the given {@link Dimension} to the system.
	 * 
	 * @param dimension	the {@link Dimension} to save
	 * @return the {@link Dimension} that was saved 
	 * 
	 * @should create new dimension
	 * @should update existing dimension
	 * @should set identifier after save
	 */
	public Dimension saveDimension(Dimension dimension);
	
	/**
	 * Deletes a {@link Dimension} from the system.
	 * 
	 * @param dimension the {@link Dimension} to purge
	 * 
	 * @should remove the dimension
	 */
	public void purgeDimension(Dimension dimension);
}
