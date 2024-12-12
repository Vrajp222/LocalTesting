package jlin2.examples.localtesting


import org.junit.Test
import org.junit.Assert.*

class EmailValidatorTest {

    @Test
    fun testValidEmail() {
        val validEmail = "123@abc.com"
        assertTrue("Email should be valid", EmailValidator.isValidEmail(validEmail))
    }

    @Test
    fun testValidEmailWithSubdomain() {
        val validEmail = "123@abc.co.ca"
        assertTrue("Email with subdomain should be valid", EmailValidator.isValidEmail(validEmail))
    }

    @Test
    fun testInvalidEmailWithIncorrectDomain() {
        val invalidEmail = "123@abc"
        assertFalse("Email with incorrect domain should be invalid", EmailValidator.isValidEmail(invalidEmail))
    }

    @Test
    fun testInvalidEmailWithDoubleDots() {
        val invalidEmail = "123@abc..com"
        assertFalse("Email with double dots should be invalid", EmailValidator.isValidEmail(invalidEmail))
    }

    @Test
    fun testInvalidEmailWithoutUsername() {
        val invalidEmail = "@abc.com"
        assertFalse("Email without username should be invalid", EmailValidator.isValidEmail(invalidEmail))
    }

    @Test
    fun testInvalidEmailWithoutDomain() {
        val invalidEmail = "testing123"
        assertFalse("Email without domain should be invalid", EmailValidator.isValidEmail(invalidEmail))
    }

    @Test
    fun testEmptyEmail() {
        val emptyEmail = ""
        assertFalse("Empty email should be invalid", EmailValidator.isValidEmail(emptyEmail))
    }

    @Test
    fun testNullEmail() {
        val nullEmail: String? = null
        assertFalse("Null email should be invalid", EmailValidator.isValidEmail(nullEmail))
    }
}
