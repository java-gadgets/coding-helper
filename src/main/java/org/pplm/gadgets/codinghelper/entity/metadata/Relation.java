package org.pplm.gadgets.codinghelper.entity.metadata;

import java.util.Collection;
/**
 * 
 * @author OracleGao
 *
 */
public class Relation {
	private String name;
	private Collection<String> entityTuple;
	private Collection<Entity> entityInstTuple;
	
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
	
}
