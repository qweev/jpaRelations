package wojtek.net.jpaRelations.oneToOneBiRel;

import org.springframework.data.jpa.repository.JpaRepository;
import wojtek.net.jpaRelations.oneToOneUniRel.ItemDao;

public interface Engine extends JpaRepository<EngineDao, Long> {
}
