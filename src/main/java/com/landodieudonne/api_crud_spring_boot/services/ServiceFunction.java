package com.landodieudonne.api_crud_spring_boot.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.landodieudonne.api_crud_spring_boot.model.Folder;
import com.landodieudonne.api_crud_spring_boot.repository.FolderRepository;

@Service
public class ServiceFunction {

	@Autowired
	private FolderRepository repository;

	public Folder AddFolder(Folder fldr) {
		fldr.setFolderId(UUID.randomUUID().toString().split("-")[0]);
		return repository.save(fldr);
	}

	public List<Folder> AllFolders() {
		return repository.findAll();
	}

	public Folder editFolderName(String folderId, String newName) {
		Folder existingFolder = repository.findOne(folderId);
		existingFolder.FolderSetAll(existingFolder, null, false);
		existingFolder.setName(newName);
		return repository.save(existingFolder);
	}

	public Folder SetUpdateNbrFilesInFolder(String idFolder, Boolean add, Boolean editNumber) {
		Folder existingFolder = repository.findOne(idFolder);
		existingFolder.FolderSetAll(existingFolder, add, editNumber);
		return repository.save(existingFolder);
	}

	public Boolean deleteFolderById(String fldrId) {
		repository.delete(fldrId);
		return true;
	}

}
