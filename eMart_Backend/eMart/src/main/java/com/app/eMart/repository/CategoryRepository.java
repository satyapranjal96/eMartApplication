package com.app.eMart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.eMart.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
