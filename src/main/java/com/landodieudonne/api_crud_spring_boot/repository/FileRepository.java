package com.landodieudonne.api_crud_spring_boot.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.landodieudonne.api_crud_spring_boot.model.File;

public interface FileRepository extends MongoRepository<File, String> {
	@Query(value = "{ 'id_ref' : ?0 }", fields = "{ 'id_ref' : 1, 'name' : 1, 'newName' : 1}")
	List<File> findOneWithIdRef(String id_ref);
}
