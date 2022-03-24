package StudentServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;


@Service  
@EnableTransactionManagement
@Component
public class StudentServiceImp  implements StudentService {
	@Autowired
	StudentService studentService;

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		Student data=studentRepository.save(student);
		return data;
	}

	@Override
	public List<Student> getStudents() {
	List<Student>	list=studentRepository.findAll();
		return list;
	}

	@Override
	public boolean deleteStudent(long id) {
		Optional<Student> studentold = studentRepository.findById(id);

		Student ss=studentold.get();
		studentRepository.delete(ss);

	    
		return false;
	}

	@Override
	public Student getStudentByID(long id) {
		Optional<Student> data=studentRepository.findById(id);
		return data.get();
	}

	@Override
	//@Transactional(value="multipletransactions")
	public Student updateStudent(Student student) {
		Optional<Student> studentold = studentRepository.findById(student.getStudent_id());

		Student ss=studentold.get();
		ss.setStudent_name(student.getStudent_name());
		ss.setStudent_branch(student.getStudent_branch());
		ss.setStudent_email(student.getStudent_email());
		ss.setAddress(student.getAddress());
		ss.setStudent_phno_number(student.getStudent_phno_number());
		ss.setStudent_age(student.getStudent_age());
	    
	    Student updatedNote = studentRepository.save(ss);
		return updatedNote;
	}

}
