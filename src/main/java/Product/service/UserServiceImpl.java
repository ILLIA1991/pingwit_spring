package Product.service;

import Product.controller.ProductDTO.UserDTO;
import Product.controller.ProductDTO.UserFilterDTO;
import Product.converter.UserConverter;
import Product.exception.ProductNotFoundException;
import Product.repository.model.User;
import Product.repository.PagingUserRepository;
import Product.repository.SpringDataUserRepository;
import Product.validator.UserValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final SpringDataUserRepository userRepository;
    private final UserConverter userConverter;
    private final UserValidator validator;
    private final PagingUserRepository pagingUserRepository;

    public UserServiceImpl(SpringDataUserRepository userRepository, UserConverter userConverter, UserValidator validator, PagingUserRepository pagingUserRepository) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.validator = validator;
        this.pagingUserRepository = pagingUserRepository;
    }


    @Override
    public List<UserDTO> getAllUsers() {
        Collection<User> all = userRepository.findAll();
        return userConverter.convertToDto(all);
    }

    @Override
    public UserDTO getById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("User not found: " + id));
        return userConverter.convertToDto(user);
    }

    @Override
    @Transactional
    public Integer createUser(UserDTO userToCreate) {
        validator.validateUser(userToCreate);
        User user = userConverter.convertToEntity(userToCreate);
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    @Override
    public void deleteById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("User not found: " + id));
        userRepository.delete(user);

    }

    @Override
    public List<UserDTO> searchByName(String name) {
        List<User> users = userRepository.findAllByNameOrderBySurname(name);
        return userConverter.convertToDto(users);
    }

    @Override
    @Transactional
    public UserDTO updateUser(Integer id, UserDTO userToUpdate) {
        User user = userRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("User not found: " + id));
        User entityToUpdate = userConverter.convertToEntity(userToUpdate);
        entityToUpdate.setId(id);
        User updatedEntity = userRepository.save(entityToUpdate);
        return userConverter.convertToDto(updatedEntity);
    }

    @Override
    public List<UserDTO> search(UserFilterDTO filter) {
        List<User> allByNameAndSurname = userRepository.findAllByNameAndSurname(filter.getName(), filter.getSurname());
        return userConverter.convertToDto(allByNameAndSurname);
    }

    @Override
    public Page<UserDTO> getPage(Pageable pageable) {
        Page<User> userPage = pagingUserRepository.findAll(pageable);
        List<UserDTO> userDTOS = userConverter.convertToDto(userPage.getContent());
        return new PageImpl<>(userDTOS, userPage.getPageable(), userPage.getTotalElements());
    }
}
