package Product.repository;

import Product.repository.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagingUserRepository extends PagingAndSortingRepository<User, Integer> {
}
