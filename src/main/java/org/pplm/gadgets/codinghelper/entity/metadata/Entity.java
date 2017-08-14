package org.pplm.gadgets.codinghelper.entity.metadata;

import java.util.Collection;
/**
 * 
 * @author OracleGao
 *
 */
public class Entity {
	private String name;
	private Collection<EntityAttr> attrs;
	private boolean extended;
	
	public Entity() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<EntityAttr> getAttrs() {
		return attrs;
	}

	public void setAttrs(Collection<EntityAttr> attrs) {
		this.attrs = attrs;
	}

	public boolean isExtended() {
		return extended;
	}

	public void setExtended(boolean extended) {
		this.extended = extended;
	}
	
}
