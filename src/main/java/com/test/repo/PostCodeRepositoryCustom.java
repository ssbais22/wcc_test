package com.test.repo;

import com.test.entity.PostCode;


public interface PostCodeRepositoryCustom {
    PostCode findByName(String costCode);
}
