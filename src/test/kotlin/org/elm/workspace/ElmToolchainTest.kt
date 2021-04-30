package org.elm.workspace

import org.junit.Test
import java.nio.file.Paths
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class ElmToolchainTest {
    @Test
    fun `allows an executable file`() {
        val rawElmPath = Paths.get(ClassLoader.getSystemResource("org/elm/workspace/fixtures/elm-executable").toURI())
        assertTrue(ElmToolchain.looksLikeValidToolchainLocation(rawElmPath))
    }

    @Test
    fun `allows bare elm path`() {
        val rawElmPath = Paths.get("elm")
        assertTrue(ElmToolchain.looksLikeValidToolchainLocation(rawElmPath))
    }

    @Test
    fun `does not allow an empty path`() {
        assertFalse(ElmToolchain.looksLikeValidToolchainLocation(null))
    }

    @Test
    fun `allows a non-executable file`() {
        val rawElmPath = Paths.get(ClassLoader.getSystemResource("org/elm/workspace/fixtures/non-executable").toURI())
        assertFalse(ElmToolchain.looksLikeValidToolchainLocation(rawElmPath))
    }
}
