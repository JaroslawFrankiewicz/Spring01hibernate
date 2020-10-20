package pl.coderslab.user;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserRepositoryTest {
    private UserRepository userRepository;
    @Before
    public void setUp() throws Exception {
        userRepository = new UserRepository();
    }
    @Test
    public void shouldPersistUser() {
        // given
        User user = new User();
        user.setName("Andrzej");
        // when
        userRepository.persist(user);
        // then
        User persistedUser = userRepository.findByName("Andrzej");
        assertNotNull(persistedUser);
        assertThat(persistedUser.getId(), is(1));
    }
    @Test
    public void shouldEditUser() {
        // given
        User user = new User();
        user.setName("Andrzej");
        userRepository.persist(user);
        // when
        User toUpdate = new User(1, "Andrzej");
        toUpdate.setName("Jozef");
        userRepository.update(toUpdate);
        // then
        User persistedUser = userRepository.findByName("Jozef");
        assertNotNull(persistedUser);
        assertThat(persistedUser.getId(), is(1));
    }
    @Test
    public void shouldDeleteUser() {
        // given
        User user = new User();
        user.setName("Andrzej");
        userRepository.persist(user);
        // when
        userRepository.deleteById(1);
        // then
        int count = userRepository.count();
        assertThat(count, is(0));
    }
}