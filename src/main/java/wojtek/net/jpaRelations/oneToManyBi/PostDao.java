package wojtek.net.jpaRelations.oneToManyBi;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Post")
public class PostDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id", unique = true, nullable = false )
    private Long id;

    @Column( name = "post_value", length = 20 )
    private String postValue;

// dzieki cascade robimy save na encji post i zapisuja sie obie encje (post i comment)
    @OneToMany(mappedBy = "postDaoRel", cascade = CascadeType.ALL)
    private List<CommentDao> commentDaoList;


    @Override
    public String toString(){

        return "POST = id: " + id + " - post: " + postValue;
    }
}
