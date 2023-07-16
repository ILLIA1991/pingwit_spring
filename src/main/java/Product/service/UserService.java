package Product.service;

import Product.controller.ProductDTO.UserDTO;
import Product.controller.ProductDTO.UserFilterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getById(Integer id);

    Integer createUser(UserDTO userDTO);

    void deleteById(Integer id);

    List<UserDTO> searchByName(String name);

    UserDTO updateUser(Integer id, UserDTO userToUpdate);

    List<UserDTO> search(UserFilterDTO filter);

    Page<UserDTO> getPage(Pageable pageable);
}
