package org.pplm.gadgets.codinghelper.entity;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author OracleGao
 *
 */
public class Metadata {
	private String name;
	private Collection<Entity> entities;
	private Collection<Relation> relations;
	private Config config;

	public Metadata() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Entity> getEntities() {
		return entities;
	}

	public void setEntities(Collection<Entity> entities) {
		this.entities = entities;
	}

	public Collection<Relation> getRelations() {
		return relations;
	}

	public void setRelations(Collection<Relation> relations) {
		this.relations = relations;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}
	
	/**
	 * 
	 * @author OracleGao
	 *
	 */
	public static class Entity {
		private String name;
		private String relationPrefix;
		private Collection<EntityAttr> attrs;
		private String extend;
		
		public Entity() {
			super();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getRelationPrefix() {
			return relationPrefix;
		}

		public void setRelationPrefix(String relationPrefix) {
			this.relationPrefix = relationPrefix;
		}

		public Collection<EntityAttr> getAttrs() {
			return attrs;
		}

		public void setAttrs(Collection<EntityAttr> attrs) {
			this.attrs = attrs;
		}

		public String getExtend() {
			return extend;
		}

		public void setExtend(String extend) {
			this.extend = extend;
		}

		/**
		 * 
		 * @author OracleGao
		 *
		 */
		public static class EntityAttr {
			private String name;
			private String type;
			
			public EntityAttr() {
				super();
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}
		}
	}

	/**
	 * 
	 * @author OracleGao
	 *
	 */
	public static class Relation extends Entity {
		private Collection<String> entityTuple;
		private Map<String, Collection<String>> filter;
		
		public Relation() {
			super();
		}

		public Collection<String> getEntityTuple() {
			return entityTuple;
		}

		public void setEntityTuple(Collection<String> entityTuple) {
			this.entityTuple = entityTuple;
		}

		public Map<String, Collection<String>> getFilter() {
			return filter;
		}

		public void setFilter(Map<String, Collection<String>> filter) {
			this.filter = filter;
		}
	}
	
	/**
	 * 
	 * @author OracleGao
	 *
	 */
	public static class Config {
		private String packPrefix;
		private String packEntity;
		
		public Config() {
			super();
		}

		public String getPackPrefix() {
			return packPrefix;
		}

		public void setPackPrefix(String packPrefix) {
			this.packPrefix = packPrefix;
		}

		public String getPackEntity() {
			return packEntity;
		}

		public void setPackEntity(String packEntity) {
			this.packEntity = packEntity;
		}
		
		public String getEntityPackageSrc() {
			return StringUtils.join(packPrefix, '.', packEntity);
		}
	}
	
}
