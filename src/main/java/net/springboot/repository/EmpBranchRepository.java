//
//import net.javaguides.springboot.model.EmployeeBranchDTO;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface EmpBranchRepository extends JpaRepository<EmployeeBranchDTO, Long> {
//
//    @Query("SELECT NEW net.javaguides.springboot.model.EmployeeBranchDTO(e.firstName, b.branchName) " +
//           "FROM Employee e " +
//           "INNER JOIN Branch b ON e.id = b.employee.id")
//    List<EmployeeBranchDTO> getEmployeeBranchInfo();
//}
//
//
