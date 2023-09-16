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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.landodieudonne.api_crud_spring_boot.model.Folder;
import com.landodieudonne.api_crud_spring_boot.services.ServiceFunction;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class FolderController {
	@Autowired
	private ServiceFunction service;

	@PostMapping("/addFolder")
	@ResponseStatus(HttpStatus.CREATED)
	public Folder addFolder(@RequestBody Folder fldr) {
		System.out.println("fldr getName " + fldr.getName());
		return service.AddFolder(fldr);
	}

	@GetMapping("/folders")
	public List<Folder> getAllFolders() {
		return service.AllFolders();
	}

	@PutMapping("/editFolder")
	public Folder editFolder(@RequestBody Map<String, Object> payload, Folder fldr) {
		fldr.setFolderId(payload.get("id").toString());
		fldr.setNewName(payload.get("newName").toString());
		return service.editFolderName(fldr);
	}

	@DeleteMapping("deleteFolder/{id}")
	public Boolean deletFolder(@PathVariable("id") String id) {
		return service.deleteFolderById(id);
	}

}
