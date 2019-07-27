package com.rvslab.chapter3.bootsecurity

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext
import org.springframework.security.oauth2.client.OAuth2RestTemplate
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class BootsecurityApplicationTests {

    @Test
    fun testOAuthService() {
        val resource = ResourceOwnerPasswordResourceDetails()
        resource.username = "guest"
        resource.password = "guest123"
        resource.accessTokenUri = "http://localhost:8080/oauth/token"
        resource.clientId = "trustedclient"
        resource.clientSecret = "trustedclient123"
        resource.grantType = "password"
        resource.scope = arrayListOf("read", "write", "trust")

        val clientContext = DefaultOAuth2ClientContext()
        val restTemplate = OAuth2RestTemplate(resource, clientContext)
        val greet = restTemplate.getForObject("http://localhost:8080", Greet::class.java)

        Assert.assertEquals("Hello World!", greet.message)
    }
}
