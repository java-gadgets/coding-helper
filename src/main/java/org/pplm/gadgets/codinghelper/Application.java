package org.pplm.gadgets.codinghelper;

import org.pplm.gadgets.codinghelper.config.AppConfig;
import org.pplm.gadgets.codinghelper.config.TypeConfig;
import org.pplm.gadgets.codinghelper.entity.Metadata;
import org.pplm.gadgets.codinghelper.entity.Metadata.Config;
import org.pplm.gadgets.codinghelper.generater.ClassExtendsGenerater;
import org.pplm.gadgets.codinghelper.generater.ClassGenerater;
import org.pplm.gadgets.codinghelper.generater.FieldGenerater;
import org.pplm.gadgets.codinghelper.generater.ImportGenerater;
import org.pplm.gadgets.codinghelper.generater.MethodGenerater;
import org.pplm.gadgets.codinghelper.generater.PackageGenerater;
import org.pplm.gadgets.codinghelper.template.EntityTemplateManager;
import org.pplm.gadgets.codinghelper.template.TemplateManager;
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
	private Metadata metadata;
	
	@Autowired
	private TemplateManager templateManager;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("helloworld");
		//entityTemplateManager.initTemplate();
		Config config = metadata.getConfig();
		final PackageGenerater packageGenerater = templateManager.getGenerater(EntityTemplateManager.TEMPLATE_NAME_PACKAGE, PackageGenerater.class);
		packageGenerater.setPackagePrefix(config.getPackPrefix());
		packageGenerater.setPackageName(config.getPackEntity());

		metadata.getEntities().forEach(entity -> {
			final ClassGenerater classGenerater = templateManager.getGenerater(EntityTemplateManager.TEMPLATE_NAME_ENTITY, ClassGenerater.class);
			classGenerater.setClassName(entity.getName());
			classGenerater.setPack(packageGenerater);
			
			ClassExtendsGenerater classExtendsGenerater = templateManager.getGenerater(EntityTemplateManager.TEMPLATE_NAME_CLASS_EXTENDS, ClassExtendsGenerater.class);
			classExtendsGenerater.setExtend(entity.getExtend());
			classGenerater.setExtend(classExtendsGenerater);
			ImportGenerater importExtendGenerater = templateManager.getGenerater(EntityTemplateManager.TEMPLATE_NAME_IMPORT, ImportGenerater.class);
			importExtendGenerater.setType(entity.getExtend());
			classGenerater.addImport(importExtendGenerater);
			
			entity.getAttrs().forEach(attr -> {
				String type = attr.getType();
				String name = attr.getName();
				ImportGenerater importGenerater = templateManager.getGenerater(EntityTemplateManager.TEMPLATE_NAME_IMPORT, ImportGenerater.class);
				importGenerater.setType(type);
				classGenerater.addImport(importGenerater);
				
				FieldGenerater fieldGenerater = templateManager.getGenerater(EntityTemplateManager.TEMPLATE_NAME_FILED, FieldGenerater.class);
				fieldGenerater.setFieldName(name);
				fieldGenerater.setType(type);
				classGenerater.addField(fieldGenerater);
				
				MethodGenerater methodGenerater = null;
				if ("boolean".equals(type) || "Boolean".equals(type)) {
					methodGenerater = templateManager.getGenerater(EntityTemplateManager.TEMPLATE_NAME_IS, MethodGenerater.class);
				} else {
					methodGenerater = templateManager.getGenerater(EntityTemplateManager.TEMPLATE_NAME_GETTER, MethodGenerater.class);
				}
				methodGenerater.setFieldName(name);
				methodGenerater.setType(type);
				classGenerater.addMethod(methodGenerater);
				
				methodGenerater = templateManager.getGenerater(EntityTemplateManager.TEMPLATE_NAME_SETTER, MethodGenerater.class);
				
				methodGenerater.setFieldName(name);
				methodGenerater.setType(type);
				classGenerater.addMethod(methodGenerater);
				//MethodGenerater getterGenerater = new MethodGenerater(fieldTempalte, typeConfig);
			});
			
			System.out.println(classGenerater.genSrc());
		});
		
		
		
		
		//entityTemplateManager.genTemplate(EntityTemplateManager.TEMPLATE_NAME_GETTER);
//		System.out.println(objectMapper.writeValueAsString(config.types()));
		System.out.println("helloworld");
	}
	
}
