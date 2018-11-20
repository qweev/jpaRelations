package wojtek.net.jpaRelations.oneToManyBi;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Comment")
public class CommentDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id", unique = true, nullable = false )
    private Long id;

    @Column( name = "comment_value", length = 20 )
    private String commmentValue;

    @ManyToOne
//    @JoinColumn(name = "post_dao_id") // jak sie odchaczy to bedzie nazwa kolumny post_dao_id zamiast post_dao_rel_id
    private PostDao postDaoRel;

    @Override
    public String toString(){

        return "COMMENT = id: " + id + " - comment_value: " + commmentValue + " - post id: " + postDaoRel.getId() ;
    }
}
