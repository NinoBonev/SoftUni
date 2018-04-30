package shoppinglist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shoppinglist.bindingModel.ProductBindingModel;
import shoppinglist.entity.Product;
import shoppinglist.repository.ProductRepository;

import java.util.List;

@Controller
public class ProductController {

	private final ProductRepository productRepository;

	@Autowired
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Product> products = this.productRepository.findAll();

		model.addAttribute("products", products);
		model.addAttribute("view", "product/index");

		return "base-layout";

	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("view", "product/create");
		return "base-layout";

	}

	@PostMapping("/create")
	public String createProcess(Model model, ProductBindingModel productBindingModel) {
		Product product = new Product();

		product.setName(productBindingModel.getName());
		product.setStatus(productBindingModel.getStatus());
		product.setQuantity(productBindingModel.getQuantity());
		product.setPriority(productBindingModel.getPriority());

		this.productRepository.saveAndFlush(product);

		return "redirect:/";

	}

	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable int id) {
		Product product = this.productRepository.findOne(id);

		model.addAttribute("view", "product/edit");
		model.addAttribute("product", product);

		return "base-layout";

	}

	@PostMapping("/edit/{id}")
	public String editProcess(Model model, @PathVariable int id, ProductBindingModel productBindingModel) {
		Product productFromDB = this.productRepository.findOne(id);

		productFromDB.setName(productBindingModel.getName());
		productFromDB.setStatus(productBindingModel.getStatus());
		productFromDB.setQuantity(productBindingModel.getQuantity());
		productFromDB.setPriority(productBindingModel.getPriority());


		this.productRepository.saveAndFlush(productFromDB);

		return "redirect:/";
	}
}
