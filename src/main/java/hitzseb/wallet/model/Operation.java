package hitzseb.wallet.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "operations")
@Data
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Double amount;
	@Enumerated(EnumType.STRING)
	private OperationType type;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	private LocalDate date;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private AppUser user;
}