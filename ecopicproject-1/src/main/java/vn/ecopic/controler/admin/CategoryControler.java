package vn.ecopic.controler.admin;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.ecopic.entity.Category;
import vn.ecopic.model.CategoryModel;
import vn.ecopic.service.ICategoryService;

@Controller
@RequestMapping("admin/categories")
public class CategoryControler {
	@Autowired
	ICategoryService categoryService;
	@RequestMapping("")
	public String list(ModelMap model)
	{
		List<Category> list = categoryService.findAll();
		model.addAttribute("categories",list);
		return "admin/categories/list";
	}
	@GetMapping("add")
	public String Add(ModelMap model)
	{
		CategoryModel cate = new CategoryModel();
		cate.setIsEdit(false);
		model.addAttribute("category",cate);
		return "admin/categories/addOrEdit";
	}
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, 
			@Valid @ModelAttribute("category") CategoryModel cate, BindingResult result)
	{
		if(result.hasErrors())
		{
			return new ModelAndView("admin/categories/addOrEdit");
		}
		Category entity = new Category();
		BeanUtils.copyProperties(cate, entity);
		categoryService.save(entity);
		String message ="";
		if(cate.getIsEdit() == true)
		{
			message = "Category đã được cập nhật thành công";
		}else
		{
			message = "Category đã được thêm thành công";
		}
		model.addAttribute("message", message);
		return new ModelAndView("forward:/admin/categories");
		
	}
	@GetMapping("edit/{categoryId}")
	public ModelAndView edit(ModelMap model, 
			@PathVariable("categoryId") Long categoryId)
	{
		Optional<Category> opt = categoryService.findById(categoryId);
		CategoryModel cate = new CategoryModel();
		if(opt.isPresent())
		{
			Category entity = opt.get();
			BeanUtils.copyProperties(entity, cate);
			cate.setIsEdit(true);
			model.addAttribute("category", cate);
			return new ModelAndView("admin/categories/addOrEdit",model);
		}
		model.addAttribute("message", "Category không tồn tại");
		
		return new ModelAndView("forward:/admin/categories",model);
	}
	@GetMapping("delete/{categoryId}")
	public ModelAndView delete(ModelMap model, 
			@PathVariable("categoryId") Long categoryId)
	{
		categoryService.deleteById(categoryId);
		model.addAttribute("message", "đã xóa thành công");
		return new ModelAndView("forward:/admin/categories",model);
	}
	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name="name",required = false) String name)
	{
		List<Category> list = null;
		if(StringUtils.hasText(name))
		{
			list =  categoryService.findByCategoryNameContaining(name);
		}else
		{
			list = categoryService.findAll();
		}
		model.addAttribute("categories", list);
		return "admin/categories/search";
	}
}
