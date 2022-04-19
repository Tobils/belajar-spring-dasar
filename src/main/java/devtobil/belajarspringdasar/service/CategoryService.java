package devtobil.belajarspringdasar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import devtobil.belajarspringdasar.repository.CategoryRepository;
import lombok.Getter;

@Component
public class CategoryService {

  @Getter
  private CategoryRepository categoryRepository;

  @Autowired
  public void setCategoryRepositor(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public CategoryRepository getCategoryRepository() {
    return this.categoryRepository;
  }
}
