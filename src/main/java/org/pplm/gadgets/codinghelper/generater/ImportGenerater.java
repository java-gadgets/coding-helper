package org.pplm.gadgets.codinghelper.generater;

import org.apache.commons.lang3.StringUtils;
import org.pplm.gadgets.codinghelper.config.TypeConfig;

public class ImportGenerater extends Generater {

	public static final String REPLACED_IMPORT_SRC = KEY_LEFT + "IMPORT_SRC" + KEY_RIGHT;
	
	private String type;
	
	public ImportGenerater(String template, TypeConfig typeConfig) {
		super(template, typeConfig);
	}

	@Override
	protected String genSrcImpl() {
		String importSrc = typeConfig.getImportSrc(type);
		if(StringUtils.isBlank(importSrc)) {
			return "";
		}
		return template.replaceAll(REPLACED_IMPORT_SRC, importSrc);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
