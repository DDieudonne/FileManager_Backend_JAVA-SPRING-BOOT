package com.landodieudonne.api_crud_spring_boot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.landodieudonne.api_crud_spring_boot.model.File;
import com.landodieudonne.api_crud_spring_boot.repository.FileRepository;
import com.landodieudonne.api_crud_spring_boot.repository.FolderRepository;
import com.landodieudonne.api_crud_spring_boot.services.FileService;
import com.landodieudonne.api_crud_spring_boot.services.ServiceFunction;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class FileController {

	@Autowired
	private FileService service;
	@Autowired
	private ServiceFunction folderService;

	@PostMapping("/addFileInfolder/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public File addFile(@RequestBody File file, @PathVariable("id") String id) {
		folderService.SetUpdateNbrFilesInFolder(id, true, true);
		file.setId_ref(id);
		return service.AddFile(file, id);
	}

	@GetMapping("/filesFolder/{id}")
	public List<File> getAllFiles(@PathVariable("id") String id) {
		return service.AllFilesByRef(id);
	}

	@PutMapping("/editFileInfolder")
	public File editFile(@RequestBody Map<String, Object> payload, File fldr) {
		fldr.setFileId(payload.get("id").toString());
		fldr.setNewName(payload.get("newName").toString());
		return service.editFileName(fldr);
	}

	@DeleteMapping("delFileInfolder/{id}")
	public Boolean deletFile(@RequestParam(name = "folderId") String folderId, @PathVariable("id") String id) {
		folderService.SetUpdateNbrFilesInFolder(folderId, false, true);
		return service.deleteFileById(id);
	}

}
