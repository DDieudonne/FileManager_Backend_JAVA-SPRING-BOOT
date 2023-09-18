package com.landodieudonne.api_crud_spring_boot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Files")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {
	@Id
	private String id;
	private String name;
	private String newName;
	private String id_ref;
	private String date;

	public String getName() {
		return name;
	}

	public String getFileId() {
		return this.id;
	}

	public void setFileId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getId_ref() {
		return id_ref;
	}

	public void setId_ref(String id_ref) {
		this.id_ref = id_ref;
	}

}
