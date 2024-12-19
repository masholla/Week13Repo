package pet.store.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import jakarta.persistence.JoinColumn;

@Data
@Entity
public class PetStore 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petStoreId;

    private String name;
    private String location;

    @EqualsAndHashCode.Exclude
	@ToString.Exclude
    @OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> employees;

    @EqualsAndHashCode.Exclude
	@ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "pet_store_customer",
        joinColumns = @JoinColumn(name = "pet_store_id"),
        inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<Customer> customers;
}
