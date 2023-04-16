package dev.aaron.aak.compose.text.input

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import java.text.DecimalFormat

object CurrencyVisualTransformation: VisualTransformation {

    private val decimalFormat: DecimalFormat = DecimalFormat("#,###")

    override fun filter(text: AnnotatedString): TransformedText {
        val originText = text.text
        if (originText.isBlank()) {
            return TransformedText(text, OffsetMapping.Identity)
        }

        val numberParts = originText.split(".")
        val intPart = decimalFormat.format(numberParts[0].toInt())
        val decimalPart = if (numberParts.size >= 2) numberParts[1] else ""

        val formattedText = when {
            originText.endsWith(".") -> "$intPart."
            originText.contains(".") -> "$intPart.$decimalPart"
            else -> intPart
        }

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                val originSubString = originText.substring(0, offset)
                var commaCount = 0
                for (i in originSubString.indices) {
                    val originChar = originSubString[i]
                    val transChar = formattedText[i + commaCount]

                    if (originChar != transChar) {
                        commaCount += 1
                    }
                }

                return offset + commaCount
            }

            override fun transformedToOriginal(offset: Int): Int {
                return offset
            }
        }

        return TransformedText(AnnotatedString(formattedText), offsetMapping)
    }
}