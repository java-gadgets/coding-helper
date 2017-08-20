package org.pplm.gadgets.codinghelper.entity.metadata;

import java.util.Collection;
import java.util.Map;
/**
 * 
 * @author OracleGao
 *
 */
public class Relation {
	private String name;
	private Collection<String> entityTuple;
	private Collection<Entity> entityInstTuple;
	private Map<String, Collection<String>> filter;

	public Relation() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<String> getEntityTuple() {
		return entityTuple;
	}

	public void setEntityTuple(Collection<String> entityTuple) {
		this.entityTuple = entityTuple;
	}

	public Collection<Entity> getEntityInstTuple() {
		return entityInstTuple;
	}

	public void setEntityInstTuple(Collection<Entity> entityInstTuple) {
		this.entityInstTuple = entityInstTuple;
	}

	public Map<String, Collection<String>> getFilter() {
		return filter;
	}

	public void setFilter(Map<String, Collection<String>> filter) {
		this.filter = filter;
	}
	
}
