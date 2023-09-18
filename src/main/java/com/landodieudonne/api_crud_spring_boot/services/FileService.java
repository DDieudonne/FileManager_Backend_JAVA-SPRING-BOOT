package com.landodieudonne.api_crud_spring_boot.services;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.landodieudonne.api_crud_spring_boot.model.File;
import com.landodieudonne.api_crud_spring_boot.repository.FileRepository;

@Service
public class FileService {

	@Autowired
	private FileRepository repository;
	
	public File AddFile(File file, String idFolder) {
		file.setFileId(UUID.randomUUID().toString().split("-")[0]);
		return repository.save(file);
	}

	public List<File> AllFilesByRef(String id_ref) {
		return repository.findOneWithIdRef(id_ref);
	}

	public File editFileName(File file) {
		File existingFolder = repository.findOne(file.getFileId());
		existingFolder.setName(file.getNewName());
		return repository.save(existingFolder);
	}

	public Boolean deleteFileById(String fldrId) {
		repository.delete(fldrId);
		return true;
	}
}
