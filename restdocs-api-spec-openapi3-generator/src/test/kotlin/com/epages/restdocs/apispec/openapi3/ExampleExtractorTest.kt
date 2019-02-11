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
    then(ExampleExtractor.extract("input you||^^r email ^$delimiterStr jinhoon.kim@nhnent.com")).isEqualTo(
        "jinhoon.kim@nhnent.com")
    then(ExampleExtractor.extract("")).isEqualTo("")
    then(ExampleExtractor.extract("asdfwfwf1 #@231 #@F#@FFSAD5 asdf")).isEqualTo("")
  }

  @Test
  fun `should remove example from description`() {
    then(ExampleExtractor.remove("fddsfasdf$delimiterStr sfwwd$delimiterStr")).isEqualTo(
        "fddsfasdf$delimiterStr sfwwd")
    then(ExampleExtractor.remove("fddsf|한글$delimiterStr sfwwd$delimiterStr asw")).isEqualTo(
        "fddsf|한글$delimiterStr sfwwd")
    then(ExampleExtractor.remove("input you||^^r email ^$delimiterStr jinhoon.kim@nhnent.com")).isEqualTo(
        "input you||^^r email ^")
    then(ExampleExtractor.remove("")).isEqualTo("")
    then(ExampleExtractor.remove("asdfwfwf1 #@231 #@F#@FFSAD5 asdf")).isEqualTo("asdfwfwf1 #@231 #@F#@FFSAD5 asdf")
  }
}
