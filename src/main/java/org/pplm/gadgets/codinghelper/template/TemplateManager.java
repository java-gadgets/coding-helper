package org.pplm.gadgets.codinghelper.template;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.pplm.gadgets.codinghelper.config.TemplateConfig;
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
	private TemplateConfig config;

	private Map<String, String> templateMap = new HashMap<>();
	
	protected String name;
	protected String path;
	
	public TemplateManager(String name) {
		super();
		this.path = config.getPath() + '/' + name;
	}

	public String getTemplate(String templateName) {
		return templateMap.get(templateName);
	}
	
	@PostConstruct
	public void initTemplate() throws JsonParseException, JsonMappingException, IOException {
		final File templatePath = resourceLoader.getResource(path).getFile();
		File file = new File(templatePath, config.getConfig());
		Map<String, String> configMap = objectMapper.readValue(file, new TypeReference<Map<String, String>>(){});
		configMap.forEach((key, value) -> {
			try {
				File templateFile = new File(templatePath, value);
				String template = FileUtils.readFileToString(templateFile, config.getEncoding());
				templateMap.put(key, template);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		});
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

}
