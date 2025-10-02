package com.vdp.shared.utils //

import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.floatOrNull
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.longOrNull

/**
 * Extrai um valor primitivo (String, Int, Boolean, etc.) de um JsonElement
 * navegando por um caminho de chaves.
 *
 * Exemplo de uso:
 * val userName: String? = jsonElement.getPrimitive("userRequest", "name")
 * val userAge: Int? = jsonElement.getPrimitive("userRequest", "age")
 */
inline fun <reified T> JsonElement.extractValue(vararg path: String): T? {
    var currentElement: JsonElement? = this

    for (key in path) {
        currentElement = (currentElement as? JsonObject)?.get(key)
    }

    return when (T::class) {
        String::class -> currentElement?.jsonPrimitive?.content as? T
        Int::class -> currentElement?.jsonPrimitive?.intOrNull as? T
        Boolean::class -> currentElement?.jsonPrimitive?.booleanOrNull as? T
        Double::class -> currentElement?.jsonPrimitive?.doubleOrNull as? T
        Long::class -> currentElement?.jsonPrimitive?.longOrNull as? T
        Float::class -> currentElement?.jsonPrimitive?.floatOrNull as? T
        else -> null
    }
}
