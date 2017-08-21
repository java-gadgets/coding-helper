package org.pplm.gadgets.codinghelper.generater;

import org.apache.commons.lang3.StringUtils;
import org.pplm.gadgets.codinghelper.config.TypeConfig;

public class ClassExtendsGenerater extends Generater {

	public static final String REPLACED_CLASS_EXTEND = KEY_LEFT + "CLASS_EXTEND" + KEY_RIGHT;
	
	private String extend;
	
	public ClassExtendsGenerater(String template, TypeConfig typeConfig) {
		super(template, typeConfig);
	}

	@Override
	protected String genSrcImpl() {
		if (StringUtils.isBlank(extend)) {
			return "";
		}
		return template.replaceAll(REPLACED_CLASS_EXTEND, extend);
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

}
