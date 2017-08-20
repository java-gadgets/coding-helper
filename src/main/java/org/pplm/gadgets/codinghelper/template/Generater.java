package org.pplm.gadgets.codinghelper.template;

import java.util.function.Function;

import org.pplm.gadgets.codinghelper.config.TypeConfig;

/**
 * 
 * @author OracleGao
 *
 */
public abstract class Generater {

	public static final String KEY_LEFT = "${";
	public static final String KEY_RIGHT = "}";
	
	public static final String REPLACED_CLASS_NAME = KEY_LEFT + "CLASS_NAME" + KEY_RIGHT;
	public static final String REPLACED_PACKAGE = KEY_LEFT + "PACKAGE" + KEY_RIGHT;
	public static final String REPLACED_FIELD_NAME = KEY_LEFT + "FIELD_NAME" + KEY_RIGHT;
	public static final String REPLACED_FIELD_NAME_CAP = KEY_LEFT + "FIELD_NAME_CAP" + KEY_RIGHT;
	public static final String REPLACED_TYPE = KEY_LEFT + "TYPE" + KEY_RIGHT;
	public static final String REPLACED_IMPORTS = KEY_LEFT + "IMPORTS" + KEY_RIGHT;
	
	protected TypeConfig typeConfig;
	
	protected String template;
	
	public Generater(String template, TypeConfig typeConfig) {
		super();
		this.template = template;
	}

	public abstract String genSrc();
	
	public void genSrc(Function<String, Void> fun) {
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
