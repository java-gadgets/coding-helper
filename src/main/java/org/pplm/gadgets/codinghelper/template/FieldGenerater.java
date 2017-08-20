package org.pplm.gadgets.codinghelper.template;

import org.apache.commons.lang3.StringUtils;
import org.pplm.gadgets.codinghelper.config.TypeConfig;

public class FieldGenerater extends Generater {

	private String fieldName;
	private String type;
	
	public FieldGenerater(String template, TypeConfig typeConfig) {
		super(template, typeConfig);
	}

	@Override
	public String genSrc() {
		return template.replaceAll(REPLACED_FIELD_NAME, fieldName)
		.replaceAll(REPLACED_FIELD_NAME_CAP, StringUtils.capitalize(fieldName))
		.replaceAll(REPLACED_TYPE, typeConfig.getKeySrc(type));
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
