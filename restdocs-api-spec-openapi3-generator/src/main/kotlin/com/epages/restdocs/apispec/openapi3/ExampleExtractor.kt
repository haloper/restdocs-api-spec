package com.epages.restdocs.apispec.openapi3

/**
 * @author Jinhoon Kim
 */
object ExampleExtractor {

    val delimiter = "\\^\\|"

    val expressions = arrayOf(
        "($delimiter)([^($delimiter)]*)".toRegex(),
        "\\(ex:(.*)\\)".toRegex())

    fun extract(description: String): String {

        return expressions.mapNotNull {
            it.findAll(description).lastOrNull()?.groupValues?.lastOrNull()
        }.firstOrNull()?.trim() ?: ""
    }
}
