package com.test.repo;

import com.test.entity.PostCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCodeRepository extends JpaRepository<PostCode, String> ,PostCodeRepositoryCustom {

}
