package com.db.pojo;

public final class MstRolePojo {

	private int id;
	private String name;
	private String code;
	private String description;
	private int is_active;
	private String created_at;
	private String modified_at;
	
	public MstRolePojo(int id, String name, String code, String description, int is_active, String created_at, String modified_at) {
		this.id = id;
		this.name = name;
		this.code =code;
		this.description = description;
		this.is_active = is_active;
		this.created_at = created_at;
		this.modified_at = modified_at;
		
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public int getIs_active() {
		return is_active;
	}

	public String getCreated_at() {
		return created_at;
	}

	public String getModified_at() {
		return modified_at;
	}

	@Override
	public String toString() {
		return "MstRolePojo [id=" + id + ", name=" + name + ", code=" + code + ", description=" + description
				+ ", is_active=" + is_active + ", created_at=" + created_at + ", modified_at=" + modified_at + "]";
	}
	
}
