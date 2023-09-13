package hu.plugins.jira.customfields.service.impl;

import hu.plugins.jira.customfields.service.ColorResolver;

public class ColorResolverImpl implements ColorResolver {
    @Override
    public String resolveColor(String userColor) {
        return hu.plugins.jira.customfields.util.ColorResolver.getHexColor(userColor);
    }
}
