package io.jetbrains.springbooster.user;
import io.jetbrains.springbooster.department.Department;
import io.jetbrains.springbooster.department.DepartmentRepository;
import io.jetbrains.springbooster.language.Language;
import io.jetbrains.springbooster.language.LanguageRepository;
import io.jetbrains.springbooster.subdepartment.SubDepartment;
import io.jetbrains.springbooster.subdepartment.SubDepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SubDepartmentRepository subDepartmentRepository;

    @Autowired
    private LanguageRepository languageRepository;

    private User user;

    private SubDepartment subDepartment;

    private Department department;


    public List<PostDTO> getUsers() throws SQLException {
        List<PostDTO> postDTOS = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        Iterable<User> users = new ArrayList<User>();
        for (User user1 : users = userRepository.findAll()) {
            postDTOS.add(modelMapper.map(user1,PostDTO.class));
        }
        return postDTOS;
    }

    public List<PostDTO> getUser(String id){
        List<PostDTO> postDTOS = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        List<User> users = new ArrayList<User>();
        for (User user1 : userRepository.findAll()) {
            postDTOS.add(modelMapper.map(user1,PostDTO.class));
        }
        return postDTOS;
    }

    public PostDTO addUser(PreDTO preDTO){
        PostDTO postDTO;
        ModelMapper modelMapper = new ModelMapper();

        User user = modelMapper.map(preDTO, User.class);
        user.setDepartment(new Department(1,preDTO.getDepartment_name()));
        userRepository.save(user);
        department = user.getDepartment();
        subDepartment = new SubDepartment(department,preDTO.getDepartment_name());
        subDepartmentRepository.save(subDepartment);
        postDTO = modelMapper.map(user,PostDTO.class);
        return postDTO;
    }

    public void addLanguage(Language language){
        languageRepository.save(language);
    }

    public void updateUser(PreDTO preDTO, int id) {
        PostDTO postDTO;
        ModelMapper modelMapper = new ModelMapper();

        User user = modelMapper.map(preDTO, User.class);
        User user1;
        int user_id =id;
        user1 = userRepository.getUser(user_id);

        if(user1.getDepartment() != null){
            user.setDepartment(user1.getDepartment());
        }else {
            user.setDepartment(new Department(1,preDTO.getDepartment_name()));
        }

        user.setUser_id(user_id);
        userRepository.save(user);
    }

    public void updateDepartment(PreDTO preDTO, int userId, int id) {
        User user1;
        user1 = userRepository.getUser(userId);
        department = user1.getDepartment();
        department.setDepartment_name(preDTO.getDepartment_name());
        user1.setDepartment(department);
        userRepository.save(user1);
    }

    public void deleteUser(int user_id) {
        userRepository.deleteById(user_id);
    }

    public void getLanguages() {
        List<Integer> langs = languageRepository.getLangIds();

        List<User> users = userRepository.getAll();
        Department department;

        int userId=0;
        for(User user : users){
            userId = user.getUser_id();
        }

        for(int i=0;i< langs.size(); i++){
            for(User user1 : users){
                department = user1.getDepartment();
                String name = department.getDepartment_name();
                userRepository.saveNewRow(user1);
            }
        }
    }

}
