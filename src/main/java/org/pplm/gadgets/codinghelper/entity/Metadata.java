package org.pplm.gadgets.codinghelper.entity;

import java.util.Collection;

import org.pplm.gadgets.codinghelper.entity.metadata.Config;
import org.pplm.gadgets.codinghelper.entity.metadata.Entity;
import org.pplm.gadgets.codinghelper.entity.metadata.Relation;
/**
 * 
 * @author OracleGao
 *
 */
public class Metadata {
	private String name;
	private Collection<Entity> entities;
	private Collection<Relation> relations;
	private Config config;

	public Metadata() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Entity> getEntities() {
		return entities;
	}

	public void setEntities(Collection<Entity> entities) {
		this.entities = entities;
	}

	public Collection<Relation> getRelations() {
		return relations;
	}

	public void setRelations(Collection<Relation> relations) {
		this.relations = relations;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}
	
}
