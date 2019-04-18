package hero.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hero.beans.Profile;


@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> { }

