package com.jinjer.orangemovieapp

import com.jinjer.orangemovieapp.data.remote.NetworkUtils
import org.junit.Test

import org.junit.Assert.*

class BuildImageUrlTest {
    private val baseImageUrl = NetworkUtils.baseImageUrl

    @Test
    fun getCorrectImageUrl() {
        val fakeImagePath = "xffsgdf.jpg"
        val resultImagePath = NetworkUtils.buildImageUrl(fakeImagePath)
        assertEquals("$baseImageUrl$fakeImagePath", resultImagePath)
    }
}