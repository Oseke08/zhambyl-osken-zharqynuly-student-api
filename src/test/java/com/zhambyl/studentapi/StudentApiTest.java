package com.zhambyl.studentapi;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class StudentApiTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void ownerEndpointReturnsStudentName() throws Exception {
        mvc.perform(get("/api/students/owner"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.studentName").value("Zhambyl Osken Zharqynuly"))
           .andExpect(jsonPath("$.id").value("37437"));
    }

    @Test
    void crudLifecycleWorks() throws Exception {
        String body = "{\"fullName\":\"Zhambyl Osken Zharqynuly\",\"email\":\"zhambyl.test@example.com\",\"course\":\"DevOps\"}";

        String created = mvc.perform(post("/api/students").contentType("application/json").content(body))
           .andExpect(status().isCreated())
           .andExpect(jsonPath("$.fullName").value("Zhambyl Osken Zharqynuly"))
           .andReturn().getResponse().getContentAsString();

        long id = Long.parseLong(created.replaceAll(".*\"id\":(\\d+).*", "$1"));

        mvc.perform(get("/api/students")).andExpect(status().isOk());
        mvc.perform(get("/api/students/" + id)).andExpect(status().isOk())
           .andExpect(jsonPath("$.course").value("DevOps"));
        mvc.perform(put("/api/students/" + id).contentType("application/json")
                .content("{\"fullName\":\"Zhambyl Osken Zharqynuly\",\"email\":\"zhambyl.updated@example.com\",\"course\":\"Cloud\"}"))
           .andExpect(status().isOk()).andExpect(jsonPath("$.course").value("Cloud"));
        mvc.perform(delete("/api/students/" + id)).andExpect(status().isNoContent());
        mvc.perform(get("/api/students/" + id)).andExpect(status().isNotFound())
           .andExpect(content().string(containsString("was not found")));
    }
}
