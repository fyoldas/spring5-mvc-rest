package guru.springfamework.domain;

import java.util.ArrayList;
import java.util.List;


public class Categories {
	
	private List<Category> categories = new ArrayList<Category>();

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
			

}
