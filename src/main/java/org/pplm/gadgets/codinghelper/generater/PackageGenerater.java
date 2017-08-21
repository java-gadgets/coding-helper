package org.pplm.gadgets.codinghelper.generater;

import org.pplm.gadgets.codinghelper.config.TypeConfig;

public class PackageGenerater extends Generater {

	private String packagePrefix;
	private String packageName;
	
	public PackageGenerater(String template, TypeConfig typeConfig) {
		super(template, typeConfig);
	}

	@Override
	protected String genSrcImpl() {
		return this.template.replaceAll(REPLACED_PACKAGE_PREFIX, packagePrefix)
		.replaceAll(REPLACED_PACKAGE_NAME, packageName);
	}

	public String getPackagePrefix() {
		return packagePrefix;
	}

	public void setPackagePrefix(String packagePrefix) {
		this.packagePrefix = packagePrefix;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

}
