package wojtek.net.jpaRelations.manyToOneUni;

import org.springframework.data.jpa.repository.JpaRepository;
import wojtek.net.jpaRelations.oneToOneBiRel.CarDao;

public interface Product extends JpaRepository<ProductDao, Long> {
}
