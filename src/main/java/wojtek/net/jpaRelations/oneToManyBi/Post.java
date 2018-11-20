package wojtek.net.jpaRelations.oneToManyBi;

import org.springframework.data.jpa.repository.JpaRepository;
import wojtek.net.jpaRelations.manyToOneUni.OrderDao;

public interface Post extends JpaRepository<PostDao, Long> {
}
