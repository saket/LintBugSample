package me.saket.module

object ClassWithLintErrors {
  fun text(): List<String> {
    val strings = mutableListOf<String>()
    strings.add("foo")
    return strings
  }
}