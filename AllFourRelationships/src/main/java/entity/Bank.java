package entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToMany;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "Locker")
    private List<Lockers> lockers;
    
    @ManyToMany
    @JoinTable(
        name = "bank_cities",
        joinColumns = @JoinColumn(name = "bank_id"),
        inverseJoinColumns = @JoinColumn(name = "cities_id")
    )
    private List<Cities> cities;


	public List<Cities> getCities() {
		return cities;
	}

	public void setCities(List<Cities> cities) {
		this.cities = cities;
	}

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

	public List<Lockers> getLockers() {
		return lockers;
	}

	public void setLockers(List<Lockers> lockers) {
		this.lockers = lockers;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", lockers=" + lockers + "]";
	}
}

