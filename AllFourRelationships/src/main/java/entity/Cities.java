package entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "cities")
    private List<Bank> banks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Bank> getBank() {
		return banks;
	}

	public void setBank(List<Bank> banks) {
		this.banks = banks;
	}

	@Override
	public String toString() {
		return "Cities [id=" + id + ", name=" + name + ", banks=" + banks + "]";
	}
}

