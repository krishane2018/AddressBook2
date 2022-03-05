import com.example.accessingdatajpa.AddressBookRepository;
import com.example.accessingdatajpa.AppController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes=AppController.class)
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressBookRepository mockRepo;


    /**
     * Basic test
     */
    @Test
    public void testCreateAddressBook() throws Exception {
        this.mockMvc.perform(post("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("")));
    }
}