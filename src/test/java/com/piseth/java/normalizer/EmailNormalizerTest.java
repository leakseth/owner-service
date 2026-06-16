package com.piseth.java.normalizer;

import com.piseth.java.normolizer.EmailNormalizer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EmailNormalizerTest {
    private final EmailNormalizer normalizer = new EmailNormalizer();
    @Test
    void shouldReturnNull_whenEmailIsNull() {
        // given
        String email = null;
        // when
        String emailAfterNormalized = normalizer.normalize(email);
        //then
        //assertEquals(null, emailAfterNormalized);

        assertNull(emailAfterNormalized);

        //assertNull(normalizer.normalize(null));
    }

    @Test
    void shouldReturnNull_whenEmailIsBlank() {
        assertNull(normalizer.normalize(""));
        assertNull(normalizer.normalize("   "));
    }

    @Test
    void shouldTrimWhitespace() {
        String result = normalizer.normalize("  test@example.com  ");
        assertEquals("test@example.com", result);
    }

    @Test
    void shouldConvertToLowerCase() {
        String result = normalizer.normalize("TESt@EXAMPLE.COM");
        assertEquals("test@example.com", result);
    }

    @Test
    void shouldTrimAndLowercaseTogether() {
        String result = normalizer.normalize("  TEST@Example.Com  ");
        assertEquals("test@example.com", result);
    }
}
