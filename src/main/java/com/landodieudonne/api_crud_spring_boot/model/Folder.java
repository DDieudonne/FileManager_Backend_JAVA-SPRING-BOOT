package com.landodieudonne.api_crud_spring_boot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Folders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Folder {
	@Id
	private String id;
	private String name;
	private String newName;
	private Number nbr_files;
	private String date;

	public String getFolderId() {
		return this.id;
	}

	public void setFolderId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Number getNbr_files() {
		return nbr_files;
	}

	public void setNbr_files(Number nbr_files) {
		this.nbr_files = nbr_files;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}
	
	
}
