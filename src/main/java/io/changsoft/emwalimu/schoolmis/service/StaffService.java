package io.changsoft.emwalimu.schoolmis.service;

import io.changsoft.emwalimu.schoolmis.domain.Staff;
import io.changsoft.emwalimu.schoolmis.domain.SystemParameter;
import io.changsoft.emwalimu.schoolmis.domain.User;
import io.changsoft.emwalimu.schoolmis.model.StaffDTO;
import io.changsoft.emwalimu.schoolmis.repos.StaffRepository;
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
public class StaffService {

    private final StaffRepository staffRepository;
    private final SystemParameterRepository systemParameterRepository;
    private final UserRepository userRepository;

    public StaffService(final StaffRepository staffRepository,
            final SystemParameterRepository systemParameterRepository,
            final UserRepository userRepository) {
        this.staffRepository = staffRepository;
        this.systemParameterRepository = systemParameterRepository;
        this.userRepository = userRepository;
    }

    public List<StaffDTO> findAll() {
        return staffRepository.findAll()
                .stream()
                .map(staff -> mapToDTO(staff, new StaffDTO()))
                .collect(Collectors.toList());
    }

    public StaffDTO get(final Long id) {
        return staffRepository.findById(id)
                .map(staff -> mapToDTO(staff, new StaffDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final StaffDTO staffDTO) {
        final Staff staff = new Staff();
        mapToEntity(staffDTO, staff);
        return staffRepository.save(staff).getId();
    }

    public void update(final Long id, final StaffDTO staffDTO) {
        final Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(staffDTO, staff);
        staffRepository.save(staff);
    }

    public void delete(final Long id) {
        staffRepository.deleteById(id);
    }

    private StaffDTO mapToDTO(final Staff staff, final StaffDTO staffDTO) {
        staffDTO.setId(staff.getId());
        staffDTO.setStaffNumber(staff.getStaffNumber());
        staffDTO.setDepartments(staff.getDepartmentSystemParameters() == null ? null : staff.getDepartmentSystemParameters().stream()
                .map(systemParameter -> systemParameter.getId())
                .collect(Collectors.toList()));
        staffDTO.setUser(staff.getUser() == null ? null : staff.getUser().getId());
        return staffDTO;
    }

    private Staff mapToEntity(final StaffDTO staffDTO, final Staff staff) {
        staff.setStaffNumber(staffDTO.getStaffNumber());
        if (staffDTO.getDepartments() != null) {
            final List<SystemParameter> departments = systemParameterRepository.findAllById(staffDTO.getDepartments());
            if (departments.size() != staffDTO.getDepartments().size()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "one of departments not found");
            }
            staff.setDepartmentSystemParameters(departments.stream().collect(Collectors.toSet()));
        }
        if (staffDTO.getUser() != null && (staff.getUser() == null || !staff.getUser().getId().equals(staffDTO.getUser()))) {
            final User user = userRepository.findById(staffDTO.getUser())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
            staff.setUser(user);
        }
        return staff;
    }

}
