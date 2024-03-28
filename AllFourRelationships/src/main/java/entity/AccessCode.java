package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class AccessCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accessCodeValue;
    @OneToOne
    @JoinColumn(name="locker_id")
    private Lockers locker;

    
    public String getAccessCodeValue() {
        return accessCodeValue;
    }

    public Lockers getLocker() {
        return locker;
    }

    public void setAccessCodeValue(String accessCode) {
        this.accessCodeValue = accessCode;
    }

    public void setLocker(Lockers locker) {
        this.locker = locker;
    }

    @Override
    public String toString() {
        return "AccessCode [acessCode=" + accessCodeValue + ", locker=" + locker + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
