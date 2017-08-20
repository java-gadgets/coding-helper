package org.pplm.gadgets.codinghelper.template;

import org.springframework.stereotype.Component;

@Component
public class EntityTemplateManager extends TemplateManager {
	
	public static final String NAME = "entity";
	
	public static final String TEMPLATE_NAME_IS = "is";
	public static final String TEMPLATE_NAME_GETTER = "getter";
	public static final String TEMPLATE_NAME_SETTER = "setter";
	public static final String TEMPLATE_NAME_FILED = "field";
	public static final String TEMPLATE_NAME_ENTITY = "entity";
	
	public EntityTemplateManager() {
		super(NAME);
	}
	
}
