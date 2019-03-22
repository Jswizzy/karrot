@file:Suppress("PackageDirectoryMismatch")
package com.smithjn.karrot.extensions

/**
 * Trick compiler into treating a statement as an expression,
 * useful for checking that when statements are exhaustive.
 */
val <T> T.exhaustive: T
    get() = this