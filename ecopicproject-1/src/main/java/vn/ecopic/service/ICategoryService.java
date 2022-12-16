package vn.ecopic.service;

import java.util.List;
import java.util.Optional;
import vn.ecopic.entity.Category;

public interface ICategoryService {

	void delete(Category entity);

	Optional<Category> findById(Long id);

	List<Category> findAllById(Iterable<Long> ids);

	<S extends Category> S save(S entity);

	List<Category> findAll();

	void deleteById(Long id);

	List<Category> findByCategoryNameContaining(String name);


}
