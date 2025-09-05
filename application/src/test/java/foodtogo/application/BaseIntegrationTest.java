package foodtogo.application;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest(classes = TestApplication.class)
@ActiveProfiles("test")
public abstract class BaseIntegrationTest {

    protected static final String TEST_TENANT = "test";

    @Autowired
    private WebApplicationContext context;

    protected MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc =
            MockMvcBuilders.webAppContextSetup(context)
                .defaultRequest(
                    get("/")
                        .with(csrf())
                        .with(
                            user("user")
                                .roles("USER")
                                //.authorities(
                                //    new GrantedTenantAuthority(
                                //        Tenant.builder().id(TEST_TENANT).build())
                        )
                )
                .apply(springSecurity())
                .build();
    }
}
