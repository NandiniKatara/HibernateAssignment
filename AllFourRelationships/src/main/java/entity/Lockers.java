package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Lockers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

	@OneToOne(mappedBy = "locker", cascade = CascadeType.ALL)
	private AccessCode accessCode;

    @ManyToOne
    private Bank bank;

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

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public AccessCode getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(AccessCode accessCode) {
		this.accessCode = accessCode;
	}

	@Override
	public String toString() {
		return "Lockers [id=" + id + ", name=" + name + ", bank=" + bank + "]";
	}
}

