package wojtek.net.jpaRelations.oneToManyUni;

import org.springframework.data.jpa.repository.JpaRepository;
import wojtek.net.jpaRelations.manyToOneUni.ProductDao;

public interface Student extends JpaRepository<StudentDao, Long> {
}
