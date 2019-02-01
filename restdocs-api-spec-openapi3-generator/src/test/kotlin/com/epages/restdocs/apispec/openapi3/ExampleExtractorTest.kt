package com.epages.restdocs.apispec.openapi3

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

/**
 * @author Jinhoon Kim
 */
class ExampleExtractorTest {

    val delimiterStr = ExampleExtractor.delimiter.replace("\\", "")

    @Test
    fun `should extract example from description`() {
        then(ExampleExtractor.extract("fddsfasdf$delimiterStr sfwwd$delimiterStr")).isEqualTo("")
        then(ExampleExtractor.extract("fddsf|한글$delimiterStr sfwwd$delimiterStr asw")).isEqualTo("asw")
        then(ExampleExtractor.extract("input you||^^r email ^$delimiterStr jinhoon.kim@nhnent.com")).isEqualTo("jinhoon.kim@nhnent.com")
        then(ExampleExtractor.extract("input your email (ex:jinhoon.kim@nhnent.com)")).isEqualTo("jinhoon.kim@nhnent.com")
        then(ExampleExtractor.extract("")).isEqualTo("")
        then(ExampleExtractor.extract("asdfwfwf1 #@231 #@F#@FFSAD5 asdf")).isEqualTo("")
    }
}
