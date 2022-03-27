package intec.be.Falconapp.models;


/*
 We need to implement this class because each country.js have many states and in order to make a relationship between
 the country.js and the state we have implemented state class.

 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
// WE NEED THIS LINE TO AVOID INFINITE REGRESSION
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class State {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private String name;
	private String capital;
    private String code;

	// MANY STATES HAVE ONE COUNTRY
	@ManyToOne
	@JoinColumn(name="countryid", insertable=false, updatable=false)
	private Country country;

	// This is the foreign key for country.js and the relations between state and country.js will be base on this "countryid".
	private int countryid;
	
	private String details;
	
}
