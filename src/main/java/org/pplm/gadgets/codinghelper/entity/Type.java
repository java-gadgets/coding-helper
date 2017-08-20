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
	private String importSrc;
	
	/**
	 * 代码中组装的类型字符串
	 */
	private String keySrc;

	public Type() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImportSrc() {
		return importSrc;
	}

	public void setImportSrc(String importSrc) {
		this.importSrc = importSrc;
	}

	public String getKeySrc() {
		return keySrc;
	}

	public void setKeySrc(String keySrc) {
		this.keySrc = keySrc;
	}
	
}
