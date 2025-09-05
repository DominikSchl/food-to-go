package foodtogo.application.api;

import foodtogo.application.BaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@AutoConfigureMockMvc
public class VerifyApiTest extends BaseIntegrationTest {

    private static final String API_DOCS_PATH = "/v3/api-docs";
    private static final String SPEC_FILE_NAME = "food-to-go.yaml";

    @Test
    void verifyOpenApiSpec() throws Exception {
        String versionControllSpec =
                new String(
                        Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(SPEC_FILE_NAME))
                                .readAllBytes());

        String generatedSpec =
                mockMvc
                        .perform(get(API_DOCS_PATH))
                        .andExpect(status().isOk())
                        .andReturn()
                        .getResponse()
                        .getContentAsString();

        assertThat(generatedSpec).isEqualTo(versionControllSpec);
    }

    @Test
    void generateOpenApiSpec() throws  Exception {
        byte[] content =
                mockMvc
                        .perform(get(API_DOCS_PATH))
                        .andExpect(status().isOk())
                        .andReturn()
                        .getResponse()
                        .getContentAsByteArray();

        Files.write(Paths.get("src", "main", "resources", SPEC_FILE_NAME), content);
    }
}
