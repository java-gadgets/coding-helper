package org.pplm.gadgets.codinghelper.template;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.pplm.gadgets.codinghelper.config.TypeConfig;

/**
 * 
 * @author OracleGao
 *
 */
public class ClasssGenerater extends Generater {
	
	private String className;
	private String packageSrc;
	private Collection<String> imports;
	private String extend;
	private List<FieldGenerater> getters = new ArrayList<>();
	private List<FieldGenerater> setters = new ArrayList<>();
	private List<FieldGenerater> fields = new ArrayList<>();
	
	public ClasssGenerater(String template, TypeConfig typeConfig) {
		super(template, typeConfig);
	}
	
	public void setClassName(String className) {
		template = template.replaceAll(REPLACED_CLASS_NAME, className);
	}
	
	public void replacePackageStr(String packageStr) {
		template = template.replaceAll(REPLACED_PACKAGE, packageStr);
	}
	
	public void addGetterGenerater(){
		
	}

	@Override
	public String genSrc() {
		// TODO Auto-generated method stub
		return null;
	}
}
