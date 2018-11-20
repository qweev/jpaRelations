package wojtek.net.jpaRelations.manyToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import wojtek.net.jpaRelations.oneToManyBi.CommentDao;

public interface Grupa extends JpaRepository<GrupaDao, Long> {
}
