package hu.local.plugins.jira.customfields.field;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.fields.config.FieldConfig;
import com.atlassian.jira.issue.fields.config.FieldConfigItemType;
import com.atlassian.jira.issue.fields.layout.field.FieldLayoutItem;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.velocity.VelocityManager;
import hu.local.plugins.jira.customfields.manager.UniqueSettingsManager;

import java.util.HashMap;
import java.util.Map;

public class RichterCFConfig implements FieldConfigItemType {
    private final JiraAuthenticationContext jiraAuthenticationContext;
    private final VelocityManager velocityManager;
    private final UniqueSettingsManager uniqueSettingsManager;

    public RichterCFConfig(
            JiraAuthenticationContext jiraAuthenticationContext,
            VelocityManager velocityManager,
            UniqueSettingsManager uniqueSettingsManager) {
        this.jiraAuthenticationContext = jiraAuthenticationContext;
        this.velocityManager = velocityManager;
        this.uniqueSettingsManager = uniqueSettingsManager;
    }

    @Override
    public String getDisplayName() {
        return "Uniqueness Configuration";
    }

    @Override
    public String getDisplayNameKey() {
        return "";
    }

    @Override
    public String getViewHtml(FieldConfig fieldConfig, FieldLayoutItem fieldLayoutItem) {
        return null;
    }

    @Override
    public String getObjectKey() {
        return "RichterCFConfig";
    }

    @Override
    public Object getConfigurationObject(Issue issue, FieldConfig fieldConfig) {
        Map<String, Object> configurationObject = new HashMap<>();
        return configurationObject;
    }

    @Override
    public String getBaseEditUrl() {
        return "RichterRegexCFUniqueConfigAction.jspa";
    }
}
