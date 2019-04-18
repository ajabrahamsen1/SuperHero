// AJ Abrahamsen 4/17/2019 ajabrahamsen@dmacc.edu

package hero.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profile {

	// Instance variables.
	@Id
	@Column(name = "hero_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long heroId;
	private String heroName;
	private String superPower;
	private String weakness;
	
	// Default Constructor
	public Profile() 
	{
		super();
	}

	public long getHeroId() {
		return heroId;
	}

	public void setHeroId(long heroId) {
		this.heroId = heroId;
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public String getSuperPower() {
		return superPower;
	}

	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}

	public String getWeakness() {
		return weakness;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}
	
	@Override
	public String toString() 
	{
		return "Name: " + heroName;
	}
}
