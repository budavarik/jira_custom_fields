package hu.local.plugins.jira.customfields.service;

/**
 * Convert user entered color to HEX.
 */
public interface ColorResolver {
    String resolveColor(String userColor);
}
