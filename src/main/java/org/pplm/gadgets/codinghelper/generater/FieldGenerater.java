package org.pplm.gadgets.codinghelper.generater;

import org.pplm.gadgets.codinghelper.config.TypeConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FieldGenerater extends Generater {
	private static Logger logger = LoggerFactory.getLogger(FieldGenerater.class);
	
	protected String fieldName;
	private String type;
	
	public FieldGenerater(String template, TypeConfig typeConfig) {
		super(template, typeConfig);
	}

	@Override
	protected String genSrcImpl() {
		String content = template.replaceAll(REPLACED_FIELD_NAME, fieldName);
		logger.debug(type + "," + typeConfig.getKeySrc(type));
		content = content.replaceAll(REPLACED_TYPE, typeConfig.getKeySrc(type));
		return content;
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
