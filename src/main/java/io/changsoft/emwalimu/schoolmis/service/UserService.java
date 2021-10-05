package io.changsoft.emwalimu.schoolmis.service;

import io.changsoft.emwalimu.schoolmis.domain.SystemParameter;
import io.changsoft.emwalimu.schoolmis.domain.User;
import io.changsoft.emwalimu.schoolmis.model.UserDTO;
import io.changsoft.emwalimu.schoolmis.repos.SystemParameterRepository;
import io.changsoft.emwalimu.schoolmis.repos.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;
    private final SystemParameterRepository systemParameterRepository;

    public UserService(final UserRepository userRepository,
            final SystemParameterRepository systemParameterRepository) {
        this.userRepository = userRepository;
        this.systemParameterRepository = systemParameterRepository;
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> mapToDTO(user, new UserDTO()))
                .collect(Collectors.toList());
    }

    public UserDTO get(final Long id) {
        return userRepository.findById(id)
                .map(user -> mapToDTO(user, new UserDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final UserDTO userDTO) {
        final User user = new User();
        mapToEntity(userDTO, user);
        return userRepository.save(user).getId();
    }

    public void update(final Long id, final UserDTO userDTO) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(userDTO, user);
        userRepository.save(user);
    }

    public void delete(final Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO mapToDTO(final User user, final UserDTO userDTO) {
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setSecondName(user.getSecondName());
        userDTO.setEmail(user.getEmail());
        userDTO.setMobileNumber(user.getMobileNumber());
        userDTO.setPassword(user.getPassword());
        userDTO.setAvatar(user.getAvatar());
        userDTO.setDeleted(user.getDeleted());
        userDTO.setActive(user.getActive());
        userDTO.setLocation(user.getLocation());
        userDTO.setUserRoles(user.getUserRoleSystemParameters() == null ? null : user.getUserRoleSystemParameters().stream()
                .map(systemParameter -> systemParameter.getId())
                .collect(Collectors.toList()));
        return userDTO;
    }

    private User mapToEntity(final UserDTO userDTO, final User user) {
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setSecondName(userDTO.getSecondName());
        user.setEmail(userDTO.getEmail());
        user.setMobileNumber(userDTO.getMobileNumber());
        user.setPassword(userDTO.getPassword());
        user.setAvatar(userDTO.getAvatar());
        user.setDeleted(userDTO.getDeleted());
        user.setActive(userDTO.getActive());
        user.setLocation(userDTO.getLocation());
        if (userDTO.getUserRoles() != null) {
            final List<SystemParameter> userRoles = systemParameterRepository.findAllById(userDTO.getUserRoles());
            if (userRoles.size() != userDTO.getUserRoles().size()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "one of userRoles not found");
            }
            user.setUserRoleSystemParameters(userRoles.stream().collect(Collectors.toSet()));
        }
        return user;
    }

}
