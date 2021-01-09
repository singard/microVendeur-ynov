package com.antiamazon.vendeur1.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NewVendeur {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	private String soc;
	private String desc;
	private String rue;
	private String ville;
	private String cp;
	private String paiementCB;
	private String paiementPaypal;
	private String photo64;

	
	
}
