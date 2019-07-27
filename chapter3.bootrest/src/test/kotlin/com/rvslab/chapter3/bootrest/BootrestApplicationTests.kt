package com.rvslab.chapter3.bootrest

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

@RunWith(SpringRunner::class)
@SpringBootTest
class BootrestApplicationTests {
    @InjectMocks
    private var greetingController: GreetingController? = null
    private var mockMvc: MockMvc?= null

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        mockMvc = MockMvcBuilders.standaloneSetup(greetingController).build()
    }

    @Test
    fun testSpringBootApp() {
        var req = get("/")
        var r = mockMvc!!.perform(req)
        r.andExpect(status().`is`(HttpStatus.OK.value()))
        r.andExpect(jsonPath("\$.message").value("Hello World!"))
    }
}