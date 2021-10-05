package io.changsoft.emwalimu.schoolmis.service;

import io.changsoft.emwalimu.schoolmis.domain.SystemParameter;
import io.changsoft.emwalimu.schoolmis.model.SystemParameterDTO;
import io.changsoft.emwalimu.schoolmis.repos.SystemParameterRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class SystemParameterService {

    private final SystemParameterRepository systemParameterRepository;

    public SystemParameterService(final SystemParameterRepository systemParameterRepository) {
        this.systemParameterRepository = systemParameterRepository;
    }

    public List<SystemParameterDTO> findAll() {
        return systemParameterRepository.findAll()
                .stream()
                .map(systemParameter -> mapToDTO(systemParameter, new SystemParameterDTO()))
                .collect(Collectors.toList());
    }

    public SystemParameterDTO get(final Long id) {
        return systemParameterRepository.findById(id)
                .map(systemParameter -> mapToDTO(systemParameter, new SystemParameterDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final SystemParameterDTO systemParameterDTO) {
        final SystemParameter systemParameter = new SystemParameter();
        mapToEntity(systemParameterDTO, systemParameter);
        return systemParameterRepository.save(systemParameter).getId();
    }

    public void update(final Long id, final SystemParameterDTO systemParameterDTO) {
        final SystemParameter systemParameter = systemParameterRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(systemParameterDTO, systemParameter);
        systemParameterRepository.save(systemParameter);
    }

    public void delete(final Long id) {
        systemParameterRepository.deleteById(id);
    }

    private SystemParameterDTO mapToDTO(final SystemParameter systemParameter,
            final SystemParameterDTO systemParameterDTO) {
        systemParameterDTO.setId(systemParameter.getId());
        systemParameterDTO.setParamType(systemParameter.getParamType());
        systemParameterDTO.setCode(systemParameter.getCode());
        systemParameterDTO.setName(systemParameter.getName());
        systemParameterDTO.setDescription(systemParameter.getDescription());
        return systemParameterDTO;
    }

    private SystemParameter mapToEntity(final SystemParameterDTO systemParameterDTO,
            final SystemParameter systemParameter) {
        systemParameter.setParamType(systemParameterDTO.getParamType());
        systemParameter.setCode(systemParameterDTO.getCode());
        systemParameter.setName(systemParameterDTO.getName());
        systemParameter.setDescription(systemParameterDTO.getDescription());
        return systemParameter;
    }

}
