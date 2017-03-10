package hahakafka.consumer.like;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

	public List<User> findByEmail(String email);

	public User findOneByUserId(String userId);

}
