package org.pplm.gadgets.codinghelper.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.pplm.gadgets.codinghelper.entity.Type;

public class TypeConfig {

	private Map<String, Type> typeMap = new HashMap<>();

	public TypeConfig(Collection<Type> types) {
		super();
		types.forEach(type -> {
			typeMap.put(type.getType(), type);
		});
	}

	public String getImportSrc(String type) {
		if (typeMap.containsKey(type)) {
			return typeMap.get(type).getImportSrc();
		}
		return null;
	}

	public Collection<String> getImportSrcs(final Collection<String> types) {
		return typeMap.values().stream()
				.filter(type -> types.contains(type.getType()) && StringUtils.isNotBlank(type.getImportSrc()))
				.map(type -> type.getImportSrc()).collect(Collectors.toList());
	}

	public String getKeySrc(String type) {
		if (typeMap.containsKey(type)) {
			String keySrc = typeMap.get(type).getKeySrc();
			if (StringUtils.isNotBlank(keySrc)) {
				return keySrc;
			}
		}
		return type;
	}
	
}
