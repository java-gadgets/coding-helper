package org.pplm.gadgets.codinghelper.generater;

import java.util.function.Function;

import org.pplm.gadgets.codinghelper.config.TypeConfig;

/**
 * 
 * @author OracleGao
 *
 */
public abstract class Generater {

	public static final String KEY_LEFT = "\\$\\{";
	public static final String KEY_RIGHT = "\\}";
	
	public static final String REPLACED_CLASS_NAME =     KEY_LEFT + "CLASS_NAME" + KEY_RIGHT;
	public static final String REPLACED_PACKAGE =        KEY_LEFT + "PACKAGE" + KEY_RIGHT;
	public static final String REPLACED_FIELD_NAME =     KEY_LEFT + "FIELD_NAME" + KEY_RIGHT;
	public static final String REPLACED_FIELD_NAME_CAP = KEY_LEFT + "FIELD_NAME_CAP" + KEY_RIGHT;
	public static final String REPLACED_TYPE =           KEY_LEFT + "TYPE" + KEY_RIGHT;
	public static final String REPLACED_IMPORTS =        KEY_LEFT + "IMPORTS" + KEY_RIGHT;
	public static final String REPLACED_METHODS =        KEY_LEFT + "METHODS" + KEY_RIGHT;
	public static final String REPLACED_FIELDS =         KEY_LEFT + "FIELDS" + KEY_RIGHT;
	public static final String REPLACED_PACKAGE_PREFIX = KEY_LEFT + "PACKAGE_PREFIX" + KEY_RIGHT;
	public static final String REPLACED_PACKAGE_NAME =   KEY_LEFT + "PACKAGE_NAME" + KEY_RIGHT;
	public static final String REPLACED_EXTENDS =        KEY_LEFT + "EXTENDS" + KEY_RIGHT;
	
	protected TypeConfig typeConfig;
	
	protected String template;
	
	private String src;
	
	public Generater(String template, TypeConfig typeConfig) {
		super();
		this.template = template;
		this.typeConfig = typeConfig;
	}

	public final String genSrc() {
		return genSrc(false);
	}
	
	public final String genSrc(boolean regen) {
		if (src == null) {
			src = genSrcImpl();
		} else {
			if(regen) {
				src = genSrcImpl();
			}
		}
		return src;
	}
	
	protected abstract String genSrcImpl();
	
	public final void genSrc(Function<String, Void> fun) {
		fun.apply(genSrc());
	}
	
	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public TypeConfig getTypeConfig() {
		return typeConfig;
	}

	public void setTypeConfig(TypeConfig typeConfig) {
		this.typeConfig = typeConfig;
	}

}
