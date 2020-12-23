package com.brainXTech.sampleapplevelup.Utils

import java.util.regex.Pattern

fun String.isValidEmail(): Boolean = isValid(LevelUPRegex.EMAIL_REGEX)

fun String.isValidPassword(): Boolean {
    return this.length>6
}

fun String.isValid(pattern: String?): Boolean {
    if (pattern.isNullOrEmpty()) return false
    val matcher = Pattern.compile(pattern).matcher(this)
    return matcher.matches()
}
