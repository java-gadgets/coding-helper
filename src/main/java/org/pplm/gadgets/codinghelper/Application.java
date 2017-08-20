package org.pplm.gadgets.codinghelper;

import org.pplm.gadgets.codinghelper.config.AppConfig;
import org.pplm.gadgets.codinghelper.entity.Metadata;
import org.pplm.gadgets.codinghelper.template.EntityTemplateManager;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class Application implements ApplicationRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private AppConfig config;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private EntityTemplateManager entityTemplateManager;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("helloworld");
		//entityTemplateManager.initTemplate();
		Metadata metadata = config.metaData();
		//entityTemplateManager.genTemplate(EntityTemplateManager.TEMPLATE_NAME_GETTER);
		System.out.println(objectMapper.writeValueAsString(metadata));
//		System.out.println(objectMapper.writeValueAsString(config.types()));
		System.out.println("helloworld");
	}
	
}
