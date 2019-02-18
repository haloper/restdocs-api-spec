package com.epages.restdocs.apispec.openapi3

/**
 * @author Jinhoon Kim
 */
object ExampleExtractor {

  val delimiter = "\\^\\|"

  val expression = "($delimiter)([^($delimiter)]*)$".toRegex()
  fun extract(description: String) = expression.findAll(
      description).lastOrNull()?.groupValues?.lastOrNull().let {
    it?.trim()
  }

  fun remove(description: String): String {
    return expression.replace(description, "")
  }
}
