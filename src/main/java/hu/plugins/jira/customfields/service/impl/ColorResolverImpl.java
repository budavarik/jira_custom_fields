package hu.local.plugins.jira.customfields.service.impl;

import hu.local.plugins.jira.customfields.service.ColorResolver;

public class ColorResolverImpl implements ColorResolver {
    @Override
    public String resolveColor(String userColor) {
        return hu.local.plugins.jira.customfields.util.ColorResolver.getHexColor(userColor);
    }
}
