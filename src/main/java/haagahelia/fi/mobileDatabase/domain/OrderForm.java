package haagahelia.fi.mobileDatabase.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrderForm {
	@NotNull
	@Size(min=2, max=30)
	private String name;

	@NotNull
	@Min(18)
	private Integer age;
	
	@NotNull
	@Size(min=2, max=30)
	private String laite;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getLaite() {
		return laite;
	}

	public void setLaite(String laite) {
		this.laite = laite;
	}

	@Override
	public String toString() {
		return "OrderForm [name=" + name + ", age=" + age + ", laite=" + laite + "]";
	}

}
