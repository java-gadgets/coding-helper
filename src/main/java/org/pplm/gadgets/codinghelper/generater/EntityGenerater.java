package org.pplm.gadgets.codinghelper.generater;

import java.util.Collection;

import org.pplm.gadgets.codinghelper.entity.metadata.Entity;
import org.pplm.gadgets.codinghelper.entity.metadata.EntityAttr;
import org.pplm.gadgets.codinghelper.template.EntityTemplateManager;

/**
 * 
 * @author OracleGao
 *
 */
public class EntityGenerater {

	private EntityTemplateManager entityTemplateManager;
	
	private String packageStr;
	private String className;
	private String extend;
	private Collection<EntityAttr> entityAttrs;
	
	public EntityGenerater(EntityTemplateManager entityTemplateManager) {
		super();
		this.entityTemplateManager = entityTemplateManager;
	}

	public void generate() {
		String replaced = packageStr;
		
	}
	
	private String generateImports() {
		return null;
	}
	
	private String generateGetters() {
		return null;
	}
	
	private String generateSetters() {
		return null;
	}
	
	private String generateAttrs() {
		return null;
	}
	
	
	public String getPackageStr() {
		return packageStr;
	}

	public void setPackageStr(String packageStr) {
		this.packageStr = packageStr;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public Collection<EntityAttr> getEntityAttrs() {
		return entityAttrs;
	}

	public void setEntityAttrs(Collection<EntityAttr> entityAttrs) {
		this.entityAttrs = entityAttrs;
	}

}
