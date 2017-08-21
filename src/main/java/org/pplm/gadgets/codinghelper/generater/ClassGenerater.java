package org.pplm.gadgets.codinghelper.generater;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.pplm.gadgets.codinghelper.config.TypeConfig;

/**
 * 
 * @author OracleGao
 *
 */
public class ClassGenerater extends Generater {

	private String className;
	private PackageGenerater pack;
	private List<ImportGenerater> imports = new ArrayList<>();
	private ClassExtendsGenerater extend;
	private List<FieldGenerater> fields = new ArrayList<>();
	private List<MethodGenerater> methods = new ArrayList<>();

	public ClassGenerater(String template, TypeConfig typeConfig) {
		super(template, typeConfig);
	}

	public void addImport(ImportGenerater imp) {
		this.imports.add(imp);
	}

	public void addField(FieldGenerater field) {
		this.fields.add(field);
	}

	public void addFields(Collection<FieldGenerater> fields) {
		this.fields.addAll(fields);
	}

	public void addMethod(MethodGenerater method) {
		this.methods.add(method);
	}

	public void addMethods(Collection<MethodGenerater> methods) {
		this.methods.addAll(methods);
	}

	@Override
	protected String genSrcImpl() {
		String importsSrc = genImportsSrc();
		String fieldsSrc = genFieldsSrc();
		String methodsSrc = genMethodsSrc();
		return this.template.replaceAll(REPLACED_CLASS_NAME, className).replaceAll(REPLACED_PACKAGE, pack.genSrc())
				.replaceAll(REPLACED_EXTENDS, extend.genSrc())
				.replaceAll(REPLACED_IMPORTS, importsSrc).replaceAll(REPLACED_FIELDS, fieldsSrc)
				.replaceAll(REPLACED_METHODS, methodsSrc);
	}

	private String genImportsSrc() {
		return imports.stream().map(imp -> imp.genSrc()).distinct().filter(StringUtils::isNoneBlank)
				.collect(Collectors.joining(IOUtils.LINE_SEPARATOR));
	}

	private String genFieldsSrc() {
		return fields.stream().map(field -> field.genSrc()).collect(Collectors.joining(IOUtils.LINE_SEPARATOR));
	}

	private String genMethodsSrc() {
		return methods.stream().map(method -> method.genSrc()).collect(Collectors.joining(IOUtils.LINE_SEPARATOR));
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public PackageGenerater getPack() {
		return pack;
	}

	public void setPack(PackageGenerater pack) {
		this.pack = pack;
	}

	public List<ImportGenerater> getImports() {
		return imports;
	}

	public void setImports(List<ImportGenerater> imports) {
		this.imports = imports;
	}

	public ClassExtendsGenerater getExtend() {
		return extend;
	}

	public void setExtend(ClassExtendsGenerater extend) {
		this.extend = extend;
	}

	public List<FieldGenerater> getFields() {
		return fields;
	}

	public void setFields(List<FieldGenerater> fields) {
		this.fields = fields;
	}

	public List<MethodGenerater> getMethods() {
		return methods;
	}

	public void setMethods(List<MethodGenerater> methods) {
		this.methods = methods;
	}

}
