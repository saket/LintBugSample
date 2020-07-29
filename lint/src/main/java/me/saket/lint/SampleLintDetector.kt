@file:Suppress("UnstableApiUsage")

package me.saket.lint

import com.android.tools.lint.detector.api.*
import com.android.tools.lint.detector.api.Category.Companion.CORRECTNESS
import com.android.tools.lint.detector.api.Severity.ERROR
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression
import org.jetbrains.uast.asRecursiveLogString
import java.util.*

class SampleLintDetector : Detector(), SourceCodeScanner {

  override fun getApplicableMethodNames(): List<String>? {
    return listOf("mutableListOf")
  }

  override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
    println("node: ${node.asRecursiveLogString()}")

    context.report(
        issue = ISSUE,
        location = context.getLocation(node),
        message = "Some error message"
    )
  }

  companion object {
    val ISSUE = Issue.create(
        id = "YouShallNotPass",
        briefDescription = "You shall not pass",
        explanation = "Some explanation",
        category = CORRECTNESS,
        priority = 5,
        severity = ERROR,
        implementation = Implementation(
            SampleLintDetector::class.java,
            EnumSet.of(Scope.JAVA_FILE, Scope.TEST_SOURCES),
            EnumSet.of(Scope.JAVA_FILE),
            EnumSet.of(Scope.TEST_SOURCES)
        )
    )
  }
}