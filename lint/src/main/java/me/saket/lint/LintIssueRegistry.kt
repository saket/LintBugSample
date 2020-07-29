package me.saket.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

@Suppress("UnstableApiUsage", "unused")
class LintIssueRegistry : IssueRegistry() {
    override val issues: List<Issue> get() = listOf(SampleLintDetector.ISSUE)
    override val api: Int get() = CURRENT_API
}