package hu.local.plugins.jira.customfields.manager.impl;

import com.atlassian.sal.api.pluginsettings.PluginSettings;
import com.atlassian.sal.api.pluginsettings.PluginSettingsFactory;
import hu.local.plugins.jira.customfields.manager.UniqueSettingsManager;

public class UniqueSettingsManagerImpl implements UniqueSettingsManager {
    private static final String PLUGIN_KEY = "UniqueRegexCFUnique";

    private final PluginSettings pluginSettings;

    public UniqueSettingsManagerImpl(PluginSettingsFactory pluginSettingsFactory) {
        this.pluginSettings = pluginSettingsFactory.createSettingsForKey(PLUGIN_KEY);
    }
}
