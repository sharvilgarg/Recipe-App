package com.project.recipeapp.controllers;

import com.project.recipeapp.domain.Category;
import com.project.recipeapp.domain.UnitOfMeasure;
import com.project.recipeapp.repositories.CategoryRepository;
import com.project.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {

        Optional<Category> categoryOptional=categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional=unitOfMeasureRepository.findByDescription("Ounce");

        System.out.println("Cat ID is "+ categoryOptional.get().getId());
        System.out.println("UOM ID is "+ unitOfMeasureOptional.get().getId());

        System.out.println("Cat Description is "+ categoryOptional.get().getDescription());
        System.out.println("UOM Description is "+ unitOfMeasureOptional.get().getDescription());

        return "index";
    }
}
