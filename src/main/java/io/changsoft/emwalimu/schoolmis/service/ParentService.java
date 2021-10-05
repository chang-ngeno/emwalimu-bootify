package io.changsoft.emwalimu.schoolmis.service;

import io.changsoft.emwalimu.schoolmis.domain.Parent;
import io.changsoft.emwalimu.schoolmis.domain.User;
import io.changsoft.emwalimu.schoolmis.model.ParentDTO;
import io.changsoft.emwalimu.schoolmis.repos.ParentRepository;
import io.changsoft.emwalimu.schoolmis.repos.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class ParentService {

    private final ParentRepository parentRepository;
    private final UserRepository userRepository;

    public ParentService(final ParentRepository parentRepository,
            final UserRepository userRepository) {
        this.parentRepository = parentRepository;
        this.userRepository = userRepository;
    }

    public List<ParentDTO> findAll() {
        return parentRepository.findAll()
                .stream()
                .map(parent -> mapToDTO(parent, new ParentDTO()))
                .collect(Collectors.toList());
    }

    public ParentDTO get(final Long id) {
        return parentRepository.findById(id)
                .map(parent -> mapToDTO(parent, new ParentDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final ParentDTO parentDTO) {
        final Parent parent = new Parent();
        mapToEntity(parentDTO, parent);
        return parentRepository.save(parent).getId();
    }

    public void update(final Long id, final ParentDTO parentDTO) {
        final Parent parent = parentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(parentDTO, parent);
        parentRepository.save(parent);
    }

    public void delete(final Long id) {
        parentRepository.deleteById(id);
    }

    private ParentDTO mapToDTO(final Parent parent, final ParentDTO parentDTO) {
        parentDTO.setId(parent.getId());
        parentDTO.setRelationship(parent.getRelationship());
        parentDTO.setUser(parent.getUser() == null ? null : parent.getUser().getId());
        return parentDTO;
    }

    private Parent mapToEntity(final ParentDTO parentDTO, final Parent parent) {
        parent.setRelationship(parentDTO.getRelationship());
        if (parentDTO.getUser() != null && (parent.getUser() == null || !parent.getUser().getId().equals(parentDTO.getUser()))) {
            final User user = userRepository.findById(parentDTO.getUser())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
            parent.setUser(user);
        }
        return parent;
    }

}
