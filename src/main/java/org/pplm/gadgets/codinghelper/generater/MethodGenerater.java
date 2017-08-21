package org.pplm.gadgets.codinghelper.generater;

import org.apache.commons.lang3.StringUtils;
import org.pplm.gadgets.codinghelper.config.TypeConfig;

public class MethodGenerater extends FieldGenerater {

	public MethodGenerater(String template, TypeConfig typeConfig) {
		super(template, typeConfig);
	}

	@Override
	protected String genSrcImpl() {
		return super.genSrcImpl().replaceAll(REPLACED_FIELD_NAME_CAP, StringUtils.capitalize(fieldName));
	}

}
