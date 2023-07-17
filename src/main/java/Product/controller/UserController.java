package Product.controller;

import Product.controller.ProductDTO.UserDTO;
import Product.controller.ProductDTO.UserFilterDTO;
import Product.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping("/user")
    public List<UserDTO> searchByName(@RequestParam String name) {
        return userService.searchByName(name);
    }

    @GetMapping
    public List<UserDTO> getAll() {
        LOGGER.debug("пришел запрос на получение всех юзеров!");
        return userService.getAllUsers();
    }

    @PostMapping
    public Integer createUser(@RequestBody @Valid UserDTO userToCreate) {
        return userService.createUser(userToCreate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Integer id, @RequestBody @Valid UserDTO userToUpdate) {
        return userService.updateUser(id, userToUpdate);
    }

    @PostMapping("/search")
    public List<UserDTO>  search(@RequestBody UserFilterDTO filter) {
        return userService.search(filter);
    }

    @GetMapping("/page")
    public Page<UserDTO> getPaged(Pageable pageable) {
        return userService.getPage(pageable);
    }
}
