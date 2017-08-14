package org.pplm.gadgets.codinghelper.entity;
/**
 * 
 * @author OracleGao
 *
 */
public class Type {
	/**
	 * 元数据metadata.json中attr.type使用的类型
	 */
	private String type;
	
	/**
	 * 需要在代码开始时导入的类声明
	 */
	private String importStr;
	
	/**
	 * 代码中组装的类型字符串
	 */
	private String srcKey;

	public Type() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImportStr() {
		return importStr;
	}

	public void setImportStr(String importStr) {
		this.importStr = importStr;
	}

	public String getSrcKey() {
		return srcKey;
	}

	public void setSrcKey(String srcKey) {
		this.srcKey = srcKey;
	}
	
}
