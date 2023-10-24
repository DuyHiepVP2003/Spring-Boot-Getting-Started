package com.project.Mobile.Shop.Project.repository;

import com.project.Mobile.Shop.Project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
