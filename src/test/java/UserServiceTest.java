import DAO.UserRepo;
import Models.User;
import Service.UserService;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.mockito.Mockito.never;

public class UserServiceTest {
@Test
public void addUserWhenUserExistsDoNotAdd()throws SQLException{
    UserRepo ur;
    ur= Mockito.mock(UserRepo.class);
    User u = new User(1);
    Mockito.when(ur.getUserById(1)).thenReturn(u);
    UserService us = new UserService();
    Mockito.verify(ur,never()).addUser(u);

   }
}
