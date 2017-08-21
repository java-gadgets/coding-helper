package org.pplm.gadgets.codinghelper.template;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.pplm.gadgets.codinghelper.config.TemplateConfig;
import org.pplm.gadgets.codinghelper.config.TypeConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class TemplateManager {
	private Logger logger = LoggerFactory.getLogger(TemplateManager.class);
		
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private TemplateConfig templateConfig;
	
	@Autowired
	private TypeConfig typeConfig;

	private Map<String, String> templateMap = new HashMap<>();
	
	protected String name;
	protected String path;
	
	public TemplateManager(String name) {
		super();
		this.name = name;
	}

	public String getTemplate(String templateName) {
		return templateMap.get(templateName);
	}
	
	@PostConstruct
	public void initTemplate() throws JsonParseException, JsonMappingException, IOException {
		this.path = templateConfig.getPath() + '/' + name;
		final File templatePath = resourceLoader.getResource(path).getFile();
		File file = new File(templatePath, templateConfig.getConfig());
		Map<String, String> configMap = objectMapper.readValue(file, new TypeReference<Map<String, String>>(){});
		configMap.forEach((key, value) -> {
			try {
				File templateFile = new File(templatePath, value);
				String template = FileUtils.readFileToString(templateFile, templateConfig.getEncoding());
				templateMap.put(key, template);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		});
	}

	public <T> T getGenerater(String templateName, Class<T> clazz) {
		String template = getTemplate(templateName);
		try {
			return (T) clazz.getConstructor(String.class, TypeConfig.class).newInstance(template, typeConfig);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public TemplateConfig getTemplateConfig() {
		return templateConfig;
	}

	public void setTemplateConfig(TemplateConfig templateConfig) {
		this.templateConfig = templateConfig;
	}

	public TypeConfig getTypeConfig() {
		return typeConfig;
	}

	public void setTypeConfig(TypeConfig typeConfig) {
		this.typeConfig = typeConfig;
	}

}
