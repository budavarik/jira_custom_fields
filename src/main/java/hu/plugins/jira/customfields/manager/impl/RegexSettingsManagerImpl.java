package hu.plugins.jira.customfields.manager.impl;

import com.atlassian.sal.api.pluginsettings.PluginSettings;
import com.atlassian.sal.api.pluginsettings.PluginSettingsFactory;
import hu.plugins.jira.customfields.manager.RegexSettingsManager;

public class RegexSettingsManagerImpl implements RegexSettingsManager {
    private static final String PLUGIN_KEY = "UniqueRegexCFRegex";

    private final PluginSettings pluginSettings;

    public RegexSettingsManagerImpl(PluginSettingsFactory pluginSettingsFactory) {
        this.pluginSettings = pluginSettingsFactory.createSettingsForKey(PLUGIN_KEY);
    }
}
