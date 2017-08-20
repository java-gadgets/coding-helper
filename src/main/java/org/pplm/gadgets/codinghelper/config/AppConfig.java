package org.pplm.gadgets.codinghelper.config;

import java.io.IOException;
import java.util.Collection;

import org.pplm.gadgets.codinghelper.entity.Metadata;
import org.pplm.gadgets.codinghelper.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ConfigurationProperties(prefix = "codinghelp.app")
@Configuration
public class AppConfig {

	private String metadata;
	
	private String type;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private ObjectMapper objectMapper;
	

	public AppConfig() {
		super();
	}

	@Bean
	public Metadata metaData() throws JsonParseException, JsonMappingException, IOException {
		return objectMapper.readValue(resourceLoader.getResource(metadata).getFile(), Metadata.class);
	}
	
	@Bean 
	public TypeConfig typeConfig()  throws JsonParseException, JsonMappingException, IOException {
		Collection<Type> types = objectMapper.readValue(resourceLoader.getResource(type).getFile(), new TypeReference<Collection<Type>>(){});
		return new TypeConfig(types);
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
