package com.landodieudonne.api_crud_spring_boot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.landodieudonne.api_crud_spring_boot.model.Folder;

public interface FolderRepository extends MongoRepository<Folder, String> {
}
